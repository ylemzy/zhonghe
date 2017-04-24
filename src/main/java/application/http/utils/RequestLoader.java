package application.http.utils;

import application.http.HttpHeaders;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.springframework.util.Assert;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by J on 4/11/2017.
 */
public class RequestLoader {
    private static final Logger logger = LogManager.getLogger();

    private Connection connection;

    private String resourceName;

    private Type type;

    private List<String> requestText = null;

    enum Type{
        RESOURCE,
        FILE,
        TEXT
    }

    public RequestLoader(String resourceName, Type type) {
        this.resourceName = resourceName;
        this.type = type;
    }

    public RequestLoader(List<String> requestText){
        this.requestText = requestText;
        this.type = Type.TEXT;
    }


    public static RequestLoader makeByResource(String resourceName){
        return new RequestLoader(resourceName, Type.RESOURCE);
    }

    public static RequestLoader makeByFile(String fileName){
        return new RequestLoader(fileName, Type.FILE);
    }

    public static RequestLoader makeByText(List<String> requestText){
        return new RequestLoader(requestText);
    }

    public Connection parse() throws Exception {

        if (type != Type.TEXT){
            load();
        }

        parseRequest(requestText.get(0));

        for (int i = 1; i < requestText.size(); ++i) {
            if (!parseHeader(requestText.get(i))) {
                parseBody(requestText.get(i));
            }
        }

        //logger.info("URL:{}", JsonHelper.toJSON(connection.request().url()));
        //logger.info("URI:{}", UrlMaker.makeByResource(connection.request().url().toString()).getUri());
        /* logger.info("Method:{}", JsonHelper.toJSON(connection.request().method()));
        logger.info("Headers :{}", JsonHelper.toJSON(connection.request().headers()));
        logger.info("Cookie :{}", JsonHelper.toJSON(connection.request().cookies()));
        logger.info("Body :{}", JsonHelper.toJSON(connection.request().requestBody()));*/

        return connection;
    }

    public RequestLoader load() throws Exception {
        if (type == Type.RESOURCE){
            InputStream stream = RequestLoader.class.getResourceAsStream(resourceName);
            requestText = IOUtils.readLines(stream, "utf-8");
        }else{
            logger.info("load from {}", resourceName);
            requestText = FileUtils.readLines(new File(resourceName), "utf-8");
        }
        return this;
    }

    Connection.Method parseMethod(String method) {
        return Connection.Method.valueOf(method);
    }


    void parseRequest(final String content) throws Exception {
        String[] split = content.split(" ");
        Assert.isTrue(split.length >= 2);

        Connection.Method method = parseMethod(split[0]);
        if (method == null)
            throw new Exception("Httpmethod parse error");

        connection = Jsoup.connect(split[1]).method(method);
    }

    boolean parseHeader(final String content) {

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

    void parseBody(final String content) {
        if (StringUtils.isBlank(content))
            return;
        connection.header("x-requested-with", "XMLHttpRequest");
        connection.requestBody(content);
    }

    public Connection getConnection() {
        return connection;
    }

    public String getUrl(){
        return connection.request().url().toString();
        //return UrlMaker.make(connection.request().url().toString()).getUri();
    }


    public List<String> getRequestText() {
        return requestText;
    }
}
