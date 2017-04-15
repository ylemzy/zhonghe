package application.http.utils;

import org.jsoup.Connection;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/4/15.
 */
public class RequestCompareTest {
    @Test
    public void compare() throws Exception {
        ParseRequest request1 = new ParseRequest();
        Connection c1 = request1.parseFrom("C:\\Users\\Administrator\\Desktop\\com\\zhonghe\\data\\181_Request.txt");

        ParseRequest request2 = new ParseRequest();
        Connection c2 = request2.parseFrom("C:\\Users\\Administrator\\Desktop\\com\\zhonghe\\data\\183_Request.txt");

        RequestCompare requestCompare = new RequestCompare(c1, c2);
        requestCompare.compare();
    }

}