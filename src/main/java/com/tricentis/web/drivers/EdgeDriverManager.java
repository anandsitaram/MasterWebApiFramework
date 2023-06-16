package com.tricentis.web.drivers;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeDriverManager extends DriverManager {

    protected EdgeDriverManager() {

    }

    protected void createDriver() {
        //TODO- Add Logic for Chrome options and chromedriver.exe path
        driver = new EdgeDriver();
        DriverThLocal.setDriver(driver);
    }


}
