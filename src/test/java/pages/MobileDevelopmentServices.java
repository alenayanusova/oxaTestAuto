package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by yanusovaaa on 12/2/2015.
 */
public class MobileDevelopmentServices extends BasePage {

    public MobileDevelopmentServices(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public  final static String MOBILE_DEVELOPMENT_SERVICED_HEADER_TEXT = "Mobile Development Services";

    final String MOBILE_DEVELOPMENT_SERVICED_HEADER = "//div[@class='header']";
    @FindBy(xpath = MOBILE_DEVELOPMENT_SERVICED_HEADER)
    private WebElement mobileDevelopmentServicesHeader;

    public String getHeaderText(){
        waitForElement(MOBILE_DEVELOPMENT_SERVICED_HEADER);
        log.info("get 'MOBILE_DEVELOPMENT_SERVICED_HEADER'");
        return mobileDevelopmentServicesHeader.getText();
    }
}
