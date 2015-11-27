package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by pushkarevamn on 11/27/2015.
 */
public class NetPage extends BasePage {

    public NetPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    final String HEADER_XPATH = "//div[@class='header']";
    @FindBy(xpath = HEADER_XPATH)
    private WebElement header;


    public  final static  String HEADER_TEXT = "Portfolio";

    public String getHeaderText(){
        waitForElement(HEADER_XPATH);
        return header.getText();
    }
}
