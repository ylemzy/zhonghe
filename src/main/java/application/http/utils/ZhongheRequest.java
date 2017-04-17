package application.http.utils;

import application.uil.JsonHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Connection;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/4/15.
 */
public class ZhongheRequest {
    private static final Logger logger = LogManager.getLogger();

    Map<String, String> cookies = new HashMap<>();

    Map<String, String> formData = new HashMap<>();

    String serveNumber;
    String certID;
    String currentTabID;

    public ZhongheRequest(String serveNumber, String certID) {
        this.serveNumber = serveNumber;
        this.certID = certID;

        this.currentTabID = "BOSS^" + serveNumber + "^100110121062~" + serveNumber;
    }

    private void saveCookies(Connection.Response response) {
        cookies.putAll(response.cookies());
    }

    private void saveFormData(Connection.Response response) throws IOException {
        Document document = response.parse();
        Elements input = document.getElementsByTag("input");
        for (Element element : input) {
            formData.put(element.attr("name"), element.attr("value"));
        }
    }

    private void updateCookies(Connection connection) {
        connection.cookies(cookies);
        cookies = connection.request().cookies();
    }

    private ZhongheRequest clearFormData(){
        formData.clear();
        return this;
    }

    private ZhongheRequest putFormData(String key, String data){
        formData.put(key, data);
        return this;
    }

    private void addFormDataTo(Connection connection) {
        String s = connection.request().requestBody();
        FormDataMaker data = FormDataMaker.make(s).data(formData);
        connection.requestBody(data.rawData());
    }

    private void logResponse(Connection.Response response) throws IOException {
        logger.info("------------------------------response----------------------------------");
        logger.info("Response Headers = {}", JsonHelper.toJSON(response.headers()));
        logger.info("Response Cookies = {}", JsonHelper.toJSON(response.cookies()));
        logger.info(response.parse().html());

    }

    private void updateAndLog(Connection.Request request, Connection.Response response) throws IOException {
        saveCookies(response);
        logger.info("------------------------------request----------------------------------");
        logger.info("URL:{}", JsonHelper.toJSON(request.url()));
        logger.info("Method:{}", JsonHelper.toJSON(request.method()));
        logger.info("Headers :{}", JsonHelper.toJSON(request.headers()));
        logger.info("Cookie :{}", JsonHelper.toJSON(request.cookies()));
        logger.info("Body :{}", JsonHelper.toJSON(request.requestBody()));
        logResponse(response);
    }


    public void getMainProID() throws Exception{
        Connection connection = RequestLoader.make("getMainProID").parse();
        String url = UrlMaker.make(connection.request().url().toString()).param("servNumber", this.serveNumber).getUrl();
        connection.url(url);
        updateCookies(connection);
        Connection.Response response = connection.execute();
        updateAndLog(connection.request(), response);
    }

    public void idCardActionCheck() throws Exception{
        Connection connection = RequestLoader.make("idCardActionCheck").parse();
        updateCookies(connection);
        clearFormData().putFormData("certId", certID).addFormDataTo(connection);
        Connection.Response response = connection.execute();
        updateAndLog(connection.request(), response);
    }

    public void clearUserSession() throws Exception{
        Connection connection = RequestLoader.make("clearUserSession").parse();
        String url = UrlMaker.make(connection.request().url().toString()).param("tabid", this.currentTabID).getUrl();
        connection.url(url);
        updateCookies(connection);
        Connection.Response response = connection.execute();
        updateAndLog(connection.request(), response);
    }


    /**
     * @param serveNumber 13602565600
     * @param certID     460027198811272037
     * @throws Exception
     */
    public void qryCustInfo(String serveNumber, String certID) throws Exception {
        Connection connection = RequestLoader.make("qryCustInfo").parse();
        updateCookies(connection);

        clearFormData().putFormData("serveNumber", serveNumber).putFormData("certID", certID).addFormDataTo(connection);

        Connection.Response response = connection.execute();
        updateAndLog(connection.request(), response);

    }

    public void checkProvFeeMenu() throws Exception {
        Connection connection = RequestLoader.make("checkProvFeeMenu").parse();
        updateCookies(connection);
        Connection.Response response = connection.execute();
        updateAndLog(connection.request(), response);
    }

    public void uvDisper() throws Exception {
        Connection connection = RequestLoader.make("uvDisper").parse();

        setHuaweiCookies();
        updateCookies(connection);

        String url = UrlMaker.make(connection.request().url().toString()).param("currentTabID", this.currentTabID).getUrl();
        connection.url(url);
        Connection.Response response = connection.execute();
        saveFormData(response);
        updateAndLog(connection.request(), response);
    }

    public void bossviewhome() throws Exception {
        Connection connection = RequestLoader.make("bossviewhome").parse();
        updateCookies(connection);
        addFormDataTo(connection);
        Connection.Response response = connection.execute();
        updateAndLog(connection.request(), response);
    }

    public void layoutAction200() throws Exception {
        Connection connection = RequestLoader.make("layoutAction200").parse();
        connection.timeout((int)TimeUnit.SECONDS.toMillis(10));
        updateCookies(connection);
        Connection.Response response = connection.execute();
        updateAndLog(connection.request(), response);
    }

    public void layoutAction39() throws Exception {
        Connection connection = RequestLoader.make("layoutAction39").parse();
        connection.timeout((int)TimeUnit.SECONDS.toMillis(10));
        updateCookies(connection);
        Connection.Response response = connection.execute();
        updateAndLog(connection.request(), response);

        Elements td = response.parse().getElementsByTag("td");
        logger.info("-------------->>>>>>>>>>>>>>>>>> {}", td.first().text());
    }

    public void layoutAction78() throws Exception {
        Connection connection = RequestLoader.make("layoutAction78").parse();
        connection.timeout((int)TimeUnit.SECONDS.toMillis(10));
        updateCookies(connection);
        Connection.Response response = connection.execute();
        updateAndLog(connection.request(), response);
        Elements td = response.parse().getElementsByTag("td");
        logger.info("-------------->>>>>>>>>>>>>>>>>> {}", td.first().text());
    }


    public void sequentially() throws Exception {
        getMainProID();
        idCardActionCheck();
        clearUserSession();
        qryCustInfo(serveNumber, certID);
        uvDisper();
        bossviewhome();
        layoutAction200();
        layoutAction39();
        //layoutAction78();
    }
/*
*   "com.huawei.boss.CONTACTID" : "null<->undefined",
  "com.huawei.boss.CURRENT_TAB" : "BOSS^13602565600^100110121062~13602565600<->BOSS%5E13602565600%5E100110121062%7E13602565600"
*
* */

    public void setHuaweiCookies() {
        cookies.put("com.huawei.boss.CURRENT_USER", serveNumber);
        cookies.put("com.huawei.boss.CURRENT_TAB", currentTabID);
        cookies.put("com.huawei.boss.CURRENT_MENUID", "100110121062");
    }

}
