package application.http.utils;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/4/15.
 */
public class BatchRequestLoaderTest {

    BatchRequestLoader batchRequestLoader = new BatchRequestLoader("C:\\Users\\Administrator\\Desktop\\com\\zhonghe\\src\\main\\resources\\a");

    @Test
    public void load() throws Exception {
        batchRequestLoader.load();
    }

}