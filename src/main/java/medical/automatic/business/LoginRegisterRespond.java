package medical.automatic.business;

import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;

import java.util.List;
import java.util.Map;

import static toolskit.documents.ReadIni.readIni;

import medical.automatic.URLConnection;
import medical.BusinessFile;
/**
 * @ ClassName: medical.automatic.login
 * @ Author: DingDong
 * @ Date: 2019/10/14 17:54
 * @ Version: 1.0
 * @ desc:
 */


public class LoginRegisterRespond extends BusinessFile {

    private String topUrl = "";
    private String url = "";

    public void setTopUrl(String filename) {
        Map<String, Object> url_ini = readIni(filename,"");
        this.topUrl = ((Map<String, String>) url_ini.get("manual_url")).get("url");
    }

    public String getUrl() {
        return url;
    }

    public String getHttpLogin(String user, String pass,String code) throws IOException {

        url = (topUrl + "/Home/action/act/log?username=" + user + "&password=" + pass + "+ &checkcode=" + code + "");

        String httpRespone = getHttpRespone(url);
        return httpRespone;
    }

    public String getHttpRegister(String user, String pass, String hpId, String name, String dmId) throws IOException {


        url = (topUrl + "login/userRegister?username=" + user + "&password=" + pass + "&hpId=" + hpId + "&name=" + name + "&dmId=" + dmId + "");

        String httpRespone = getHttpRespone(url);
        return httpRespone;
    }

    public String getHttpRespone(String url) throws IOException {
        String line = "";
        String httpResults = "";
        try {
            HttpURLConnection connection = URLConnection
                    .getConnection(url);
            DataOutputStream out = null;
            // 建立实际的连接
            connection.connect();
            out = new DataOutputStream(connection.getOutputStream());

            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            while ((line = reader.readLine()) != null) {
                httpResults = httpResults + line.toString();
            }
            reader.close();
            out.flush();
            out.close();
            // 断开连接
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return httpResults;
    }

    @DataProvider(name  = "getLoginData")
    public Object[][] getLoginData(Method method) {
        Object[][] testData = getResponExcel(method.getName());

        return testData;
    }
    @DataProvider(name  = "getRegisterData")
    public Object[][] getRegisterData(Method method) {
        Object[][] testData = getResponExcel(method.getName());

        return testData;
    }

    private Object[][] getResponExcel(String methodName){
        String xmlPath = ".\\src\\main\\java\\medical\\automatic\\user\\TestLoginRegister.xml";
        List<Map<String, String>> xmlData = getXmlData(methodName,xmlPath);
        String  load = xmlData.get(0).get("load");
        String sheetName =xmlData.get(0).get("sheetName");

        return dataProviderSource(load,sheetName);
    }



}
