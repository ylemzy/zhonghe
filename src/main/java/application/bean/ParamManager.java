package application.bean;

import application.http.utils.TemplateParam;

/**
 * Created by J on 4/30/2017.
 */
public class ParamManager {

    public static TemplateParam param;

    static {
        param = new TemplateParam();

        param.put("number", "13602565600");
        param.put("idCard", "460027198811272037");

        /*templateParam2.put("number", "13510033371");
        templateParam2.put("idCard", "441402198702260434");*/

    }

    public static TemplateParam getParam() {
        return param;
    }


    public static TemplateParam param2;

    static {
        param2 = new TemplateParam();

        param2.put("number", "13602565600");

        /*templateParam2.put("number", "13510033371");
        templateParam2.put("idCard", "441402198702260434");*/

    }

    public static TemplateParam getParam2() {
        return param2;
    }
}
