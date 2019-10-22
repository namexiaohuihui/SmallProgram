package medical.automatic.user;

import java.io.IOException;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import medical.automatic.Common;
import medical.automatic.business.LoginRegisterRespond;
import toolskit.InformationLog;


public class TestLoginRegister {

    public static LoginRegisterRespond weather;

    @BeforeMethod
    public void runDriveBrowser() {
        String filename = "medical.ini";
        this.weather = new LoginRegisterRespond();
        weather.setTopUrl(filename);
    }

    @Test(description = "登录接口", dataProvider = "getLoginData", dataProviderClass = LoginRegisterRespond.class, groups = {"BaseCase"})
    public void getLoginSucc(Map<?, ?> param) throws IOException {
        resullogin(param);
//        System.out.println( "用例执行失败，编辑内容为：" + param);
    }


    @Test(description = "注册接口", dataProvider = "getRegisterData", dataProviderClass = LoginRegisterRespond.class, groups = {"BaseCase"})
    public void getRegisterSucc(Map<?, ?> param) throws IOException {
        resultRegister(param);
//        System.out.println( "用例执行失败，编辑内容为：" + param);
    }

    private void resullogin(Map<?, ?> param) throws IOException {
        String user = (String) param.get("username");
        String pass = (String) param.get("password");
        String code = (String) param.get("code");
        String status = (String) param.get("status");
        String msg = (String) param.get("msg");

        InformationLog.inputLogInfo("【正常用例】:登录账号" + user + "!");

        String httpResult = weather.getHttpLogin(user, pass, code);


        InformationLog.inputLogInfo("请求地址: " + weather.getUrl());
        InformationLog.inputLogInfo("返回结果: " + httpResult);
        String codeInfo = Common.getJsonValue(httpResult, "error");

        InformationLog.inputLogInfo("用例结果: resultCode=>expected: " + user + " ,actual: " + codeInfo);
        Assert.assertEquals(status, codeInfo);

        String codemsg = Common.getJsonValue(httpResult, "msg");

        Assert.assertEquals(codemsg, msg);
    }

    private void resultRegister(Map<?, ?> param) throws IOException {
        String user = "7";
        String pass = "7";
        String hpId = "1";
        String name = "7";
        String dmId = "1";

        InformationLog.inputLogInfo("【正常用例】:登录账号" + user + "!");
        String httpResult = weather.getHttpRegister(user, pass, hpId, name, dmId);

        InformationLog.inputLogInfo("请求地址: " + weather.getUrl());
        InformationLog.inputLogInfo("返回结果: " + httpResult);

        String codeInfo = Common.getJsonValue(httpResult, "code");
        InformationLog.inputLogInfo("用例结果: resultCode=>expected: " + user + " ,actual: " + codeInfo);

        Assert.assertEquals("200", codeInfo);
    }
}
