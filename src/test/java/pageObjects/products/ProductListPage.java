package pageObjects.products;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.BasePage;
import pageObjects.LeftNavigation;
import pageObjects.SearchOptions;

import java.util.Map;

public class ProductListPage extends BasePage {
    SearchOptions searchOptions;
    LeftNavigation leftNavigation;

    @FindBy(tagName = "h1")
    WebElement heading;

    public ProductListPage(WebDriver webDriver) {
        super(webDriver);
        searchOptions = new SearchOptions(webDriver);
        leftNavigation = new LeftNavigation(webDriver);
    }

    public String getSearchResult(){
        return searchOptions.getSearchResult();
    }

    public void setFilters(Map<String, String> filterOptions){
        filterOptions.forEach(
                (filter, options) -> {
                    leftNavigation.setCheckboxesOnFilter(filter, options);
                }
        );
    }

    public String getHeading(){
        waitForElementVisible(heading);
        return heading.getText();
    }
}
