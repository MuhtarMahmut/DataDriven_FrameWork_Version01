package Utilities;

import org.apache.poi.xssf.usermodel.*;
import java.io.FileInputStream;
import java.util.Properties;

public interface FileReader {


     static String getPropertiesData(String name) {

        String xx="";
        try {
            FileInputStream file = new FileInputStream("src/test/java/Utilities/Files/ConfigurationReader");
            Properties config = new Properties();
            config.load(file);
            xx = config.getProperty(name);
        }catch(Exception e){  }

        return  xx;
    }


     static String getExcelData(int row, int column) {
        String result="";
        try {
            FileInputStream file = new FileInputStream("src/test/java/Utilities/Files/Excel.xlsx");
            XSSFWorkbook xcelDoc = new XSSFWorkbook(file);
            XSSFSheet Sheet1 = xcelDoc.getSheet("Sheet1");
            result = Sheet1.getRow(row - 1).getCell(column - 1).getStringCellValue();
        } catch (Exception e){  }
        return result;
    }


}
