package com.web;

import com.tricentis.common.constants.FrameworkConstants;
import com.tricentis.common.reports.ExtentLogger;
import com.tricentis.common.reports.ExtentReport;
import com.tricentis.common.utils.ConfigReader;
import com.tricentis.web.drivers.DriverInstance;
import com.tricentis.web.enums.DRIVERTYPE;
import org.apache.commons.io.FileUtils;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class BaseWebTest {

    @BeforeSuite
    public void beforeSuite() {
        ExtentReport.setUpReport();
        /*try {
            //TODO handle empty file
            FileUtils.cleanDirectory(new File(FrameworkConstants.SCREENSHOT_PATH));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/
    }

    @AfterSuite
    public void afterSuite() {

        ExtentReport.closeReport();
    }
    @Parameters("browser")
    @BeforeMethod
    public void setUp(ITestResult result, @Optional String browser) {
        if (Objects.isNull(browser)) {
            browser = ConfigReader.getBrowserValue();
        }
        ExtentReport.createTestNode(result.getMethod().getMethodName());
        DriverInstance.initDriver(DRIVERTYPE.valueOf(browser.toUpperCase()));
        DriverInstance.getDriver().get(ConfigReader.getApplicationUrl());
        DriverInstance.getDriver().manage().window().maximize();
        ExtentLogger.info(ConfigReader.getApplicationUrl()+" URL is launched in "+browser+" in browser");


    }

    @AfterMethod
    public void tearDown(ITestResult result) {

        if(result.getStatus()==ITestResult.FAILURE){
            ExtentLogger.fail("Failed because of - "+result.getThrowable().getMessage(),true);
        }

        DriverInstance.quitDriver();


    }


}
