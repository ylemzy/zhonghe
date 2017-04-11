package application.http.request;

/**
 * Created by Administrator on 2017/3/7.
 */
public class TestDocument {
    public static final String test_phone1 = "13510033371";//*瑜
    public static final String test_certId1 = "441402198702260434";

    public static final String test_phone2 = "13602565600";
    public static final String test_certId2 = "460027198811272037";


    public class RequestData{
        public String cookies;
        public String phone;
        public String certId;

        public String getCookies() {
            return cookies;
        }

        public void setCookies(String cookies) {
            this.cookies = cookies;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getCertId() {
            return certId;
        }

        public void setCertId(String certId) {
            this.certId = certId;
        }

        public RequestData(String phone, String certId, String cookies) {
            this.cookies = cookies;
            this.phone = phone;
            this.certId = certId;
        }
    }
    public static String cookiesShi = "sna_cookie=2AB424E68DB0ED612248662A642D9C855EE98D0C0C37498FA8A09DC6C8E853DF98E568DADEA58DB4E92FD9B19C3C60341FF2B1E7AE9D84CF; JSESSIONID=0000UQMa-KQmQuWmZt4r9hAvLyI:1ar31o9r5:1ar35079l:1arakp0jb; rootTicket=78AB9D34D65A0B67DAE58572EC3799C5A761D9F8096B82A91E5BF1C67AC98B6CDC353E8D6DC9819AB1089F4E8328D7C734C5E3C3A6A893DCEB1DA4B80EFDD92E; loginCookie=3708EDDFABC18AC271C4D2E8AD54FA511D6FDC59A343D88915908E66EEC26C4E86CD7B9540EC759F5D5EBE86428CC6FC1A88F36909A76ECE970FC95A5FF024B85CFE92D870833ACC63ED22CD6AAD00103708EDDFABC18AC26772EBD9D14431CDD62ECC2B6F66E2B9B7D7C70F99DB7E581A6180F400C5507128245E753F7FC715CE158EA4BE15F4AC639636A970947AB8; staffInfoCookie=Blixinda@@@BBSZ22161213048@@@755; IPAddr=10.252.126.194; BIGipServercrm_portal_sz=2627140618.14340.0000; loginTicketCookie=C707EC8AFEB12E93D27D44B6464CAAAF6A6CCFC200F1C476; LOGIN_OUT_USE_LOGINID=4B9E199D936CC09B1E2B3B05C72DE9F9A2D336A2EE24F6969D8EB6120397294A812FA1446CA242DEBE4404803E2CC34FFF08F99E6508B66F8C9E1EC1E5D6B60B9C8F8ABB539EF48FEB1DA4B80EFDD92E; dtcqsyslocation=FEC497828E8EC12206BE9D9062C6E47005EEBDFFE35CAAB2458442457D802975; LIFE_TIME=1488908480781_120; com.huawei.boss.CURRENT_MENUID=100110121062; com.huawei.boss.CURRENT_TAB=BOSS%5E13602565600%5E100110121062%7E13602565600; com.huawei.boss.CURRENT_USER=13602565600; com.huawei.boss.CONTACTID=undefined; bsacKF=NGCRM_BOSS; BIGipServercrm_crm_sz=2627140618.14596.0000; MACAddr=00-FF-98-BC-7F-89; sDNSName=SZ-20160715MMML; BIGipServercrm_comm_sz=2610363402.40452.0000; compareCookie=89129798D8D8617E8D9125B39388FC1A";
    public static String cookiesChen = "sna_cookie=2AB424E68DB0ED612248662A642D9C855EE98D0C0C37498FA8A09DC6C8E853DF98E568DADEA58DB4E92FD9B19C3C60341FF2B1E7AE9D84CF; JSESSIONID=0000UQMa-KQmQuWmZt4r9hAvLyI:1ar31o9r5:1ar35079l:1arakp0jb; rootTicket=78AB9D34D65A0B67DAE58572EC3799C5A761D9F8096B82A91E5BF1C67AC98B6CDC353E8D6DC9819AB1089F4E8328D7C734C5E3C3A6A893DCEB1DA4B80EFDD92E; loginCookie=3708EDDFABC18AC271C4D2E8AD54FA511D6FDC59A343D88915908E66EEC26C4E86CD7B9540EC759F5D5EBE86428CC6FC1A88F36909A76ECE970FC95A5FF024B85CFE92D870833ACC63ED22CD6AAD00103708EDDFABC18AC26772EBD9D14431CDD62ECC2B6F66E2B9B7D7C70F99DB7E581A6180F400C5507128245E753F7FC715CE158EA4BE15F4AC639636A970947AB8; staffInfoCookie=Blixinda@@@BBSZ22161213048@@@755; IPAddr=10.252.126.194; BIGipServercrm_portal_sz=2627140618.14340.0000; loginTicketCookie=C707EC8AFEB12E93D27D44B6464CAAAF6A6CCFC200F1C476; LOGIN_OUT_USE_LOGINID=4B9E199D936CC09B1E2B3B05C72DE9F9A2D336A2EE24F6969D8EB6120397294A812FA1446CA242DEBE4404803E2CC34FFF08F99E6508B66F8C9E1EC1E5D6B60B9C8F8ABB539EF48FEB1DA4B80EFDD92E; dtcqsyslocation=FEC497828E8EC12206BE9D9062C6E47005EEBDFFE35CAAB2458442457D802975; LIFE_TIME=1488908427283_120; com.huawei.boss.CURRENT_MENUID=100110121062; com.huawei.boss.CURRENT_TAB=BOSS%5E13510033371%5E100110121062%7E13510033371; com.huawei.boss.CURRENT_USER=13510033371; com.huawei.boss.CONTACTID=undefined; bsacKF=NGCRM_BOSS; BIGipServercrm_crm_sz=2627140618.14596.0000; MACAddr=00-FF-98-BC-7F-89; sDNSName=SZ-20160715MMML; BIGipServercrm_comm_sz=2610363402.40452.0000; compareCookie=8FC7A9CDD6094B5D5FB5F2A0875B81BE";

