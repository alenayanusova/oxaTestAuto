package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by yanusovaaa on 11/30/2015.
 */

public class ContactUsPage extends BasePage {

    public ContactUsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public  final static String CONTACT_US_HEADER_TEXT = "Online Request";
    public final static String NAME_VALIDATION_TEXT = "Enter your name, please";
    public final static String EMAIL_VALIDATION_TEXT = "Enter your email, please";

    final String CONTACT_US_HEADER = "//div[@class='header']";
    @FindBy(xpath = CONTACT_US_HEADER)
    private WebElement contactUsHeader;

    final String NAME_VALIDATION = "//div[@id='request-error-message-name']";
    @FindBy(xpath = NAME_VALIDATION)
    private WebElement nameValidation;

    final String EMAIL_VALIDATION = "//div[@id='request-error-message-email']";
    @FindBy(xpath = EMAIL_VALIDATION)
    private WebElement emailValidation;

    final String SEND_REQUEST_BUTTON = "//input[@value='Send Request']";
    @FindBy(xpath = SEND_REQUEST_BUTTON)
    private WebElement sendRequestButton;

    public String getHeaderText(){
        waitForElement(CONTACT_US_HEADER);
        return contactUsHeader.getText();
    }

    public String getNameValidationText(){
        waitForElement(NAME_VALIDATION);
        return nameValidation.getText();
    }

    public String getEmailValidationText(){
        waitForElement(EMAIL_VALIDATION);
        return emailValidation.getText();
    }

    public void sendRequest(){
        waitForElement(SEND_REQUEST_BUTTON);
        sendRequestButton.click();
    }


}
