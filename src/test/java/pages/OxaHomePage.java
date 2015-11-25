package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by yanusovaaa on 11/25/2015.
 */
public class OxaHomePage extends BasePage {

    private By tabAboutAs = By.xpath("//*[@id='top-menu-107']");
    private By tabServices = By.xpath("//*[@id='top-menu-115']");
    private By tabPortfolio = By.xpath("//*[@id='top-menu-3586']");

    public OxaHomePage(WebDriver driver) {
        super(driver);
    }

    public void goToTabAboutAs(){
        driver.findElement(tabAboutAs).click();
        log.info("Click 'tabAboutAs'");
    }

    public void goToTabServices(){
        driver.findElement(tabServices).click();
        log.info("Click 'tabServices'");
    }

    public void goToTabPortfolio(){
        driver.findElement(tabPortfolio).click();
        log.info("Click 'tabPortfolio'");
    }


}
