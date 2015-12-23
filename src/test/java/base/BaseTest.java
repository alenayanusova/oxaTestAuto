package base;

import org.apache.log4j.Logger;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.*;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Created by yanusovaaa on 11/25/2015.
 * @author yanusovaaa
 */

public abstract class BaseTest {
    protected WebDriver driver;
    protected Logger log = Logger.getLogger(this.getClass().getName());
    protected final String BASE_URL = "http://redesign-qa.oxagile.com/";

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
    public ServiciesPage serviciesPage;
    public SoftwareQualityAssurance softwareQualityAssurance;
    public TechnicalSupportAndMaintenancePage technicalSupportAndMaintenancePage;
    public WebDevelopmentServices webDevelopmentServices;
    public FreeQuotePage freeQuotePage;

    public abstract void initPages();

    @Parameters("browser")
    @BeforeMethod
    public void setUp(String browser) {
       // driver = new FirefoxDriver();
        if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("ie")) {
            File file = new File("C:\\IEDriverServer.exe");
            System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
            DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
            driver = new InternetExplorerDriver(capabilities);
        }
        else {
            throw new IllegalArgumentException("The Browser Type is Undefined");
        }
        initPages();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        log.info("Set timeout fro 10 seconds");
        driver.get(BASE_URL);

    }

    @AfterMethod
    public void shutDown() {
        driver.quit();
        log.info("Driver shut down");
    }

}

