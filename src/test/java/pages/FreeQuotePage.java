package pages;
import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by pushkarevamn on 12/7/2015.
 *
 * @author pushkarevamn
 */

public class FreeQuotePage extends BasePage{

    final String SLIDER = "//div[contains(@class,'noUi-handle')]";
    @FindBy(xpath = SLIDER)
    private WebElement horizontalSlider;

    final String IDENTIFIER_YES = "//div[@class='big-box captcha']/span";
    @FindBy(xpath = IDENTIFIER_YES)
    private WebElement identifierYes;

    public void horizontalSlide(){
        waitForElement(SLIDER);
        log.info("get 'Move slider'");
        Actions actions = new Actions(driver);
        actions.dragAndDrop(horizontalSlider,identifierYes);
        actions.build().perform();
    }

    public FreeQuotePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    final String HUMAN_YES_XPATH = "//span[text()='Yes']";
    @FindBy(xpath = HUMAN_YES_XPATH)
    private WebElement humanYes;

    public  final static  String YES_STYLE = "red-style";

    public String getHumanYes(){
        waitForElement(HUMAN_YES_XPATH);
        return humanYes.getAttribute("class");
    }
}

