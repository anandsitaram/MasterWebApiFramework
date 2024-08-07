package com.tricentis.common.utils;

import com.tricentis.common.constants.FrameworkConstants;
import com.tricentis.common.exceptions.ValueNotFoundException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

/**
 * Utility class for reading configuration properties.
 */
public final class ConfigUtil {

    private ConfigUtil() {
        // Private constructor to prevent instantiation
    }

    private static final Properties properties = new Properties();
    private static final Map<String, String> CONFIGMAP = new HashMap<>();

    static {
        try (BufferedReader reader = new BufferedReader(new FileReader(FrameworkConstants.PROPERTY_PATH))) {
            properties.load(reader);
        } catch (IOException e) {
            System.err.println("Error loading properties file: " + e.getMessage());
            System.exit(0);
        }

        for (Map.Entry<Object, Object> entry : properties.entrySet()) {
            CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()));
        }
    }

    /**
     * Retrieves the value associated with the given key from the configuration.
     *
     * @param key the configuration key
     * @return the value associated with the key
     * @throws ValueNotFoundException if the key is not present in the configuration
     */
    static String getValue(String key) {
        if (Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key))) {
            throw new ValueNotFoundException("Key not present in properties file");
        }
        return CONFIGMAP.get(key);
    }
}


