package com.tricentis.common.utils;

import com.tricentis.common.constants.FrameworkConstants;
import com.tricentis.common.exceptions.ValueNotFoundException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

public final class ConfigUtil {

    private ConfigUtil(){

    }

    private static Properties properties = new Properties();
    private static Map<String, String> CONFIGMAP = new HashMap<>();

    static {
        boolean envFlag = false;
        String envValue = "";
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(FrameworkConstants.PROPERTY_PATH));
            properties.load(reader);
            reader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        for (Map.Entry<Object, Object> entry : properties.entrySet()) {
            if (String.valueOf(entry.getKey()).contains("env_resources")) {
                envFlag = true;
                envValue = String.valueOf(entry.getValue());
            }


            CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()));

        }
        if (envFlag) {
            try {
                reader = new BufferedReader(new FileReader(FrameworkConstants.PROPERTY_PATH));
                properties.load(reader);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            for (Map.Entry<Object, Object> entry : properties.entrySet()) {
                CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()));

            }
        }



    }

     static String getValue(String key) {

        if (Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key))) {
            throw new ValueNotFoundException("Key not present in properties file");
        }
        return CONFIGMAP.get(key);

    }

}


