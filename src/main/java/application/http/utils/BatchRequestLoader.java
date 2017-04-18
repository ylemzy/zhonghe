package application.http.utils;

import application.uil.JsonHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/4/15.
 */
public class BatchRequestLoader {

    private static final Logger logger = LogManager.getLogger();

    private String dirName;

    private Map<String, RequestLoader> data = new HashMap<>();

    public String getDirName() {
        return dirName;
    }

    public BatchRequestLoader(String dir){
        this.dirName = dir;
    }

    public void load() throws Exception {
        File dir = new File(dirName);
        if (!dir.exists())
            return;


        File[] files = dir.listFiles();
        logger.info("Loading files {}", JsonHelper.toJSON(files));
        for (File file : files) {
            if (file.isDirectory())
                continue;
            RequestLoader requestLoader = RequestLoader.makeByFile(file.getAbsolutePath());
            requestLoader.parse();
            data.put(requestLoader.getUrl(), requestLoader);
        }
    }


    public Map<String, RequestLoader> getData() {
        return data;
    }
}
