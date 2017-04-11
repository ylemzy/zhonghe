package application.uil;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
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

    void parseFrom(String filename) throws IOException {
        List<String> strings = FileUtils.readLines(new File(filename), "utf-8");

    }

    Connection.Method parseMethod(String method){
        return Connection.Method.valueOf(method);
    }


    Connection parseReqeust(String content) throws Exception {
        String[] split = content.split(" ");
        Assert.isTrue(split.length >= 2);

        Connection.Method method = parseMethod(split[0]);
        if (method == null)
            throw new Exception("Httpmethod parse error");

        return Jsoup.connect(split[1]).method(method);
    }

}
