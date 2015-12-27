package tests;

import base.BaseTest;
import org.junit.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.support.PageFactory;
import pages.*;

/**
 * Created by pushkarevamn on 12/7/2015.
 *
 * @author pushkarevamn
 */

public class FreeQuoteTest extends BaseTest {

    @Override
    public void initPages() {
        oxaHomePage = PageFactory.initElements(driver, OxaHomePage.class);
        freeQuotePage = PageFactory.initElements(driver, FreeQuotePage.class);
    }

    @Test(enabled = false)
    public void test1(){
        log.info("Log step 1: Go to tab Free Quote");
        OxaHomePage oxaHomePage = new OxaHomePage(driver);
        oxaHomePage.goToTabFreeQuote();

        log.info("Log step 2: Go to block Slider");
        pages.FreeQuotePage freeQuotePage = new pages.FreeQuotePage(driver);
        freeQuotePage.horizontalSlide();
        Assert.assertEquals("Style is incorrect " + freeQuotePage.getHumanYes(), pages.FreeQuotePage.YES_STYLE, freeQuotePage.getHumanYes());
}


}
