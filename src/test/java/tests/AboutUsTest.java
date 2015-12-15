package tests;

import base.BaseTest;
import org.junit.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.support.PageFactory;
import pages.*;

/**
 * Created by yanusovaaa on 11/25/2015.
 * @author yanusovaaa
 */

public class AboutUsTest extends BaseTest {
    @Override
    public void initPages() {
        oxaHomePage = PageFactory.initElements(driver, OxaHomePage.class);
        aboutUsPage = PageFactory.initElements(driver, AboutUsPage.class);
        newsPage = PageFactory.initElements(driver, NewsPage.class);
        contactUsPage = PageFactory.initElements(driver, ContactUsPage.class);
        softwareQualityAssurance = PageFactory.initElements(driver, SoftwareQualityAssurance.class);
        searchResultsPage = PageFactory.initElements(driver, SearchResultsPage.class);
        webDevelopmentServices = PageFactory.initElements(driver, WebDevelopmentServices.class);
        mobileDevelopmentServices = PageFactory.initElements(driver, MobileDevelopmentServices.class);
        technicalSupportAndMaintenancePage = PageFactory.initElements(driver, TechnicalSupportAndMaintenancePage.class);
        customSoftwareDevelopmentServices = PageFactory.initElements(driver, CustomSoftwareDevelopmentServices.class);

    }

    @Test
    public void test1(){
        log.info("Log step 1: Go to About As tab");
        oxaHomePage.goToTabAboutAs();
        log.info("Log step 2: Check that page is About As");
        Assert.assertEquals("page isn't about us", AboutUsPage.ABOUT_AS_HEADER_TEXT, aboutUsPage.getHeaderText());

    }

    @Test
    public void test2(){
        log.info("Log step 1: Go to About As tab");

        oxaHomePage.goToTabAboutAs();
        log.info("Log step 2: Go to News");
        oxaHomePage.goToNewsPageFromAboutUsMenu();
        log.info("Log step 3: Check that page is News");
        Assert.assertEquals("page isn't news", NewsPage.NEWS_HEADER_TEXT, newsPage.getHeaderText());
    }

    @Test
    public void test3(){
        log.info("Log step 1: Go to Contact Us for About Us menu");
        oxaHomePage.goToContactUsFromAboutUsMenu();

        log.info("Log step 2: Check that page is Contact Us");
        Assert.assertEquals("page isn't contact us", ContactUsPage.CONTACT_US_HEADER_TEXT, contactUsPage.getHeaderText());

        log.info("Log step 3: Check for required NAME field");
        contactUsPage.sendRequest();
        Assert.assertEquals("validation message for name field wasn't found", ContactUsPage.NAME_VALIDATION_TEXT, contactUsPage.getNameValidationText());

        log.info("Log step 4: Check for required EMAIL field");
        contactUsPage.sendRequest("name");
        Assert.assertEquals("validation message for email field wasn't found", ContactUsPage.EMAIL_VALIDATION_TEXT, contactUsPage.getEmailValidationText());

        log.info("log step 5: Check for required Message textarea");
        contactUsPage.sendRequest("name", "alena.yanusova@oxagile.com");
        Assert.assertEquals("validation message for message textarea wasn't found", ContactUsPage.MESSAGE_VALIDATION_TEXT, contactUsPage.getMessageValidationText());

    }

    @Test
    public void test4(){
        log.info("Log step 1: Go to About As tab");
        oxaHomePage.goToTabAboutAs();

        log.info("Log step 2: Go to QA page");
        aboutUsPage.goToQAPage();

        log.info("Log step 3: Go to Contact Us");
        softwareQualityAssurance.goToContactUs();

        log.info("Log step 4: Check that page is Contact Us");
        Assert.assertEquals("page isn't contact us", ContactUsPage.CONTACT_US_HEADER_TEXT, contactUsPage.getHeaderText());
    }

    @Test
    public void test5(){
        log.info("Log step 1: Try to search");
        oxaHomePage.tryToSearch("java");

        log.info("Log step 2: Check that page is Search");
        Assert.assertEquals("page isn't search results", searchResultsPage.getExpectedResult("java"), searchResultsPage.getHeaderText());
    }

    @Test
    public void test6(){
        log.info("Log step 1: Go to About As tab");
        oxaHomePage.goToTabAboutAs();

        log.info("Log step 2: Go to Contact Us from About Us page");
        aboutUsPage.goToContactUsFromAboutUsPage();

        log.info("Log step 3: Check that page is Contact Us");
        Assert.assertEquals("page isn't contact us", ContactUsPage.CONTACT_US_HEADER_TEXT, contactUsPage.getHeaderText());
    }

    @Test
    public void test7(){
        log.info("Log step 1: Go to About As tab");
        oxaHomePage.goToTabAboutAs();

        log.info("Log step 2: Go to Customer software services page");
        aboutUsPage.goToCustomerSoftwareServices();

        log.info("Log step 3: Check that page is Customer software services page");
        Assert.assertEquals("page isn't customer software services", CustomSoftwareDevelopmentServices.CUSTOMER_SOFTWARE_SERVICES_HEADER_TEXT, customSoftwareDevelopmentServices.getHeaderText());
    }

    @Test
    public void test8(){
        log.info("Log step 1: Go to About As tab");
        oxaHomePage.goToTabAboutAs();

        log.info("Log step 2: Go to Web development services page");
        aboutUsPage.goToWebDevelopmentServices();

        log.info("Log step 3: Check that page is Web development services page");
        Assert.assertEquals("page isn't web development services", WebDevelopmentServices.WEB_DEVELOPMENT_SERVICES_HEADER_TEXT, webDevelopmentServices.getHeaderText());
    }

    @Test
    public void test9(){
        log.info("Log step 1: Go to About As tab");
        oxaHomePage.goToTabAboutAs();

        log.info("Log step 2: Go to Mobile development services page");
        aboutUsPage.goToMobileApplicationDevelopmentServices();

        log.info("Log step 3: Check that page is Mobile development services page");
        Assert.assertEquals("page isn't web development services", MobileDevelopmentServices.MOBILE_DEVELOPMENT_SERVICED_HEADER_TEXT, mobileDevelopmentServices.getHeaderText());
    }

    @Test
    public void test10(){
        log.info("Log step 1: Go to About As tab");
        oxaHomePage.goToTabAboutAs();

        log.info("Log step 2: Go to Technical support page");
        aboutUsPage.goToTechnicalSupport();

        log.info("Log step 3: Check that page is Technical support page");
        Assert.assertEquals("page isn't web development services", TechnicalSupportAndMaintenancePage.TECHNICAL_SUPPORT_HEADER_TEXT, technicalSupportAndMaintenancePage.getHeaderText());
    }

}
