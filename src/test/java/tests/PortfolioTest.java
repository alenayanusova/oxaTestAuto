package tests;

import base.BaseTest;
import org.junit.Test;
import pages.*;

import static junit.framework.Assert.assertEquals;

/**
 * Created by pushkarevamn on 11/27/2015.
 *
 * @author pushkarevamn
 */
public class PortfolioTest extends BaseTest {

    @Test
    public void test1(){
        log.info("Log step 1: Go to tab Portfolio");
        OxaHomePage oxaHomePage = new OxaHomePage(driver);
        oxaHomePage.goToTabPortfolio();

        log.info("Log step 2: Go to block Mobile Development");
        PortfolioPage portfolioPage = new PortfolioPage(driver);
        MobilePage mobilePage = new MobilePage(driver);
        portfolioPage.goToMobileDevelopment();
        assertEquals(mobilePage.getBreadcrumbsText(), MobilePage.BREADCRUMBS_TEXT);

    }
    @Test
        public void test2(){
        log.info("Log step 1: Go to tab Portfolio");
        OxaHomePage oxaHomePage = new OxaHomePage(driver);
        oxaHomePage.goToTabPortfolio();

        log.info("Log step 2: Go to block Net Development");
        PortfolioPage portfolioPage = new PortfolioPage(driver);
        NetPage netPage = new NetPage(driver);
        portfolioPage.goToNetDevelopment();
        assertEquals(netPage.getBreadcrumbsText(), NetPage.BREADCRUMBS_TEXT);

    }
    @Test
    public void test3(){
        log.info("Log step 1: Go to tab Portfolio");
        OxaHomePage oxaHomePage = new OxaHomePage(driver);
        oxaHomePage.goToTabPortfolio();

        log.info("Log step 2: Go to block Java Development");
        PortfolioPage portfolioPage = new PortfolioPage(driver);
        JavaPage javaPage = new JavaPage(driver);
        portfolioPage.goToJavaDevelopment();
        assertEquals(javaPage.getBreadcrumbsText(), JavaPage.BREADCRUMBS_TEXT);

    }
    @Test
    public void test4(){
        log.info("Log step 1: Go to tab Portfolio");
        OxaHomePage oxaHomePage = new OxaHomePage(driver);
        oxaHomePage.goToTabPortfolio();

        log.info("Log step 2: Go to block Java Development");
        PortfolioPage portfolioPage = new PortfolioPage(driver);
        PhpPage phpPage = new PhpPage(driver);
        portfolioPage.goToPhpDevelopment();
        assertEquals(phpPage.getBreadcrumbsText(), PhpPage.BREADCRUMBS_TEXT);

    }
}

