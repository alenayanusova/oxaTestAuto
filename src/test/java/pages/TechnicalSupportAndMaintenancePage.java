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

public class TechnicalSupportAndMaintenancePage extends BasePage {

    public TechnicalSupportAndMaintenancePage(WebDriver driver) {
        super(driver);
    }

    public  final static String TECHNICAL_SUPPORT_HEADER_TEXT = "Technical Support & Maintenance";

    final String TECHNICAL_SUPPORT_HEADER = "//div[@class='header']";
    @FindBy(xpath = TECHNICAL_SUPPORT_HEADER)
    private WebElement technicalSupportHeader;

    public String getHeaderText(){
        waitForElement(TECHNICAL_SUPPORT_HEADER);
        log.info("get 'TECHNICAL_SUPPORT_HEADER'");
        return technicalSupportHeader.getText();
    }
}
