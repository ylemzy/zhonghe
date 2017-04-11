package application.controller;

import application.service.NewsService;
import application.uil.JsonHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by huangzebin on 2017/3/3.
 */
@RestController
public class FetchController {

    private static final Logger logger = LogManager.getLogger();

    @Autowired
    NewsService newsService;

    @RequestMapping(value = "/start", method = RequestMethod.POST)
    public void start(@RequestBody String param){
        logger.info("start ids : {}", param);
        List<String> ids = JsonHelper.toList(param);
        newsService.start(ids);
    }
}
