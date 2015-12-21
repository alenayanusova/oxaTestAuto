package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

/**
 * Created by yanusovaaa on 12/1/2015.
 * @author yanusovaaa
 */
public class SearchResultsPage extends BasePage {

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public  final static String SEARCH_RESULT_HEADER_TEXT = "Search\nSearch Results for: ";
    public final static String SEARCH_RESULT_IS_ABSENT_MESSAGE = "We're sorry, but your search returned no results. Please try another query.";

    final String SEARCH_RESULT_HEADER = "//div[@class='header']";
    @FindBy(xpath = SEARCH_RESULT_HEADER)
    private WebElement searchResultHeader;

    final String SEARCH_RESULTS = "//div[@class='search-list-item']";
    @FindBys(@FindBy(xpath = SEARCH_RESULTS))
    private List<WebElement> searchResults;

    final String PAGES_NAVIGATION = "//div[@class='page_nav']";
    @FindBy(xpath = PAGES_NAVIGATION)
    private WebElement pageNavigation;


    final String NEXT_RESULT_PAGE = "//a[@class = 'next page-numbers']";
    @FindBy(xpath = NEXT_RESULT_PAGE)
    private WebElement nextResultPage;

    final String SEARCH_RESULT_IS_ABSENT = "//div[@class='search-list-item-content']";
    @FindBy(xpath = SEARCH_RESULT_IS_ABSENT)
    private WebElement searchResultIsAbsent;

    public String getHeaderText(){
        waitForElement(SEARCH_RESULT_HEADER);
        log.info("get 'SEARCH_RESULT_HEADER'");
        return searchResultHeader.getText();
    }

    public boolean checkSearchResultsForOnePage(String key) {

        log.info("check that search result are here");

        int i = 1;

        if (isElementPresent(SEARCH_RESULTS)) {

            for (int j = 0; j < searchResults.size(); j++) {
                if (isElementPresent("//strong[text()='" + key + "']")) {
                    i++;
                } else break;
            }
        }

        if (i < searchResults.size()){
            return false;
        } else return true;

    }

    public boolean checkAllPagesForResults(String key){
        log.info("check message for incorrect requests");
        boolean flag = false;
        if (isElementPresent(SEARCH_RESULT_IS_ABSENT)) {
            flag = true;
        } else {
            if (checkSearchResultsForOnePage(key) && isElementPresent(PAGES_NAVIGATION)) {
                while (isElementPresent(NEXT_RESULT_PAGE)) {
                    log.info("check that next page is present");
                    nextResultPage.click();
                    log.info("go to next page");
                    if (checkSearchResultsForOnePage(key)){
                        flag = true;
                    } else {
                        flag = false;
                        break;
                    }
                }
            }
        }

        return flag;

    }

    public String getSearchResultIsAbsentMessage(){
        waitForElement(SEARCH_RESULT_IS_ABSENT);
        log.info("get 'SEARCH_RESULT_IS_ABSENT'");
        return searchResultIsAbsent.getText();
    }

    public String getExpectedResult(String key){
        return SEARCH_RESULT_HEADER_TEXT + "\"" + key + "\"";
    }

}
