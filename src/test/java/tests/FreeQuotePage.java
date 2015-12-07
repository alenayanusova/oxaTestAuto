package tests;

import base.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import pages.*;

/**
 * Created by pushkarevamn on 12/7/2015.
 *
 * @author pushkarevamn
 */

public class FreeQuotePage extends BaseTest {
    @Test
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
