package driverManagers;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

public class LocalDriverManager extends DriverManager{

    @Override
    public void createDriver(String browser) {
        switch (browser){
            case "chrome":{
                ChromeOptions options = new ChromeOptions();
                options.setPageLoadStrategy(PageLoadStrategy.fromString(System.getProperty("web.driver.pageLoadStrategy")));
                driver = new ChromeDriver(options);
                break;
            }
            case "firefox":{
                FirefoxOptions options = new FirefoxOptions();
                options.setPageLoadStrategy(PageLoadStrategy.fromString(System.getProperty("web.driver.pageLoadStrategy")));
                driver = new FirefoxDriver(options);
                break;
            }
            default:{
                SafariOptions options = new SafariOptions();
                options.setPageLoadStrategy(PageLoadStrategy.fromString(System.getProperty("web.driver.pageLoadStrategy")));
                driver = new SafariDriver(options);
                break;
            }
        }
    }
}
