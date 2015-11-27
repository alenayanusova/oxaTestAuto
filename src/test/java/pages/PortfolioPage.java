package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by pushkarevamn on 11/27/2015.
 */
public class PortfolioPage extends BasePage{

    public PortfolioPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    final String PORTFOLIO_LINK = "//a[contains(@href, 'http://portfolio/by-technology/')]";
    @FindBy(xpath = PORTFOLIO_LINK)
    private WebElement portfolioLink;

    final String MOBILE_DEVELOPMENT_LINK = "//img[contains(@src, 'mobile_development.png')]";
    @FindBy(xpath = MOBILE_DEVELOPMENT_LINK)
    private WebElement mobileDevelopmentLink;

    final String NET_DEVELOPMENT_LINK = "//img[contains(@src, 'net_development.png')]";
    @FindBy(xpath = NET_DEVELOPMENT_LINK)
    private WebElement netDevelopmentLink;

    final String JAVA_DEVELOPMENT_LINK = "//img[contains(@src, 'java_development.png')]";
    @FindBy(xpath = JAVA_DEVELOPMENT_LINK)
    private WebElement javaDevelopmentLink;

    final String PHP_DEVELOPMENT_LINK = "//img[contains(@src, 'php_development.png')]";
    @FindBy(xpath = PHP_DEVELOPMENT_LINK)
    private WebElement phpDevelopmentLink;

    public void goToMobileDevelopment(){
        waitForElement(MOBILE_DEVELOPMENT_LINK);
        mobileDevelopmentLink.click();
    }

    public void goToNetDevelopment(){
        waitForElement(NET_DEVELOPMENT_LINK);
        netDevelopmentLink.click();
    }

    public void goToJavaDevelopment(){
        waitForElement(JAVA_DEVELOPMENT_LINK);
        javaDevelopmentLink.click();
    }
    public void goToPhpDevelopment(){
        waitForElement(PHP_DEVELOPMENT_LINK);
        phpDevelopmentLink.click();
    }


}