    public static String cookies = cookiesChen;

    public RequestData[] reqDatas = {
            new RequestData(test_phone1, test_certId1, cookiesChen),
            new RequestData(test_phone2, test_certId2, cookiesShi)
    };

    public static RequestData getUser(){
        TestDocument testDocument = new TestDocument();
        return testDocument.reqDatas[1];
    }


    public static String formData = "ccm_ObjectID=&ccm_RandomNum=&ccdirect=false&ccm_EntityID=7554051594511&ccm_EntityName=%CD%F5*%C8%F4&ccm_CreateDate=2012-04-02+17%3A30%3A00&ccm_Status=stcmNml&ccm_StatusDate=2012-04-02+17%3A49%3A43&ccm_EditStatus=0&ccm_Region=755&ccm_ShortName=&ccm_Password=&ccm_CustType=PersonCustomer&ccm_VipType=VC0000&ccm_Foreigner=0&ccm_CustClass1=CustClass111&ccm_CustClass2=CustClass201&ccm_National=China&ccm_Address=********&ccm_CertID=460027********203*&ccm_CertType=IdCard&ccm_CertAddr=********&ccm_LinkMan=%CD%F5*%C8%F4&ccm_LinkPhone=13602565600&ccm_HomeTel=&ccm_OfficeTel=&ccm_MobileTel=&ccm_PostCode=518002&ccm_LinkAddr=********&ccm_Email=&ccm_HomePage=&ccm_IsMergeBill=0&ccm_CreditLevel=crdtNormal&ccm_OwnerAreaID=&ccm_OrgID=BBSZ07900&ccm_RegStatus=1&ccm_Notes=&ccm_ResponseCustMgr=&ccm_CurrentCustMgr=&ccm_InLevel=1&ccm_TownID=&ccm_VipTypeStateDate=&ccm_NetServGrade=&ccm_CustAddrArray=%5B%5D&ccm_CustBillArray=%5B%5D&ccm_IsEncrypt=1&ccm_starLevel=4&ccm_IsFaceChk=0&ccregister=true&ccnotRegister=false&csm_ObjectID=&csm_RandomNum=&csdirect=false&csm_EntityID=7554054349760&csm_EntityName=%CD%F5*%C8%F4&csm_CreateDate=******&csm_Status=US10&csm_StatusDate=******&csm_EditStatus=0&csm_Region=755&csm_Password=MjAwNDI3&csm_ProductID=0&csm_ServNumber=13602565600&csm_RegisterOrgID=BBSZ07900&csm_OwnerOrgID=BBSZ07900&csm_AccountOid=7554052430180&csm_CustomerOid=7554051594511&csm_AuthType=AuthCheckB&csm_MobileType=mbtpNml&csm_AreaID=&csm_PayMode=1010&csm_StopKey=00000000&csm_Brand=BrandGotone&csm_StartDate=2012-04-02+17%3A30%3A00&csm_InvalidDate=2037-01-01+00%3A00%3A00&csm_SettleDay=1&csm_Enum=89860060191409808408&csm_Imsi=460002506614107&csm_Credit=0&csm_SubsProduct=%5B%5D&csm_IsDefaultTelNum=1&csm_BelongRegion=0&csm_TargetRegion=0&csm_CretLevel=&csgotone=true&csnotGotone=false&cam_ObjectID=&cam_RandomNum=&cadirect=false&cam_EntityID=7554052430180&cam_EntityName=%CD%F5*%C8%F4&cam_CreateDate=2012-04-02+17%3A30%3A00&cam_Status=stcmNml&cam_StatusDate=2012-04-02+17%3A30%3A00&cam_EditStatus=0&cam_Region=755&cam_CustID=7554051594511&cam_GroupAcctID=&cam_PrePayType=pptpPost&cam_AccountType=actpCmn&cam_OverDraft=0&cam_ControlScheme=0&cam_EntrustTel=13602565600&cam_OrgID=BBSZ07900&cam_NotifyType=&cam_NotifyValue=0&cam_InvPrintType=&cam_Notes=&cam_PayChannelArray=%5B%5D&cam_CustBillArray=%5B%5D&cam_UrgeInfos=%5B%5D&cam_SettleAccount=&cam_IsDefault=0&cam_BillInvoiceMailArray=%5B%5D&cam_NotifyValueDisplay=0.00&cam_CreateDateDisplay=2012-04-02&com_ObjectID=&com_RandomNum=&comenuId=123456&codirect=false&com_EntityID=Blixinda&com_EntityName=*%E8%A4&com_CreateDate=2016-12-19+16%3A30%3A52&com_Status=1&com_StatusDate=2016-12-19+16%3A30%3A52&com_EditStatus=0&com_Region=755&conodeID=Blixinda&conodeName=*%E8%A4&conodeParentID=BBSZ22161213048&coentityID=Blixinda&cootherParam=OPRT36&cochecked=false&com_MenuID=123456&com_ServNum=&com_TouchNum=&com_Password=F3A3F3EBF727ACB1CBB58325BF1FE308&com_OrgID=BBSZ22161213048&com_RoamOrgID=&com_PassChangeDate=2016-12-19+16%3A30%3A52&com_OperType=OPRT36&com_Manager=0&com_Level=&com_ContactPhone=13632505266&com_MacAddress=00-FF-98-BC-7F-89&com_OnDuty=0&com_Note=16121316021010&com_ShareStore=&com_BirthDay=&com_WorkDate=&com_CertID=&com_Sex=&com_EducationLevel=&com_TotalLevel=&com_SkillLevel=&com_TrainLevel=&com_ComityLevel=&com_Operator_type=0&com_NativeHome=&com_graduateDate=&com_IsMarray=0&com_PolityFace=&com_HomeAddress=&com_JobLive=&com_NowPostID=&com_BloodType=&com_Healthy=&com_Character=&com_Enjoyful=&com_PriSocietyRelation=&com_FamilyDes=&com_StarLevel=&com_AssessRec=&com_hr_status=1&com_Restrict_time=0&com_Start_time=0&com_End_time=0&com_Enable_gprs=0&com_Gprs_starttime=0&com_Gprs_endtime=0&com_Check_mac=0&com_Mac=&com_IPAddress=10.252.126.194&costartUsingTime=2016-12-19+00%3A00%3A00&coendUsingTime=2099-01-01+00%3A00%3A00&com_QueueID=&com_LoginType=SECAUTH&com_InvVersion=&com_areaID=&servNumber=13602565600&transmit=layoutAction.do%3Fmethod%3DshowLayout%26layoutId%3D1%26viewId%3D0&recType=&stopKeyValue=%D5%FD%B3%A3%CA%B9%D3%C3&remotemac=D0-17-C2-87-32-19";


