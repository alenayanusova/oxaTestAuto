package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by yanusovaaa on 11/30/2015.
 */

public class NewsPage extends BasePage {

    public NewsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public  final static  String NEWS_HEADER_TEXT = "News";

    final String NEWS_HEADER = "//div[@class='header']";
    @FindBy(xpath = NEWS_HEADER)
    private WebElement newsHeader;

    public String getHeaderText(){
        waitForElement(NEWS_HEADER);
        return newsHeader.getText();
    }
}
