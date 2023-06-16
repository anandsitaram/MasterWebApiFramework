package com.api;

import com.tricentis.common.reports.ExtentReport;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseApiTest {
    @BeforeSuite
    public void beforeSuite() {
        ExtentReport.setUpReport();
    }

    @AfterSuite
    public void afterSuite() {
        ExtentReport.closeReport();
    }

    @BeforeMethod
    public void setUp(ITestResult result) {

        ExtentReport.createTestNode(result.getMethod().getMethodName());



    }

    @AfterMethod
    public void tearDown(ITestResult result) {




    }





}
