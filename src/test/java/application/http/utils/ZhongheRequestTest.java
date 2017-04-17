package application.http.utils;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/4/15.
 */
public class ZhongheRequestTest {
    //ZhongheRequest r = new ZhongheRequest("13602565600", "460027198811272037");
    ZhongheRequest r = new ZhongheRequest("13510033371", "441402198702260434");

    @Test
    public void qryCustInfo() throws Exception {
    }

    @Test
    public void checkProvFeeMenu() throws Exception {

    }

    @Test
    public void uvDisper() throws Exception {
        r.uvDisper();
    }


    @Test
    public void layoutAction78() throws Exception {
        r.layoutAction78();
    }

    @Test
    public void sequentially() throws Exception {
        r.sequentially();

    }

}