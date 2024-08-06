package com.tricentis.web.drivers;

import com.tricentis.common.utils.ConfigReader;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.util.Objects;

public class EdgeDriverManager extends DriverManager {

    protected EdgeDriverManager() {

    }

    protected void createDriver() {
        String options = ConfigReader.getBrowserOptions();
        if (Objects.nonNull(options)) {
            EdgeOptions edgeOptions = new EdgeOptions();
            edgeOptions.addArguments(options);
            driver = new EdgeDriver(edgeOptions);

        } else {
            driver = new EdgeDriver();

        }
        DriverThLocal.setDriver(driver);
    }


}
