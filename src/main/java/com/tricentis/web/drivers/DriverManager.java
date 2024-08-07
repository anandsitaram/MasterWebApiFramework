package com.tricentis.web.drivers;

import org.openqa.selenium.WebDriver;

import java.util.Objects;

/**
 * Abstract class for managing WebDriver instances.
 */
public abstract class DriverManager {
    protected WebDriver driver;

    /**
     * Creates the WebDriver instance. Implementations must provide the specific driver setup.
     */
    protected abstract void createDriver();

    /**
     * Retrieves the current WebDriver instance.
     *
     * @return the current WebDriver instance.
     */
    protected WebDriver getDriver() {
        return DriverThLocal.getDriver();
    }

    /**
     * Quits the current WebDriver instance and removes it from the ThreadLocal storage.
     */
    public void quitDriver() {
        WebDriver currentDriver = DriverThLocal.getDriver();
        if (Objects.nonNull(currentDriver)) {
            try {
                currentDriver.quit();
            } finally {
                DriverThLocal.unload();
            }
        }
    }
}