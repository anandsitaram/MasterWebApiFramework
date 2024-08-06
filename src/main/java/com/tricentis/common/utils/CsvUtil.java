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

public final class CsvUtil {

    private static CsvUtil csvUtil = null;

    private static final Map<String, Map<String, String>> testData = new HashMap<>();

    private CsvUtil() {
    }

    private static void setInstance() {
        if (Objects.isNull(csvUtil)) {
            synchronized (CsvUtil.class) {
                if (Objects.isNull(csvUtil)) {
                    csvUtil = new CsvUtil();
                    try {
                        CsvReader csvReader = new CsvReader(FrameworkConstants.TESTDATA_PATH + File.separator + ConfigReader.getCsvDataFile() + ".csv");
                        csvReader.readHeaders();
                        while (csvReader.readRecord()) {
                            String employeeID = csvReader.get("TestCaseId").trim();
                            Map<String, String> dictData = new HashMap<>();
                            for (int i = 1; i < csvReader.getColumnCount() / 2 + 1; i++) {
                                String key = csvReader.get("Key" + i).trim();
                                String value = csvReader.get("Value" + i).trim();
                                dictData.put(key, value);


                            }
                            testData.put(employeeID, dictData);


                        }

                    } catch (IOException e) {
                        throw new FrameworkException("Problem in reading csv file "+e.getMessage());

                    }
                }
            }
        }
    }


    public static String readData(String testCaseId, String key) {
        setInstance();
        if (Objects.isNull(testData.get(testCaseId)) || Objects.isNull(testData.get(testCaseId).get(key))) {
            throw new ValueNotFoundException("Key or the Value not present in test data file");
        }
        return testData.get(testCaseId).get(key);

    }


}