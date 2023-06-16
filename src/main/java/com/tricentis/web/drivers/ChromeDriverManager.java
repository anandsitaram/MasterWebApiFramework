package com.tricentis.web.drivers;

import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverManager extends DriverManager {

    protected ChromeDriverManager() {

    }

    protected void createDriver() {
        //TODO- Add Logic for Chrome options and chromedriver.exe path
        driver = new ChromeDriver();
        DriverThLocal.setDriver(driver);
    }


}
