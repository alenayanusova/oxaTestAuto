package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

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

    final String SEARCH_RESULT_HEADER = "//div[@class='header']";
    @FindBy(xpath = SEARCH_RESULT_HEADER)
    private WebElement searchResultHeader;

    final String SEARCH_RESULTS = "//div[@class='search-list-item']";
    @FindAll(@FindBy(xpath = SEARCH_RESULTS))
    private List<WebElement> searchResults;

    final String PAGES_NAVIGATION = "//div[@class='page_nav']";
    @FindBy(xpath = PAGES_NAVIGATION)
    private WebElement pageNavigation;


    final String NEXT_RESULT_PAGE = "//a[@class = 'next page-numbers']";
    @FindBy(xpath = NEXT_RESULT_PAGE)
    private WebElement nextResultPage;

    final String SEARCH_RESULT_IS_ABSENT = "//body[@class = 'search search-no-results full']";
    @FindBy(xpath = SEARCH_RESULT_IS_ABSENT)
    private WebElement searchResultIsAbsent;


    public int checkThatSearchResultsIsHere(){
        log.info("check that search result are here");
        if (isElementPresent(SEARCH_RESULT_IS_ABSENT)){
            log.info("search query is incorrect");
            return 0;
        }else if (isElementPresent(SEARCH_RESULTS)){
            log.info("search results are here");
            return 1;
        } else {
            log.info("search results weren't found");
            return 2;
        }
    }

    public boolean checkSearchResultsForOnePage(String key) {
        log.info("check that all search results contain " + key);
        int j;

        waitForElement(SEARCH_RESULTS);
        log.info("we have " + searchResults.size() + " results on the page");

        for (j = 0; j < searchResults.size()&&isElementPresent("//div[@class = 'search-list-item-content']/strong[text()='" + key + "']"); j++) {

            log.info("result " + j + " on page contain " + key);
        }

        log.info(j + "= j");

        if (j == (searchResults.size())){
            log.info("all results on page contain " + key);
            return true;


        } else {
            log.info("any result on page don't contain " + key);
            return false;

        }

    }

    public boolean checkAllPagesForResults(String key){
        boolean flag = false;
        if (checkThatSearchResultsIsHere() == 2){
            flag = false;
        } else if (checkThatSearchResultsIsHere() == 0){
            flag = true;
        } else {

            if (!isElementPresent(PAGES_NAVIGATION)) {
                log.info("one page is present only");
                flag = checkSearchResultsForOnePage(key);
            } else {
                log.info("more pages is present");
                for (int i = 1; isElementPresent(NEXT_RESULT_PAGE); nextResultPage.click(), i++) {
                    log.info("go to " + i + " page");
                    flag = checkSearchResultsForOnePage(key);
                    if (!flag){
                        break;
                    }

                }
            }
        }
        return flag;
    }

}
