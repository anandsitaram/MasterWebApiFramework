package com.tricentis.web.drivers;

import org.openqa.selenium.WebDriver;

import java.util.Objects;

public abstract class DriverManager {
    protected WebDriver driver;

    protected abstract void createDriver();

    protected WebDriver getDriver() {
        return DriverThLocal.getDriver();
    }

    protected void quitDriver() {
        if (Objects.nonNull(DriverThLocal.getDriver())) {
            getDriver().quit();
            DriverThLocal.unload();
        }
    }
}