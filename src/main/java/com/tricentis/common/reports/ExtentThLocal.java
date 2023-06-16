package com.tricentis.common.reports;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentThLocal {

    private ExtentThLocal(){

    }

    private static ThreadLocal<ExtentTest> extentTestThreadLocal= new ThreadLocal<>();

    static ExtentTest getExtentTest(){
        return extentTestThreadLocal.get();
    }

    static void setExtentTest(ExtentTest extentTest){
        extentTestThreadLocal.set(extentTest);
    }

    public static void unload() {
        extentTestThreadLocal.remove();
    }
}
