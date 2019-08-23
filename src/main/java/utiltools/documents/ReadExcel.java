package utiltools.documents;

import utiltools.documents.DiscernExcel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import utiltools.SystemOut;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.*;
import java.util.*;

/**
 * @ ClassName: ReadExcel
 * @ Author: DingDong
 * @ Date: 2019/8/13 11:50
 * @ Version: 1.0
 * @ desc: 读取excel表格中的数据信息
 */
public class ReadExcel extends DiscernExcel {
    /**
     * 读取Excel文件的内容
     *
     * @param workbook
     * @param sheetName   sheet名字
     * @return 以List返回excel中内容
     */
    public  static List<Map<String, String>> getExcelList(Workbook workbook, String sheetName) {


//        //定义工作表
//        XSSFSheet xssfSheet;
//        if (sheetName.equals("")) {
//            // 默认取第一个子表
//            xssfSheet = workbook.getSheetAt(0);
//        } else {
//            xssfSheet = workbook.getSheet(sheetName);
//        }
//
//        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
//
//        //定义行
//        //默认第一行为标题行，index = 0
//        XSSFRow titleRow = xssfSheet.getRow(0);
//
//        //循环取每行的数据
//        for (int rowIndex = 1; rowIndex < xssfSheet.getPhysicalNumberOfRows(); rowIndex++) {
//            XSSFRow xssfRow = xssfSheet.getRow(rowIndex);
//            if (xssfRow == null) {
//                continue;
//            }
//
//            Map<String, String> map = new LinkedHashMap<String, String>();
//            //循环取每个单元格(cell)的数据
//            for (int cellIndex = 0; cellIndex < xssfRow.getPhysicalNumberOfCells(); cellIndex++) {
//                XSSFCell titleCell = titleRow.getCell(cellIndex);
//                XSSFCell xssfCell = xssfRow.getCell(cellIndex);
//                map.put(getCellValue(titleCell), getCellValue(xssfCell));
//            }
//            list.add(map);
//        }
//
//        return list;
        return null;
    }

    public static void main(String[] args) {
//        try {
//            ReadExcel obj = new ReadExcel();
//            File file = new File("C:\\Users\\DingDonf\\Desktop\\红包发放.xlsx");
//            InputStream inputStream = new FileInputStream(file);
//            List<Map<String, String>> excelList = obj.getExcelList(inputStream, "发放");
//            System.out.println("从excel读取数据并开始使用:");
//            for (Map<String, String> list : excelList) {
//                System.out.println(list.get("用户ID"));
//                System.out.println(list.get("发放原因"));
//                System.out.println(list.get("详细说明"));
//                System.out.println();
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//
    }
}
