package base;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;


/**
 * Created by yanusovaaa on 11/25/2015.
 */

public class BasePage {
    protected WebDriver driver;
    protected Logger log = Logger.getLogger(this.getClass().getName());

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }


    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void waitForElement(String xpath){
        for (int second = 0;; second++) {
            if (second >= 60)
                throw new NoSuchElementException("timeout");
            if (isElementPresent(By.xpath(xpath)))
                    break;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
