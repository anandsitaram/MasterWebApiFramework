package com.tricentis.common.utils;

import com.csvreader.CsvReader;
import com.tricentis.common.constants.FrameworkConstants;
import com.tricentis.common.exceptions.FrameworkException;
import com.tricentis.common.exceptions.ValueNotFoundException;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Utility class for reading test data from CSV files.
 */
public final class CsvUtil {

    private static volatile CsvUtil csvUtil = null;
    private static final Map<String, Map<String, String>> testData = new ConcurrentHashMap<>();

    private CsvUtil() {
        // Private constructor to prevent instantiation
    }

    /**
     * Initializes the singleton instance and loads the CSV data.
     */
    private static void setInstance() {
        if (csvUtil == null) {
            synchronized (CsvUtil.class) {
                if (csvUtil == null) {
                    csvUtil = new CsvUtil();
                    loadCsvData();
                }
            }
        }
    }

    /**
     * Loads data from the specified CSV file into the testData map.
     */
    private static void loadCsvData() {
        CsvReader csvReader = null;
        try {
            csvReader = new CsvReader(FrameworkConstants.TESTDATA_PATH + File.separator + ConfigReader.getCsvDataFile() + ".csv");
            csvReader.readHeaders();
            while (csvReader.readRecord()) {
                String testCaseId = csvReader.get("TestCaseId").trim();
                Map<String, String> dictData = new ConcurrentHashMap<>();
                int columnCount = csvReader.getColumnCount() / 2;
                for (int i = 1; i <= columnCount; i++) {
                    String key = csvReader.get("Key" + i).trim();
                    String value = csvReader.get("Value" + i).trim();
                    dictData.put(key, value);
                }
                testData.put(testCaseId, dictData);
            }
        } catch (IOException e) {
            throw new FrameworkException("Problem in reading CSV file: " + e.getMessage());
        } finally {
            if (csvReader != null) {
                csvReader.close();
            }
        }
    }

    /**
     * Retrieves the value associated with the given testCaseId and key from the test data.
     *
     * @param testCaseId the test case identifier
     * @param key        the key for which the value is to be retrieved
     * @return the value associated with the given key in the specified test case
     * @throws ValueNotFoundException if the key or value is not present in the test data
     */
    public static String readData(String testCaseId, String key) {
        setInstance();
        Map<String, String> data = testData.get(testCaseId);
        if (data == null || !data.containsKey(key)) {
            throw new ValueNotFoundException("Key or value not present in test data file for testCaseId: " + testCaseId + " and key: " + key);
        }
        return data.get(key);
    }
}