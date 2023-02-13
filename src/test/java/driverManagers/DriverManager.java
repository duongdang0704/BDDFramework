package driverManagers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import utils.ConfigManager;

import java.time.Duration;

public abstract class DriverManager {
    WebDriver driver;
    public void setup(String browser){
        if (driver == null){
            WebDriverManager.getInstance(browser).setup();
            createDriver(browser);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ConfigManager.pageLoadWait));
            driver.manage().window().maximize();
        }
    }
    protected abstract void createDriver(String browser);

    public WebDriver getDriver(){
        return driver;
    }

}
