package tests;

import base.BaseTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;
import pages.OxaHomePage;
import pages.ServicesPage;
import static org.junit.Assert.*;



/**
 * Created by sivenkovdn on 27.11.2015.
 * @author sicenkovdn
 */
public class ServiciesTest extends BaseTest {

    @Override
    public void initPages() {
        oxaHomePage = PageFactory.initElements(driver, OxaHomePage.class);
        servicesPage = PageFactory.initElements(driver, ServicesPage.class);

    }

    @Test (enabled = false)
    public void test(){

        oxaHomePage.goToTabServices();
        servicesPage.goCustomSoftwareDevelopmentServices();
        assertEquals("Custom Software Development Services - Oxagile", driver.getTitle());
    }

    @Test (enabled = false)
    public void test2(){

        oxaHomePage.goToTabServices();
        servicesPage.goWebApplicationDevelopmentServices();
        assertEquals("Web Development Company - Web App Development - Oxagile", driver.getTitle());
    }

    @Test (enabled = false)
    public void test3(){
        oxaHomePage.goToTabServices();
        servicesPage.goMobileApplicationDevelopmentServices();
        assertEquals("Mobile Application Development Company - Mobile Development Services - Oxagile", driver.getTitle());
    }

    @Test (enabled = false)
    public void test4(){

        oxaHomePage.goToTabServices();
        servicesPage.goSoftwareTestingAndQAServices();
        assertEquals("QA and Software Testing Professional Services - Oxagile", driver.getTitle());
    }

    @Test (enabled = false)
    public void test5(){

        oxaHomePage.goToTabServices();
        servicesPage.goSupportAndMaintenanceServices();
        assertEquals("Software Maintenance & Technical Support Services - Oxagile", driver.getTitle());

    }

    @Test (enabled = false)
    public void test6(){
        oxaHomePage.goToTabServices();
        servicesPage.goContactUsPage();
        assertEquals("Request Free Quote Form from Oxagile", driver.getTitle());

    }
}
