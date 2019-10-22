package toolskit.documents;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * @ ClassName: toolskit.documents
 * @ Author: DingDong
 * @ Date: 2019/10/21 14:36
 * @ Version: 1.0
 * @ desc:
 */

public class XmlUtil {

    public static List getXmlComent(String path){
        //获取xml文件完全路径
        System.out.println("xml·path"+path);

        List contList=new ArrayList();
        //dom4j中读取xml文件的方法
        SAXReader saxR=new SAXReader();
        try {
            Document doc=saxR.read(path);
            //存放顶结点
            Element eleroot=doc.getRootElement();
            //parMap，存放顶结点下一级结点
            Map parMap=null;
            Map sonMap=null;
            for(Iterator i=eleroot.elementIterator();i.hasNext();){
                //parMap中存放的结点的子结点
                parMap=new HashMap();
                sonMap=new HashMap();
                Element elepar=(Element)i.next();
                for(Iterator j=elepar.elementIterator();j.hasNext();){
                    Element eleSon=(Element)j.next();
                    System.out.println("+++++"+eleSon.getName()+"    "+ eleSon.getText());
                    sonMap.put(eleSon.getName(), eleSon.getText());
                }

                parMap.put(elepar.getName(),sonMap);
                System.out.println("*****"+elepar.getName() +"*********" + sonMap);
                contList.add(parMap);
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        return contList;
    }
}
