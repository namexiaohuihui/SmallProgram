package utiltools.documents;

import java.io.*;
import java.net.URL;
import java.util.List;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

/**
 * @ ClassName: ReadYaml
 * @ Author: DingDong
 * @ Date: 2019/8/23 14:40
 * @ Version: 1.0
 * @ desc:
 */
public class ReadYaml {


    public void testLoadFromStream() throws FileNotFoundException {
        String filepath = "C:\\Users\\Administrator\\Desktop\\app.yaml";
        InputStream input = new FileInputStream(new File(filepath));
        Yaml yaml = new Yaml();
        Object data = yaml.load(input);
        System.out.println(data);
    }
    public void testLoadManyDocuments() throws FileNotFoundException {
        String filepath = "C:\\Users\\Administrator\\Desktop\\app.yaml";
//        InputStream input = new FileInputStream(new File(
////                "src/test/resources/specification/example2_28.yaml"));
        InputStream input = new FileInputStream(new File(filepath));
        Yaml yaml = new Yaml();
        int counter = 0;
        for (Object data : yaml.loadAll(input)) {
            System.out.println(data);
            counter++;
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        new ReadYaml().testLoadManyDocuments();
        //https://bitbucket.org/asomov/snakeyaml/wiki/Documentation
    }
}
