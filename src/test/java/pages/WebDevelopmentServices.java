package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by yanusovaaa on 12/2/2015.
 * @author yanusovaaa
 */

public class WebDevelopmentServices extends BasePage{

    public WebDevelopmentServices(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public  final static String WEB_DEVELOPMENT_SERVICES_HEADER_TEXT = "Web Development Services";

    final String WEB_DEVELOPMENT_SERVICES_HEADER = "//div[@class='header']";
    @FindBy(xpath = WEB_DEVELOPMENT_SERVICES_HEADER)
    private WebElement webDevelopmentServicesHeader;

    public String getHeaderText(){
        waitForElement(WEB_DEVELOPMENT_SERVICES_HEADER);
        log.info("get 'WEB_DEVELOPMENT_SERVICES_HEADER'");
        return webDevelopmentServicesHeader.getText();
    }
}
