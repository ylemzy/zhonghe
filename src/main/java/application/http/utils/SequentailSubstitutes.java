package application.http.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by J on 4/22/2017.
 */
public class SequentailSubstitutes {

    private static final Logger logger = LogManager.getLogger();
    TreeMap<Integer, TextSubstitutes> substitutesTreeMap = new TreeMap<>();

    public void prepareSubstituesList(SequentialRequestLoader sequentialLoader, TemplateParam params) throws Exception {
        TreeMap<Integer, RequestLoader> data = sequentialLoader.load().getData();
        Iterator<Map.Entry<Integer, RequestLoader>> iterator = data.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer, RequestLoader> next = iterator.next();
            try {
                List<String> requestText = next.getValue().load().getRequestText();
                TextSubstitutes textSubstitutes = new TextSubstitutes(requestText);
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
