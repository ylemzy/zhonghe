package application.http.utils;

import application.uil.JsonHelper;
import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Connection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 2017/4/15.
 */
public class RequestCompare {

    private static final Logger logger = LogManager.getLogger();

    Connection a;
    Connection b;

    public RequestCompare(Connection a, Connection b){
        this.a = a;
        this.b = b;
    }

    Map<String, String> theSame = new HashMap<>();

    Map<String, String> diffHeaders = new HashMap<>();
    Map<String, String> diffCookies = new HashMap<>();
    Map<String, String> diffBody = new HashMap();
    Map<String, String> diffParams = new HashMap();

    private int compare(String value1, String value2) {

        if (value1 == null && value2 == null) {
            return 0;
        } else if (value1 == null) {
            return 2;
        } else if (value2 == null) {
            return 3;
        } else {
            if (value1.equals(value2)) {
                return 0;
            }
            return 1;
        }
    }

    private String whenDiffTheValue(String value1, String value2) {
        return StringUtils.trimToEmpty(value1) + "<->" + StringUtils.trimToEmpty(value2);
    }

    private void compareAndSave(String key, String value1, String value2, Map<String, String> diffMap, Map<String, String> sameMap) {
        int res = compare(value1, value2);
        switch (res) {
            case 0:
                sameMap.put(key, value1);
                break;
            case 1:
            case 2:
            case 3:
                diffMap.put(key, whenDiffTheValue(value1, value2));
            default:
                break;
        }
    }

    private void compareMap(Map<String, String> m1, Map<String, String> m2, Map<String, String> diffMap, Map<String, String> sameMap) {
        Set<String> set = new HashSet<>();
        set.addAll(m1.keySet());
        set.addAll(m2.keySet());

        for (String s : set) {
            compareAndSave(s, m1.get(s), m2.get(s), diffMap, sameMap);
        }
    }

    public void compareHeaders() {
        compareMap(a.request().headers(),
                b.request().headers(),
                diffHeaders,
                theSame);
    }

    public void compareCookies() {
        compareMap(a.request().cookies(),
                b.request().cookies(),
                diffCookies,
                theSame);
    }

    public void compareBody(){
        FormDataMaker f1 = FormDataMaker.make(a.request().requestBody());
        FormDataMaker f2 = FormDataMaker.make(b.request().requestBody());
        compareMap(f1.data(),
                f2.data(),
                diffBody,
                theSame);
    }
    public void compareParams(){
        UrlMaker u1 = UrlMaker.make(a.request().url().toString());
        UrlMaker u2 = UrlMaker.make(b.request().url().toString());
        compareMap(u1.params(),
                u2.params(),
                diffParams,
                theSame);
    }



    public String compare(){
        compareHeaders();
        compareCookies();
        compareParams();
        compareBody();
        return log();
    }

    public String log(){
        logger.info("--------------------compare request------------------------");
        StringBuffer buffer = new StringBuffer();
        buffer.append("Diff headers " + JsonHelper.toJSON(diffHeaders)).append("\n");
        buffer.append("Diff cookies " + JsonHelper.toJSON(diffCookies)).append("\n");
        buffer.append("Diff body " + JsonHelper.toJSON(diffBody)).append("\n");
        buffer.append("Diff params " + JsonHelper.toJSON(diffParams)).append("\n");
        buffer.append("Same all " + JsonHelper.toJSON(theSame)).append("\n");

        String s = buffer.toString();
        logger.info(s);

        return s;
    }
}
