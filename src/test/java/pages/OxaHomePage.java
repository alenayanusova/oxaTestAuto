package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
    }

    final String ABOUT_US_TAB = "//*[@id='top-menu-107']";
    @FindBy(xpath = ABOUT_US_TAB)
    private WebElement aboutUsTab;

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

    final String NEWS_LINK = "//a[contains(@href, 'http://redesign-qa.oxagile.com/company/news/')]";
    @FindBy(xpath = NEWS_LINK)
    private WebElement newsLink;

    final String CONTACT_US_BUTTON = "//a[contains(@href, 'http://redesign-qa.oxagile.com/free-quote/')]";
    @FindBy(xpath = CONTACT_US_BUTTON)
    private WebElement contactUsButton;

    final String FREE_QUOTE_BUTTON = "//div[contains(@class,'free-quote-btn')]/a[contains(@href, 'http://redesign-qa.oxagile.com/free-quote')]";
    @FindBy(xpath = FREE_QUOTE_BUTTON)
    private WebElement freeQuoteButton;




    public void goToTabAboutAs(){
        waitForElement(ABOUT_US_TAB);
        aboutUsTab.click();
        log.info("Click 'tabAboutUs'");
    }

    public void goToNewsPageFromAboutUsMenu(){
        waitForElement(ABOUT_US_TAB);
        waitForElement(NEWS_LINK);
        Actions builder = new Actions(driver);
        builder.moveToElement(aboutUsTab).click(newsLink).build().perform();
        log.info("Hover on aboutUsTab and click 'newsLink'");
    }

    public void goToContactUsFromAboutUsMenu(){
        waitForElement(ABOUT_US_TAB);
        waitForElement(CONTACT_US_BUTTON);
        Actions builder = new Actions(driver);
        builder.moveToElement(aboutUsTab).click(contactUsButton).build().perform();
        log.info("Hover on aboutUsTab and click 'contactUsButton'");
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

    public void tryToSearch(String key) {
        waitForElement(SEARCH_HOVER);
        waitForElement(SEARCH_FIELD);
        Actions builder = new Actions(driver);
        builder.moveToElement(searchHover).sendKeys(searchField,key).build().perform();
        log.info("Send value in 'searchField'");
        waitForElement(SEARCH_SUBMIT_BUTTON);
        searchSubmitButton.click();
        log.info("Click 'searchSubmitButton'");
    }

    public void goToTabFreeQuote(){
        waitForElement(FREE_QUOTE_BUTTON);
        freeQuoteButton.click();
        log.info("Click 'freeQuoteButton'");
    }
}
