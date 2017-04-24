package application.http.utils;

import application.uil.JsonHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Connection;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by J on 4/22/2017.
 */
public class SequentailExecutor {
    private static final Logger logger = LogManager.getLogger();

    TreeMap<Integer, RequestLoader> sequentailLoader;

    ConnectionFilter connectionFilter = new ConnectionFilter();

/*    final static String[] replaceableCookies = {
            "sna_cookie",
            "JSESSIONID",
            "rootTicket",
            "loginCookie",
            "staffInfoCookie",
            "IPAddr"
    };*/

    public SequentailExecutor(TreeMap<Integer, RequestLoader> sequentailLoader) {
        this.sequentailLoader = sequentailLoader;
    }

    public void execute(Connection previousConn) throws Exception {
        Iterator<Map.Entry<Integer, RequestLoader>> iterator = sequentailLoader.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer, RequestLoader> next = iterator.next();
            try{
                previousConn = execute(next.getValue(), previousConn);
            }catch (Exception e){
                List<String> requestText = next.getValue().getRequestText();
                requestText.forEach(row ->{
                    logger.error(row);
                });

                throw e;
            }

        }
    }


    public Connection execute(RequestLoader loader, Connection previousConn) throws Exception {

        connectionFilter.initCookies(previousConn.request());
        Connection connection = loader.parse();

        String url = loader.getUrl();
        logger.info("--> execute {}", url);
        connectionFilter.beforeFilter(connection.request());
        Connection.Response response = connection.timeout((int)TimeUnit.SECONDS.toMillis(10)).execute();
        connectionFilter.afterFilter(response);

        logger.info("--> finish {}", url);
        return connection;
    }


    private static class ConnectionFilter{
        final static String[] irreplaceableCookies = {
                "com.huawei.boss.CURRENT_MENUID",
                "com.huawei.boss.CURRENT_TAB",
                "com.huawei.boss.CURRENT_USER",
                "com.huawei.boss.CONTACTID",
        };

        static Map<String, String> formData = new HashMap<>();

        static Map<String, String> cookies = new HashMap<>();


        public ConnectionFilter initCookies(Connection.Request request){
            cookies.putAll(removeIrreplaceableCookies(request));
            return this;
        }

        public ConnectionFilter beforeFilter(Connection.Request request){

            request.cookies().putAll(cookies);

            if (request.url().getPath().contains("bossviewhome.jsp")){
                loadLastFormData(request);
            }

            return this;
        }

        public ConnectionFilter afterFilter(Connection.Response response) throws IOException {

            cookies.putAll(response.cookies());
            formData.clear();

            if (response.url().getPath().contains("uvDisper.action")){
                Document document = response.parse();
                Elements input = document.getElementsByTag("input");
                for (Element element : input) {
                    formData.put(element.attr("name"), element.attr("value"));
                }
                logger.info("uvDisper.action -> \n{}", JsonHelper.toJSON(formData));
            }

            log("layoutAction.do?method=showView&ownerType=1&viewId=200", response);
            log("layoutAction.do?method=showView&ownerType=1&viewId=39", response);
            //log("layoutAction.do?method=showView&ownerType=1&viewId=39", response);

            return this;
        }

        private void loadLastFormData(Connection.Request request){
            FormDataMaker data = FormDataMaker.make(formData);
            request.requestBody(data.rawData());
            logger.info("request form:{}", JsonHelper.toJSON(data.data()));
        }

        private Map<String, String> removeIrreplaceableCookies(Connection.Request request){
            Map<String, String> cookies = request.cookies();
            for (String irreplaceableCookie : irreplaceableCookies) {
                cookies.remove(irreplaceableCookie);
            }
            return cookies;
        }

        private void log(String urlSubKeyword, Connection.Response response){
            if (response.url().toString().contains(urlSubKeyword)){
                logger.info("{} -> \n{}",
                        urlSubKeyword,
                        JsonHelper.toJSON(response.body()));
            }
        }
    }
}
