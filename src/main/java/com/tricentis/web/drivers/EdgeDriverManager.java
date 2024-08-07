package com.tricentis.web.drivers;

import com.tricentis.common.utils.ConfigReader;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.util.Objects;
/**
 * Manager for creating and managing the Edge WebDriver instance.
 */
public class EdgeDriverManager extends DriverManager {


    protected EdgeDriverManager() {

    }

    @Override
    protected void createDriver() {
        EdgeOptions edgeOptions = new EdgeOptions();
        String options = ConfigReader.getBrowserOptions();
        if (Objects.nonNull(options)) {
            edgeOptions.addArguments(options);
        }
        driver = new EdgeDriver(edgeOptions);
        DriverThLocal.setDriver(driver);
    }


}
