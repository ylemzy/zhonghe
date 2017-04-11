package application.http.request;

import application.http.utils.CookieMaker;
import application.http.utils.FormDataMaker;
import application.http.utils.UrlMaker;
import application.uil.JsonHelper;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by huangzebin on 2017/3/2.
 */
public class HttpRequestTest {




    public void setUser(){

    }

   /* @Test
    public void initAuthSecuityConfig() throws IOException {
        *//*
        * LIFE_TIME
        * com.huawei.boss.CURRENT_USER
        * compareCookie
        * *//*
        CookieMaker cookieMaker = new CookieMaker(cookies);
        Connection.Response execute = Jsoup.connect("http://10.252.150.157/ngcustcare/custlogin/initAuthSecuityConfig.action")
                .method(Connection.Method.POST)
                .cookies(cookieMaker.data())
                .execute();
        System.out.println(execute.body().toString());
    }

    @Test
    public void getMainProID() throws IOException {
        CookieMaker cookieMaker = new CookieMaker(cookies);
        Connection.Response execute = Jsoup.connect("http://10.252.150.157/ngcustcare/custlogin/getMainProID.action?servNumber=" + phone)
                .data()
                .method(Connection.Method.POST)
                .cookies(cookieMaker.data())
                .execute();
        System.out.println(execute.body().toString());
    }

    @Test
    public void idCardActionCheck() throws IOException {
        CookieMaker cookieMaker = new CookieMaker(cookies);
        Connection.Response execute = Jsoup.connect("http://10.252.150.157/ngcustcare/custsvc/certcheck/idCardActionCheck.action")
                .data()
                .method(Connection.Method.POST)
                .cookies(cookieMaker.data())
                .data("certId", certId)
                .execute();
        System.out.println(execute.body().toString());
    }

*//*    method	qryCustInfo
    servNumber	13602565600
    authCheckMode	AuthCheckD
    verifyCode
            pswd
    certType	IdCard
    certID	460027198811272037
    rndPswd
    custType	PersonCustomer
    domainType
            isCert2G
    ONLYLOGIN	onlyLogin
    withoutPassValidate	false
    isUseReadIdCardWithTwo	0*//*

    @Test
    public void qryCustInfo() throws IOException {
        CookieMaker cookieMaker = new CookieMaker(cookies);
        Connection.Response execute = Jsoup.connect("http://10.252.150.157/ngcustcare/custlogin/qryCustInfo.action")
                .data()
                .method(Connection.Method.POST)
                .cookies(cookieMaker.data())
                .data("method", "qryCustInfo")
                .data("servNumber", phone)
                .data("authCheckMode", "AuthCheckD")
                .data("verifyCode", "")
                .data("pswd", "")
                .data("certType", "IdCard")
                .data("certID", certId)
                .data("rndPswd", "PersonCustomer")
                .data("domainType", "")
                .data("isCert2G", "")
                .data("ONLYLOGIN", "onlyLogin")
                .data("withoutPassValidate", "false")
                .data("isUseReadIdCardWithTwo", "0")

                .execute();
        System.out.println(execute.body().toString());
    }

    @Test
    public void commonFunctionalAction() throws IOException {
        CookieMaker cookieMaker = new CookieMaker(cookies);
        Connection connection = Jsoup.connect("http://10.252.150.157/ngcustcare/backreception/commonFunctional/commonFunctionalAction!getCurrAuthTypeMode.action?")
                .data()
                .method(Connection.Method.POST)
                .cookies(cookieMaker
                        .cookie(co_current_user, co_current_user_value)
                        .cookie(co_current_tab, co_current_tab_value)
                        .cookie(co_current_menuid, co_current_menuid_value)
                        .data());

        System.out.println(JsonHelper.toJSON(cookieMaker.data()));

        Connection.Response execute = connection
                .execute();

        System.out.println(execute.body().toString());
    }

    @Test
    public void loadBatchReceptionCustom() throws IOException {
        CookieMaker cookieMaker = new CookieMaker(cookies);
        Connection connection = Jsoup.connect("http://10.252.150.157/ngcustcare/backreception/loadBatchReceptionCustom!queryCustRuleForAuthListCount.action?servnumber=" + phone)
                .data()
                .method(Connection.Method.POST)
                .cookies(cookieMaker
                        .cookie(co_current_user, co_current_user_value)
                        .cookie(co_current_tab, co_current_tab_value)
                        .cookie(co_current_menuid, co_current_menuid_value)
                        .data());

        System.out.println(JsonHelper.toJSON(cookieMaker.data()));

        Connection.Response execute = connection
                .execute();

        System.out.println(execute.body().toString());
    }

    @Test
    public void remoteCall1() throws IOException {
        CookieMaker cookieMaker = new CookieMaker(cookies);
        Connection connection = Jsoup.connect("http://10.252.150.157/ngcustcare/remoteCall.action")
                .data()
                .method(Connection.Method.POST)
                .cookies(cookieMaker
                        .cookie(co_current_user, co_current_user_value)
                        .cookie(co_current_tab, co_current_tab_value)
                        .cookie(co_current_menuid, co_current_menuid_value)
                        .data());

        System.out.println(JsonHelper.toJSON(cookieMaker.data()));

        Connection.Response execute = connection
                .data("remoteCallXml", "@260@263xml@232version@261@2341@2460@234@232encoding@261@234UTF@2458@234@263@262@260huawei@295call@262@260i@262product@247targetcustsale@247@242@260@247i@262@260e@262getCmpPopHintMessage@260@247e@262@260p@262@260@247p@262@260@247huawei@295call@262")
                .execute();

        System.out.println(execute.body().toString());
    }

    @Test
    public void remoteCall2() throws IOException {
        CookieMaker cookieMaker = new CookieMaker(cookies);
        Connection connection = Jsoup.connect("http://10.252.150.157/ngcustcare/remoteCall.action")
                .data()
                .method(Connection.Method.POST)
                .cookies(cookieMaker
                        .cookie(co_current_user, co_current_user_value)
                        .cookie(co_current_tab, co_current_tab_value)
                        .cookie(co_current_menuid, co_current_menuid_value)
                        .data());

        System.out.println(JsonHelper.toJSON(cookieMaker.data()));

        Connection.Response execute = connection
                .data("remoteCallXml", "@260@263xml@232version@261@2341@2460@234@232encoding@261@234UTF@2458@234@263@262@260huawei@295call@262@260i@262product@247targetcustsale@247@242@260@247i@262@260e@262checkCanActivityPopUpMessage@260@247e@262@260p@262@260@247p@262@260@247huawei@295call@262")
                .execute();

        System.out.println(execute.body().toString());
    }
*/

