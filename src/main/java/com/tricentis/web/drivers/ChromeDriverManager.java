package com.tricentis.web.drivers;

import com.tricentis.common.exceptions.FrameworkException;
import com.tricentis.common.utils.ConfigReader;
import com.tricentis.web.constants.WebConstants;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.util.Objects;

public class ChromeDriverManager extends DriverManager {

    protected ChromeDriverManager() {

    }

    protected void createDriver() {
        setChromeDriverPath();
        String options = ConfigReader.getBrowserOptions();
        if (Objects.nonNull(options)) {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments(options);
            driver = new ChromeDriver(chromeOptions);

        } else {
            driver = new ChromeDriver();

        }

        DriverThLocal.setDriver(driver);
    }

    private void setChromeDriverPath() {
        File file = new File(WebConstants.CHROMEDRIVERPATH);
        if (file.exists()) {
            System.setProperty("webdriver.chrome.driver", WebConstants.CHROMEDRIVERPATH);

        } else if (!ConfigReader.isSeleniumNew()) {
            throw new FrameworkException("Place required chromedriver.exe in this path " + WebConstants.CHROMEDRIVERPATH
                    + " or Upgrade the selenium versions to 4.8.x");
        }

    }
}
