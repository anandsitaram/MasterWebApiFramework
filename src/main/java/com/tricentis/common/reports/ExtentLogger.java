package com.tricentis.common.reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.tricentis.common.constants.FrameworkConstants;
import com.tricentis.common.utils.ConfigReader;
import com.tricentis.web.drivers.DriverInstance;
import io.restassured.http.Header;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.util.List;

public final class ExtentLogger {
    private ExtentLogger() {

    }


    public static void fail(String message) {

        if (ConfigReader.isFailedStepLogger()) {
            if (ConfigReader.isFailedStepScreenShot()) {
                ExtentThLocal.getExtentTest().fail(message, MediaEntityBuilder.createScreenCaptureFromPath(getBase64ScreenPath()).build());
            } else {
                ExtentThLocal.getExtentTest().fail(message);
            }
        }

    }

    public static void fail(String message, boolean screenshot) {
        if (screenshot) {
            ExtentThLocal.getExtentTest().fail(message, MediaEntityBuilder.createScreenCaptureFromPath(getBase64ScreenPath()).build());
        } else {
            ExtentThLocal.getExtentTest().fail(message);
        }


    }

    public static void pass(String message, boolean screenshot) {

        if (screenshot) {
            ExtentThLocal.getExtentTest().pass(message, MediaEntityBuilder.createScreenCaptureFromPath(getBase64ScreenPath()).build());
        } else {
            ExtentThLocal.getExtentTest().pass(message);
        }


    }

    public static void info(String message) {
        ExtentThLocal.getExtentTest().info(message);
    }

    public static void skip(String message) {
        ExtentThLocal.getExtentTest().skip(message);
    }

    public static void pass(String message) {
        if (ConfigReader.isPassedStepLogger()) {
            if (ConfigReader.isPassedStepScreenShot()) {
                ExtentThLocal.getExtentTest().pass(message, MediaEntityBuilder.createScreenCaptureFromPath(getBase64ScreenPath()).build());
            } else {
                ExtentThLocal.getExtentTest().pass(message);
            }

        }
    }

    private synchronized static String getBase64ScreenPath() {
        File src = ((TakesScreenshot) DriverInstance.getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            File dest = new File(FrameworkConstants.SCREENSHOT_PATH + System.currentTimeMillis() + ".png");

            FileUtils.copyFile(src, dest);
            return dest.getAbsolutePath();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getBase64ScreenShot() {
        return ((TakesScreenshot) DriverInstance.getDriver()).getScreenshotAs(OutputType.BASE64);
    }

    public static void logJson(String json) {
        ExtentThLocal.getExtentTest().info(MarkupHelper.createCodeBlock(json, CodeLanguage.JSON));

    }

    public static void logHeaders(List<Header> headersList) {

        String[][] arrayHeaders = headersList.stream().map(header -> new String[]{header.getName(), header.getValue()})
                .toArray(String[][]::new);
        ExtentThLocal.getExtentTest().info(MarkupHelper.createTable(arrayHeaders));


    }

    public static void logRequest(RequestSpecification requestSpecification) {

        QueryableRequestSpecification queryableRequestSpecification = SpecificationQuerier.query(requestSpecification);
        info("Endpoint is " + queryableRequestSpecification.getURI());
        info("Method is " + queryableRequestSpecification.getMethod());
        info("Headers are");
        logHeaders(queryableRequestSpecification.getHeaders().asList());
        System.out.println(!queryableRequestSpecification.getMethod().equals(Method.DELETE.name()));
        if(!queryableRequestSpecification.getMethod().equals(Method.GET.name())&&
                !queryableRequestSpecification.getMethod().equals(Method.DELETE.name())){
            info("Request body is ");
            logJson(queryableRequestSpecification.getBody());
        }
        else{
            info("No Request body as it is "+queryableRequestSpecification.getMethod()+" Request");
        }

    }

    public static void logResponse(Response response) {
        info("Response status is " + response.getStatusCode());
        info("Response Headers are ");
        logHeaders(response.getHeaders().asList());
        info("Response body is ");
        logJson(response.getBody().prettyPrint());
    }
}
