package tests;

import base.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.OxaHomePage;

/**
 * Created by yanusovaaa on 11/25/2015.
 */
public class TryToTest extends BaseTest {

    @Test
    public void test1(){
        log.info("Log step 1: Go to About As tab");
        OxaHomePage oxaHomePage = new OxaHomePage(driver);
        oxaHomePage.goToTabAboutAs();

    }
}
