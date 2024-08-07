package com.tricentis.common.utils;

import com.tricentis.common.constants.ConfigConstants;
import com.tricentis.common.exceptions.ValueNotFoundException;

/**
 * Utility class for reading configuration values.
 */
public final class ConfigReader {

    // Private constructor to prevent instantiation
    private ConfigReader() {}

    /**
     * Retrieves a boolean value from the configuration.
     *
     * @param key the configuration key
     * @return the boolean value, or false if the key is not found
     */
    private static Boolean getBooleanValue(String key) {
        try {
            return Boolean.valueOf(ConfigUtil.getValue(key));
        } catch (ValueNotFoundException e) {
            return false;
        }
    }

    /**
     * Retrieves the timeout value from the configuration.
     *
     * @return the timeout value as an Integer
     */
    public static Integer getTimeOutValue() {
        return Integer.valueOf(ConfigUtil.getValue(ConfigConstants.TIMEOUT));
    }

    /**
     * Checks if a screenshot should be taken on validation failure.
     *
     * @return true if a screenshot should be taken, false otherwise
     */
    public static boolean isValidationFailedScreenshot() {
        return getBooleanValue(ConfigConstants.VALIDATIONFAILED_SCREENSHOT);
    }

    /**
     * Checks if a screenshot should be taken on validation success.
     *
     * @return true if a screenshot should be taken, false otherwise
     */
    public static boolean isValidationPassedScreenshot() {
        return getBooleanValue(ConfigConstants.VALIDATIONPASSED_SCREENSHOT);
    }

    /**
     * Checks if logging should occur on failed steps.
     *
     * @return true if logging should occur, false otherwise
     */
    public static boolean isFailedStepLogger() {
        return getBooleanValue(ConfigConstants.FAILEDSTEP_LOGGER);
    }

    /**
     * Checks if logging should occur on passed steps.
     *
     * @return true if logging should occur, false otherwise
     */
    public static boolean isPassedStepLogger() {
        return getBooleanValue(ConfigConstants.PASSEDSTEP_LOGGER);
    }

    /**
     * Checks if a screenshot should be taken on failed steps.
     *
     * @return true if a screenshot should be taken, false otherwise
     */
    public static boolean isFailedStepScreenShot() {
        return getBooleanValue(ConfigConstants.FAILEDSTEP_SCREENSHOT);
    }

    /**
     * Checks if a screenshot should be taken on passed steps.
     *
     * @return true if a screenshot should be taken, false otherwise
     */
    public static boolean isPassedStepScreenShot() {
        return getBooleanValue(ConfigConstants.PASSEDSTEP_SCREENSHOT);
    }

    /**
     * Checks if reports should be overridden.
     *
     * @return true if reports should be overridden, false otherwise
     */
    public static boolean isOverRideReport() {
        return getBooleanValue(ConfigConstants.OVERRIDE_REPORT);
    }

    /**
     * Checks if the new version of Selenium is used.
     *
     * @return true if the new version is used, false otherwise
     */
    public static boolean isSeleniumNew() {
        return getBooleanValue(ConfigConstants.ISSELENIUMNEW);
    }

    /**
     * Checks if logging is disabled.
     *
     * @return true if logging is disabled, false otherwise
     */
    public static boolean isLoggingDisabled() {
        return getBooleanValue(ConfigConstants.DISABLE_LOGGING);
    }

    /**
     * Retrieves browser options from the configuration.
     *
     * @return the browser options, or null if the key is not found
     */
    public static String getBrowserOptions() {
        try {
            return ConfigUtil.getValue(ConfigConstants.BROWSEROPTIONS);
        } catch (ValueNotFoundException e) {
            return null;
        }
    }

    /**
     * Retrieves the browser value from the configuration.
     *
     * @return the browser value
     */
    public static String getBrowserValue() {
        return ConfigUtil.getValue(ConfigConstants.BROWSER);
    }

    /**
     * Retrieves the application URL from the configuration.
     *
     * @return the application URL
     */
    public static String getApplicationUrl() {
        return ConfigUtil.getValue(ConfigConstants.APPLICATION_URL);
    }

    /**
     * Retrieves the base URI from the configuration.
     *
     * @return the base URI
     */
    public static String getBaseUri() {
        return ConfigUtil.getValue(ConfigConstants.BASEURI);
    }

    /**
     * Retrieves the JSON data file path from the configuration.
     *
     * @return the JSON data file path
     */
    public static String getJsonDataFile() {
        return ConfigUtil.getValue(ConfigConstants.JSONDATAFILE);
    }

    /**
     * Retrieves the CSV data file path from the configuration.
     *
     * @return the CSV data file path
     */
    public static String getCsvDataFile() {
        return ConfigUtil.getValue(ConfigConstants.CSVDATAFILE);
    }

    /**
     * Retrieves a value from the configuration based on the provided key.
     *
     * @param key the configuration key
     * @return the value associated with the key
     */
    public static String getValue(String key) {
        return ConfigUtil.getValue(key);
    }
}


