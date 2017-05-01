package application.bean;

/**
 * Created by J on 4/30/2017.
 */
public class SessionManager {
    static Session session;

    public static Session getSession() {
        return session;
    }

    public static void setSession(Session session) {
        SessionManager.session = session;
    }
}
