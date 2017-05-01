package application.controller;

import application.bean.Session;
import application.bean.SessionManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
        SessionManager.setSession(session);
        System.out.println(session.getSession());
        return "message";
    }
}
