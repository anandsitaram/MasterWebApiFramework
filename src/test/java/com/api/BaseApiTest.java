package com.api;

import com.tricentis.common.listeners.ITestListenerImp;
import com.tricentis.common.reports.ExtentLogger;
import com.tricentis.common.reports.ExtentReport;
import org.testng.ITestResult;
import org.testng.annotations.*;

@Listeners({ITestListenerImp.class})
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



}
