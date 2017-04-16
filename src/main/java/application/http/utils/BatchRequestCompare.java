package application.http.utils;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 2017/4/15.
 */
public class BatchRequestCompare {
    private static final Logger logger = LogManager.getLogger();
    BatchRequestLoader batchLoader1;
    BatchRequestLoader batchLoader2;

    public BatchRequestCompare(String dir1, String dir2) {
        batchLoader1 = new BatchRequestLoader(dir1);
        batchLoader2 = new BatchRequestLoader(dir2);
    }

    public void compare() throws Exception {
        batchLoader1.load();
        batchLoader2.load();

        Map<String, RequestLoader> data1 = batchLoader1.getData();
        Map<String, RequestLoader> data2 = batchLoader2.getData();

        Set<String> allKey = new HashSet<>();
        allKey.addAll(data1.keySet());
        allKey.addAll(data2.keySet());

        allKey.forEach(key ->{
            RequestLoader loader1 = data1.get(key);
            RequestLoader loader2 = data2.get(key);
            if (loader1 != null && loader2 != null){
                RequestCompare com = new RequestCompare(loader1.getConnection(), loader2.getConnection());
                String compare = com.compare();
                int i = key.lastIndexOf("/");

                File file = new File(batchLoader1.getDirName() + "/" + "diff/" + key.substring(i));

                try {
                    logger.info("save diff -> {}", file);
                    FileUtils.writeStringToFile(file, compare, "utf-8", false);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else if (loader1 == null){

            }else if (loader2 == null){

            }

        });
    }
}
