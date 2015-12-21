package pages;

import base.BasePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;



/**
 * Created by sivenkovdn on 26.11.2015.
 * @author sivenkovdn
 */
public class ServicesPage extends BasePage {
    public ServicesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    final String CUSTOM_SOFTWARE_DESIGN_AND_DEVELOPMENT_LINK = "//a[contains(@href, '/services/custom-software-design-and-development')]";
    @FindBy(xpath = CUSTOM_SOFTWARE_DESIGN_AND_DEVELOPMENT_LINK)
    private WebElement customSoftwareDesignAndDevelopmentLink;

    final String MOBILE_APPLICATION_DEVELOPMENT_LINK = "//a[contains(@href, '/services/mobile-application-development/')]";
    @FindBy(xpath = MOBILE_APPLICATION_DEVELOPMENT_LINK)
    private WebElement mobileApplicationDevelopmentLink;

    final String WEB_APPLICATION_DEVELOPMENT_LINK = "//a[contains(@href, '/services/web-development')]";
    @FindBy(xpath = WEB_APPLICATION_DEVELOPMENT_LINK)
    private WebElement webApplicationDevelopmentLink;

    final String SOFTWARE_TESTING_AND_QA_LINK = "//a[contains(@href, '/services/software-testing-services/')]";
    @FindBy(xpath = SOFTWARE_TESTING_AND_QA_LINK)
    private WebElement softwareTestingAndQALink;

    final String SUPPORT_AND_MAINTENANCE_LINK = "//a[contains(@href, '/services/technical-support-and-maintenance/')]";
    @FindBy(xpath = SUPPORT_AND_MAINTENANCE_LINK)
    private WebElement supportAndMaintenanceLink;

    final String CONTACT_US_LINK = "//a[contains(@href, 'http://www.oxagile.com/free-quote/')]";
    @FindBy(xpath = CONTACT_US_LINK)
    private WebElement contactUsLink;

    public void goCustomSoftwareDevelopmentServices(){
        log.warn("Navigate to Custom Software Development Services page");
        waitForElement(CUSTOM_SOFTWARE_DESIGN_AND_DEVELOPMENT_LINK);
        customSoftwareDesignAndDevelopmentLink.click();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        log.warn("User is on Custom Software Development Services page");
    }

    public void goMobileApplicationDevelopmentServices(){
        log.warn("Navigate to Mobile Development Services page");
        waitForElement(MOBILE_APPLICATION_DEVELOPMENT_LINK);
        mobileApplicationDevelopmentLink.click();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        log.warn("User is on Mobile Development Services page");
    }

    public void goWebApplicationDevelopmentServices(){
        log.warn("Navigate to Web Development Services page");
        waitForElement(WEB_APPLICATION_DEVELOPMENT_LINK);
        webApplicationDevelopmentLink.click();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        log.warn("User is on Web Development Services page");
    }

    public void goSoftwareTestingAndQAServices(){
        log.warn("Navigate to Software Quality Assurance, Quality Control & Testing Services page");
        waitForElement(SOFTWARE_TESTING_AND_QA_LINK);
        softwareTestingAndQALink.click();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        log.warn("User is on Software Quality Assurance, Quality Control & Testing Services page");
    }

    public void goSupportAndMaintenanceServices(){
        log.warn("Navigate to Technical Support & Maintenance page.");
        waitForElement(SUPPORT_AND_MAINTENANCE_LINK);
        supportAndMaintenanceLink.click();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        log.warn("User is on Technical Support & Maintenance page");
    }

    public void goContactUsPage(){
        log.warn("Navigate to Contact Us page");
        waitForElement(CONTACT_US_LINK);
        contactUsLink.click();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        log.warn("User is on Contact Us page");
    }
}
