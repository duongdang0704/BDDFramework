package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigManager;

import java.time.Duration;

public abstract class BasePage {
    WebDriver webDriver;
    WebDriverWait wait;

    public BasePage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(ConfigManager.ajaxWait));

    }

    public String getTile(){
        return webDriver.getTitle();
    }

    public BasePage waitUntilPageDisplay(String title){
        wait.until(ExpectedConditions.titleContains(title));
        return this;
    }

    public void waitForElementVisible(WebElement element){
        wait.ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.visibilityOf(element));

    }
    public void waitForElementClickable(WebElement element){
        wait.ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElementPresentAndClickable(By locator){
        wait.until(ExpectedConditions.and(ExpectedConditions.presenceOfElementLocated(locator),
                                            ExpectedConditions.elementToBeClickable(locator)));
    }

    public void setCheckbox(WebElement element, boolean check){
        if(element.isSelected() != check){
            element.click();
        }
    }

    public void hoverOnElement(WebElement element){
        new Actions(webDriver).moveToElement(element).perform();
    }

}
