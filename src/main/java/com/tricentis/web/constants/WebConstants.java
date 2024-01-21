package com.tricentis.web.constants;

import com.tricentis.common.constants.FrameworkConstants;

public final class WebConstants {
    private WebConstants() {

    }

    public static final String CHROMEDRIVERPATH = FrameworkConstants.TEST_RESOURCE_PATH + "/drivers/chromedriver.exe";
    public static final String GECKODRIVERPATH = System.getProperty("user.dir") + "/drivers/geckodriver.exe";

    public static final String EDGEDRIVERPATH = System.getProperty("user.dir") + "/drivers/edgedriver.exe";


}
