package application.http.utils;

import application.http.HttpHeaders;
import application.http.utils.CookieMaker;
import application.uil.JsonHelper;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.helper.HttpConnection;
import org.springframework.http.HttpMethod;
import org.springframework.util.Assert;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by J on 4/11/2017.
 */
public class ParseRequest {
    private static final Logger logger = LogManager.getLogger();

    private Connection connection;

    public Connection parseFrom(String filename) throws Exception {
        List<String> strings = FileUtils.readLines(new File(filename), "utf-8");
        parseRequest(strings.get(0));

        for (int i = 1; i < strings.size(); ++i) {
            if (!parseHeader(strings.get(i))) {
                parseBody(strings.get(i));
            }
        }

        logger.info("URL:{}", JsonHelper.toJSON(connection.request().url()));
        logger.info("Method:{}", JsonHelper.toJSON(connection.request().method()));
        logger.info("Headers :{}", JsonHelper.toJSON(connection.request().headers()));
        logger.info("Cookie :{}", JsonHelper.toJSON(connection.request().cookies()));
        logger.info("Body :{}", JsonHelper.toJSON(connection.request().requestBody()));

        return connection;
    }

    Connection.Method parseMethod(String method) {
        return Connection.Method.valueOf(method);
    }


    void parseRequest(String content) throws Exception {
        String[] split = content.split(" ");
        Assert.isTrue(split.length >= 2);

        Connection.Method method = parseMethod(split[0]);
        if (method == null)
            throw new Exception("Httpmethod parse error");

        connection = Jsoup.connect(split[1]).method(method);
    }

    boolean parseHeader(String content) {

        if (content.startsWith(HttpHeaders.COOKIE + ":")) {
            connection.cookies(CookieMaker.make(content.substring(HttpHeaders.COOKIE.length() + 1)).data());
            return true;
        }

        String[] split = content.split(":");

        if (split.length < 2)
            return false;

        connection.header(split[0].trim(), split[1].trim());
        return true;
    }

    void parseBody(String content) {
        if (StringUtils.isBlank(content))
            return;
        connection.requestBody(content);
    }

    public Connection getConnection() {
        return connection;
    }
}
