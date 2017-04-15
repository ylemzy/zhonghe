package application.http.utils;

import application.http.utils.ParseRequest;
import application.http.utils.RequestCompare;
import org.jsoup.Connection;
import org.junit.Test;

/**
 * Created by J on 4/14/2017.
 */
public class ParseRequestTest {

    @Test
    public void ruoView() throws Exception {
        ParseRequest parseRequest = new ParseRequest();
        Connection connection = parseRequest.parseFrom("C:\\Users\\Administrator\\Desktop\\com\\zhonghe\\data\\181_Request.txt");
        Connection.Response execute = connection.execute();
        System.out.println(execute.body());
    }


    @Test
    public void ruoLayout() throws Exception {
        ParseRequest parseRequest = new ParseRequest();
        Connection connection = parseRequest.parseFrom("C:\\Users\\Administrator\\Desktop\\com\\zhonghe\\data\\182_Request.txt");
        Connection.Response execute = connection.execute();
        System.out.println(execute.body());
    }

    @Test
    public void yuView() throws Exception {
        ParseRequest parseRequest = new ParseRequest();
        Connection connection = parseRequest.parseFrom("C:\\Users\\Administrator\\Desktop\\com\\zhonghe\\data\\183_Request.txt");
        Connection.Response execute = connection.execute();
        System.out.println(execute.body());
    }


    @Test
    public void yuLayout() throws Exception {
        ParseRequest parseRequest = new ParseRequest();
        Connection connection = parseRequest.parseFrom("C:\\Users\\Administrator\\Desktop\\com\\zhonghe\\data\\184_Request.txt");
        Connection.Response execute = connection.execute();
        System.out.println(execute.body());
    }



}