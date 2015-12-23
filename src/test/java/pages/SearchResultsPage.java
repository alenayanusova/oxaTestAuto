package pages;

import base.BasePage;
import org.openqa.selenium.By;
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

    public final static String SEARCH_RESULT_HEADER_TEXT = "Search\nSearch Results for: ";

    final String SEARCH_RESULT_HEADER = "//div[@class='header']";
    @FindBy(xpath = SEARCH_RESULT_HEADER)
    private WebElement searchResultHeader;

    final String SEARCH_RESULTS = "//div[@class='search-list-item']";
    @FindAll(@FindBy(xpath = SEARCH_RESULTS))
    private List<WebElement> searchResults;

    final String PAGES_NAVIGATION = "//div[@class='page_nav']";
    @FindBy(xpath = PAGES_NAVIGATION)
    private WebElement pageNavigation;


    final String NEXT_RESULT_PAGE = "//a[contains(@class, 'next page-numbers')]";
    @FindBy(xpath = NEXT_RESULT_PAGE)
    private WebElement nextResultPage;

    final String SEARCH_RESULT_IS_ABSENT = "//body[@class = 'search search-no-results full']";
    @FindBy(xpath = SEARCH_RESULT_IS_ABSENT)
    private WebElement searchResultIsAbsent;


    public int checkThatSearchResultsIsHere() {
        log.info("check that search result are here");
        if (isElementPresent(SEARCH_RESULT_IS_ABSENT)) {
            log.info("search query is incorrect");
            return 0;
        } else if (isElementPresent(SEARCH_RESULTS)) {
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

        for (j = 0; j < searchResults.size() && isElementPresent("//div[@class = 'search-list-item-content']/strong[contains(text(),'" + key + "')]"); waitForElement(SEARCH_RESULTS), j++) {

            log.info("result " + (j + 1) + " on page contain " + key);
        }

        log.info("number of checked results is " + j);

        if (j == (searchResults.size())) {
            log.info("all results on page contain " + key);
            return true;


        } else {
            log.info("any result on page don't contain " + key);
            return false;

        }

    }

    public boolean checkAllPagesForResults(String key) {
        boolean flag = false;
        if (checkThatSearchResultsIsHere() == 2) {
            flag = false;
        } else if (checkThatSearchResultsIsHere() == 0) {
            flag = true;
        } else {

            if (!isElementPresent(PAGES_NAVIGATION)) {
                log.info("one page is present only");
                flag = checkSearchResultsForOnePage(key);

            } else {
                log.info("more pages is present");
                int pagesAmount = Integer.parseInt(driver.findElement(By.xpath("//a[@class='page-numbers'][last()]")).getText());

                for (int i = 0; i < pagesAmount; i++) {
                    log.info("go to " + (i + 1) + " page");
                    flag = checkSearchResultsForOnePage(key);
                    if (!flag) {
                        log.info("we have problem on " + i + " page");
                        break;
                    }
                    if (isElementPresent(NEXT_RESULT_PAGE)) {
                        nextResultPage.click();

                    }
                }
            }

        }
        return flag;
    }
}


