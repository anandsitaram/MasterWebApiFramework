package com.tricentis.web.pages;

import com.tricentis.web.drivers.DriverInstance;
import org.openqa.selenium.WebDriver;

public class BasePage {

    protected WebDriver driver;
    protected BasePage(){
        driver=   DriverInstance.getDriver();
        //TODO HARDCODE
        int i=0;
        System.out.println(driver.hashCode()+" "+i);
        i++;

    }
}

