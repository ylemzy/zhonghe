package application.controller;

import application.bean.*;
import application.elastic.repository.UserBatchSaver;
import application.fetch.UserDetail;
import application.http.utils.TemplateParam;
import application.uil.CsvWriter;
import application.uil.JsonHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by J on 4/30/2017.
 */
@Controller
public class GreetingController {


    @Autowired
    UserBatchSaver userBatchSaver;


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

/*    @RequestMapping(value = "/query", method= RequestMethod.POST)
    public String save(@ModelAttribute(value="query") QueryParams query, Model model) throws Exception {
        List<TemplateParam> templateParams = toTemplateParams(query.getParams());

        List<ExecuteResult> results = new ArrayList<>();
        for (int i = 0; i < templateParams.size(); ++i){
            ExecuteResult execute = SequentailManager.getSequentailSubstitutes().execute(templateParams.get(i));
            results.add(execute);
            userBatchSaver.save(execute);
        }

        model.addAttribute("result", JsonHelper.toJSON(results));
        return "result";
    }*/

    @RequestMapping(value = "/query", method= RequestMethod.POST)
    public String queryAuto(@ModelAttribute(value="query") QueryParams query, Model model) throws Exception {
        List<TemplateParam> templateParams = toTemplateParams2(query.getParams());

        List<ExecuteResult> results = new ArrayList<>();
        for (int i = 0; i < templateParams.size(); ++i){
            ExecuteResult execute = SequentailManager.getSequentailSubstitutes().execute(templateParams.get(i));
            results.add(execute);
            userBatchSaver.save(execute);
        }

        saveToCsv(results);
        model.addAttribute("result", JsonHelper.toJSON(results));
        return "result";
    }

    public void saveToCsv(List<ExecuteResult> datas){
        CsvWriter csvWriter = new CsvWriter();
        datas.forEach(item->{
            csvWriter.write(pickData(item));
        });

        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String format = simpleDateFormat.format(date);
        csvWriter.write2LocalFile("D:/query/" + format + ".csv");
    }

    public List<String> pickData(ExecuteResult executeResult){
        UserDetail userDetail = executeResult.getUserDetail();
        Map<String, Object> map = JsonHelper.toMap(userDetail.getText());

        List<String> res = new ArrayList<>();
        res.add(map.get("客户名称").toString());
        res.add(map.get("产品类型").toString());
        res.add(map.get("用户状态").toString());
        res.add(map.get("帐户余额").toString());
        res.add(map.get("可用预付金").toString());
        res.add(map.get("专款专用帐户余额").toString());
        return res;
    }


/*    private List<TemplateParam> toTemplateParams(String query){
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
    }*/

    private List<TemplateParam> toTemplateParams2(String query){
        String[] split = query.split("\n");

        List<TemplateParam> templateParams = new ArrayList<>();
        for (int i = 0; i < split.length; ++i){
            TemplateParam param = new TemplateParam();
            param.put("number", split[i].trim());
            templateParams.add(param);
        }
        return templateParams;
    }

}
