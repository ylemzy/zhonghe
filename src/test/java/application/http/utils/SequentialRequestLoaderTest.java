package application.http.utils;

import application.uil.JsonHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/4/17.
 */
public class SequentialRequestLoaderTest {
    private static final Logger logger = LogManager.getLogger();
    SequentialRequestLoader loader = new SequentialRequestLoader(
            "C:\\Users\\Administrator\\Desktop\\com\\zhonghe\\src\\main\\resources\\417\\rq"
    );

    @Test
    public void load() throws Exception {
      loader.load();
      //logger.info(JsonHelper.toJSON(loader.getData()));
    }
}