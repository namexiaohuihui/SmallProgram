package utiltools.documents;

import java.io.*;
import java.net.URL;
import java.util.List;
import java.util.Map;

import org.yaml.snakeyaml.TypeDescription;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

/**
 * @ ClassName: ReadYaml
 * @ Author: DingDong
 * @ Date: 2019/8/23 14:40
 * @ Version: 1.0
 * @ desc:
 */
public class ReadYaml {


    public void testLoadFromStream() throws FileNotFoundException {
        String filepath = "E:\\SmallProgram\\src\\main\\java\\utiltools\\documents\\app.yaml";
        InputStream input = new FileInputStream(new File(filepath));
        Yaml yaml = new Yaml();
        Object data = yaml.load(input);
        System.out.println(data);
    }
    public void testLoadManyDocuments() throws FileNotFoundException {
        String filepath = "E:\\SmallProgram\\src\\main\\java\\utiltools\\documents\\app.yaml";
        InputStream input = new FileInputStream(new File(filepath));
        Yaml yaml = new Yaml();
        int counter = 0;
        for (Object data : yaml.loadAll(input)) {
            System.out.println(data);
            counter++;
        }
    }
    public void testCat(){
        Constructor constructor = new Constructor(Car.class);//Car.class is root
        TypeDescription carDescription = new TypeDescription(Car.class);
        carDescription.putListPropertyType("wheels", Wheel.class);
        constructor.addTypeDescription(carDescription);
        Yaml yaml = new Yaml(constructor);
    }
    public static void main(String[] args) throws FileNotFoundException {
        new ReadYaml().testCat();
        //https://bitbucket.org/asomov/snakeyaml/wiki/Documentation
    }
}
