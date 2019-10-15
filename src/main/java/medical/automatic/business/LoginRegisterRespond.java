package medical.automatic.business;

import medical.automatic.URLConnection;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import toolskit.documents.ReadExcel;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;

import static toolskit.documents.ReadIni.readIni;

/**
 * @ ClassName: medical.automatic.login
 * @ Author: DingDong
 * @ Date: 2019/10/14 17:54
 * @ Version: 1.0
 * @ desc:
 */


public class LoginRegisterRespond {

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
    public Object[][] getLoginData(ITestContext context) {

        String load = ".\\drivers\\测试用例.xlsx";
        String sheetName = "接口登录";
        ReadExcel re = new ReadExcel();

        List<Map<String, String>> maps = re.readExcel(load, sheetName);
        Object[][] testData = mapsTpArray(maps);

        return testData;
    }
    @DataProvider(name  = "getRegisterData")
    public Object[][] getRegisterData(ITestContext context) {

        String load = ".\\drivers\\测试用例.xlsx";
        String sheetName = "接口注册";
        ReadExcel re = new ReadExcel();

        List<Map<String, String>> maps = re.readExcel(load, sheetName);
        Object[][] testData = mapsTpArray(maps);

        return testData;
    }

    private Object[][] mapsTpArray(List<Map<String, String>> maps) {
        int singleListSize = maps.size();

        // 创建一个二维数组
        Object[][] testData = new Object[singleListSize][];

        for (int singleSize = 0; singleSize < singleListSize; singleSize++) {

            Map<String, String> singleMap = maps.get(singleSize);
            testData[singleSize] = new Object[]{singleMap};

        }

        // 返回数据传给脚本
        return testData;


    }
}
