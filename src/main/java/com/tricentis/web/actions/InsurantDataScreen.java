package com.tricentis.web.actions;

import com.tricentis.common.reports.ExtentLogger;
import com.tricentis.web.constants.TestData;
import com.tricentis.web.pages.EnterInsurantDataPage;

import java.util.Map;

public final class InsurantDataScreen {


    private EnterInsurantDataPage enterInsurantDataPage;

    public InsurantDataScreen() {

        enterInsurantDataPage = new EnterInsurantDataPage();

    }

    public EnterInsurantDataPage getEnterInsurantDataPage() {
        return enterInsurantDataPage;
    }

    public ProductDataScreen populateAllDetailsForVehicle(Map<String, Map<String, String>> data) {

        enterInsurantDataPage.enterFirstName(data.get(TestData.INSURANT_DATA).get("firstName"))
                .enterLastName(data.get(TestData.INSURANT_DATA).get("lastName"))
                .enterDob(data.get(TestData.INSURANT_DATA).get("dateOfBirth"))
                .checkGenderBtn(data.get(TestData.INSURANT_DATA).get("gender"))
                .enterStreetAddrs(data.get(TestData.INSURANT_DATA).get("streetAddress"))
                .selectCountry(data.get(TestData.INSURANT_DATA).get("country"))
                .enterZipCode(data.get(TestData.INSURANT_DATA).get("zipcode"))
                .enterCity(data.get(TestData.INSURANT_DATA).get("city"))
                .selectOccp(data.get(TestData.INSURANT_DATA).get("occupation"))
                .selectHobbies(data.get(TestData.INSURANT_DATA).get("Hobbies"))
                .goToProductDataPage();
        ExtentLogger.info("All Fields are entered in Insurant Data Page");
        return new ProductDataScreen();


    }

}