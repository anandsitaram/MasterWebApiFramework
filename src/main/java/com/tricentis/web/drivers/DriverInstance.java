package com.tricentis.web.drivers;

import com.tricentis.web.enums.DRIVERTYPE;
import org.openqa.selenium.WebDriver;

import java.util.Objects;

public final class DriverInstance {

    private DriverInstance() {

    }

    /**
     * Initializes the WebDriver instance for the specified browser type if not already initialized.
     *
     * @param browser the type of browser to initialize.
     */
    public static void initDriver(DRIVERTYPE browser) {
        if (Objects.isNull(DriverThLocal.getDriver())) {
            DriverFactory.initDriver(browser);
        }
    }

    /**
     * Retrieves the current WebDriver instance.
     *
     * @return the current WebDriver instance.
     */
    public static WebDriver getDriver() {
        return DriverFactory.getDriver();
    }

    /**
     * Quits the current WebDriver instance.
     */
    public static void quitDriver() {
        DriverFactory.quitDriver();
    }
}