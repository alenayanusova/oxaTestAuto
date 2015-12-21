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

public class CustomSoftwareDevelopmentServices extends BasePage {

    public CustomSoftwareDevelopmentServices(WebDriver driver) {
        super(driver);
    }

    public  final static String CUSTOMER_SOFTWARE_SERVICES_HEADER_TEXT = "Custom Software Development Services";

    final String CUSTOMER_SOFTWARE_SERVICES_HEADER = "//div[@class='header']";
    @FindBy(xpath = CUSTOMER_SOFTWARE_SERVICES_HEADER)
    private WebElement customerSoftwareServicesHeader;

    public String getHeaderText(){
        waitForElement(CUSTOMER_SOFTWARE_SERVICES_HEADER);
        log.info("get 'CUSTOMER_SOFTWARE_SERVICES_HEADER'");
        return customerSoftwareServicesHeader.getText();
    }
}
