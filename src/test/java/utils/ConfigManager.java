package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager {

    public static String baseURL;
    public static int pageLoadWait;
    public static String environment;
    public static String browser;
    public static int ajaxWait;

    public static void loadConfig(String configureFile){
        Properties properties= new Properties();
        try {
            properties.load(new FileInputStream(configureFile));
            properties.forEach((key, value) -> System.setProperty((String) key, (String) value));
        } catch (IOException e) {
            e.printStackTrace();
        }
        baseURL = properties.getProperty("baseURL");
        pageLoadWait = Integer.parseInt(properties.getProperty("pageLoadWait"));
        environment = properties.getProperty("environment");
        browser = properties.getProperty("browser");
        ajaxWait = Integer.parseInt(properties.getProperty("ajaxWait"));
    }
}
