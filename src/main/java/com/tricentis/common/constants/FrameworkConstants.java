package com.tricentis.common.constants;

public interface FrameworkConstants {

    String TEST_RESOURCE_PATH=System.getProperty("user.dir")+"/src/test/resources";

    String PROPERTY_PATH=TEST_RESOURCE_PATH+"/config.properties";

    String EXTENTREPORT_PATH=System.getProperty("user.dir")+"/Reports/";

    String SCREENSHOT_PATH=System.getProperty("user.dir")+"/Screenshots/";

    String WEB_TESTDATA_FILE="web-test-data";

    String API_TESTDATA_FILE="api-test-data";
    String WEB_TESTDATA_PATH=TEST_RESOURCE_PATH+"/"+WEB_TESTDATA_FILE+".json";

    String API_TESTDATA_PATH=TEST_RESOURCE_PATH+"/"+API_TESTDATA_FILE+".json";


}
