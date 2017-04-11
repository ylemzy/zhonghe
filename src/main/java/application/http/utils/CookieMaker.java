package application.http.utils;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/3/5.
 */
public class CookieMaker {

    Map<String, String> cookieData;

    public static CookieMaker make(String rawCookies){
        return new CookieMaker(rawCookies);
    }

    public CookieMaker(String rawCookies){
        cookieData =  new LinkedHashMap<>();
        String[] split = rawCookies.split(";");

        for (String s : split) {
            String[] cookie = s.split("=");
            cookieData.put(cookie[0].trim(), cookie[1].trim());
        }
    }

    public CookieMaker cookie(String key, String value){
        cookieData.put(key, value);
        return this;
    }

    public Map<String, String> data(){
        return cookieData;
    }
}
