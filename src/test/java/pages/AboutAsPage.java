package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by yanusovaaa on 11/26/2015.
 */

public class AboutAsPage extends BasePage {

    public AboutAsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public  final static  String ABOUT_AS_HEADER_TEXT = "About Us";

    final String ABOUT_US_HEADER = "//div[@class='header']";
    @FindBy(xpath = ABOUT_US_HEADER)
    private WebElement aboutUsHeader;


    final String NEWS_LINK = "//a[contains(@href, 'http://redesign-qa.oxagile.com/company/news/')]";
    @FindBy(xpath = NEWS_LINK)
    private WebElement newsLink;

    final String CONTACT_US_LINK = "//a[contains(@href, '/free-quote/')]";
    @FindBy(xpath = CONTACT_US_LINK)
    private WebElement contactUsLink;

    public String getHeaderText(){
        waitForElement(ABOUT_US_HEADER);
        return aboutUsHeader.getText();
    }

    public void goToNews(){
        waitForElement(NEWS_LINK);
        newsLink.click();
        log.info("Click 'newsLink'");
    }

    public void goToContactUs(){
        waitForElement(CONTACT_US_LINK);
        contactUsLink.click();
        log.info("Click 'contactUsLink'");
    }




}
