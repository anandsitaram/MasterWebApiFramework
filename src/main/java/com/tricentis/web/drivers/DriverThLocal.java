package com.tricentis.web.drivers;

import org.openqa.selenium.WebDriver;

public final class DriverThLocal {
    private DriverThLocal() {

    }

    protected static ThreadLocal<WebDriver> driverThread = new ThreadLocal<>();

    protected static WebDriver getDriver() {
        return driverThread.get();

    }

    protected static void setDriver(WebDriver driver) {

        driverThread.set(driver);
    }

    protected static void unload() {
        driverThread.remove();
    }
}