package base;

import org.apache.log4j.Logger;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import pages.*;
import ru.yandex.qatools.allure.annotations.Attachment;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Created by yanusovaaa on 11/25/2015.
 * @author yanusovaaa
 */

public abstract class BaseTest {
    protected static WebDriver driver;
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

    @Parameters(value = "browser")
    @BeforeTest
    public void setUp(@Optional("Firefox") String browser) {
        //log.info(browser + " was selected");
        driver = BrowserFactory.getBrowser(browser);

        initPages();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        log.info("Set timeout fro 10 seconds");
        driver.get(BASE_URL);

    }

    @Attachment
    public static byte[] makeScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @AfterTest
    public void shutDown() {
        BrowserFactory.closeAllDriver();
        log.info("Driver shut down");
    }
}

