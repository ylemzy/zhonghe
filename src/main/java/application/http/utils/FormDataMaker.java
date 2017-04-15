package application.http.utils;

import org.apache.logging.log4j.util.Strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/3/6.
 */
public class FormDataMaker {
    private Map<String, String> datas = new HashMap<>();

    public static FormDataMaker make(String rawFormData){
        return new FormDataMaker(rawFormData);
    }

    public static FormDataMaker make(Map<String, String> datas){
        return new FormDataMaker(datas);
    }

    public FormDataMaker(String rawFormData){
        toMap(rawFormData);
    }

    public FormDataMaker(Map<String, String> datas){
        this.datas = datas;
    }

    public void toMap(String rawFormData){
        if (Strings.isBlank(rawFormData)){
            return;
        }

        String[] split = rawFormData.split("[&]");
        for (String s : split) {
            String[] param = s.split("[=]");
            if (param.length == 1){
                datas.put(param[0].trim(), "");
            }else if (param.length == 2){
                datas.put(param[0].trim(), param[1].trim());
            }
        }
    }

    public FormDataMaker data(String key, String value){
        datas.put(key, value);
        return this;
    }

    public Map<String, String> data(){
        return datas;
    }

    public String rawData(){
        StringBuffer buffer = new StringBuffer();
        datas.forEach((k, v)->{
            buffer.append(k + "=" + v + "&");
        });
        if (buffer.length() > 0){
            buffer.setLength(buffer.length()-1);
        }
        return buffer.toString();
    }

}
