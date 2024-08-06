package com.tricentis.common.utils;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

public class LogUtil {

    private LogUtil() {

    }

    public static Logger log() {
        if(ConfigReader.isLoggingDisabled()) {
            Configurator.setRootLevel(Level.OFF);
        }
        return LogManager.getLogger(Thread.currentThread().getStackTrace()[2].getClassName());
    }

}
