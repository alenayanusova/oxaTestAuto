package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by alena on 23.12.15.
 * @author yanosovaa
 */

public class BrowserFactory {

    private static Map<String, WebDriver> drivers = new HashMap<String, WebDriver>();

    /*
     * Factory method for getting browsers
     */

    public static WebDriver getBrowser(String browserName) {
        WebDriver driver = null;

        if (browserName.equals("Firefox")) {
            driver = drivers.get("Firefox");
            if (driver == null) {
                driver = new FirefoxDriver();
                drivers.put("Firefox", driver);
            }

        } else if (browserName.equals("IE")) {
            driver = drivers.get("IE");
            if (driver == null) {
                System.setProperty("webdriver.ie.driver",
                        "./src/resources/drivers/IEDriverServer.exe");
                driver = new InternetExplorerDriver();
                drivers.put("IE", driver);
            }

        } else if (browserName.equals("Chrome")) {
            driver = drivers.get("Chrome");
            if (driver == null) {
                System.setProperty("webdriver.chrome.driver",
                        "./src/resources/drivers/chromedriver.exe");
                driver = new ChromeDriver();
                drivers.put("Chrome", driver);
            }

        }
        return driver;
    }

    public static void closeAllDriver() {
        for (String key : drivers.keySet()) {
            drivers.get(key).close();
            drivers.get(key).quit();
        }
    }
}
