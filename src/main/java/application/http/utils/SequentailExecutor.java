package application.http.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Connection;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by J on 4/22/2017.
 */
public class SequentailExecutor {
    private static final Logger logger = LogManager.getLogger();

    TreeMap<Integer, RequestLoader> sequentailLoader;

    final static String[] replaceableCookies = {
            "sna_cookie",
            "JSESSIONID",
            "rootTicket",
            "loginCookie",
            "staffInfoCookie",
            "IPAddr"
    };

    final static String[] irreplaceableCookies = {
            "com.huawei.boss.CURRENT_MENUID",
            "com.huawei.boss.CURRENT_TAB",
            "com.huawei.boss.CURRENT_USER",
            "com.huawei.boss.CONTACTID",
    };


    public SequentailExecutor(TreeMap<Integer, RequestLoader> sequentailLoader) {
        this.sequentailLoader = sequentailLoader;
    }

    public void execute(Connection previousConn) throws Exception {
        Iterator<Map.Entry<Integer, RequestLoader>> iterator = sequentailLoader.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer, RequestLoader> next = iterator.next();
            previousConn = execute(next.getValue(), previousConn);
        }
    }

    private Map<String, String> removeIrreplaceableCookies(Connection.Request request){
        Map<String, String> cookies = request.cookies();
        for (String irreplaceableCookie : irreplaceableCookies) {
            cookies.remove(irreplaceableCookie);
        }
        return cookies;
    }

    public Connection execute(RequestLoader loader, Connection previousConn) throws Exception {

        Connection parse = loader.load().parse();
        Connection.Request request = previousConn.request();
        if (request != null){
            parse.cookies(removeIrreplaceableCookies(request));
        }

        Connection.Response response = previousConn.response();
        if (response != null){
            parse.cookies(response.cookies());
        }

        Connection.Response execute = previousConn.execute();


        return parse;
    }
}
