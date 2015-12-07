package tests;

import base.BaseTest;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import pages.OxaHomePage;
import pages.ServiciesPage;
import static org.junit.Assert.*;



/**
 * Created by sivenkovdn on 27.11.2015.
 * @author sicenkovdn
 */
public class ServiciesTest extends BaseTest {

    @Override
    public void initPages() {
        oxaHomePage = PageFactory.initElements(driver, OxaHomePage.class);
        serviciesPage = PageFactory.initElements(driver, ServiciesPage.class);

    }

    @Test
    public void test(){

        oxaHomePage.goToTabServices();
        serviciesPage.goCustomSoftwareDevelopmentServices();
        assertEquals("Custom Software Development Services - Oxagile", driver.getTitle());
    }

    @Test
    public void test2(){

        oxaHomePage.goToTabServices();
        serviciesPage.goWebApplicationDevelopmentServices();
        assertEquals("Web Development Company - Web App Development - Oxagile", driver.getTitle());
    }

    @Test
    public void test3(){
        oxaHomePage.goToTabServices();
        serviciesPage.goMobileApplicationDevelopmentServices();
        assertEquals("Mobile Application Development Company - Mobile Development Services - Oxagile", driver.getTitle());
    }

    @Test
    public void test4(){

        oxaHomePage.goToTabServices();
        serviciesPage.goSoftwareTestingAndQAServices();
        assertEquals("QA and Software Testing Professional Services - Oxagile", driver.getTitle());
    }

    @Test
    public void test5(){

        oxaHomePage.goToTabServices();
        serviciesPage.goSupportAndMaintenanceServices();
        assertEquals("Software Maintenance & Technical Support Services - Oxagile", driver.getTitle());

    }

    @Test
    public void test6(){
        oxaHomePage.goToTabServices();
        serviciesPage.goContactUsPage();
        assertEquals("Request Free Quote Form from Oxagile", driver.getTitle());

    }
}
