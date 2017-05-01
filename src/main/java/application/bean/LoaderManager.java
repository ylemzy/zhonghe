package application.bean;

import application.http.utils.SequentialRequestLoader;

/**
 * Created by J on 5/1/2017.
 */
public class LoaderManager {


    static SequentialRequestLoader sequentialRequestLoader = new SequentialRequestLoader();

    public static SequentialRequestLoader loadByResource() {
        sequentialRequestLoader.loadByResource();
        return sequentialRequestLoader;
    }
}
