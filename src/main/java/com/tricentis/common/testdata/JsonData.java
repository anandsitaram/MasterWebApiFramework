package com.tricentis.common.testdata;

import com.tricentis.common.constants.FrameworkConstants;
import com.tricentis.common.exceptions.ValueNotFoundException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class JsonData {

    private static JsonData webJsonData;

    private static JsonData apiJsonData;
    private static String webTestData=FrameworkConstants.WEB_TESTDATA_FILE;

    private static String apiTestData= FrameworkConstants.API_TESTDATA_FILE;
    private JsonData(){

    }

    private static JsonData getWebFileInstance(String file){

        if(!file.equalsIgnoreCase(webTestData)){
            webJsonData=null;
            webTestData=file;
        }
        if(Objects.isNull(webJsonData)){
            webJsonData= new JsonData();
        }
        return webJsonData;

    }

    private static JsonData getApiFileInstance(String file){

        if(!file.equalsIgnoreCase(apiTestData)){
            apiJsonData=null;
            apiTestData=file;
        }
        if(Objects.isNull(apiJsonData)){
            apiJsonData= new JsonData();
        }
        return apiJsonData;

    }
    public static Map<String, Map<String, String>> readTestData(String keyValue){

        getWebFileInstance(FrameworkConstants.WEB_TESTDATA_FILE);
        System.out.println(webJsonData.hashCode());
        JSONParser jsonParser = new JSONParser();
        try {
            Object obj = jsonParser.parse(new FileReader(FrameworkConstants.WEB_TESTDATA_PATH));
            JSONObject jsonObject=(JSONObject)obj;
            if(!jsonObject.containsKey(keyValue)){
                throw new ValueNotFoundException("Key not present in the test data file");
            }
            JSONObject testDataKey = (JSONObject)jsonObject.get(keyValue);
            Map<String, Map<String,String>>data= new HashMap<>();
            for (Object key : testDataKey.keySet()) {
                String keyStr = (String)key;
                JSONObject keyvalue = (JSONObject) testDataKey.get(keyStr);
                Map<String,String> temp= new HashMap<>();

                keyvalue.keySet().forEach(keyStr1 ->
                {
                    Object keyvalue1 = keyvalue.get(keyStr1);
                    temp.put(keyStr1.toString(),keyvalue1.toString());

                });
                data.put(keyStr,temp);

            }
            return data;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }


    }

    public static Map<String, Map<String, String>> readTestData(String file,String keyValue){

        getWebFileInstance(file);
        System.out.println(webJsonData.hashCode());
        JSONParser jsonParser = new JSONParser();
        try {
            Object obj = jsonParser.parse(new FileReader(FrameworkConstants.TEST_RESOURCE_PATH+file+".json"));
            JSONObject jsonObject=(JSONObject)obj;
            JSONObject testDataKey = (JSONObject)jsonObject.get(keyValue);
            Map<String, Map<String,String>>data= new HashMap<>();
            for (Object key : testDataKey.keySet()) {
                String keyStr = (String)key;
                JSONObject keyvalue = (JSONObject) testDataKey.get(keyStr);
                Map<String,String> temp= new HashMap<>();

                keyvalue.keySet().forEach(keyStr1 ->
                {
                    Object keyvalue1 = keyvalue.get(keyStr1);
                    temp.put(keyStr1.toString(),keyvalue1.toString());

                });
                data.put(keyStr,temp);

            }
            return data;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }


    }

    public static Map<String, Object> readMapTestData(String keyValue) {
        getApiFileInstance(FrameworkConstants.API_TESTDATA_FILE);
        System.out.println(apiJsonData.hashCode());
        JSONParser jsonParser = new JSONParser();
        try {
            Object obj = jsonParser.parse(new FileReader(FrameworkConstants.API_TESTDATA_PATH));
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
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}