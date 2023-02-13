package pageObjects;

import org.openqa.selenium.WebDriver;
import pageObjects.products.ProductListPage;
import pageObjects.products.ShoesProductListPage;

public class MasterPage extends BasePage{
    TopNavigation topNavigation;
    public MasterPage(WebDriver webDriver) {
        super(webDriver);
        topNavigation = new TopNavigation(webDriver);
    }

    public ProductListPage searchProduct(String keywords){
        return topNavigation.search(keywords);
    }

    public ProductListPage gotoPage(String menu){
        topNavigation.clickMenu(menu);
        if (menu.equalsIgnoreCase("Shoes")) return new ShoesProductListPage(webDriver);
        else return new ProductListPage(webDriver);
    }
}
