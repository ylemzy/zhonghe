package application.uil;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by J on 4/14/2017.
 */
public class ParseRequestTest {

    @Test
    public void test() throws Exception {
        ParseRequest parseRequest = new ParseRequest();
        parseRequest.parseFrom("C:\\Users\\J\\Desktop\\data_compare\\zhonghe\\data\\r1");
    }

}