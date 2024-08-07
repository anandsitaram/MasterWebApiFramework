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
/**
 * Utility class providing methods for interacting with web elements in Selenium.
 */
public final class SeleniumHelper {

    // Private constructor to prevent instantiation
    private SeleniumHelper() {}

    /**
     * Waits for an element to be visible and returns it.
     *
     * @param by the locator of the element
     * @return the visible WebElement
     */
    public static WebElement waitUntilIsVisible(By by) {
        WebDriverWait wait = new WebDriverWait(DriverInstance.getDriver(), Duration.ofSeconds(ConfigReader.getTimeOutValue()));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    /**
     * Checks if an element is displayed on the page.
     *
     * @param by the locator of the element
     * @return true if the element is displayed, false otherwise
     */
    public static boolean isElementDisplayed(By by) {
        WebElement element = waitUntilIsVisible(by);
        return element.isDisplayed();
    }

    /**
     * Waits until an element is present in the DOM.
     *
     * @param by the locator of the element
     */
    public static void waitUntilIsPresent(By by) {
        WebDriverWait wait = new WebDriverWait(DriverInstance.getDriver(), Duration.ofSeconds(ConfigReader.getTimeOutValue()));
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    /**
     * Waits for an element to be clickable and returns it.
     *
     * @param by the locator of the element
     * @return the clickable WebElement
     */
    public static WebElement waitUntilIsClickable(By by) {
        WebDriverWait wait = new WebDriverWait(DriverInstance.getDriver(), Duration.ofSeconds(ConfigReader.getTimeOutValue()));
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    /**
     * Waits until an element becomes invisible and logs the provided message.
     *
     * @param by      the locator of the element
     * @param message the message to log
     */
    public static void waitUntilIsInvisible(By by, String message) {
        WebDriverWait wait = new WebDriverWait(DriverInstance.getDriver(), Duration.ofSeconds(ConfigReader.getTimeOutValue()));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
        LogUtil.log().info(message);
        ExtentLogger.pass(message);
    }

    /**
     * Sends keys to an element located by the provided locator.
     *
     * @param by   the locator of the element
     * @param text the text to send
     */
    public static void sendKeys(By by, String text) {
        WebElement element = waitUntilIsVisible(by);
        element.sendKeys(text);
        ExtentLogger.pass(text + " is entered");
    }

    /**
     * Sends keys to an element located by the provided locator and logs a custom message.
     *
     * @param by      the locator of the element
     * @param text    the text to send
     * @param message the message to log
     */
    public static void sendKeys(By by, String text, String message) {
        WebElement element = waitUntilIsVisible(by);
        element.sendKeys(text);
        LogUtil.log().info(message);
        ExtentLogger.pass(message);
    }

    /**
     * Gets the text of an element located by the provided locator and logs a custom message.
     *
     * @param by      the locator of the element
     * @param message the message to log
     * @return the text of the element
     */
    public static String getText(By by, String message) {
        WebElement element = waitUntilIsVisible(by);
        String text = element.getText();
        LogUtil.log().info(message);
        ExtentLogger.pass(message);
        return text;
    }

    /**
     * Clicks an element located by the provided locator.
     *
     * @param by the locator of the element
     */
    public static void click(By by) {
        WebElement element = waitUntilIsClickable(by);
        element.click();
        ExtentLogger.pass(by.toString() + " is clicked");
    }

    /**
     * Clicks an element located by the provided locator and logs a custom message.
     *
     * @param by      the locator of the element
     * @param message the message to log
     */
    public static void click(By by, String message) {
        WebElement element = waitUntilIsClickable(by);
        element.click();
        LogUtil.log().info(message);
        ExtentLogger.pass(message);
    }

    /**
     * Performs a JavaScript click on an element located by the provided locator.
     *
     * @param by the locator of the element
     */
    public static void jsClick(By by) {
        WebElement element = waitUntilIsClickable(by);
        ((JavascriptExecutor) DriverInstance.getDriver()).executeScript("arguments[0].click()", element);
    }

    /**
     * Performs a JavaScript click on an element located by the provided locator and logs a custom message.
     *
     * @param by      the locator of the element
     * @param message the message to log
     */
    public static void jsClick(By by, String message) {
        WebElement element = waitUntilIsClickable(by);
        ((JavascriptExecutor) DriverInstance.getDriver()).executeScript("arguments[0].click()", element);
        LogUtil.log().info(message);
        ExtentLogger.pass(message);
    }

    /**
     * Waits for the page to fully load by checking the document ready state.
     *
     * @param className the class name to log upon successful page load
     */
    public static void waitForPageLoad(String className) {
        WebDriverWait wait = new WebDriverWait(DriverInstance.getDriver(), Duration.ofSeconds(ConfigReader.getTimeOutValue()));
        wait.until((ExpectedCondition<Boolean>) driver ->
                ((JavascriptExecutor) DriverInstance.getDriver()).executeScript("return document.readyState").equals("complete"));
        LogUtil.log().info(className + " is loaded successfully");
        ExtentLogger.pass(className + " is loaded successfully");
    }

    /**
     * Selects an option by visible text from a dropdown located by the provided locator.
     *
     * @param by    the locator of the dropdown element
     * @param value the visible text of the option to select
     */
    public static void selectVisibleTextFromDropdown(By by, String value) {
        WebElement element = waitUntilIsVisible(by);
        Select select = new Select(element);
        select.selectByVisibleText(value);
        ExtentLogger.pass(value + " is selected from dropdown");
    }

    /**
     * Selects an option by visible text from a dropdown located by the provided locator and logs a custom message.
     *
     * @param by      the locator of the dropdown element
     * @param value   the visible text of the option to select
     * @param message the message to log
     */
    public static void selectVisibleTextFromDropdown(By by, String value, String message) {
        WebElement element = waitUntilIsVisible(by);
        Select select = new Select(element);
        select.selectByVisibleText(value);
        LogUtil.log().info(message);
        ExtentLogger.pass(message);
    }


}
