package com.tricentis.common.reports;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import io.restassured.http.Header;

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

        getExtentTest().pass(message);
    }

    public static void fail(String message) {
        getExtentTest().fail(message);
    }
    public static void logJson(String json) {
        getExtentTest().info(MarkupHelper.createCodeBlock(json, CodeLanguage.JSON));

    }

    public static void logHeaders(List<Header> headersList) {

        String[][] arrayHeaders = headersList.stream().map(header -> new String[]{header.getName(), header.getValue()})
                .toArray(String[][]::new);
        getExtentTest().info(MarkupHelper.createTable(arrayHeaders));


    }


}
