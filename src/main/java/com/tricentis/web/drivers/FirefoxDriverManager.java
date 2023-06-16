package com.tricentis.web.drivers;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverManager extends DriverManager {

    protected FirefoxDriverManager() {

    }

    protected void createDriver() {
        //TODO- Add Logic for Chrome options and chromedriver.exe path
        driver = new FirefoxDriver();
        DriverThLocal.setDriver(driver);
    }


}
