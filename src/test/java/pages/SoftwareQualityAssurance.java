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

public class SoftwareQualityAssurance extends BasePage{

    public SoftwareQualityAssurance(WebDriver driver) {
        super(driver);
    }


    final String FREE_QUOTE_BUTTON = "//a[contains(text(),'Get a Free Quote')]";
    @FindBy(xpath = FREE_QUOTE_BUTTON)
    private WebElement freeQuoteButton;

    public void goToContactUs(){
        waitForElement(FREE_QUOTE_BUTTON);
        freeQuoteButton.click();
        log.info("Click 'freeQuoteButton'");
    }

}
