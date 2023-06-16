package com.tricentis.web.pages;

import com.tricentis.common.exceptions.ValueNotFoundException;
import com.tricentis.web.enums.VEHICLETYPE;
import com.tricentis.web.utils.SeleniumHelper;
import org.openqa.selenium.By;

public class MenuPage extends BasePage {

    public MenuPage() {
        super();
    }

    private By motorCycleLnk = By.id("nav_motorcycle");

    private By truckLnk = By.id("nav_truck");

    private By camperLnk = By.id("nav_camper");

    private By autoMobileLnk = By.id("nav_automobile");

    public EnterVehicleDataPage selectVehicleType(String vehicleType) {
        SeleniumHelper.waitForPageLoad(this.getClass().getSimpleName());
        VEHICLETYPE type = VEHICLETYPE.valueOf(vehicleType.toUpperCase());
        //TODO IF LOOP
        switch(type){
            case AUTOMOBILE:   SeleniumHelper.jsClick(autoMobileLnk,type+ " link is clicked");
                break;
            case TRUCK:   SeleniumHelper.jsClick(truckLnk,type+ " link is clicked");
                break;
            case CAMPER:   SeleniumHelper.jsClick(camperLnk,type+ " link is clicked");
                break;
            case MOTORCYCLE:   SeleniumHelper.jsClick(motorCycleLnk,type+ "link is clicked");
                break;

            default: throw new ValueNotFoundException("Incorrect value passed in the argument");
        }

        return new EnterVehicleDataPage();

    }


}

