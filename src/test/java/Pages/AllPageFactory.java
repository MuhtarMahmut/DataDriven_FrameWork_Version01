package Pages;

import Pages.elemntPages.*;
import Utilities.TestBase;
import org.openqa.selenium.support.PageFactory;

public class AllPageFactory extends TestBase {

    // store all Pages' classes' page factory

    {

        PageFactory.initElements(driver, Google1.class);

        PageFactory.initElements(driver, Google2.class);



    }

}
