package Utilities;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.*;
import java.io.*;
import java.time.*;
import static Utilities.TestBase.*;

public interface Mylibraray{

     static void sleepForNow(int a){

        try {
            Thread.sleep(a * 1000);
        } catch (Exception e){}

    }


    static String getExcelData(int row, int cell) {

        String result="";
        try {
            FileInputStream file = new FileInputStream("src/test/java/utilities/Excel.xlsx");
            XSSFWorkbook xcelDoc = new XSSFWorkbook(file);
            XSSFSheet Sheet1 = xcelDoc.getSheet("Sheet1");
            result = Sheet1.getRow(row - 1).getCell(cell - 1).getStringCellValue();
        } catch (Exception e){  }
        return result;

    }



     static void TakeScreenShots(String saveAs){

        String DateTime= LocalDate.now().toString()+ LocalTime.now().toString().substring(0,5);
            saveAs = saveAs+"_"+DateTime.replaceAll("[-,:]","");
        try {
            TakesScreenshot ss = (TakesScreenshot) driver;
            File muhtar = ss.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(muhtar, new File("src/test/Reports/CapturedScreenShots/"+saveAs+".png"));
        } catch (Exception e){}

    }




}
