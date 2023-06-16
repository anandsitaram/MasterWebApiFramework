package com.tricentis.common.utils;

import com.tricentis.common.constants.ConfigConstants;
import com.tricentis.common.exceptions.ValueNotFoundException;

public final class ConfigReader {

    private ConfigReader(){

    }


    private static Boolean getBooleanValue(String Key){
        try {
            return Boolean.valueOf(ConfigUtil.getValue(Key));
        }
        catch (ValueNotFoundException e){
            return false;
        }

    }
    public static Integer getTimeOutValue() {

        return Integer.valueOf(ConfigUtil.getValue("timeout"));

    }

   public static boolean isValidationFailedScreenshot(){

        return getBooleanValue(ConfigConstants.VALIDATIONFAILED_SCREENSHOT);

    }

    public static boolean isValidationPassedScreenshot(){
        return getBooleanValue(ConfigConstants.VALIDATIONPASSED_SCREENSHOT);

    }

    public static boolean isFailedStepLogger(){
        return getBooleanValue(ConfigConstants.FAILEDSTEP_LOGGER);

    }

    public static boolean isPassedStepLogger(){
        return getBooleanValue(ConfigConstants.PASSEDSTEP_LOGGER);

    }

    public static boolean isFailedStepScreenShot(){
        return getBooleanValue(ConfigConstants.FAILEDSTEP_SCREENSHOT);

    }

    public static boolean isPassedStepScreenShot(){
        return getBooleanValue(ConfigConstants.PASSEDSTEP_SCREENSHOT);

    }

    public static boolean isOverRideReport(){

        return getBooleanValue(ConfigConstants.OVERRIDE_REPORT);

    }

    public static String getBrowserValue(){

        return ConfigUtil.getValue(ConfigConstants.BROWSER);

    }

    public static String getApplicationUrl(){

        return ConfigUtil.getValue(ConfigConstants.APPLICATION_URL);

    }
    public static String getBaseUri(){

        return ConfigUtil.getValue(ConfigConstants.BASEURI);

    }

    /*public static String getValue(String key) {

        return ConfigUtils.getValue(key);

    }*/
}


