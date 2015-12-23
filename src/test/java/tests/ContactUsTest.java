package tests;

import base.BaseTest;
import org.testng.annotations.*;
import org.openqa.selenium.support.PageFactory;
import pages.ContactUsPage;
import pages.OxaHomePage;
import pages.ServiciesPage;

import static org.junit.Assert.assertEquals;

/**
 * Created by Hooligan on 06.12.2015.
 */
public class ContactUsTest extends BaseTest {

    @DataProvider (name = "wrongEmailValidation" )
    public Object [][] wrongEmailValidation () {
        return new Object[][] {
                {"name", "asd", "Wrong email format"},
                {"name", "asd@", "Wrong email format"},
                {"name", "asd@@aaa.com", "Wrong email format"},
                {"name", "@aaa.com", "Wrong email format"},

        };
    }

    @Override
    public void initPages() {
        oxaHomePage = PageFactory.initElements(driver, OxaHomePage.class);
        contactUsPage = PageFactory.initElements(driver, ContactUsPage.class);
        serviciesPage = PageFactory.initElements(driver, ServiciesPage.class);
    }

    @Test (enabled = false, groups = "validation")
    public void validationEmptyFieldsTest() {
        oxaHomePage.goToContactUsFromAboutUsMenu();
        contactUsPage.sendRequest();
        try {
            assertEquals(ContactUsPage.NAME_VALIDATION_TEXT,contactUsPage.getNameValidationText());
        } catch (Exception e) {
            log.info("Name validation is not done correctly");
        }

        contactUsPage.sendRequest("user");
        try {
            assertEquals(ContactUsPage.EMAIL_VALIDATION_TEXT,contactUsPage.getEmailValidationText());
        } catch (Exception e) {
            log.info("Email validation is not done correctly");
        }

        contactUsPage.sendRequest("user", "user@test.com");
        try {
            assertEquals(ContactUsPage.MESSAGE_VALIDATION_TEXT,contactUsPage.getMessageValidationText());
        } catch (Exception e) {
            log.info("Message validation is not done correctly");
        }

        contactUsPage.sendRequest("user", "user@test.com", "test");
        assertEquals(ContactUsPage.HUMAN_VALIDATION_TEXT,contactUsPage.getHumanValidationText());
    }

    @Test (dataProvider = "wrongEmailValidation", groups = "validation")
    public void emailValidationTest(String name, String email, String expected) {
        oxaHomePage.goToTabServices();
        serviciesPage.goContactUsPage();
        contactUsPage.emailWrong(name, email);
        assertEquals(expected, contactUsPage.getWrongEmailText());

    }


}
