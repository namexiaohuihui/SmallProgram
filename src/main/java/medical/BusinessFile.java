package medical;

import org.testng.Assert;
import toolskit.documents.ReadExcel;
import toolskit.documents.XmlUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ ClassName: medical
 * @ Author: DingDong
 * @ Date: 2019/10/21 16:25
 * @ Version: 1.0
 * @ desc:
 */
public class BusinessFile {

    public Object[][] dataProviderSource(String  load,String sheetName){

        ReadExcel re = new ReadExcel();

        List<Map<String, String>> maps = re.readExcel(load, sheetName);

        Object[][] testData = mapsToArray(maps);
        return testData;
    }

    public List<Map<String, String>> getXmlData(String methodName,String xmlPath){
        List parList;

        List<Map<String, String>> sonList=new ArrayList<>();

        // 读取xml内容
        parList = XmlUtil.getXmlComent(xmlPath);

        // 根据名字进行区分
        for (int i=0;i< parList.size();i++) {
            Map map = (Map)parList.get(i);
            if (map.containsKey(methodName)) {
                Map<String,String> subMap = (Map<String,String>) map.get(methodName);
                sonList.add(subMap);
            }
        }

        if (sonList.size() > 0) {
            return sonList;
        }else{
            Assert.assertTrue(sonList.size()!=0,parList+"为空，找不到属性值："+methodName );
            return null;
        }
    }


    public Object[][] mapsToArray(List<Map<String, String>> maps) {
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
