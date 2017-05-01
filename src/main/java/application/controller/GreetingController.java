package application.controller;

import application.bean.*;
import application.fetch.Template;
import application.http.utils.TemplateParam;
import application.uil.JsonHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by J on 4/30/2017.
 */
@Controller
public class GreetingController {


    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("ses", new Session());
        return "greeting";
    }


    @RequestMapping(value = "/ses", method= RequestMethod.POST)
    public String save(@ModelAttribute(value="ses") Session session, Model model) {
        model.addAttribute("message", "Load ss success!");
        model.addAttribute("query", new QueryParams());
        SessionManager.setSession(session);
        System.out.println(session.getSession());
        return "message";
    }

    @RequestMapping(value = "/query", method= RequestMethod.POST)
    public String save(@ModelAttribute(value="query")QueryParams query, Model model) throws Exception {
        List<TemplateParam> templateParams = toTemplateParams(query.getParams());

        List<ExecuteResult> results = new ArrayList<>();
        for (int i = 0; i < templateParams.size(); ++i){
            ExecuteResult execute = SequentailManager.getSequentailSubstitutes().execute(templateParams.get(i));
            results.add(execute);
        }
        model.addAttribute("result", JsonHelper.toJSON(results));
        return "result";
    }

    private List<TemplateParam> toTemplateParams(String query){
        String[] split = query.split("\n");
        Assert.isTrue(split.length % 2 == 0);

        List<TemplateParam> templateParams = new ArrayList<>();
        for (int i = 0; i + 1 < split.length; i += 2){
            TemplateParam param = new TemplateParam();
            param.put("number", split[i].trim());
            param.put("idCard", split[i+1].trim());
            templateParams.add(param);
        }
        return templateParams;
    }
}
