package base;

import org.apache.log4j.Logger;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.*;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

/**
 * Created by yanusovaaa on 11/25/2015.
 * @author yanusovaaa
 */

public abstract class BaseTest {
    protected WebDriver driver;
    protected Logger log = Logger.getLogger(this.getClass().getName());
    protected final String BASE_URL = "http://www.oxagile.com/";

    public AboutUsPage aboutUsPage;
    public ContactUsPage contactUsPage;
    public CustomSoftwareDevelopmentServices customSoftwareDevelopmentServices;
    public JavaPage javaPage;
    public MobileDevelopmentServices mobileDevelopmentServices;
    public MobilePage mobilePage;
    public NetPage netPage;
    public NewsPage newsPage;
    public OxaHomePage oxaHomePage;
    public PhpPage phpPage;
    public PortfolioPage portfolioPage;
    public SearchResultsPage searchResultsPage;
    public ServicesPage servicesPage;
    public SoftwareQualityAssurance softwareQualityAssurance;
    public TechnicalSupportAndMaintenancePage technicalSupportAndMaintenancePage;
    public WebDevelopmentServices webDevelopmentServices;
    public FreeQuotePage freeQuotePage;

    public abstract void initPages();

    @BeforeTest
    public void setUp() {
       // driver = new FirefoxDriver();
        driver = BrowserFactory.getBrowser("Firefox");

        initPages();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        log.info("Set timeout fro 10 seconds");
        driver.get(BASE_URL);

    }

    @AfterTest
    public void shutDown() {
        BrowserFactory.closeAllDriver();
        log.info("Driver shut down");
    }

    @Attachment(type = "image/png")
    protected byte[] createAttachment() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }



}

