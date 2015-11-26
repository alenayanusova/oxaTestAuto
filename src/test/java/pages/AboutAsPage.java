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


    final String NEWS_LINK = "//a[contains(@href, 'http://redesign-qa.oxagile.com/company/news/')]";
    @FindBy(xpath = NEWS_LINK)
    private WebElement newsLink;

    public void goToNews(){
        newsLink.click();

    }


}
