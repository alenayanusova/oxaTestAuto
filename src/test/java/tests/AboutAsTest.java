package tests;

import base.BaseTest;
import org.junit.Test;
import pages.AboutAsPage;
import pages.OxaHomePage;

/**
 * Created by yanusovaaa on 11/25/2015.
 */

public class AboutAsTest extends BaseTest {

    @Test
    public void test1(){
        log.info("Log step 1: Go to About As tab");
        OxaHomePage oxaHomePage = new OxaHomePage(driver);
        oxaHomePage.goToTabAboutAs();
    }

    @Test
    public void test2(){
        log.info("Log step 1: Go to About As tab");
        OxaHomePage oxaHomePage = new OxaHomePage(driver);
        oxaHomePage.goToTabAboutAs();

        log.info("Log step 2: Go to News");
        AboutAsPage aboutAsPage = new AboutAsPage(driver);
        aboutAsPage.goToNews();
    }
}
