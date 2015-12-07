package tests;

import base.BaseTest;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import pages.ContactUsPage;
import pages.OxaHomePage;

import static org.junit.Assert.assertEquals;

/**
 * Created by Hooligan on 06.12.2015.
 */
public class ContactUsTest extends BaseTest {

    @Override
    public void initPages() {
        oxaHomePage = PageFactory.initElements(driver, OxaHomePage.class);
        contactUsPage = PageFactory.initElements(driver, ContactUsPage.class);
    }

    @Test
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


}
