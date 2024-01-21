package com.tricentis.web.reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.tricentis.common.constants.FrameworkConstants;
import com.tricentis.common.exceptions.FrameworkException;
import com.tricentis.common.reports.ExtentLogger;
import com.tricentis.common.utils.ConfigReader;
import com.tricentis.web.drivers.DriverInstance;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public final class ExtentWebLogger extends ExtentLogger {
    private ExtentWebLogger() {
        super();

    }

    public static void fail(String message) {

        if (ConfigReader.isFailedStepLogger()) {
            if (ConfigReader.isFailedStepScreenShot()) {
                getExtentTest().fail(message, MediaEntityBuilder.createScreenCaptureFromPath(getBase64ScreenPath()).build());
            } else {
                getExtentTest().fail(message);
            }
        }

    }

    public static void fail(String message, boolean screenshot) {
        if (screenshot) {
            getExtentTest().fail(message, MediaEntityBuilder.createScreenCaptureFromPath(getBase64ScreenPath()).build());
        } else {
            getExtentTest().fail(message);
        }


    }

    public static void pass(String message) {
        if (ConfigReader.isPassedStepLogger()) {
            if (ConfigReader.isPassedStepScreenShot()) {
                getExtentTest().pass(message, MediaEntityBuilder.createScreenCaptureFromPath(getBase64ScreenPath()).build());
            } else {
                getExtentTest().pass(message);
            }

        }
    }


    public static void pass(String message, boolean screenshot) {

        if (screenshot) {
            getExtentTest().pass(message, MediaEntityBuilder.createScreenCaptureFromPath(getBase64ScreenPath()).build());
        } else {
            getExtentTest().pass(message);
        }


    }

    private static synchronized String getBase64ScreenPath() {
        File src = ((TakesScreenshot) DriverInstance.getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            File dest = new File(FrameworkConstants.SCREENSHOT_PATH + System.currentTimeMillis() + ".png");

            FileUtils.copyFile(src, dest);
            return dest.getAbsolutePath();
        } catch (IOException e) {
            throw new FrameworkException("Problem in taking screenshot due to "+e.getMessage());
        }
    }

    public static String getBase64ScreenShot() {
        return ((TakesScreenshot) DriverInstance.getDriver()).getScreenshotAs(OutputType.BASE64);
    }


}
