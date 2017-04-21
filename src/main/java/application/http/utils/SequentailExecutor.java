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


    public void execute(Connection previousConn) throws Exception {
        Iterator<Map.Entry<Integer, RequestLoader>> iterator = sequentailLoader.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer, RequestLoader> next = iterator.next();
            previousConn = execute(next.getValue(), previousConn);
        }
    }

    public Connection execute(RequestLoader loader, Connection previousConn) throws Exception {

        Connection parse = loader.load().parse();
        Connection.Request request = previousConn.request();
        if (request != null){
            parse.cookies(request.cookies());
        }

        Connection.Response response = previousConn.response();
        if (response != null){
            parse.cookies(response.cookies());
        }

        Connection.Response execute = previousConn.execute();


        return parse;
    }
}
