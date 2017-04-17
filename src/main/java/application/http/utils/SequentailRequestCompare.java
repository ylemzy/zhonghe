package application.http.utils;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.TreeMap;

/**
 * Created by Administrator on 2017/4/17.
 */
public class SequentailRequestCompare {
    private static final Logger logger = LogManager.getLogger();
    SequentialRequestLoader loader;

    public SequentailRequestCompare(String dir) {
       loader = new SequentialRequestLoader(dir);
    }

    public void compare() throws Exception {
        loader.load();
        TreeMap<Integer, RequestLoader> data = loader.getData();

        Iterator<Integer> iterator = data.keySet().iterator();

        Integer current = null;
        if (iterator.hasNext()){
            current = iterator.next();
        }

        File file = new File(loader.getDirName() + "/" + "diff/diff");
        file.delete();
        //file.deleteOnExit();
        logger.info("save diff -> {}", file);
        while (iterator.hasNext()){
            Integer next = iterator.next();
            RequestLoader currentLoader = data.get(current);
            RequestLoader nextLoader = data.get(next);
            RequestCompare com = new RequestCompare(currentLoader.getConnection(), nextLoader.getConnection());
            String compare = com.compare();
            try {
                FileUtils.writeStringToFile(file, compare, "utf-8", true);
            } catch (IOException e) {
                e.printStackTrace();
            }
            current = next;
        }

    }
}
