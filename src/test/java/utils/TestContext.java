package utils;

import org.openqa.selenium.WebDriver;

public class TestContext {
    WebDriver webDriver;
    public void setDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public WebDriver getDriver() {
        return webDriver;
    }
}
