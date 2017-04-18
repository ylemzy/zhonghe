package application.http.utils;

import application.uil.JsonHelper;
import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.elasticsearch.cluster.Diff;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 2017/4/15.
 */
public class RequestCompare {

    private static final Logger logger = LogManager.getLogger();

    Connection leftConnection;
    Connection rightConnection;

    TemplateParam paramLeft;
    TemplateParam paramRight;
    TemplateParam third;
    DiffValue diffValue = new DiffValue();


    enum CompareType{
        BOTH_EMPTY,
        LEFT_EMPTY,
        RIGHT_EMPTY,
        EQUAL,
        NO_EQUAL
    }

    public RequestCompare(Connection leftConnection, Connection rightConnection){
        this.leftConnection = leftConnection;
        this.rightConnection = rightConnection;
    }

    public TemplateParam getParamLeft() {
        return paramLeft;
    }

    public void setParamLeft(TemplateParam paramLeft) {
        this.paramLeft = paramLeft;
    }

    public TemplateParam getParamRight() {
        return paramRight;
    }

    public void setParamRight(TemplateParam paramRight) {
        this.paramRight = paramRight;
    }

    public TemplateParam getThird() {
        return third;
    }

    public void setThird(TemplateParam third) {
        this.third = third;
    }

    Map<String, String> theSame = new HashMap<>();

    Map<String, String> diffHeaders = new HashMap<>();
    Map<String, String> diffCookies = new HashMap<>();
    Map<String, String> diffBody = new HashMap();
    Map<String, String> diffParams = new HashMap();

    private CompareType compare(String value1, String value2) {

        if (value1 == null && value2 == null) {
            return CompareType.BOTH_EMPTY;
        } else if (value1 == null) {
            return CompareType.LEFT_EMPTY;
        } else if (value2 == null) {
            return CompareType.RIGHT_EMPTY;
        } else {
            if (value1.equals(value2)) {
                return CompareType.EQUAL;
            }
            return CompareType.NO_EQUAL;
        }
    }

    private String whenDiffTheValue(String value1, String value2) {
        return StringUtils.trimToEmpty(value1) + "<->" + StringUtils.trimToEmpty(value2);
    }



    private void compareAndSave(String key, String value1, String value2, Map<String, String> diffMap, Map<String, String> sameMap) {
        CompareType res = compare(value1, value2);
        switch (res) {
            case EQUAL:
            case BOTH_EMPTY:
                sameMap.put(key, value1);
                break;
            case LEFT_EMPTY:
                paramLeft.makeNewValue(key, value1, third, diffValue);
            case RIGHT_EMPTY:
                paramRight.makeNewValue(key, value2, third, diffValue);
            case NO_EQUAL:
                diffMap.put(key, whenDiffTheValue(value1, value2));
                paramLeft.makeNewValue(key, value1, third, diffValue);
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
        compareMap(leftConnection.request().headers(),
                rightConnection.request().headers(),
                diffHeaders,
                theSame);
    }

    public void compareCookies() {
        compareMap(leftConnection.request().cookies(),
                rightConnection.request().cookies(),
                diffCookies,
                theSame);
    }

    public void compareBody(){
        FormDataMaker f1 = FormDataMaker.make(leftConnection.request().requestBody());
        FormDataMaker f2 = FormDataMaker.make(rightConnection.request().requestBody());
        compareMap(f1.data(),
                f2.data(),
                diffBody,
                theSame);
    }
    public void compareParams(){
        UrlMaker u1 = UrlMaker.make(leftConnection.request().url().toString());
        UrlMaker u2 = UrlMaker.make(rightConnection.request().url().toString());
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

    public DiffValue getDiffValue(){
        return this.diffValue;
    }

    public Connection getDiffConnect(){
        makeParam(leftConnection);
        makeBody(leftConnection);
        makeCookies(leftConnection);
        return leftConnection;
    }

    private void makeParam(Connection connection){
        UrlMaker make = UrlMaker.make(connection.request().url().toString());
        diffValue.forEach((k, v) ->{
            if (make.params.containsKey(k)){
                make.param(k, v);
            }
        });
        connection.url(make.getUrl());
    }

    private void makeBody(Connection connection){
        FormDataMaker form = FormDataMaker.make(connection.request().requestBody());
        diffValue.forEach((k, v) ->{
            if (form.data().containsKey(k)){
                form.data(k, v);
            }
        });
        connection.requestBody(form.rawData());
    }

    private void makeCookies(Connection connection){
        Map<String, String> cookies = connection.request().cookies();
        diffValue.forEach((k, v) ->{
            if (cookies.containsKey(k)){
                connection.cookie(k, v);
            }
        });
    }

    public String log(){

        StringBuffer buffer = new StringBuffer();
        buffer.append("--------------------compare request------------------------\n");
        buffer.append("Diff between:\n" + leftConnection.request().url() + "\n" +  rightConnection.request().url()).append("\n");
        buffer.append("Diff headers " + JsonHelper.toJSON(diffHeaders)).append("\n");
        buffer.append("Diff cookies " + JsonHelper.toJSON(diffCookies)).append("\n");
        buffer.append("Diff body " + JsonHelper.toJSON(diffBody)).append("\n");
        buffer.append("Diff params " + JsonHelper.toJSON(diffParams)).append("\n");
        buffer.append("Same all " + JsonHelper.toJSON(theSame)).append("\n");

        String s = buffer.toString();
        //logger.info(s);

        return s;
    }
}
