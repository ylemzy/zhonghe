package application.http.utils;

import application.uil.JsonHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.omg.CORBA.INTERNAL;

import java.io.File;
import java.util.*;

/**
 * Created by Administrator on 2017/4/15.
 */
public class SequentialRequestLoader {

    private static final Logger logger = LogManager.getLogger();

    private String dirName;

    private TreeMap<Integer, RequestLoader> data = new TreeMap<>();

    private List<RequestLoader> sequentail = new ArrayList<>();

    public String getDirName() {
        return dirName;
    }

    public SequentialRequestLoader(String dir){
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
            String name = file.getName();
            String replace = name.replace("_Request.txt", "");

            Integer key = Integer.valueOf(replace);
            data.put(key, requestLoader);
        }

    }

    public TreeMap<Integer, RequestLoader> getData() {
        return data;
    }
}
