package Test;
import Pages.elemntPages.Google1;
import Pages.elemntPages.Google2;
import Utilities.Mylibraray;
import Utilities.TestBase;
import org.testng.annotations.Test;




public class simpleTest2 extends TestBase {

    @Test
    public void Test02(){
        tests=reports.createTest("SecondTest");
        Mylibraray.sleepForNow(3);
        Google2.searchbox2.sendKeys("Apple");
        Mylibraray.sleepForNow(3);

    }

}
