package application.http.utils;

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
        TreeMap<Integer, RequestLoader> data = sequentialLoader.load().getData();
        Iterator<Map.Entry<Integer, RequestLoader>> iterator = data.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer, RequestLoader> next = iterator.next();
            try {
                List<String> requestText = next.getValue().load().getRequestText();
                TextSubstitutes textSubstitutes = new TextSubstitutes(requestText);
                UrlInfo.log(next.getValue().parse().request().url().toString(), "substituted", JsonHelper.toJSON(textSubstitutes.getSubstituteDom()));
                textSubstitutes.prepareSign(params);

                substitutesTreeMap.put(next.getKey(), textSubstitutes);
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

}
