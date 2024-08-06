package com.tricentis.web.utils;

import com.tricentis.common.reports.ExtentLogger;
import com.tricentis.common.utils.ConfigReader;
import com.tricentis.common.utils.LogUtil;
import com.tricentis.web.drivers.DriverInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public final class SeleniumHelper {
    private SeleniumHelper() {

    }

    public static WebElement waitUntilIsVisible(By by) {
        WebDriverWait webDriverWait = new WebDriverWait(DriverInstance.getDriver(), Duration.ofSeconds(ConfigReader.getTimeOutValue()));
        return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static boolean isElementDisplayed(By by) {
        WebElement element = waitUntilIsVisible(by);
        return element.isDisplayed();

    }

    public static void waitUntilIsPresent(By by) {
        WebDriverWait webDriverWait = new WebDriverWait(DriverInstance.getDriver(), Duration.ofSeconds(ConfigReader.getTimeOutValue()));
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public static WebElement waitUntilIsClickable(By by) {
        WebDriverWait webDriverWait = new WebDriverWait(DriverInstance.getDriver(), Duration.ofSeconds(ConfigReader.getTimeOutValue()));
        return webDriverWait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public static void waitUntilIsInvisible(By by, String message) {
        WebDriverWait webDriverWait = new WebDriverWait(DriverInstance.getDriver(), Duration.ofSeconds(ConfigReader.getTimeOutValue()));
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(by));
        LogUtil.log().info(message);
        ExtentLogger.pass(message);

    }

    public static void sendKeys(By by, String text) {
        WebElement element = waitUntilIsVisible(by);
        element.sendKeys(text);
        ExtentLogger.pass(text + " is entered");
    }

    public static void sendKeys(By by, String text, String message) {
        WebElement element = waitUntilIsVisible(by);
        element.sendKeys(text);
        LogUtil.log().info(message);
        ExtentLogger.pass(message);


    }

    public static String getText(By by, String message) {
        WebElement element = waitUntilIsVisible(by);
        String txt = element.getText();
        LogUtil.log().info(message);
        ExtentLogger.pass(message);
        return txt;
    }

    public static void click(By by) {
        WebElement element = waitUntilIsClickable(by);
        element.click();
        ExtentLogger.pass(by.toString() + " is clicked");
    }

    public static void click(By by, String message) {
        WebElement element = waitUntilIsClickable(by);
        element.click();
        LogUtil.log().info(message);
        ExtentLogger.pass(message);
    }

    public static void jsClick(By by) {
        WebElement element = waitUntilIsClickable(by);
        ((JavascriptExecutor) DriverInstance.getDriver()).executeScript("arguments[0].click()", element);

    }

    public static void jsClick(By by, String message) {
        WebElement element = waitUntilIsClickable(by);
        ((JavascriptExecutor) DriverInstance.getDriver()).executeScript("arguments[0].click()", element);
        LogUtil.log().info(message);
        ExtentLogger.pass(message);

    }

    public static void waitForPageLoad(String className) {
        WebDriverWait webDriverWait = new WebDriverWait(DriverInstance.getDriver(), Duration.ofSeconds(ConfigReader.getTimeOutValue()));
        webDriverWait.until((ExpectedCondition<Boolean>) driver ->
                ((JavascriptExecutor) DriverInstance.getDriver()).executeScript("return document.readyState").equals("complete"));
        LogUtil.log().info(className+" is loaded successfully");
        ExtentLogger.pass(className + " is loaded successfully");

    }

    public static void selectVisibleTextFromDropdown(By by, String value) {
        WebElement element = waitUntilIsVisible(by);
        Select select = new Select(element);
        select.selectByVisibleText(value);
        ExtentLogger.pass(value + " is selected from dropdown");


    }

    public static void selectVisibleTextFromDropdown(By by, String value, String message) {
        WebElement element = waitUntilIsVisible(by);
        Select select = new Select(element);
        select.selectByVisibleText(value);
        LogUtil.log().info(message);
        ExtentLogger.pass(message);


    }


}
