package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by yanusovaaa on 11/30/2015.
 * @author yanusovaaa
 */

public class ContactUsPage extends BasePage {

    public ContactUsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public  final static String CONTACT_US_HEADER_TEXT = "Online Request";
    public final static String NAME_VALIDATION_TEXT = "Enter your name, please";
    public final static String EMAIL_VALIDATION_TEXT = "Enter your email, please";
    public final static String MESSAGE_VALIDATION_TEXT = "Enter your message, please";
    public final static String HUMAN_VALIDATION_TEXT = "The cursor is not at the end of the line";

    final String CONTACT_US_HEADER = "//div[@class='header']";
    @FindBy(xpath = CONTACT_US_HEADER)
    private WebElement contactUsHeader;

    final String NAME_FIELD = "//input[@id='user-name']";
    @FindBy(xpath = NAME_FIELD)
    private WebElement nameField;

    final String NAME_VALIDATION = "//div[@id='request-error-message-name']";
    @FindBy(xpath = NAME_VALIDATION)
    private WebElement nameValidation;

    final String EMAIL_FIELD = "//input[@id='user-email']";
    @FindBy(xpath = EMAIL_FIELD)
    private WebElement emailField;

    final String EMAIL_VALIDATION = "//div[@id='request-error-message-email']";
    @FindBy(xpath = EMAIL_VALIDATION)
    private WebElement emailValidation;

    final String MESSAGE_TEXT_AREA = "//textarea[@id='_message']";
    @FindBy(xpath = MESSAGE_TEXT_AREA)
    private WebElement messageField;

    final String MESSAGE_VALIDATION = "//div[@id='request-error-message-message']";
    @FindBy(xpath = MESSAGE_VALIDATION)
    private WebElement messageValidation;

    final String HUMAN_VALIDATION = "//div[@class='capthca-error_message']/font";
    @FindBy(xpath = HUMAN_VALIDATION)
    private WebElement humanValidation;

    final String SEND_REQUEST_BUTTON = "//input[@value='Send Request']";
    @FindBy(xpath = SEND_REQUEST_BUTTON)
    private WebElement sendRequestButton;

    public String getHeaderText(){
        waitForElement(CONTACT_US_HEADER);
        log.info("get 'CONTACT_US_HEADER'");
        return contactUsHeader.getText();
    }

    public String getNameValidationText(){
        waitForElement(NAME_VALIDATION);
        log.info("get 'NAME_VALIDATION'");
        return nameValidation.getText();
    }

    public String getEmailValidationText(){
        waitForElement(EMAIL_VALIDATION);
        log.info("get 'EMAIL_VALIDATION'");
        return emailValidation.getText();
    }

    public String getMessageValidationText(){
        waitForElement(MESSAGE_VALIDATION);
        log.info("get 'MESSAGE_VALIDATION'");
        return messageValidation.getText();
    }

    public String getHumanValidationText(){
        waitForElement(HUMAN_VALIDATION);
        log.info("get 'HUMAN_VALIDATION'");
        return humanValidation.getText();
    }

    public void sendRequest(){
        waitForElement(SEND_REQUEST_BUTTON);
        sendRequestButton.click();
        log.info("click on 'SEND_REQUEST_BUTTON'");
    }

    public void sendRequest(String name){
        waitForElement(NAME_FIELD);
        nameField.clear();
        nameField.sendKeys(name);
        log.info("enter value in the 'NAME_FIELD'");
        waitForElement(SEND_REQUEST_BUTTON);
        sendRequestButton.click();
        log.info("click on 'SEND_REQUEST_BUTTON'");
        waitForElement(NAME_VALIDATION);
    }

    public void sendRequest(String name, String email){
        waitForElement(NAME_FIELD);
        nameField.clear();
        nameField.sendKeys(name);
        log.info("enter value in the 'NAME_FIELD'");
        waitForElement(EMAIL_FIELD);
        emailField.clear();
        emailField.sendKeys(email);
        log.info("enter value in the 'EMAIL_FIELD'");
        waitForElement(SEND_REQUEST_BUTTON);
        sendRequestButton.click();
        log.info("click on 'SEND_REQUEST_BUTTON'");
        waitForElement(MESSAGE_VALIDATION);
    }

    public void sendRequest(String name, String email, String message) {
        waitForElement(NAME_FIELD);
        nameField.clear();
        nameField.sendKeys(name);
        log.info("enter value in the 'NAME_FIELD'");
        waitForElement(EMAIL_FIELD);
        emailField.clear();
        emailField.sendKeys(email);
        log.info("enter value in the 'EMAIL_FIELD'");
        waitForElement(MESSAGE_TEXT_AREA);
        messageField.clear();
        messageField.sendKeys(message);
        log.info("enter value in the 'MESSAGE_TEXT_AREA'");
        waitForElement(SEND_REQUEST_BUTTON);
        sendRequestButton.click();
        log.info("click on 'SEND_REQUEST_BUTTON'");
        waitForElement(HUMAN_VALIDATION);
    }


}
