package com.web;

import com.tricentis.common.constants.FrameworkConstants;
import com.tricentis.common.listeners.ITestListenerImp;
import com.tricentis.common.reports.ExtentReport;
import com.tricentis.common.utils.ConfigReader;
import com.tricentis.web.drivers.DriverInstance;
import com.tricentis.web.enums.DRIVERTYPE;
import com.tricentis.web.reports.ExtentWebLogger;
import org.apache.commons.io.FileUtils;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

@Listeners(ITestListenerImp.class)
public class BaseWebTest {


    @BeforeSuite
    public void beforeSuite() {

        //ExtentReport.setUpReport();
        File file = new File(FrameworkConstants.SCREENSHOT_PATH);
        if (file.exists()) {
            try {
                FileUtils.cleanDirectory(new File(FrameworkConstants.SCREENSHOT_PATH));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


    @AfterSuite
    public void afterSuite() {

        //ExtentReport.closeReport();
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
            ExtentWebLogger.info(ConfigReader.getApplicationUrl() + " URL is launched in " + browser + " browser");



    }

    @AfterMethod
    public void tearDown(ITestResult result) {


        DriverInstance.quitDriver();


    }




}
