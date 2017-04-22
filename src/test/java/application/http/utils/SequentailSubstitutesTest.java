package application.http.utils;

import org.junit.Test;

import java.util.TreeMap;

import static org.junit.Assert.*;

/**
 * Created by J on 4/22/2017.
 */
public class SequentailSubstitutesTest {

    SequentailSubstitutes sequentailSubstitutes = new SequentailSubstitutes();

    SequentialRequestLoader sequentialRequestLoader = new SequentialRequestLoader(
            "C:\\Users\\Administrator\\Desktop\\com\\zhonghe\\src\\main\\resources\\420\\rq1");

    TemplateParam templateParam = new TemplateParam();

    @Test
    public void prepareSubstituesList() throws Exception {
        templateParam.put("number", "13602565600");
        templateParam.put("idCard", "460027198811272037");

        sequentailSubstitutes.prepareSubstituesList(sequentialRequestLoader, templateParam);

        TemplateParam templateParam2 = new TemplateParam();
        templateParam2.put("number", "13510033371");
        templateParam2.put("idCard", "441402198702260434");

        TreeMap<Integer, RequestLoader> substitue = sequentailSubstitutes.substitue(templateParam2);

        SequentailExecutor sequentailExecutor = new SequentailExecutor(substitue);

        RequestLoader requestLoader = RequestLoader.makeByResource("/420/17_Request.txt");
        sequentailExecutor.execute(requestLoader.load().parse());
    }

    @Test
    public void substitue() throws Exception {

    }

}