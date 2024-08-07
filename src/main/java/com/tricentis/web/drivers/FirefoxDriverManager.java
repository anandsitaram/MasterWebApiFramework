package com.tricentis.web.drivers;

import com.tricentis.common.utils.ConfigReader;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Objects;

/**
 * Manager for creating and managing the Firefox WebDriver instance.
 */
public class FirefoxDriverManager extends DriverManager {

    protected FirefoxDriverManager() {

    }

    @Override
    protected void createDriver() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        String options = ConfigReader.getBrowserOptions();
        if (Objects.nonNull(options)) {
            firefoxOptions.addArguments(options);
        }
        driver = new FirefoxDriver(firefoxOptions);
        DriverThLocal.setDriver(driver);
    }
}



