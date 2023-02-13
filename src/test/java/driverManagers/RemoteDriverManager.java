package driverManagers;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class RemoteDriverManager extends DriverManager{
    @Override
    public void createDriver(String browser) {
        AbstractDriverOptions driverOptions;
        switch (browser){
            case "chrome":{
                driverOptions = new ChromeOptions();
                break;
            }
            case "firefox":{
                driverOptions = new FirefoxOptions();
                break;
            }
            default:{
                driverOptions = new SafariOptions();
                break;
            }
        }
        driverOptions.setPageLoadStrategy(PageLoadStrategy.fromString(System.getProperty("web.driver.pageLoadStrategy")));
        driverOptions.setPlatformName(System.getProperty("web.driver.platformName"));
        driverOptions.setBrowserVersion(System.getProperty("web.driver.browserVersion"));
        Map<String, Object> cloudOptions = new HashMap<>();
        cloudOptions.put("build", System.getProperty("web.driver.build"));
        cloudOptions.put("name", System.getProperty("web.driver.name"));
        driverOptions.setCapability("cloud:options", cloudOptions);

        try {
            driver = new RemoteWebDriver(new URL(System.getProperty("web.driver.remoteHost")), driverOptions);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
