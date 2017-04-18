package application.http.utils;/**
 * Created by huangzebin on 2017/4/18.
 */

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Connection;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.TreeMap;

public class SequentailRequestReplay {
    private static final Logger logger = LogManager.getLogger();
    SequentialRequestLoader loader;


    public SequentailRequestReplay(String dir) {
        loader = new SequentialRequestLoader(dir);
    }

    private void updateConnect(DiffValue diffValue){

    }

    public void compare() throws Exception {
        loader.load();
        TreeMap<Integer, RequestLoader> data = loader.getData();

        data.forEach((k, loader) ->{
            Connection connection = loader.getConnection();

        });

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

/*    public DiffValue getDiffValue() {
        return diffValue;
    }

    public void setDiffValue(DiffValue diffValue) {
        this.diffValue = diffValue;
    }*/
}
