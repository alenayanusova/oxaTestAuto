package base;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.*;

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

    public abstract void initPages();


    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        initPages();
        log.info("FirefoxDriver initialized");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        log.info("Set timeout fro 10 seconds");
        driver.get(BASE_URL);

    }

    @After
    public void shutDown() {
        //driver.quit();
        log.info("Driver shut down");
    }

}

