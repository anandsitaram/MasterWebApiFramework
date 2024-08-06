package com.tricentis.web.drivers;

import com.tricentis.web.enums.DRIVERTYPE;
import com.tricentis.web.exceptions.BrowserNotSpecifiedException;
import org.openqa.selenium.WebDriver;

public final class DriverFactory {

    private static DriverManager driverManager;

    private DriverFactory() {

    }

    public static void initDriver(DRIVERTYPE type) {

        switch (type) {
            case CHROME:
                driverManager = new ChromeDriverManager();
                break;
            case FIREFOX:
                driverManager = new FirefoxDriverManager();
                break;
            case EDGE:
                driverManager = new EdgeDriverManager();
                break;
            case REMOTE:

            default:
                throw new BrowserNotSpecifiedException("Browser is not specified");
        }
        driverManager.createDriver();


    }

    public static void quitDriver() {
        driverManager.quitDriver();
    }

    public static WebDriver getDriver() {
        return driverManager.getDriver();
    }
}
