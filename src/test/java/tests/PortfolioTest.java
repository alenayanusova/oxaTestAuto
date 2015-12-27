package tests;

import base.BaseTest;
import org.testng.annotations.*;
import org.openqa.selenium.support.PageFactory;
import pages.*;

import static junit.framework.Assert.assertEquals;

/**
 * Created by pushkarevamn on 11/27/2015.
 *
 * @author pushkarevamn
 */
public class PortfolioTest extends BaseTest {
    @Override
    public void initPages() {
        oxaHomePage = PageFactory.initElements(driver, OxaHomePage.class);
        portfolioPage = PageFactory.initElements(driver, PortfolioPage.class);
        mobilePage = PageFactory.initElements(driver, MobilePage.class);
        netPage = PageFactory.initElements(driver, NetPage.class);
        javaPage = PageFactory.initElements(driver, JavaPage.class);
        phpPage = PageFactory.initElements(driver, PhpPage.class);
    }

    @Test (enabled = false)
    public void test1(){
        log.info("Log step 1: Go to tab Portfolio");
        oxaHomePage.goToTabPortfolio();
        log.info("Log step 2: Go to block Mobile Development");
        portfolioPage.goToMobileDevelopment();
        assertEquals(mobilePage.getBreadcrumbsText(), MobilePage.BREADCRUMBS_TEXT);
    }
    @Test (enabled = false)
        public void test2(){
        log.info("Log step 1: Go to tab Portfolio");
        oxaHomePage.goToTabPortfolio();
        log.info("Log step 2: Go to block Net Development");
        portfolioPage.goToNetDevelopment();
        assertEquals(netPage.getBreadcrumbsText(), NetPage.BREADCRUMBS_TEXT);

    }
    @Test (enabled = false)
    public void test3(){
        log.info("Log step 1: Go to tab Portfolio");
        oxaHomePage.goToTabPortfolio();
        log.info("Log step 2: Go to block Java Development");
        portfolioPage.goToJavaDevelopment();
        assertEquals(javaPage.getBreadcrumbsText(), JavaPage.BREADCRUMBS_TEXT);

    }
    @Test (enabled = false)
    public void test4(){
        log.info("Log step 1: Go to tab Portfolio");
        oxaHomePage.goToTabPortfolio();
        log.info("Log step 2: Go to block Java Development");
        portfolioPage.goToPhpDevelopment();
        assertEquals(phpPage.getBreadcrumbsText(), PhpPage.BREADCRUMBS_TEXT);

    }
}

