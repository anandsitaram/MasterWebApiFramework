package com.tricentis.web.drivers;

import com.tricentis.web.enums.DRIVERTYPE;
import com.tricentis.web.exceptions.BrowserNotSpecifiedException;
import org.openqa.selenium.WebDriver;

/**
 * Factory class for creating and managing different types of WebDriver instances.
 */
public final class DriverFactory {

    private static DriverManager driverManager;

    private DriverFactory() {
        // Prevent instantiation
    }


    /**
     * Initializes the WebDriver instance based on the specified browser type.
     *
     * @param type the type of browser to initialize.
     * @throws IllegalStateException if the driver is already initialized.
     * @throws BrowserNotSpecifiedException if the browser type is not specified.
     * @throws UnsupportedOperationException if the remote driver is not implemented.
     */
    public static synchronized void initDriver(DRIVERTYPE type) {
        if (driverManager != null) {
            throw new IllegalStateException("Driver already initialized. Call quitDriver before initializing a new driver.");
        }

        switch (type) {
            case CHROME:
                driverManager = new ChromeDriverManager();
                break;
            case FIREFOX:
                driverManager = new FirefoxDriverManager();
                break;
            case EDGE:
                driverManager = new EdgeDriverManager();
                break;
            case REMOTE:
                // Implement RemoteDriverManager if needed
                throw new UnsupportedOperationException("Remote driver is not implemented yet.");
            default:
                throw new BrowserNotSpecifiedException("Browser type not specified.");
        }
        driverManager.createDriver();
    }

    /**
     * Quits the current WebDriver instance and resets the driver manager.
     */
    public static void quitDriver() {
        if (driverManager != null) {
            driverManager.quitDriver();
            driverManager = null;
        }
    }

    /**
     * Retrieves the current WebDriver instance.
     *
     * @return the current WebDriver instance.
     * @throws IllegalStateException if the driver is not initialized.
     */
    public static WebDriver getDriver() {
        if (driverManager == null) {
            throw new IllegalStateException("Driver is not initialized. Call initDriver first.");
        }
        return driverManager.getDriver();
    }
}