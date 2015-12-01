package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * Created by yanusovaaa on 11/25/2015.
 * @author yanusovaaa
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

    final String SEARCH_HOVER = "//div[@class='searchhover']";
    @FindBy(xpath = SEARCH_HOVER)
    private WebElement searchHover;

    final String SEARCH_FIELD = "//input[@id='s']";
    @FindBy(xpath = SEARCH_FIELD)
    private WebElement searchField;

    final String SEARCH_SUBMIT_BUTTON = "//input[@id='searchsubmit']";
    @FindBy(xpath = SEARCH_SUBMIT_BUTTON)
    private WebElement searchSubmitButton;



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

    public void tryToSearch(String key){
        waitForElement(SEARCH_HOVER);
        waitForElement(SEARCH_FIELD);
        Actions builder = new Actions(driver);
        builder.moveToElement(searchHover).sendKeys(searchField,key).build().perform();
        waitForElement(SEARCH_SUBMIT_BUTTON);
        searchSubmitButton.click();
    }
}
