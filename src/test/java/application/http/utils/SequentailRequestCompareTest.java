package application.http.utils;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/4/17.
 */
public class SequentailRequestCompareTest {

    SequentailRequestCompare compare = new SequentailRequestCompare(
            "C:\\Users\\Administrator\\Desktop\\com\\zhonghe\\src\\main\\resources\\417\\rq"
    );

    @Test
    public void compare() throws Exception {
        compare.compare();
    }

}