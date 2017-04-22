package application.http.utils;

import org.junit.Test;

import java.util.List;

/**
 * Created by J on 4/22/2017.
 */
public class TextSubstitutesTest {



    @Test
    public void substitute() throws Exception {
        RequestLoader loader = RequestLoader.makeByResource("/420/rq1/34_Request.txt");
        TextSubstitutes substitutes = new TextSubstitutes(loader.load().getRequestText());
        TemplateParam templateParam = new TemplateParam();
        templateParam.put("number", "13602565600");
        templateParam.put("idCard", "460027198811272037");
        substitutes.prepareSign(templateParam);
        //substitutes.log();


        TemplateParam templateParam2 = new TemplateParam();
        templateParam2.put("number", "13510033371");
        templateParam2.put("idCard", "441402198702260434");

        List<String> substitute = substitutes.substitute(templateParam2);
        substitute.forEach(row ->{
            System.out.println(row);
        });
    }

}