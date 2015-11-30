package tests;

import base.BaseTest;
import org.junit.Test;
import pages.OxaHomePage;
import pages.ServiciesPage;
import static org.junit.Assert.*;



/**
 * Created by sivenkovdn on 27.11.2015.
 * @author sicenkovdn
 */
public class ServiciesTest extends BaseTest {



    @Test
    public void test1(){
        OxaHomePage oxaHomePage = new OxaHomePage(driver);
        oxaHomePage.goToTabServices();
        ServiciesPage serviciesPage = new ServiciesPage(driver);
        serviciesPage.goCustomSoftwareDevelopmentServices();
        assertEquals("Custom Software Development Services - Oxagile", driver.getTitle());
    }

    @Test
    public void test2(){
        OxaHomePage oxaHomePage = new OxaHomePage(driver);
        oxaHomePage.goToTabServices();
        ServiciesPage serviciesPage = new ServiciesPage(driver);
        serviciesPage.goWebApplicationDevelopmentServices();
        assertEquals("Web Development Company - Web App Development - Oxagile", driver.getTitle());
    }

    @Test
    public void test3(){
        OxaHomePage oxaHomePage = new OxaHomePage(driver);
        oxaHomePage.goToTabServices();
        ServiciesPage serviciesPage = new ServiciesPage(driver);
        serviciesPage.goMobileApplicationDevelopmentServices();
        assertEquals("Mobile Application Development Company - Mobile Development Services - Oxagile", driver.getTitle());
    }

    @Test
    public void test4(){
        OxaHomePage oxaHomePage = new OxaHomePage(driver);
        oxaHomePage.goToTabServices();
        ServiciesPage serviciesPage = new ServiciesPage(driver);
        serviciesPage.goSoftwareTestingAndQAServices();
        assertEquals("QA and Software Testing Professional Services - Oxagile", driver.getTitle());
    }

    @Test
    public void test5(){
        OxaHomePage oxaHomePage = new OxaHomePage(driver);
        oxaHomePage.goToTabServices();
        ServiciesPage serviciesPage = new ServiciesPage(driver);
        serviciesPage.goSupportAndMaintenanceServices();
        assertEquals("Software Maintenance & Technical Support Services - Oxagile", driver.getTitle());

    }

    @Test
    public void test6(){
        OxaHomePage oxaHomePage = new OxaHomePage(driver);
        oxaHomePage.goToTabServices();
        ServiciesPage serviciesPage = new ServiciesPage(driver);
        serviciesPage.goContactUsPage();
        assertEquals("Request Free Quote Form from Oxagile", driver.getTitle());

    }
}