    public static String document = "<html>\n" +
            "<head>\n" +
            "    <TITLE>UVNG入口</TITLE>\n" +
            "    <meta http-equiv=\"pragma\" content=\"no-cache\">\n" +
            "    <meta http-equiv=\"cache-control\" content=\"no-cache\">\n" +
            "    <meta http-equiv=\"expires\" content=\"0\">\n" +
            "    <script type=\"text/javascript\" src='http://10.252.150.157/ngcustcare/skins/default/js/jquery.js'></script>\n" +
            "    <script type=\"text/javascript\">\n" +
            "        $(function () {\n" +
            "\n" +
            "            try {\n" +
            "                $(\"#macAddress\").val(clientControl.GetMacAddress());\n" +
            "            }\n" +
            "            catch (e) {\n" +
            "                $(\"#macAddress\").val(\"\");\n" +
            "            }\n" +
            "\n" +
            "            document.forms[0].action = \"http://10.252.150.157/nguniteview/bossviewhome.jsp\";\n" +
            "            document.forms[0].submit();\n" +
            "        });\n" +
            "    </script>\n" +
            "</head>\n" +
            "<body style=\"padding: 6px;background-color: EBF0F4\" class=\"ballistic_bg\">\n" +
            "<OBJECT ID=\"clientControl\" Name=\"clientControl\" CLASSID=\"clsid:B5F416F2-89CB-4B29-A536-3B49889C9558\"\n" +
            "        CODEBASE=\"/ngcustcare/ocx/cspClientControl.ocx\"\n" +
            "        WIDTH=\"0\" HEIGHT=\"0\" ALIGN=\"Center\" HSPACE=\"0\" VSPACE=\"0\" STYLE=\"display: none\"></OBJECT>\n" +
            "<font size=\"4\">正在加载，请稍候.....</font>\n" +
            "<div class=\"panel\" style=\"display:none\">\n" +
            "    <script language=\"Javascript\" src=\"/ngcustcare/metaweb/static/resources/js/Util.js?1273130002000\"\n" +
            "            id=\"Util_js\"></script>\n" +
            "    <script language=\"Javascript\" src=\"/ngcustcare/metaweb/static/resources/js/isap_ui_form_validation.js?1265799570000\"\n" +
            "            id=\"isap_ui_form_validation_js\"></script>\n" +
            "    <script language=\"Javascript\" src=\"/ngcustcare/metaweb/static/resources/js/commonValidations.js?1273126955000\"\n" +
            "            id=\"commonValidations_js\"></script>\n" +
            "    <link id=\"metaweb_arch_css\" rel=\"stylesheet\" type=\"text/css\"\n" +
            "          href=\"/ngcustcare/resources/default/css/metaweb_arch.css\"></link>\n" +
            "    <link id=\"metaweb_css\" rel=\"stylesheet\" type=\"text/css\" href=\"/ngcustcare/resources/default/css/metaweb.css\"></link>\n" +
            "    <form id=\"mw_12413523140522746\" class=\"mw_form\" method=\"POST\">\n" +
            "        <input type=\"hidden\" name=\"ccm_ObjectID\" value=\"\"><input type=\"hidden\" name=\"ccm_RandomNum\" value=\"\"><input\n" +
            "            type=\"hidden\" name=\"ccdirect\" value=\"false\"><input type=\"hidden\" name=\"ccm_EntityID\"\n" +
            "                                                               value=\"7550013571169\"><input type=\"hidden\"\n" +
            "                                                                                            name=\"ccm_EntityName\"\n" +
            "                                                                                            value=\"*瑜\"><input\n" +
            "            type=\"hidden\" name=\"ccm_CreateDate\" value=\"2007-11-30 17:29:58\"><input type=\"hidden\" name=\"ccm_Status\"\n" +
            "                                                                                   value=\"stcmNml\"><input type=\"hidden\"\n" +
            "                                                                                                          name=\"ccm_StatusDate\"\n" +
            "                                                                                                          value=\"2011-06-13 11:45:09\"><input\n" +
            "            type=\"hidden\" name=\"ccm_EditStatus\" value=\"0\"><input type=\"hidden\" name=\"ccm_Region\" value=\"755\"><input\n" +
            "            type=\"hidden\" name=\"ccm_ShortName\" value=\"\"><input type=\"hidden\" name=\"ccm_Password\" value=\"\"><input\n" +
            "            type=\"hidden\" name=\"ccm_CustType\" value=\"PersonCustomer\"><input type=\"hidden\" name=\"ccm_VipType\"\n" +
            "                                                                            value=\"VC0000\"><input type=\"hidden\"\n" +
            "                                                                                                  name=\"ccm_Foreigner\"\n" +
            "                                                                                                  value=\"0\"><input\n" +
            "            type=\"hidden\" name=\"ccm_CustClass1\" value=\"CustClass111\"><input type=\"hidden\" name=\"ccm_CustClass2\"\n" +
            "                                                                            value=\"CustClass201\"><input type=\"hidden\"\n" +
            "                                                                                                        name=\"ccm_National\"\n" +
            "                                                                                                        value=\"China\"><input\n" +
            "            type=\"hidden\" name=\"ccm_Address\" value=\"********\"><input type=\"hidden\" name=\"ccm_CertID\"\n" +
            "                                                                     value=\"441402********043*\"><input type=\"hidden\"\n" +
            "                                                                                                       name=\"ccm_CertType\"\n" +
            "                                                                                                       value=\"IdCard\"><input\n" +
            "            type=\"hidden\" name=\"ccm_CertAddr\" value=\"********\"><input type=\"hidden\" name=\"ccm_LinkMan\" value=\"*瑜\"><input\n" +
            "            type=\"hidden\" name=\"ccm_LinkPhone\" value=\"13510033371\"><input type=\"hidden\" name=\"ccm_HomeTel\"\n" +
            "                                                                          value=\"\"><input type=\"hidden\"\n" +
            "                                                                                          name=\"ccm_OfficeTel\" value=\"\"><input\n" +
            "            type=\"hidden\" name=\"ccm_MobileTel\" value=\"\"><input type=\"hidden\" name=\"ccm_PostCode\" value=\"518020\"><input\n" +
            "            type=\"hidden\" name=\"ccm_LinkAddr\" value=\"********\"><input type=\"hidden\" name=\"ccm_Email\"\n" +
            "                                                                      value=\"13510033371@139.com\"><input type=\"hidden\"\n" +
            "                                                                                                         name=\"ccm_HomePage\"\n" +
            "                                                                                                         value=\"\"><input\n" +
            "            type=\"hidden\" name=\"ccm_IsMergeBill\" value=\"1\"><input type=\"hidden\" name=\"ccm_CreditLevel\"\n" +
            "                                                                  value=\"crdtLevelA\"><input type=\"hidden\"\n" +
            "                                                                                            name=\"ccm_OwnerAreaID\"\n" +
            "                                                                                            value=\"\"><input\n" +
            "            type=\"hidden\" name=\"ccm_OrgID\" value=\"BBSZ07903\"><input type=\"hidden\" name=\"ccm_RegStatus\" value=\"1\"><input\n" +
            "            type=\"hidden\" name=\"ccm_Notes\" value=\"社会属性: 外地私人\"><input type=\"hidden\" name=\"ccm_ResponseCustMgr\"\n" +
            "                                                                     value=\"\"><input type=\"hidden\"\n" +
            "                                                                                     name=\"ccm_CurrentCustMgr\" value=\"\"><input\n" +
            "            type=\"hidden\" name=\"ccm_InLevel\" value=\"1\"><input type=\"hidden\" name=\"ccm_TownID\" value=\"\"><input\n" +
            "            type=\"hidden\" name=\"ccm_VipTypeStateDate\" value=\"\"><input type=\"hidden\" name=\"ccm_NetServGrade\"\n" +
            "                                                                      value=\"\"><input type=\"hidden\"\n" +
            "                                                                                      name=\"ccm_CustAddrArray\"\n" +
            "                                                                                      value=\"[]\"><input type=\"hidden\"\n" +
            "                                                                                                        name=\"ccm_CustBillArray\"\n" +
            "                                                                                                        value=\"[]\"><input\n" +
            "            type=\"hidden\" name=\"ccm_IsEncrypt\" value=\"1\"><input type=\"hidden\" name=\"ccm_starLevel\" value=\"5\"><input\n" +
            "            type=\"hidden\" name=\"ccm_IsFaceChk\" value=\"0\"><input type=\"hidden\" name=\"ccregister\" value=\"true\"><input\n" +
            "            type=\"hidden\" name=\"ccnotRegister\" value=\"false\"><input type=\"hidden\" name=\"csm_ObjectID\" value=\"\"><input\n" +
            "            type=\"hidden\" name=\"csm_RandomNum\" value=\"\"><input type=\"hidden\" name=\"csdirect\" value=\"false\"><input\n" +
            "            type=\"hidden\" name=\"csm_EntityID\" value=\"7550013640733\"><input type=\"hidden\" name=\"csm_EntityName\"\n" +
            "                                                                           value=\"*瑜\"><input type=\"hidden\"\n" +
            "                                                                                             name=\"csm_CreateDate\"\n" +
            "                                                                                             value=\"******\"><input\n" +
            "            type=\"hidden\" name=\"csm_Status\" value=\"US10\"><input type=\"hidden\" name=\"csm_StatusDate\"\n" +
            "                                                                value=\"******\"><input type=\"hidden\"\n" +
            "                                                                                      name=\"csm_EditStatus\"\n" +
            "                                                                                      value=\"0\"><input type=\"hidden\"\n" +
            "                                                                                                       name=\"csm_Region\"\n" +
            "                                                                                                       value=\"755\"><input\n" +
            "            type=\"hidden\" name=\"csm_Password\" value=\"MjUzMDg3\"><input type=\"hidden\" name=\"csm_ProductID\"\n" +
            "                                                                      value=\"0\"><input type=\"hidden\"\n" +
            "                                                                                       name=\"csm_ServNumber\"\n" +
            "                                                                                       value=\"13510033371\"><input\n" +
            "            type=\"hidden\" name=\"csm_RegisterOrgID\" value=\"BBSZ07903\"><input type=\"hidden\" name=\"csm_OwnerOrgID\"\n" +
            "                                                                            value=\"BBSZ07903\"><input type=\"hidden\"\n" +
            "                                                                                                     name=\"csm_AccountOid\"\n" +
            "                                                                                                     value=\"7550013571169\"><input\n" +
            "            type=\"hidden\" name=\"csm_CustomerOid\" value=\"7550013571169\"><input type=\"hidden\" name=\"csm_AuthType\"\n" +
            "                                                                              value=\"AuthCheckB\"><input type=\"hidden\"\n" +
            "                                                                                                        name=\"csm_MobileType\"\n" +
            "                                                                                                        value=\"mbtpNml\"><input\n" +
            "            type=\"hidden\" name=\"csm_AreaID\" value=\"\"><input type=\"hidden\" name=\"csm_PayMode\" value=\"1010\"><input\n" +
            "            type=\"hidden\" name=\"csm_StopKey\" value=\"00000000\"><input type=\"hidden\" name=\"csm_Brand\" value=\"BrandGotone\"><input\n" +
            "            type=\"hidden\" name=\"csm_StartDate\" value=\"2007-11-30 17:29:58\"><input type=\"hidden\" name=\"csm_InvalidDate\"\n" +
            "                                                                                  value=\"2037-01-01 00:00:00\"><input\n" +
            "            type=\"hidden\" name=\"csm_SettleDay\" value=\"1\"><input type=\"hidden\" name=\"csm_Enum\"\n" +
            "                                                                value=\"89860051191509946652\"><input type=\"hidden\"\n" +
            "                                                                                                    name=\"csm_Imsi\"\n" +
            "                                                                                                    value=\"460000030166673\"><input\n" +
            "            type=\"hidden\" name=\"csm_Credit\" value=\"0\"><input type=\"hidden\" name=\"csm_SubsProduct\" value=\"[]\"><input\n" +
            "            type=\"hidden\" name=\"csm_IsDefaultTelNum\" value=\"1\"><input type=\"hidden\" name=\"csm_BelongRegion\"\n" +
            "                                                                      value=\"0\"><input type=\"hidden\"\n" +
            "                                                                                       name=\"csm_TargetRegion\"\n" +
            "                                                                                       value=\"0\"><input type=\"hidden\"\n" +
            "                                                                                                        name=\"csm_CretLevel\"\n" +
            "                                                                                                        value=\"\"><input\n" +
            "            type=\"hidden\" name=\"csgotone\" value=\"true\"><input type=\"hidden\" name=\"csnotGotone\" value=\"false\"><input\n" +
            "            type=\"hidden\" name=\"cam_ObjectID\" value=\"\"><input type=\"hidden\" name=\"cam_RandomNum\" value=\"\"><input\n" +
            "            type=\"hidden\" name=\"cadirect\" value=\"false\"><input type=\"hidden\" name=\"cam_EntityID\"\n" +
            "                                                               value=\"7550013571169\"><input type=\"hidden\"\n" +
            "                                                                                            name=\"cam_EntityName\"\n" +
            "                                                                                            value=\"*瑜\"><input\n" +
            "            type=\"hidden\" name=\"cam_CreateDate\" value=\"2007-11-30 17:29:58\"><input type=\"hidden\" name=\"cam_Status\"\n" +
            "                                                                                   value=\"stcmNml\"><input type=\"hidden\"\n" +
            "                                                                                                          name=\"cam_StatusDate\"\n" +
            "                                                                                                          value=\"2007-11-30 17:29:58\"><input\n" +
            "            type=\"hidden\" name=\"cam_EditStatus\" value=\"0\"><input type=\"hidden\" name=\"cam_Region\" value=\"755\"><input\n" +
            "            type=\"hidden\" name=\"cam_CustID\" value=\"7550013571169\"><input type=\"hidden\" name=\"cam_GroupAcctID\"\n" +
            "                                                                         value=\"\"><input type=\"hidden\"\n" +
            "                                                                                         name=\"cam_PrePayType\"\n" +
            "                                                                                         value=\"pptpPost\"><input\n" +
            "            type=\"hidden\" name=\"cam_AccountType\" value=\"actpCmn\"><input type=\"hidden\" name=\"cam_OverDraft\"\n" +
            "                                                                        value=\"0\"><input type=\"hidden\"\n" +
            "                                                                                         name=\"cam_ControlScheme\"\n" +
            "                                                                                         value=\"0\"><input type=\"hidden\"\n" +
            "                                                                                                          name=\"cam_EntrustTel\"\n" +
            "                                                                                                          value=\"13510033371\"><input\n" +
            "            type=\"hidden\" name=\"cam_OrgID\" value=\"BBSZ07903\"><input type=\"hidden\" name=\"cam_NotifyType\" value=\"1\"><input\n" +
            "            type=\"hidden\" name=\"cam_NotifyValue\" value=\"2000\"><input type=\"hidden\" name=\"cam_InvPrintType\"\n" +
            "                                                                     value=\"InvPTbillfee\"><input type=\"hidden\"\n" +
            "                                                                                                 name=\"cam_Notes\"\n" +
            "                                                                                                 value=\"\"><input\n" +
            "            type=\"hidden\" name=\"cam_PayChannelArray\" value=\"[]\"><input type=\"hidden\" name=\"cam_CustBillArray\"\n" +
            "                                                                       value=\"[]\"><input type=\"hidden\"\n" +
            "                                                                                         name=\"cam_UrgeInfos\"\n" +
            "                                                                                         value=\"[]\"><input type=\"hidden\"\n" +
            "                                                                                                           name=\"cam_SettleAccount\"\n" +
            "                                                                                                           value=\"\"><input\n" +
            "            type=\"hidden\" name=\"cam_IsDefault\" value=\"0\"><input type=\"hidden\" name=\"cam_BillInvoiceMailArray\"\n" +
            "                                                                value=\"[]\"><input type=\"hidden\"\n" +
            "                                                                                  name=\"cam_NotifyValueDisplay\"\n" +
            "                                                                                  value=\"20.00\"><input type=\"hidden\"\n" +
            "                                                                                                       name=\"cam_CreateDateDisplay\"\n" +
            "                                                                                                       value=\"2007-11-30\"><input\n" +
            "            type=\"hidden\" name=\"com_ObjectID\" value=\"\"><input type=\"hidden\" name=\"com_RandomNum\" value=\"\"><input\n" +
            "            type=\"hidden\" name=\"comenuId\" value=\"123456\"><input type=\"hidden\" name=\"cointeractiveId\"\n" +
            "                                                                value=\"undefined\"><input type=\"hidden\" name=\"codirect\"\n" +
            "                                                                                         value=\"false\"><input\n" +
            "            type=\"hidden\" name=\"com_EntityID\" value=\"Blixinda\"><input type=\"hidden\" name=\"com_EntityName\"\n" +
            "                                                                      value=\"*瑜\"><input type=\"hidden\"\n" +
            "                                                                                        name=\"com_CreateDate\"\n" +
            "                                                                                        value=\"2016-12-19 16:30:52\"><input\n" +
            "            type=\"hidden\" name=\"com_Status\" value=\"1\"><input type=\"hidden\" name=\"com_StatusDate\"\n" +
            "                                                             value=\"2016-12-19 16:30:52\"><input type=\"hidden\"\n" +
            "                                                                                                name=\"com_EditStatus\"\n" +
            "                                                                                                value=\"0\"><input\n" +
            "            type=\"hidden\" name=\"com_Region\" value=\"755\"><input type=\"hidden\" name=\"conodeID\" value=\"Blixinda\"><input\n" +
            "            type=\"hidden\" name=\"conodeName\" value=\"*瑜\"><input type=\"hidden\" name=\"conodeParentID\"\n" +
            "                                                              value=\"BBSZ22161213048\"><input type=\"hidden\"\n" +
            "                                                                                             name=\"coentityID\"\n" +
            "                                                                                             value=\"Blixinda\"><input\n" +
            "            type=\"hidden\" name=\"cootherParam\" value=\"OPRT36\"><input type=\"hidden\" name=\"cochecked\" value=\"false\"><input\n" +
            "            type=\"hidden\" name=\"com_MenuID\" value=\"123456\"><input type=\"hidden\" name=\"com_ServNum\" value=\"\"><input\n" +
            "            type=\"hidden\" name=\"com_TouchNum\" value=\"\"><input type=\"hidden\" name=\"com_Password\"\n" +
            "                                                              value=\"F3A3F3EBF727ACB1CBB58325BF1FE308\"><input\n" +
            "            type=\"hidden\" name=\"com_OrgID\" value=\"BBSZ22161213048\"><input type=\"hidden\" name=\"com_RoamOrgID\"\n" +
            "                                                                          value=\"\"><input type=\"hidden\"\n" +
            "                                                                                          name=\"com_PassChangeDate\"\n" +
            "                                                                                          value=\"2016-12-19 16:30:52\"><input\n" +
            "            type=\"hidden\" name=\"com_OperType\" value=\"OPRT36\"><input type=\"hidden\" name=\"com_Manager\" value=\"0\"><input\n" +
            "            type=\"hidden\" name=\"com_Level\" value=\"\"><input type=\"hidden\" name=\"com_ContactPhone\"\n" +
            "                                                           value=\"13632505266\"><input type=\"hidden\"\n" +
            "                                                                                      name=\"com_MacAddress\"\n" +
            "                                                                                      value=\"00-FF-F8-B0-67-89\"><input\n" +
            "            type=\"hidden\" name=\"com_OnDuty\" value=\"0\"><input type=\"hidden\" name=\"com_Note\" value=\"16121316021010\"><input\n" +
            "            type=\"hidden\" name=\"com_ShareStore\" value=\"\"><input type=\"hidden\" name=\"com_BirthDay\" value=\"\"><input\n" +
            "            type=\"hidden\" name=\"com_WorkDate\" value=\"\"><input type=\"hidden\" name=\"com_CertID\" value=\"\"><input\n" +
            "            type=\"hidden\" name=\"com_Sex\" value=\"\"><input type=\"hidden\" name=\"com_EducationLevel\" value=\"\"><input\n" +
            "            type=\"hidden\" name=\"com_TotalLevel\" value=\"\"><input type=\"hidden\" name=\"com_SkillLevel\" value=\"\"><input\n" +
            "            type=\"hidden\" name=\"com_TrainLevel\" value=\"\"><input type=\"hidden\" name=\"com_ComityLevel\" value=\"\"><input\n" +
            "            type=\"hidden\" name=\"com_Operator_type\" value=\"0\"><input type=\"hidden\" name=\"com_NativeHome\" value=\"\"><input\n" +
            "            type=\"hidden\" name=\"com_graduateDate\" value=\"\"><input type=\"hidden\" name=\"com_IsMarray\" value=\"0\"><input\n" +
            "            type=\"hidden\" name=\"com_PolityFace\" value=\"\"><input type=\"hidden\" name=\"com_HomeAddress\" value=\"\"><input\n" +
            "            type=\"hidden\" name=\"com_JobLive\" value=\"\"><input type=\"hidden\" name=\"com_NowPostID\" value=\"\"><input\n" +
            "            type=\"hidden\" name=\"com_BloodType\" value=\"\"><input type=\"hidden\" name=\"com_Healthy\" value=\"\"><input\n" +
            "            type=\"hidden\" name=\"com_Character\" value=\"\"><input type=\"hidden\" name=\"com_Enjoyful\" value=\"\"><input\n" +
            "            type=\"hidden\" name=\"com_PriSocietyRelation\" value=\"\"><input type=\"hidden\" name=\"com_FamilyDes\"\n" +
            "                                                                        value=\"\"><input type=\"hidden\"\n" +
            "                                                                                        name=\"com_StarLevel\"\n" +
            "                                                                                        value=\"\"><input type=\"hidden\"\n" +
            "                                                                                                        name=\"com_AssessRec\"\n" +
            "                                                                                                        value=\"\"><input\n" +
            "            type=\"hidden\" name=\"com_hr_status\" value=\"1\"><input type=\"hidden\" name=\"com_Restrict_time\" value=\"0\"><input\n" +
            "            type=\"hidden\" name=\"com_Start_time\" value=\"0\"><input type=\"hidden\" name=\"com_End_time\" value=\"0\"><input\n" +
            "            type=\"hidden\" name=\"com_Enable_gprs\" value=\"0\"><input type=\"hidden\" name=\"com_Gprs_starttime\"\n" +
            "                                                                  value=\"0\"><input type=\"hidden\" name=\"com_Gprs_endtime\"\n" +
            "                                                                                   value=\"0\"><input type=\"hidden\"\n" +
            "                                                                                                    name=\"com_Check_mac\"\n" +
            "                                                                                                    value=\"0\"><input\n" +
            "            type=\"hidden\" name=\"com_Mac\" value=\"\"><input type=\"hidden\" name=\"com_IPAddress\"\n" +
            "                                                         value=\"10.252.126.194\"><input type=\"hidden\"\n" +
            "                                                                                       name=\"costartUsingTime\"\n" +
            "                                                                                       value=\"2016-12-19 00:00:00\"><input\n" +
            "            type=\"hidden\" name=\"coendUsingTime\" value=\"2099-01-01 00:00:00\"><input type=\"hidden\" name=\"com_QueueID\"\n" +
            "                                                                                   value=\"\"><input type=\"hidden\"\n" +
            "                                                                                                   name=\"com_LoginType\"\n" +
            "                                                                                                   value=\"SECAUTH\"><input\n" +
            "            type=\"hidden\" name=\"com_InvVersion\" value=\"\"><input type=\"hidden\" name=\"com_areaID\" value=\"\">\n" +
            "        <input type=\"hidden\" name=\"servNumber\" value=\"13510033371\">\n" +
            "        <input type=\"hidden\" name=\"transmit\" value=\"layoutAction.do?method=showLayout&layoutId=1&viewId=0\">\n" +
            "        <input type=\"hidden\" name=\"recType\" value=\"\">\n" +
            "        <input type=\"hidden\" name=\"stopKeyValue\" value=\"正常使用\">\n" +
            "        <input type=\"hidden\" id=\"macAddress\" name=\"remotemac\">\n" +
            "    </form>\n" +
            "    <script>if (navigator.appName != 'Netscape' && null == window.onunload) {\n" +
            "        var formunload = window.onunload;\n" +
            "        window.onunload = function () {\n" +
            "            try {\n" +
            "                var f = document.body.getElementsByTagName('form');\n" +
            "                for (var i = 0; i < f.length; i++) {\n" +
            "                    f[i];\n" +
            "                }\n" +
            "            } catch (e) {\n" +
            "            }\n" +
            "            if (formunload) formunload()\n" +
            "        };\n" +
            "    }</script>\n" +
            "</div>\n" +
            "</body>\n" +
            "</html>";
}