   public void layoutAction200(CookieMaker cookieMaker) throws IOException {
       Connection connection = Jsoup.connect("http://10.252.150.157/nguniteview/layoutAction.do?method=showView&ownerType=1&viewId=200")
               .data()
               .method(Connection.Method.POST)
               .cookies(cookieMaker.data());

       outputRequest(connection.request());
       Connection.Response execute = connection
               .execute();

       System.out.println(execute.body().toString());
   }
    @Test
    public void disper() throws IOException {
        TestDocument.RequestData requestData = TestDocument.getUser();
        String tabId = "BOSS^" + requestData.getPhone() + "^100110121062~" + requestData.getPhone();
        UrlMaker urlMaker = UrlMaker.make("http://10.252.150.157/ngcustcare/uniteview/uviewtwo/uvDisper.action")
                .param("currentTabID", tabId);

        CookieMaker cookieMaker = new CookieMaker(requestData.getCookies())
                //.cookie("com.huawei.boss.CURRENT_TAB", tabId)
                //.cookie("com.huawei.boss.CURRENT_USER", requestData.getPhone())
                ;

        Connection connection = Jsoup.connect(urlMaker.getUrl())
                .header("Content-Type", "application/x-www-form-urlencoded")
                .cookies(cookieMaker.data());

        outputRequest(connection.request());
        Document document = connection
                .get();
                //.cookies(cookieMaker.data());

        //System.out.println(document.toString());

        Elements input = document.getElementsByTag("input");

        Map<String, String> orgData = new HashMap<>();
        input.forEach(e->{
            String value = e.attr("value");
            String name = e.attr("name");
            orgData.put(name, value);
        });

        bossViewHome(orgData, cookieMaker);
        layoutAction200(cookieMaker);
    }

    private void outputRequest(Connection.Request request){
       System.out.println("url = " + JsonHelper.toJSON(request.url()));
       System.out.println("headers = " + JsonHelper.toJSON(request.headers()));
       System.out.println("cookies = " + JsonHelper.toJSON(request.cookies()));
       System.out.println("requestBody = " + JsonHelper.toJSON(request.requestBody()));
        System.out.println("data = " + JsonHelper.toJSON(request.data()));
    }

    public void bossViewHome(Map<String, String> data, CookieMaker cookieMaker) throws IOException {
        FormDataMaker formDataMaker = FormDataMaker.make(data);

        Connection connection = Jsoup.connect("http://10.252.150.157/nguniteview/bossviewhome.jsp")
                .method(Connection.Method.POST)
                .header("Content-Type", " application/x-www-form-urlencoded")
                .requestBody(formDataMaker.rawData());
        outputRequest(connection.request());
        Connection.Response execute = connection
                .execute();



        //System.out.println(execute.body().toString());
    }
}