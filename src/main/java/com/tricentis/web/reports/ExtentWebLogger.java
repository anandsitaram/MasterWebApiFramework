package com.tricentis.web.reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.tricentis.common.constants.FrameworkConstants;
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



}
