package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by yanusovaaa on 11/25/2015.
 */

public class OxaHomePage extends BasePage {

    public OxaHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    final String ABOUT_AS_TAB = "//*[@id='top-menu-107']";
    @FindBy(xpath = ABOUT_AS_TAB)
    private WebElement aboutAsTab;

    final String SERVICES_TAB = "//*[@id='top-menu-115']";
    @FindBy(xpath = SERVICES_TAB)
    private WebElement servicesTab;

    final String PORTFOLIO_TAB = "//*[@id='top-menu-3586']";
    @FindBy(xpath = PORTFOLIO_TAB)
    private WebElement portfolioTab;



    public void goToTabAboutAs(){
        waitForElement(ABOUT_AS_TAB);
        aboutAsTab.click();
        log.info("Click 'tabAboutAs'");
    }

    public void goToTabServices(){
        waitForElement(SERVICES_TAB);
        servicesTab.click();
        log.info("Click 'tabServices'");
    }

    public void goToTabPortfolio(){
        waitForElement(PORTFOLIO_TAB);
        portfolioTab.click();
        log.info("Click 'tabPortfolio'");
    }



}
