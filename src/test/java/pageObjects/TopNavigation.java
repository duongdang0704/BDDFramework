package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import pageObjects.products.ProductListPage;

import java.util.List;

public class TopNavigation extends BasePage{

    public TopNavigation(WebDriver webDriver){
       super(webDriver);
    }

    @FindBy(css = "input[data-testid='nav-desktop-search']")
    WebElement searchTextbox;
    @FindAll(@FindBy(css = "a[data-testid='nav-desktop-l1']"))
    List<WebElement> menus;

    public void clickMenu(String menuItem){
        String[] items = menuItem.split("->");
        By menuLocator = By.cssSelector("a[data-label='" + items[0] + "']");
        if(items.length > 1){
            hoverOnElement(webDriver.findElement(menuLocator));
            getSubMenuElement(items[1]).click();
        }else {

            waitForElementPresentAndClickable(menuLocator);
            webDriver.findElement(menuLocator).click();
        }
    }

    public WebElement getMenuElement(String menu){
        return webDriver.findElement(By.cssSelector("a[data-label='" + menu + "']"));
    }

    public WebElement getSubMenuElement(String menuItem){
        return webDriver.findElement(By.linkText(menuItem));
    }
    public ProductListPage search(String keyword){
        searchTextbox.sendKeys(keyword);
        searchTextbox.sendKeys(Keys.ENTER);
        return new ProductListPage(webDriver);
    }
}
