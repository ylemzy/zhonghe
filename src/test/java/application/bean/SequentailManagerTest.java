package application.bean;

import application.http.utils.SequentailSubstitutes;
import application.http.utils.TemplateParam;
import application.http.utils.UrlInfo;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by J on 5/1/2017.
 */
public class SequentailManagerTest {

    @Test
    public void test() throws Exception {
        //UrlInfo.addUrlKeyword("getMainProID");
        TemplateParam param2 = new TemplateParam();
        param2.put("number", "15986661801");
        param2.put("idCard", "441622198706102317");
        SequentailSubstitutes sequentailSubstitutes = SequentailManager.getSequentailSubstitutes();
        sequentailSubstitutes.execute(param2);

    }
}