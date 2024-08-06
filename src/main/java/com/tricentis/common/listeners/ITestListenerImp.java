package com.tricentis.common.listeners;

import com.tricentis.common.reports.ExtentLogger;
import com.tricentis.common.reports.ExtentReport;
import com.tricentis.common.utils.DateUtils;
import com.tricentis.common.utils.ExcelUtil;
import com.tricentis.web.reports.ExtentWebLogger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ITestListenerImp implements ITestListener {
    private static List<List<String>> list2d = new ArrayList<>();
    @Override
    public void onTestFailure(ITestResult result) {
        addResult(result);
        ExtentLogger.failStatus("Test case is failed due to "+result.getThrowable().getMessage());

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        addResult(result);
        ExtentLogger.passStatus("Test case is passed");
    }



    @Override
    public void onTestSkipped(ITestResult result) {
        addResult(result);
        ExtentLogger.skipStatus("Test case is skipped because of "+result.getThrowable().getMessage());
    }


    private synchronized void addResult(ITestResult result) {
        String[] val = new String[3];
        val[0] = result.getMethod().getMethodName();

        if (result.getStatus() == ITestResult.FAILURE) {
            val[1] = "FAILURE";
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            val[1] = "PASSED";
        } else if (result.getStatus() == ITestResult.SKIP) {
            val[1] = "SKIPPED";
        }
        val[2] = DateUtils.getFormattedDate(result.getTestContext().getStartDate());
         list2d.add(Arrays.asList(val));
    }




    @Override
    public void onStart(ITestContext context) {
        String[] headers = {"Test Case Name","Status", "Execution Time"};
        list2d.add(Arrays.asList(headers));
        ExtentReport.setUpReport();
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentReport.closeReport();
        Object[][] array2d;
        array2d = list2d.stream().map(x -> x.toArray(new String[x.size()])).toArray(String[][]::new);
        ExcelUtil.generateReport(array2d);
    }





}

