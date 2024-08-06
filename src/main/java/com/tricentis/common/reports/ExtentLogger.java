package com.tricentis.common.reports;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.tricentis.common.constants.FrameworkConstants;
import com.tricentis.common.utils.ConfigReader;
import com.tricentis.web.drivers.DriverInstance;
import io.restassured.http.Header;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ExtentLogger {
    protected ExtentLogger() {

    }

    protected static ExtentTest getExtentTest() {
        return ExtentThLocal.getExtentTest();
    }

    public static void info(String message) {

        getExtentTest().info(message);
    }

    public static void skip(String message) {
        getExtentTest().skip(message);
    }

    public static void pass(String message) {
        try {

        if (ConfigReader.isPassedStepLogger()) {
            if (ConfigReader.isPassedStepScreenShot()) {
                logPassAndTakeScreenshot(message);
            } else {
                logPass(message);
            }
        }
        }
        catch (Exception e){
            logPass(message);
        }
    }

    public static void passForValidations(String message) {
        try {
            if (ConfigReader.isPassedStepScreenShot()) {
                logPassAndTakeScreenshot(message);
            } else {
                logPass(message);
            }

        }
        catch (Exception e){
            logPass(message);
        }
        }

    public static void fail(String message) {

        try {
            if (ConfigReader.isFailedStepScreenShot()) {
                logFailAndTakeScreenshot(message);
            } else {
                logFail(message);
            }
        }
        catch (Exception e){
            logFail(message);
        }
    }
    private static void logFail(String message) {
        getExtentTest().fail(message);
    }



    private static void logPassAndTakeScreenshot(String message){
        getExtentTest().pass(message, MediaEntityBuilder.createScreenCaptureFromPath(getBase64ScreenPath()).build());
    }

    private static void logPass(String message) {
        getExtentTest().pass(message);
    }

    private static void logFailAndTakeScreenshot(String message){
        getExtentTest().fail(message, MediaEntityBuilder.createScreenCaptureFromPath(getBase64ScreenPath()).build());
    }
    public static void logJson(String json) {
        getExtentTest().info(MarkupHelper.createCodeBlock(json, CodeLanguage.JSON));

    }

    public static void logHeaders(List<Header> headersList) {

        String[][] arrayHeaders = headersList.stream().map(header -> new String[]{header.getName(), header.getValue()})
                .toArray(String[][]::new);
        getExtentTest().info(MarkupHelper.createTable(arrayHeaders));


    }


    protected static synchronized String getBase64ScreenPath() {
        try {
        File src = ((TakesScreenshot) DriverInstance.getDriver()).getScreenshotAs(OutputType.FILE);

            File dest = new File(FrameworkConstants.SCREENSHOT_PATH + System.currentTimeMillis() + ".png");

            FileUtils.copyFile(src, dest);
            return dest.getAbsolutePath();
        } catch (IOException e) {
            throw new RuntimeException("Problem in taking screenshot due to "+e.getMessage());
        }
    }

    protected static String getBase64ScreenShot() {
        return ((TakesScreenshot) DriverInstance.getDriver()).getScreenshotAs(OutputType.BASE64);
    }


    public static void failStatus(String message) {

        getExtentTest().log(Status.FAIL,MarkupHelper.createLabel(message, ExtentColor.RED));

    }
    public static void passStatus(String message) {

            getExtentTest().log(Status.PASS,MarkupHelper.createLabel(message, ExtentColor.GREEN));

    }

    public static void skipStatus(String message) {

        getExtentTest().log(Status.SKIP,MarkupHelper.createLabel(message, ExtentColor.ORANGE));

    }

}
