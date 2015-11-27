package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by pushkarevamn on 11/27/2015.
 *
 * @author pushkarevamn
 */
public class MobilePage extends BasePage {
    public MobilePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    final String BREADCRUMBS_XPATH = "//div[@class='breadcrumbs']";
    @FindBy(xpath = BREADCRUMBS_XPATH)
    private WebElement breadcrumbs;


    public  final static  String BREADCRUMBS_TEXT = "Home / Portfolio / Mobile";

    public String getBreadcrumbsText(){
        waitForElement(BREADCRUMBS_XPATH);
        return breadcrumbs.getText();
    }
}
