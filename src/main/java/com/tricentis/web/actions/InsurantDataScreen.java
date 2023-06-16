package com.tricentis.web.actions;

import com.tricentis.common.reports.ExtentLogger;
import com.tricentis.web.pages.EnterInsurantDataPage;

import java.util.Map;

public final class InsurantDataScreen {



    private EnterInsurantDataPage enterInsurantDataPage;

    public InsurantDataScreen(){

        enterInsurantDataPage= new EnterInsurantDataPage();

    }

    public EnterInsurantDataPage getEnterInsurantDataPage() {
        return enterInsurantDataPage;
    }
    public ProductDataScreen populateAllDetailsForMotorCycle(Map<String, Map<String, String>> data){

        enterInsurantDataPage.enterFirstName(data.get("insurantData").get("firstName"))
                .enterLastName(data.get("insurantData").get("lastName"))
                .enterDob(data.get("insurantData").get("dateOfBirth"))
                .checkGenderBtn(data.get("insurantData").get("gender"))
                .enterStreetAddrs(data.get("insurantData").get("streetAddress"))
                .selectCountry(data.get("insurantData").get("country"))
                .enterZipCode(data.get("insurantData").get("zipcode"))
                .enterCity(data.get("insurantData").get("city"))
                .selectOccp(data.get("insurantData").get("occupation"))
                .selectHobbies(data.get("insurantData").get("Hobbies"))
                .goToProductDataPage();
        ExtentLogger.info("All Fields are entered in Insurant Data Page");
        return new ProductDataScreen();





    }
}