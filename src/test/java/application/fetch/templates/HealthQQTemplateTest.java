package application.fetch.templates;

import application.fetch.*;
import application.uil.JsonHelper;
import org.junit.Test;

/**
 * Created by huangzebin on 2017/3/2.
 */
public class HealthQQTemplateTest {

    @Test
    public void testCategory() throws Exception {
        Template template = TemplateLoader.getTemplate("HealthQQ");
        Category category = template.category();

        category.getChildren().forEach(c->{
            if (c.isFetchable())
            System.out.println(JsonHelper.toJSON(c));
        });
    }

    @Test
    public void testPage() throws Exception {
        Template template = TemplateLoader.getTemplate("HealthQQ");
        Request page = TemplateHelper.pageRequest("http://health.qq.com/c/jibingkepu_2.htm", "xx", template.webId());
        template.page(page);
    }

    @Test
    public void testItem() throws Exception{
        Template template = TemplateLoader.getTemplate("HealthQQ");
        Request item =  TemplateHelper.newsRequest("http://health.qq.com/a/20170301/024793.htm", "xx", template.webId());
        Response process = template.item(item);
        System.out.println(JsonHelper.toJSON(process.getBody()));
    }


    @Test
    public void testFetch() throws Exception {
        Template template = TemplateLoader.getTemplate("HealthQQ");
        template.testFetch();
    }
}