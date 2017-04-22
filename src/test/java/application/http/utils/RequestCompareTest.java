package application.http.utils;

import org.jsoup.Connection;
import org.junit.Test;

/**
 * Created by Administrator on 2017/4/15.
 */
public class RequestCompareTest {
    @Test
    public void compare() throws Exception {
        RequestLoader request11 = RequestLoader.makeByResource("layoutAction39");
        Connection c1 = request11.parse();

        RequestLoader request2 = RequestLoader.makeByResource("layoutAction78");
        Connection c2 = request2.parse();

        RequestCompare requestCompare = new RequestCompare(c1, c2);
        requestCompare.compare();
    }

}