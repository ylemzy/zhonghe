package application.bean;

import java.util.Arrays;
import java.util.List;

/**
 * Created by J on 4/30/2017.
 */
public class Session {

   private String session;

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public List<String> toStringList(){
        return Arrays.asList(session.split("\n"));
    }
}