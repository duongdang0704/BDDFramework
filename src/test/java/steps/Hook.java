package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.ConfigManager;
import utils.DriverFactory;
import utils.TestContext;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;

public class Hook {

    TestContext context;
    public Hook(TestContext context){
        this.context = context;
    }

    @Before
    public void setup(){
        ConfigManager.loadConfig("src/test/resources/test_config.properties");
        WebDriver webDriver = new DriverFactory().getDriverManager(ConfigManager.environment, ConfigManager.browser).getDriver();
        webDriver.get(ConfigManager.baseURL);
        context.setDriver(webDriver);
    }

    @After
    public void tearDown(Scenario scenario){
        if (scenario.isFailed()){
            File screenshot = ((TakesScreenshot)context.getDriver()).getScreenshotAs(OutputType.FILE);
            try {
                Files.copy(screenshot.toPath(), new File(String.format("%s/%s-%s.png", System.getProperty("screenshotFolder"), scenario.getName(), LocalDateTime.now())).toPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        context.getDriver().quit();
    }
}
