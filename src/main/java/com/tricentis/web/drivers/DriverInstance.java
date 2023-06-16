package com.tricentis.web.drivers;

import com.tricentis.web.enums.DRIVERTYPE;
import org.openqa.selenium.WebDriver;

import java.util.Objects;

public final class DriverInstance {

    private DriverInstance() {

    }

    public static void initDriver(DRIVERTYPE browser) {

        if (Objects.isNull(DriverThLocal.getDriver())) {
            DriverFactory.initDriver(browser);
        }
    }

    public static WebDriver getDriver() {
        return DriverFactory.getDriver();
    }

    public static void quitDriver() {
        DriverFactory.quitDriver();

    }

}