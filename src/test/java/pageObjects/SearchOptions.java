package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchOptions extends BasePage{

    @FindBy(className = "results-description")
    WebElement searchResultText;
    public SearchOptions(WebDriver webDriver){
        super(webDriver);

    }
    public String getSearchResult(){
        waitForElementVisible(searchResultText);
        return searchResultText.getText();
    }
}
