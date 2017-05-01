package application.http.utils;

import application.bean.LoaderManager;
import application.bean.ParamManager;
import application.bean.SessionManager;
import application.fetch.Request;
import application.uil.JsonHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.util.Assert;

import java.util.*;

/**
 * Created by J on 4/22/2017.
 */
public class SequentailSubstitutes {

    private static final Logger logger = LogManager.getLogger();
    TreeMap<Integer, TextSubstitutes> substitutesTreeMap = new TreeMap<>();


    public void prepareSubstituesList(SequentialRequestLoader sequentialLoader, TemplateParam params) throws Exception {
        Assert.isTrue(params.size() > 0);
        //TreeMap<Integer, RequestLoader> data = sequentialLoader.load().getData();
        TreeMap<Integer, RequestLoader> data = sequentialLoader.getData();
        Iterator<Map.Entry<Integer, RequestLoader>> iterator = data.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer, RequestLoader> next = iterator.next();
            try {
                List<String> requestText = next.getValue().load().getRequestText();
                TextSubstitutes textSubstitutes = new TextSubstitutes(requestText);
                textSubstitutes.prepareSign(params);//根据参数替换出签名
                UrlInfo.log(next.getValue().parse().request().url().toString(), "substituted", JsonHelper.toJSON(textSubstitutes.getSubstituteDom()));

                substitutesTreeMap.put(next.getKey(), textSubstitutes);//key为request模板名，按照fiddler的保存顺序
            } catch (Exception e) {
                logger.error(e, e);
            }
        }
    }

    TreeMap<Integer, RequestLoader> substitue(TemplateParam params){
        TreeMap<Integer, RequestLoader> sequentailLoader = new TreeMap<>();

        substitutesTreeMap.forEach((k, v)->{
            List<String> substitute = v.substitute(params);
            RequestLoader loader = RequestLoader.makeByText(substitute);
            sequentailLoader.put(k, loader);
        });

        return sequentailLoader;
    }

    public void execute(TemplateParam params) throws Exception {

        TreeMap<Integer, RequestLoader> substitue = this.substitue(params);
        SequentailExecutor sequentailExecutor = new SequentailExecutor(substitue);
        RequestLoader requestLoader = null;
        if (SessionManager.getSession() == null){
            requestLoader = RequestLoader.makeByResource("/420/16_Request.txt");
        }else{
            requestLoader = RequestLoader.makeByText(SessionManager.getSession().toStringList());
        }
        sequentailExecutor.execute(requestLoader.load().parse());
    }

}
