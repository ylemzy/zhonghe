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

public class SequentailRequestInterCompare {
    private static final Logger logger = LogManager.getLogger();
    SequentialRequestLoader leftLoader;
    SequentialRequestLoader rightLoader;


    public SequentailRequestInterCompare(String leftDir, String rightDir) {
        leftLoader = new SequentialRequestLoader(leftDir);
        rightLoader = new SequentialRequestLoader(rightDir);
    }

    private void updateConnect(DiffValue diffValue){

    }

  /*  public RequestLoader findBy(String url){
        UrlMaker makeByResource = UrlMaker.makeByResource(url);
        String uri = makeByResource.getUri();

    }*/

    public void compare() throws Exception {
        leftLoader.load();
        rightLoader.load();
        TreeMap<Integer, RequestLoader> leftSequense = leftLoader.getData();
        TreeMap<Integer, RequestLoader> rightSequense = rightLoader.getData();

        leftSequense.forEach((k, loader) ->{
            Connection connection = loader.getConnection();
            String uri = UrlMaker.make(connection.request().url().toString()).getUri();
            rightSequense.forEach((k2, loader2) ->{
                Connection connection2 = loader2.getConnection();
                String uri2 = UrlMaker.make(connection2.request().url().toString()).getUri();
                if (uri.equals(uri2)){

                }
            });

        });

        Iterator<Integer> iterator = leftSequense.keySet().iterator();

        Integer current = null;
        if (iterator.hasNext()){
            current = iterator.next();
        }

        File file = new File(leftLoader.getDirName() + "/" + "diff/diff");
        file.delete();
        //file.deleteOnExit();
        logger.info("save diff -> {}", file);
        while (iterator.hasNext()){
            Integer next = iterator.next();
            RequestLoader currentLoader = leftSequense.get(current);
            RequestLoader nextLoader = leftSequense.get(next);
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
