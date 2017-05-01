package application.http.utils;

import application.uil.JsonHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

/**
 * Created by J on 4/21/2017.
 */
public class TextSubstitutes {

    private static final Logger logger = LogManager.getLogger();

    List<String> requestText;

    public Map<String, String> getSubstituteDom() {
        return substituteDom;
    }

    public void setSubstituteDom(Map<String, String> substituteDom) {
        this.substituteDom = substituteDom;
    }

    Map<String, String> substituteDom = new HashMap<>();//key of substituted value, sign of substituted key,

    public TextSubstitutes(List<String> requestText) {
        this.requestText = requestText;
    }

    public void prepareSign(TemplateParam params){
        params.forEach((k, v) ->{
            prepareSign(k, v);
        });
    }

    public void prepareSign(String key, String value) {
        String sign = key + "_" + UUIDUtil.getUUID15();

        for (int i = 0; i < requestText.size(); ++i) {
            requestText.set(i, requestText.get(i).replace(value, sign));
        }
        substituteDom.put(key, sign);
    }

    //替换参数，生成真实request
    public List<String> substitute(TemplateParam params) {

        List<String> request = new ArrayList<>();
        String tmp = null;
        for (String str : requestText) {

            Iterator<Map.Entry<String, String>> iterator = params.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, String> next = iterator.next();
                String s = substituteDom.get(next.getKey());
                str = str.replace(s, next.getValue());
            }

            request.add(str);
        }

        return request;
    }


    public void log(){
        requestText.forEach(row->{
            logger.info("requestText {}", row);
        });

        logger.info("substituteDom {}", JsonHelper.toJSON(substituteDom));
    }
}
