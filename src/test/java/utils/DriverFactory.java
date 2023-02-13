package utils;

import driverManagers.DriverManager;
import driverManagers.LocalDriverManager;
import driverManagers.RemoteDriverManager;

public class DriverFactory {

    public DriverManager getDriverManager(String environment, String browser){
        DriverManager driverManager = null;
        if (environment.equalsIgnoreCase("local")){
            driverManager = new LocalDriverManager();
        }
        else {
            driverManager = new RemoteDriverManager();
        }
        driverManager.setup(browser);
        return driverManager;
    }

}
