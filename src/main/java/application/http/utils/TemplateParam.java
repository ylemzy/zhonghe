package application.http.utils;/**
 * Created by huangzebin on 2017/4/18.
 */

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class TemplateParam extends HashMap<String, String>{
    private static final Logger logger = LogManager.getLogger();

    public void replaceValueByThird(final String diffKey, final String diffValue, final TemplateParam third, DiffValue newValue){
        String value = diffValue;
        for (Map.Entry<String, String> entry : this.entrySet()) {
            value = value.replace(entry.getValue(), third.get(entry.getKey()));
        }
        newValue.put(diffKey, value);
    }
}
