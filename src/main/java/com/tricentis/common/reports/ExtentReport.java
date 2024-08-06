package com.tricentis.common.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.tricentis.common.constants.FrameworkConstants;
import com.tricentis.common.utils.ConfigReader;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public final class ExtentReport {

    private ExtentReport() {

    }

    private static ExtentReports extentReports;

    public static void setUpReport() {
        if (Objects.isNull(extentReports)) {
            extentReports = new ExtentReports();
            ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(getReportPath());
            extentReports.attachReporter(extentSparkReporter);
            File file = new File(FrameworkConstants.TEST_RESOURCE_PATH + "//extent-config.json");
            if (file.exists()) {
                try {
                   extentSparkReporter.loadJSONConfig(file);
                } catch (IOException e) {
                    throw new RuntimeException("Problem in setting up the extent report due to "+e.getMessage());
                }
            } else {

                extentSparkReporter.config().setTheme(Theme.DARK);
                extentSparkReporter.config().setDocumentTitle("Capstone Project - Assignment Report");
                extentSparkReporter.config().setReportName("Tricentis Vehicle Insurance Application");
            }


        }

    }

    public static void closeReport() {
        if (Objects.nonNull(extentReports)) {
            extentReports.flush();
            ExtentThLocal.unload();
        }
    }

    public static void createTestNode(String testName) {
        ExtentTest extentTest = extentReports.createTest(testName);
        ExtentThLocal.setExtentTest(extentTest);
    }

    private static String getReportPath() {
        try {
            if (ConfigReader.isOverRideReport()) {
                return FrameworkConstants.EXTENTREPORT_PATH + "Report.html";
            } else {
                return FrameworkConstants.EXTENTREPORT_PATH + "Report_" + System.currentTimeMillis() + ".html";
            }
        } catch (RuntimeException e) {
            return FrameworkConstants.EXTENTREPORT_PATH + "Report.html";

        }

    }

}
