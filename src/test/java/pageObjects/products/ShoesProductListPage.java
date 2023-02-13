package pageObjects.products;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoesProductListPage extends ProductListPage{
    @FindBy(css = "div[data-testid='tab-list']")
    WebElement tabList;
    @FindBy(linkText = "Men's")
    WebElement menTabItem;


    public ShoesProductListPage(WebDriver webDriver) {
        super(webDriver);
    }
    public void selectCategory(String category){
        waitForElementClickable(menTabItem);
        menTabItem.click();
    }

}
