package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by yanusovaaa on 12/1/2015.
 * @author yanusovaaa
 */
public class SearchResultsPage extends BasePage {

    public SearchResultsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public  final static String SEARCH_RESULT_HEADER_TEXT = "Search\nSearch Results for: ";

    final String SEARCH_RESULT_HEADER = "//div[@class='header']";
    @FindBy(xpath = SEARCH_RESULT_HEADER)
    private WebElement searchResultHeader;

    public String getHeaderText(){
        waitForElement(SEARCH_RESULT_HEADER);
        log.info("get 'SEARCH_RESULT_HEADER'");
        return searchResultHeader.getText();
    }

    public String getExpectedResult(String key){
        return SEARCH_RESULT_HEADER_TEXT + "\"" + key + "\"";
    }

}
