package Test;

import Pages.elemntPages.Google1;
import Utilities.Mylibraray;
import Utilities.TestBase;
import org.testng.annotations.Test;



public class simpleTest extends TestBase {




    @Test
    public void Test01(){
        tests=reports.createTest("FirstTest");
           Mylibraray.sleepForNow(3);
           Google1.searchbox.sendKeys("Apple");
        Mylibraray.sleepForNow(3);

    }



}
