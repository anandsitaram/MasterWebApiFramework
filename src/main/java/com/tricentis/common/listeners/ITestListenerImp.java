package com.tricentis.common.listeners;

import com.tricentis.common.utils.DateUtils;
import com.tricentis.common.utils.ExcelUtil;
import org.testng.IExecutionListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ITestListenerImp implements ITestListener, IExecutionListener {
    private static List<List<String>> list2d = new ArrayList<>();
    private static String appType=null;

    @Override
    public void onTestFailure(ITestResult result) {
        addResult(result);

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        addResult(result);

    }



    @Override
    public void onTestSkipped(ITestResult result) {
        addResult(result);
    }


    private void addResult(ITestResult result) {
        String[] val = new String[3];
        val[0] = result.getMethod().getMethodName();

        if (result.getStatus() == ITestResult.FAILURE) {
            val[1] = "FAILURE";
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            val[1] = "PASSED";
        } else if (result.getStatus() == ITestResult.SKIP) {
            val[1] = "SKIPPED";
        }
        val[2] = DateUtils.getDefaultDateTime();
         list2d.add(Arrays.asList(val));
    }

    @Override
    public void onExecutionStart() {

        String[] headers = {"Test Case Name","Status", "Execution Time"};
        list2d.add(Arrays.asList(headers));
    }

    @Override
    public void onExecutionFinish() {
        Object[][] array2d;
        array2d = list2d.stream().map(x -> x.toArray(new String[x.size()])).toArray(String[][]::new);
        ExcelUtil.generateReport(array2d);
    }


}

