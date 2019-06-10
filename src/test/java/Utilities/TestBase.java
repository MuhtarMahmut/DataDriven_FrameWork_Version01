package Utilities;



import Pages.AllPageFactory;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;

public abstract class TestBase {

    protected  static WebDriver driver;
    protected static ExtentReports reports=new ExtentReports();
    protected static ExtentHtmlReporter html= new ExtentHtmlReporter("src/test/Reports/HTML/MyHTMLReport.html");
    protected static ExtentTest tests;
    protected static Actions act;
    protected static WebDriverWait wait;




    @BeforeMethod()   // controls how the @Test method will be executed.
    protected void setup01(){
        // this before method is to setup browsers
        driver = Driver.getDriver();
        act=new Actions(driver);
        wait=new WebDriverWait(driver,50);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to(FileReader.getPropertiesData("Website"));

            new AllPageFactory();  // MUST run it everytime before methods

    }




    @AfterMethod
    protected void end(ITestResult result){
        if(result.getStatus() == ITestResult.FAILURE ){
            tests.log(Status.FAIL, result.getName());
            tests.info(result.getThrowable());

            Mylibraray.TakeScreenShots(result.getName());

        } else if(result.getStatus() == ITestResult.SKIP ){
            tests.log(Status.SKIP,result.getName());
            tests.info(result.getThrowable());
        }
    Mylibraray.sleepForNow(1);
        driver.quit();
        driver = null;
    }



    @AfterTest
    protected void EndTest(){

        reports.attachReporter(html);
        reports.setSystemInfo("Website",FileReader.getPropertiesData("Website"));
        reports.setSystemInfo("Username","Muhtar");
        reports.setSystemInfo("PassWord","123456");
        reports.setSystemInfo("Browser", FileReader.getPropertiesData("Browser"));

        html.config().setReportName("Reported by tester:  Muhtar Mahmut");     // this step sets the reporeter name
        html.config().setDocumentTitle("FaceBookReports");

        reports.flush();
    }




}
