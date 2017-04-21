package application.http.utils;

import org.jsoup.Connection;

/**
 * Created by J on 4/21/2017.
 */
public class ParamConnect {


    private Connection connection;

    private DiffValue value;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public DiffValue getValue() {
        return value;
    }

    public void setValue(DiffValue value) {
        this.value = value;
    }
}
