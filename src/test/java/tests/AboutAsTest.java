package tests;

import base.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import pages.*;

/**
 * Created by yanusovaaa on 11/25/2015.
 * @author yanusovaaa
 */

public class AboutAsTest extends BaseTest {

    @Test
    public void test1(){
        log.info("Log step 1: Go to About As tab");
        OxaHomePage oxaHomePage = new OxaHomePage(driver);
        oxaHomePage.goToTabAboutAs();

        log.info("Log step 2: Check that page is About As");
        AboutAsPage aboutAsPage = new AboutAsPage(driver);
        Assert.assertEquals("page isn't about us", AboutAsPage.ABOUT_AS_HEADER_TEXT, aboutAsPage.getHeaderText());

    }

    @Test
    public void test2(){
        log.info("Log step 1: Go to About As tab");
        OxaHomePage oxaHomePage = new OxaHomePage(driver);
        oxaHomePage.goToTabAboutAs();

        log.info("Log step 2: Go to News");
        AboutAsPage aboutAsPage = new AboutAsPage(driver);
        aboutAsPage.goToNews();

        log.info("Log step 3: Check that page is News");
        NewsPage newsPage = new NewsPage(driver);
        Assert.assertEquals("page isn't news", NewsPage.NEWS_HEADER_TEXT, newsPage.getHeaderText());
    }

    @Test
    public void test3(){
        log.info("Log step 1: Go to About As tab");
        OxaHomePage oxaHomePage = new OxaHomePage(driver);
        oxaHomePage.goToTabAboutAs();

        log.info("Log step 2: Go to Contact Us");
        AboutAsPage aboutAsPage = new AboutAsPage(driver);
        aboutAsPage.goToContactUs();

        log.info("Log step 3: Check that page is Contact Us");
        ContactUsPage contactUsPage = new ContactUsPage(driver);
        Assert.assertEquals("page isn't contact us", ContactUsPage.CONTACT_US_HEADER_TEXT, contactUsPage.getHeaderText());

        log.info("Log step 4: Check for required NAME field");
        contactUsPage.sendRequest();
        Assert.assertEquals("validation message for name field wasn't found", ContactUsPage.NAME_VALIDATION_TEXT, contactUsPage.getNameValidationText());

        log.info("Log step 4: Check for required EMAIL field");
        contactUsPage.sendRequest("name");
        Assert.assertEquals("validation message for email field wasn't found", ContactUsPage.EMAIL_VALIDATION_TEXT, contactUsPage.getEmailValidationText());

        log.info("log step 4: Check for required Message textarea");
        contactUsPage.sendRequest("name", "alena.yanusova@oxagile.com");
        Assert.assertEquals("validation message for message textarea wasn't found", ContactUsPage.MESSAGE_VALIDATION_TEXT, contactUsPage.getMessageValidationText());

    }

    @Test
    public void test4(){
        log.info("Log step 1: Go to About As tab");
        OxaHomePage oxaHomePage = new OxaHomePage(driver);
        oxaHomePage.goToTabAboutAs();

        log.info("Log step 2: Go to QA page");
        AboutAsPage aboutAsPage = new AboutAsPage(driver);
        aboutAsPage.goToQAPage();

        log.info("Log step 3: Go to Contact Us");
        QAPage qaPage = new QAPage(driver);
        qaPage.goToContactUs();

        log.info("Log step 4: Check that page is Contact Us");
        ContactUsPage contactUsPage = new ContactUsPage(driver);
        Assert.assertEquals("page isn't contact us", ContactUsPage.CONTACT_US_HEADER_TEXT, contactUsPage.getHeaderText());
    }

}
