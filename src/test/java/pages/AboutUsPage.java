package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

/**
 * Created by yanusovaaa on 11/26/2015.
 * @author yanusovaaa
 */

public class AboutUsPage extends BasePage {

    public AboutUsPage(WebDriver driver) {
        super(driver);
    }

    public  final static  String ABOUT_AS_HEADER_TEXT = "About Us";

    final String ABOUT_US_HEADER = "//div[@class='header']";
    @FindBy(xpath = ABOUT_US_HEADER)
    private WebElement aboutUsHeader;

    final String CONTACT_US_LINK = "//a[contains(@href, '/free-quote/')]";
    @FindBy(xpath = CONTACT_US_LINK)
    private WebElement contactUsLink;

    final String QA_LINK = "//a[contains(text(),'quality assurance')]";
    @FindBy(xpath = QA_LINK)
    private WebElement qaLink;

    final String CUSTOMER_SOFTWARE_SERVICES_LINK = "//a[contains(text(),'custom software services')]";
    @FindBy(xpath = CUSTOMER_SOFTWARE_SERVICES_LINK)
    private WebElement customerSoftwareServicesLink;

    final String WEB_DEVELOPMENT_SERVICED_LINK = "//a[contains(text(),'web')]";
    @FindBy(xpath = WEB_DEVELOPMENT_SERVICED_LINK)
    private WebElement webDevelopmentServices;

    final String MOBILE_DEVELOPMENT_SERVICED_LINK = "//a[contains(text(),'mobile application development')]";
    @FindBy(xpath = MOBILE_DEVELOPMENT_SERVICED_LINK)
    private WebElement mobileDevelopmentServices;

    final String TECHNICAL_SUPPORT_LINK = "//a[contains(text(),'maintenance and support')]";
    @FindBy(xpath = TECHNICAL_SUPPORT_LINK)
    private WebElement technicalSupport;

    public String getHeaderText(){
        waitForElement(ABOUT_US_HEADER);
        log.info("get 'ABOUT_US_HEADER'");
        return aboutUsHeader.getText();
    }

    public void goToContactUsFromAboutUsPage(){
        waitForElement(CONTACT_US_LINK);
        contactUsLink.click();
        log.info("Click 'contactUsLink'");
    }

    public void goToQAPage(){
        waitForElement(QA_LINK);
        qaLink.click();
        log.info("Click 'qaLink'");
        ArrayList<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());
        log.info("get window handle'");
        driver.switchTo().window(windowHandles.get(1));
        log.info("switch window");
    }

    public void goToCustomerSoftwareServices(){
        waitForElement(CUSTOMER_SOFTWARE_SERVICES_LINK);
        customerSoftwareServicesLink.click();
        log.info("Click 'customerSoftwareServicesLink'");
        ArrayList<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());
        log.info("get window handle'");
        driver.switchTo().window(windowHandles.get(1));
        log.info("switch window");
    }

    public void goToWebDevelopmentServices(){
        waitForElement(WEB_DEVELOPMENT_SERVICED_LINK);
        webDevelopmentServices.click();
        log.info("Click 'webDevelopmentServices'");
        ArrayList<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());
        log.info("get window handle'");
        driver.switchTo().window(windowHandles.get(1));
        log.info("switch window");
    }

    public void goToMobileApplicationDevelopmentServices(){
        waitForElement(MOBILE_DEVELOPMENT_SERVICED_LINK);
        mobileDevelopmentServices.click();
        log.info("Click 'mobileDevelopmentServices'");
        ArrayList<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());
        log.info("get window handle'");
        driver.switchTo().window(windowHandles.get(1));
        log.info("switch window");
    }

    public void goToTechnicalSupport(){
        waitForElement(TECHNICAL_SUPPORT_LINK);
        technicalSupport.click();
        log.info("Click 'technicalSupport'");
        ArrayList<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());
        log.info("get window handle'");
        driver.switchTo().window(windowHandles.get(1));
        log.info("switch window");
    }
}
