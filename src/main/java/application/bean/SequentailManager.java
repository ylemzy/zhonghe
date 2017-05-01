package application.bean;

import application.http.utils.SequentailSubstitutes;
import application.http.utils.UrlInfo;

/**
 * Created by J on 5/1/2017.
 */
public class SequentailManager {
    static SequentailSubstitutes sequentailSubstitutes;
    static {
        sequentailSubstitutes  = new SequentailSubstitutes();
        UrlInfo.addUrlKeyword("getMainProID");
        try {
            sequentailSubstitutes.prepareSubstituesList(LoaderManager.loadByResource(), ParamManager.getParam());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SequentailSubstitutes getSequentailSubstitutes() {
        return sequentailSubstitutes;
    }
}
