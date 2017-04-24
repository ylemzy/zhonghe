package application.http.utils;

import application.uil.JsonHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by Administrator on 2017/4/24.
 */
public class UrlInfo {
    private static final Logger logger = LogManager.getLogger();

    private static List<String> urls = new ArrayList<>();

    private static boolean contain(String url) {
        for (String s : urls) {
            if (url.contains(s))
                return true;
        }
        return false;
    }

    public static void addUrlKeyword(String url) {
        urls.add(url);
    }

    public static void log(String url, String subject, Object object) {
        if (contain(url))
            logger.info("{}: url={} ====>> \n {}", subject, url, JsonHelper.toJSON(object));
    }


}
