package application.http.utils;

import application.bean.ParamManager;
import application.bean.SequentailManager;
import application.uil.JsonHelper;
import org.junit.Test;

import java.io.File;
import java.util.TreeMap;

/**
 * Created by J on 4/22/2017.
 */
public class SequentailSubstitutesTest {

    SequentailSubstitutes sequentailSubstitutes = new SequentailSubstitutes();

    SequentialRequestLoader sequentialRequestLoader = new SequentialRequestLoader(
            "C:\\Users\\Administrator\\Desktop\\com\\zhonghe\\src\\main\\resources\\420\\rq1");

    TemplateParam templateParam = new TemplateParam();

    TemplateParam templateParam2 = new TemplateParam();

    @Test
    public void getSequentailName(){
        File dir = new File("C:\\Users\\J\\Desktop\\data_compare\\zhonghe\\src\\main\\resources\\420\\rq1");
        if (!dir.exists())
            return;

        File[] files = dir.listFiles();
        System.out.println(JsonHelper.toJSON(files));


        for (File file : files) {
            if (file.isDirectory())
                continue;

            System.out.println("\"" + file.getName() + "\",");
        }

    }

    public void init(){
        templateParam.put("number", "13602565600");
        templateParam.put("idCard", "460027198811272037");


        /*templateParam2.put("number", "13510033371");
        templateParam2.put("idCard", "441402198702260434");*/

        templateParam2.put("number", "15986661801");
        templateParam2.put("idCard", "441622198706102317");
    }

    @Test
    public void prepareSubstituesList() throws Exception {

        init();

        UrlInfo.addUrlKeyword("getMainProID");
        sequentailSubstitutes.prepareSubstituesList(sequentialRequestLoader, templateParam);

        TreeMap<Integer, RequestLoader> substitue = sequentailSubstitutes.substitue(templateParam2);

        SequentailExecutor sequentailExecutor = new SequentailExecutor(substitue);

        RequestLoader requestLoader = RequestLoader.makeByResource("/420/16_Request.txt");
        sequentailExecutor.execute(requestLoader.load().parse());
    }

    @Test
    public void substitue() throws Exception {

        //SequentailManager.getSequentailSubstitutes().execute(templateParam2);
    }

}