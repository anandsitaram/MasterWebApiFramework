package com.tricentis.web.drivers;

import com.tricentis.common.utils.ConfigReader;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Objects;

public class FirefoxDriverManager extends DriverManager {

    protected FirefoxDriverManager() {

    }

    protected void createDriver() {
        String options = ConfigReader.getBrowserOptions();
        if (Objects.nonNull(options)) {
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.addArguments(options);
            driver = new FirefoxDriver(firefoxOptions);

        } else {
            driver = new FirefoxDriver();

        }
        DriverThLocal.setDriver(driver);
    }


}
