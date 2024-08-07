package com.tricentis.web.drivers;

import com.tricentis.common.exceptions.FrameworkException;
import com.tricentis.common.utils.ConfigReader;
import com.tricentis.web.constants.WebConstants;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.util.Objects;
/**
 * Manager for creating and managing the Chrome WebDriver instance.
 */
public class ChromeDriverManager extends DriverManager {

    protected ChromeDriverManager() {

    }
    @Override
    protected void createDriver() {
        setChromeDriverPath();
        ChromeOptions chromeOptions = new ChromeOptions();
        String options = ConfigReader.getBrowserOptions();
        if (Objects.nonNull(options)) {
            chromeOptions.addArguments(options);
        }
        driver = new ChromeDriver(chromeOptions);
        DriverThLocal.setDriver(driver);
    }

    /**
     * Sets the path for the ChromeDriver executable.
     *
     * @throws FrameworkException if the ChromeDriver executable is not found and Selenium version is outdated.
     */
    private void setChromeDriverPath() {
        File file = new File(WebConstants.CHROMEDRIVERPATH);
        if (file.exists()) {
            System.setProperty("webdriver.chrome.driver", WebConstants.CHROMEDRIVERPATH);
        } else if (!ConfigReader.isSeleniumNew()) {
            throw new FrameworkException("Place the required chromedriver.exe in path " + WebConstants.CHROMEDRIVERPATH
                    + " or upgrade Selenium to version 4.8.x.");
        }
    }
}