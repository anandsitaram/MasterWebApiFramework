package com.tricentis.common.testdata;

import com.tricentis.common.constants.FrameworkConstants;
import com.tricentis.common.exceptions.FrameworkException;
import com.tricentis.common.exceptions.ValueNotFoundException;
import com.tricentis.common.utils.ConfigReader;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public final class JsonData {

    private JsonData() {

    }

    private static JSONParser jsonParser = new JSONParser();


    public static Map<String, Map<String, String>> readTestData(String keyValue) {

        try {
            Object obj = jsonParser.parse(new FileReader(FrameworkConstants.TESTDATA_PATH + File.separator + ConfigReader.getJsonDataFile() + ".json"));
            JSONObject jsonObject = (JSONObject) obj;
            if (!jsonObject.containsKey(keyValue)) {
                throw new ValueNotFoundException("Key not present in the test data file");
            }
            JSONObject testDataKey = (JSONObject) jsonObject.get(keyValue);
            Map<String, Map<String, String>> data = new HashMap<>();
            for (Object key : testDataKey.keySet()) {
                String keyStr = (String) key;
                JSONObject keyvalue = (JSONObject) testDataKey.get(keyStr);
                Map<String, String> temp = new HashMap<>();

                keyvalue.keySet().forEach(keyStr1 ->
                {
                    Object keyvalue1 = keyvalue.get(keyStr1);
                    temp.put(keyStr1.toString(), keyvalue1.toString());

                });
                data.put(keyStr, temp);

            }
            return data;
        } catch (IOException | ParseException e) {
            throw new FrameworkException("Error in reading the json file due to" + e.getMessage());
        }
    }

    public static Map<String, Map<String, String>> readTestData(String file, String keyValue) {


        try {
            Object obj = jsonParser.parse(new FileReader(FrameworkConstants.TESTDATA_PATH + file + ".json"));
            JSONObject jsonObject = (JSONObject) obj;
            JSONObject testDataKey = (JSONObject) jsonObject.get(keyValue);
            Map<String, Map<String, String>> data = new HashMap<>();
            for (Object key : testDataKey.keySet()) {
                String keyStr = (String) key;
                JSONObject keyvalue = (JSONObject) testDataKey.get(keyStr);
                Map<String, String> temp = new HashMap<>();

                keyvalue.keySet().forEach(keyStr1 ->
                {
                    Object keyvalue1 = keyvalue.get(keyStr1);
                    temp.put(keyStr1.toString(), keyvalue1.toString());

                });
                data.put(keyStr, temp);

            }
            return data;
        } catch (IOException | ParseException e) {
            throw new FrameworkException("Error in reading the json file due to " + e.getMessage());
        }


    }

    public static Map<String, Object> readMapTestData(String fileName, String keyValue) {

        try {
            Object obj = jsonParser.parse(new FileReader(FrameworkConstants.TESTDATA_PATH + File.separator + fileName + ".json"));
            JSONObject jsonObject = (JSONObject) obj;
            if (!jsonObject.containsKey(keyValue)) {
                throw new ValueNotFoundException("Key not present in the test data file");
            }
            JSONObject testDataKey = (JSONObject) jsonObject.get(keyValue);
            Map<String, Object> data = new HashMap<>();
            for (Object key : testDataKey.keySet()) {
                String keyStr = (String) key;
                Object value = testDataKey.get(keyStr);

                data.put(keyStr, value);

            }
            return data;
        } catch (IOException | ParseException e) {
            throw new FrameworkException("Error in reading the json file due to " + e.getMessage());
        }
    }


}