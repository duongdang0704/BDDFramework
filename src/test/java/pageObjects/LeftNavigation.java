package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class LeftNavigation extends BasePage{

    @FindAll({
            @FindBy(css = "div[data-testid='accordion-item-Type']"),
            @FindBy(id = "Type")
    })
    WebElement typePanel;
    @FindBy(css = "div[data-testid='accordion-item-Activity']")
    WebElement activityPanel;
    @FindBy(css = "div[data-testid='accordion-item-Size']")
    WebElement sizePanel;
    @FindBy(css = "div[data-testid='accordion-item-Color']")
    WebElement colorPanel;

    public LeftNavigation(WebDriver webDriver){
        super(webDriver);
    }

    public WebElement getFilterElement(String id){
        WebElement element = webDriver.findElement(By.id(id));
        waitForElementVisible(element);
        return element;
    }

    public void setCheckboxesOnFilter(String filter, String options){
//        WebElement filterElement = webDriver.findElement(By.cssSelector("div[data-testid='panel-content-" + "Type']"));
//        waitForElementVisible(filterElement);
//        for (String option:options.split(",")
//             ) {
//            WebElement optionElement = webDriver.findElement(By.id(option));
//            setCheckbox(optionElement, true);
//        }
        typePanel.click();
        setCheckbox(typePanel.findElement(By.id("Rompers")), true);
    }
}
