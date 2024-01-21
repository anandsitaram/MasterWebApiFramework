package com.tricentis.common.utils;

import com.tricentis.common.constants.ConfigConstants;
import com.tricentis.common.exceptions.ValueNotFoundException;

public final class ConfigReader {

    private ConfigReader() {

    }


    private static Boolean getBooleanValue(String key) {
        try {
            return Boolean.valueOf(ConfigUtil.getValue(key));
        } catch (ValueNotFoundException e) {
            return false;
        }

    }

    public static Integer getTimeOutValue() {

        return Integer.valueOf(ConfigUtil.getValue(ConfigConstants.TIMEOUT));

    }

    public static boolean isValidationFailedScreenshot() {

        return getBooleanValue(ConfigConstants.VALIDATIONFAILED_SCREENSHOT);

    }

    public static boolean isValidationPassedScreenshot() {
        return getBooleanValue(ConfigConstants.VALIDATIONPASSED_SCREENSHOT);

    }

    public static boolean isFailedStepLogger() {
        return getBooleanValue(ConfigConstants.FAILEDSTEP_LOGGER);

    }

    public static boolean isPassedStepLogger() {
        return getBooleanValue(ConfigConstants.PASSEDSTEP_LOGGER);

    }

    public static boolean isFailedStepScreenShot() {
        return getBooleanValue(ConfigConstants.FAILEDSTEP_SCREENSHOT);

    }

    public static boolean isPassedStepScreenShot() {
        return getBooleanValue(ConfigConstants.PASSEDSTEP_SCREENSHOT);

    }

    public static boolean isOverRideReport() {

        return getBooleanValue(ConfigConstants.OVERRIDE_REPORT);

    }

    public static boolean isSeleniumNew() {

        return getBooleanValue(ConfigConstants.ISSELENIUMNEW);

    }

    public static String getBrowserOptions() {
        try {
            return ConfigUtil.getValue(ConfigConstants.BROWSEROPTIONS);
        } catch (ValueNotFoundException e) {
            return null;
        }

    }

    public static String getBrowserValue() {

        return ConfigUtil.getValue(ConfigConstants.BROWSER);

    }


    public static String getApplicationUrl() {

        return ConfigUtil.getValue(ConfigConstants.APPLICATION_URL);

    }

    public static String getBaseUri() {

        return ConfigUtil.getValue(ConfigConstants.BASEURI);

    }

    public static String getJsonDataFile() {
        return ConfigUtil.getValue(ConfigConstants.JSONDATAFILE);

    }

    public static String getCsvDataFile() {
        return ConfigUtil.getValue(ConfigConstants.CSVDATAFILE);

    }

    public static String getValue(String key) {

        return ConfigUtil.getValue(key);

    }
}


