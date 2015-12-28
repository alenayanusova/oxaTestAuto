package tests;

import base.BaseTest;
import base.listeners.CustomTestListenerAdapter;
import org.junit.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.support.PageFactory;
import pages.*;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Title;
import ru.yandex.qatools.allure.model.SeverityLevel;

/**
 * Created by yanusovaaa on 11/25/2015.
 * @author yanusovaaa
 */

@Listeners({ CustomTestListenerAdapter.class })
public class AboutUsTest extends BaseTest {

    @DataProvider (name = "requiredFieldsValidation" )
    public Object [][] requiredFieldsValidation () {
        return new Object[][] {
                {"", "", "", ContactUsPage.NAME_VALIDATION_TEXT},
                {"name", "", "", ContactUsPage.EMAIL_VALIDATION_TEXT},
                {"name", "alena.yanusova@oxagile.com", "", ContactUsPage.MESSAGE_VALIDATION_TEXT},
                {"name", "alena.yanusova@oxagile.com", "text", ContactUsPage.HUMAN_VALIDATION_TEXT},

        };
    }

    @DataProvider (name = "keysForSearch" )
    public Object [][] keysForSearch () {
        return new Object[][] {
                {"Java"},
                {"dsfsdfdsfds"},
        };
    }

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

    @Features("About Us")
    @Severity(SeverityLevel.BLOCKER)
    @Title("navigation to about us tab")
    @Description("1) go to home page; \n"
            + "2) go to about us; \n"
            + "3) check that page is about us. \n")

    @Test(enabled = true)
    public void goToAboutUs(){
        log.info("Log step 1: Go to About Us tab");
        oxaHomePage.goToTabAboutAs();
        log.info("Log step 2: Check that page is About As");
        Assert.assertEquals("page isn't about us", AboutUsPage.ABOUT_AS_HEADER_TEXT, aboutUsPage.getHeaderText());

    }

    @Features("About Us")
    @Severity(SeverityLevel.MINOR)
    @Title("navigation to the news page")
    @Description("1) go to home page; \n"
            + "2) go to news; \n"
            + "3) check that page is news. \n")

    @Test (enabled = true)
    public void navigationToNewsPage(){
        log.info("Log step 1: Go to About As tab");

        oxaHomePage.goToTabAboutAs();
        log.info("Log step 2: Go to News");
        oxaHomePage.goToNewsPageFromAboutUsMenu();
        log.info("Log step 3: Check that page is News and get screenshot");
        Assert.assertEquals("page isn't news", NewsPage.NEWS_HEADER_TEXT, newsPage.getHeaderText());
    }

    @Features("About Us")
    @Severity(SeverityLevel.NORMAL)
    @Title("check required fields for contact us form")
    @Description("1) go to home page; \n"
            + "2) open contact us from about us menu by hover; \n"
            + "3) check validation for all objects. \n")

    @Test(dataProvider = "requiredFieldsValidation", enabled = true)
    public void checkValidationForContact(String name, String email, String text, String expected) {
        log.info("Log step 1: Go to Contact Us for About Us menu");
        oxaHomePage.goToContactUsFromAboutUsMenu();


        log.info("log step 2: Check for " + expected + " validation");
        contactUsPage.sendRequest(name, email, text);
        Assert.assertEquals("validation message wasn't found", expected, contactUsPage.getValidationText(name, email, text));

    }

    @Features("About Us")
    @Severity(SeverityLevel.MINOR)
    @Title("check navigation between pages")
    @Description("1) go to home page; \n"
            + "2) go to about us; \n"
            + "3) go to QA page; \n"
            + "4) go to contact us; \n"
            + "5) check that page is contact us. \n")

    @Test (enabled = true)
    public void checkNavigationBetweenPages1(){
        log.info("Log step 1: Go to About As tab");
        oxaHomePage.goToTabAboutAs();

        log.info("Log step 2: Go to QA page");
        aboutUsPage.goToQAPage();

        log.info("Log step 3: Go to Contact Us");
        softwareQualityAssurance.goToContactUs();

        log.info("Log step 4: Check that page is Contact Us");
        Assert.assertEquals("page isn't contact us", ContactUsPage.CONTACT_US_HEADER_TEXT, contactUsPage.getHeaderText());
    }


    @Features("About Us")
    @Severity(SeverityLevel.NORMAL)
    @Title("check that search works correct")
    @Description("1) open home page; \n"
            + "2) hover on search field; \n"
            + "3) send search request; \n"
            + "4(check that search works correct. \n")

