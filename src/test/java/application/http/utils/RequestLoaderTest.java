package application.http.utils;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by J on 4/14/2017.
 */
public class RequestLoaderTest {

    @Test
    public void test() throws Exception {
        RequestLoader requestLoader = RequestLoader.makeByResource("/420/rq1/2_Request.txt");
        Connection parse = requestLoader.load().parse();
        parse.method(Connection.Method.POST);

        Connection.Response execute = parse.execute();
        System.out.println(execute.statusMessage() + execute.body());
    }


    @Test
    public void test2() throws IOException {
        //Jsoup.connect("http://10.252.150.157/ngcustcare/custsvc/xmlData/getServNumDictData.action")
        Jsoup.connect("http://10.252.150.157/ngcustcare/custlogin/initAuthSecuityConfig.action")
                .method(Connection.Method.POST)
                .requestBody("groupId=CMMobileNumberDefine")
                .post();
    }

/*
    @Test
    public void ruoView() throws Exception {
        RequestLoader requestLoader = new RequestLoader();
        Connection connection = requestLoader.parseFrom("C:\\Users\\Administrator\\Desktop\\com\\zhonghe\\data\\181_Request.txt");
        Connection.Response execute = connection.execute();
        System.out.println(execute.body());
    }


    @Test
    public void ruoLayout() throws Exception {
        RequestLoader requestLoader = new RequestLoader();
        Connection connection = requestLoader.parseFrom("C:\\Users\\Administrator\\Desktop\\com\\zhonghe\\data\\182_Request.txt");
        Connection.Response execute = connection.execute();
        System.out.println(execute.body());
    }

    @Test
    public void yuView() throws Exception {
        RequestLoader requestLoader = new RequestLoader();
        Connection connection = requestLoader.parseFrom("C:\\Users\\Administrator\\Desktop\\com\\zhonghe\\data\\183_Request.txt");
        Connection.Response execute = connection.execute();
        System.out.println(execute.body());
    }


    @Test
    public void yuLayout() throws Exception {
        RequestLoader requestLoader = new RequestLoader();
        Connection connection = requestLoader.parseFrom("C:\\Users\\Administrator\\Desktop\\com\\zhonghe\\data\\184_Request.txt");
        Connection.Response execute = connection.execute();
        System.out.println(execute.body());
    }
*/



}