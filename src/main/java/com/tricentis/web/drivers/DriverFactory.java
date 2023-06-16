package com.tricentis.web.drivers;

import com.tricentis.common.exceptions.BrowserNotSpecifiedException;
import com.tricentis.web.enums.DRIVERTYPE;
import org.openqa.selenium.WebDriver;

public final class DriverFactory {

    private static DriverManager driverManager;

    private DriverFactory() {

    }

    public static void initDriver(DRIVERTYPE type) {

        switch(type){
            case CHROME:   driverManager = new ChromeDriverManager();
                break;
            case FIREFOX:   driverManager = new FirefoxDriverManager();
                break;
            case EDGE:     driverManager= new EdgeDriverManager();
                break;
            default: throw new BrowserNotSpecifiedException("Browser is not specified");
        }
        driverManager.createDriver();

       /* if (browser.equals("CHROME")) {
            driverManager = new ChromeDriverManager();
            driverManager.createDriver();
            driver = driverManager.getDriver();

        } else if (browser.equals("FIREFOX")) {
            driver = new FirefoxDriver();
        } else {

        }*/
        // return driverManager.getDriver();

    }

    public static void quitDriver() {
        driverManager.quitDriver();
    }

    public static WebDriver getDriver() {
        return driverManager.getDriver();
    }
}
