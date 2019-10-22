package medical.manual.handles;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

import medical.BusinessFile;

public class LoginElement  extends BusinessFile {

    // 用于存储元素路径及元素类型
    private Map<String, String> loginElement;

    private void setPathAndType(String elePath, String pathType) {
        loginElement = new HashMap<>();
        loginElement.put("elePath", elePath);
        loginElement.put("pathType", pathType);
    }

    public Map<String, String> getLoginTitle() {
        setPathAndType("h3.title", "css");
        return loginElement;
    }

    public Map<String, String> getLoginUser() {
        setPathAndType("username", "name");
        return loginElement;
    }

    public Map getLoginUserError() {
        setPathAndType("form > div:nth-child(2) > div > div.el-form-item__error", "css");
        return loginElement;
    }

    public String getUserErrorMsg() {
        // 账号输入框错误提示语
        return "请填写账号";
    }

    public Map getLoginPass() {
        setPathAndType("password", "name");

        return loginElement;
    }

    public Map getLoginPassError() {
        setPathAndType("div.el-form-item.el-tooltip.is-error.is-required > div > div.el-form-item__error", "css");
        return loginElement;
    }

    public String getPassErrorMsg() {
        // 密码输入框错误提示语
        return "请填写密码";
    }

    public Map getLoginButton() {
        setPathAndType("form > button:nth-child(4)", "css");
        return loginElement;
    }

    public Map getLoginRegister() {
        setPathAndType("form > button:nth-child(5)", "css");
        return loginElement;
    }

    private Map getLoginError() {
        setPathAndType("body > div.el-message.el-message--error", "css");
        return loginElement;
    }


    public Method getLoginPageElement(String methodName) {
        Method getPassErrorMsg = null;
        try {
            // 根据方法名获得指定的方法， 参数name为方法名，参数parameterTypes为方法的参数类型

            getPassErrorMsg = LoginElement.class.getDeclaredMethod(methodName);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return getPassErrorMsg;
    }


    @DataProvider
    public Object[][] getLoginData(Method method) {

        String xmlpth = ".\\src\\main\\java\\medical\\manual\\user\\TestUserLogin.xml";
        List<Map<String, String>> xmlData = getXmlData(method.getName(),xmlpth);
        String  load = xmlData.get(0).get("load");
        String sheetName =xmlData.get(0).get("sheetName");

        Object[][] testData = dataProviderSource(load,sheetName);

        return testData;

    }



}
