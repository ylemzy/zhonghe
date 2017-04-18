package application.http.utils;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/4/15.
 */
public class BatchRequestCompareTest {

    BatchRequestCompare compare = new BatchRequestCompare(
            "C:\\Users\\Administrator\\Desktop\\com\\zhonghe\\src\\main\\resources\\leftConnection",
            "C:\\Users\\Administrator\\Desktop\\com\\zhonghe\\src\\main\\resources\\rightConnection");

    @Test
    public void compare() throws Exception {
        compare.compare();
    }

}