    @Test (dataProvider = "keysForSearch", enabled = true)
    public void checkForSearch(String key){
        log.info("Log step 1: Try to search");
        oxaHomePage.tryToSearch(key);

        log.info("Log step 2: Check that search works correct");
        Assert.assertTrue("search works incorrect", searchResultsPage.checkAllPagesForResults(key));
    }

    @Features("About Us")
    @Severity(SeverityLevel.MINOR)
    @Title("check navigation between pages")
    @Description("1) go to home page; \n"
            + "2) go to about us; \n"
            + "3) go to contact us; \n"
            + "4) check that page is contact us. \n")

    @Test (enabled = true)
    public void checkNavigationBetweenPages2(){
        log.info("Log step 1: Go to About As tab");
        oxaHomePage.goToTabAboutAs();

        log.info("Log step 2: Go to Contact Us from About Us page");
        aboutUsPage.goToContactUsFromAboutUsPage();

        log.info("Log step 3: Check that page is Contact Us");
        Assert.assertEquals("page isn't contact us", ContactUsPage.CONTACT_US_HEADER_TEXT, contactUsPage.getHeaderText());
    }


    @Features("About Us")
    @Severity(SeverityLevel.MINOR)
    @Title("check navigation to the customer software services page")
    @Description("1) go to home page; \n"
            + "2) go to about us; \n"
            + "3) go to customer software services page; \n"
            + "4) check that page is software services page. \n")
    @Test (enabled = true)
    public void checkNavigationBetweenPages3(){
        log.info("Log step 1: Go to About As tab");
        oxaHomePage.goToTabAboutAs();

        log.info("Log step 2: Go to Customer software services page");
        aboutUsPage.goToCustomerSoftwareServices();

        log.info("Log step 3: Check that page is Customer software services page");
        Assert.assertEquals("page isn't customer software services", CustomSoftwareDevelopmentServices.CUSTOMER_SOFTWARE_SERVICES_HEADER_TEXT, customSoftwareDevelopmentServices.getHeaderText());
    }

    @Features("About Us")
    @Severity(SeverityLevel.MINOR)
    @Title("check navigation to the web development services page")
    @Description("1) go to home page; \n"
            + "2) go to about us; \n"
            + "3) go to web development services page; \n"
            + "4) check that page is web development services page. \n")
    @Test (enabled = true)
    public void checkNavigationBetweenPages4(){
        log.info("Log step 1: Go to About As tab");
        oxaHomePage.goToTabAboutAs();

        log.info("Log step 2: Go to Web development services page");
        aboutUsPage.goToWebDevelopmentServices();

        log.info("Log step 3: Check that page is Web development services page");
        Assert.assertEquals("page isn't web development services", WebDevelopmentServices.WEB_DEVELOPMENT_SERVICES_HEADER_TEXT, webDevelopmentServices.getHeaderText());
    }


    @Features("About Us")
    @Severity(SeverityLevel.MINOR)
    @Title("check navigation to the mobile development services page")
    @Description("1) go to home page; \n"
            + "2) go to about us; \n"
            + "3) go to mobile development services page; \n"
            + "4) check that page is mobile development services page. \n")
    @Test (enabled = true)
    public void checkNavigationBetweenPages5(){
        log.info("Log step 1: Go to About As tab");
        oxaHomePage.goToTabAboutAs();

        log.info("Log step 2: Go to Mobile development services page");
        aboutUsPage.goToMobileApplicationDevelopmentServices();

        log.info("Log step 3: Check that page is Mobile development services page");
        Assert.assertEquals("page isn't web development services", MobileDevelopmentServices.MOBILE_DEVELOPMENT_SERVICED_HEADER_TEXT, mobileDevelopmentServices.getHeaderText());
    }

    @Features("About Us")
    @Severity(SeverityLevel.MINOR)
    @Title("check navigation to the technical support page")
    @Description("1) go to home page; \n"
            + "2) go to about us; \n"
            + "3) go to technical support page; \n"
            + "4) check that page is technical support page. \n")
    @Test (enabled = true)
    public void checkNavigationBetweenPages6(){
        log.info("Log step 1: Go to About As tab");
        oxaHomePage.goToTabAboutAs();

        log.info("Log step 2: Go to Technical support page");
        aboutUsPage.goToTechnicalSupport();

        log.info("Log step 3: Check that page is Technical support page");
        Assert.assertEquals("page isn't web development services", TechnicalSupportAndMaintenancePage.TECHNICAL_SUPPORT_HEADER_TEXT, technicalSupportAndMaintenancePage.getHeaderText());
    }

}
