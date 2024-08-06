package com.tricentis.web.actions;

import com.tricentis.common.reports.ExtentLogger;
import com.tricentis.common.utils.DateUtils;
import com.tricentis.web.constants.TestData;
import com.tricentis.web.pages.EnterProductDataPage;

import java.util.Map;

public class ProductDataScreen {
    EnterProductDataPage enterProductDataPage;

    public ProductDataScreen() {

        enterProductDataPage = new EnterProductDataPage();

    }

    public EnterProductDataPage getEnterProductDataPage() {
        return enterProductDataPage;
    }

    public PriceOptionScreen populateAllDetailsForMotorCycle(Map<String, Map<String, String>> data) {

          //Start date update to currentDate+1 month
        //enterProductDataPage.enterStartDate(data.get(TestData.PRODUCT_DATA).get("startDate"))
        enterProductDataPage.enterStartDate(DateUtils.getCurrentDatePlusOneMonth())
                .enterInsureSum(data.get(TestData.PRODUCT_DATA).get("insuranceSum"))
                .enterDamageSum(data.get(TestData.PRODUCT_DATA).get("damageInsurance"))
                .selectOptionalProducts(data.get(TestData.PRODUCT_DATA).get("OptionalProducts"))
                .goToPriceOptionPage();
        ExtentLogger.passStatus("All Fields are entered in Product Data Page");
        return new PriceOptionScreen();


    }

    public PriceOptionScreen populateAllDetailsForTruck(Map<String, Map<String, String>> data) {

        //Start date update to currentDate+1 month
        //enterProductDataPage.enterStartDate(data.get(TestData.PRODUCT_DATA).get("startDate"))
        enterProductDataPage.enterStartDate(DateUtils.getCurrentDatePlusOneMonth())
                .enterInsureSum(data.get(TestData.PRODUCT_DATA).get("insuranceSum"))
                .enterDamageSum(data.get(TestData.PRODUCT_DATA).get("damageInsurance"))
                .selectOptionalProducts(data.get(TestData.PRODUCT_DATA).get("OptionalProducts"))
                .goToPriceOptionPage();
        ExtentLogger.info("All Fields are entered in Product Data Page");
        return new PriceOptionScreen();


    }

    public PriceOptionScreen populateAllDetailsForCamper(Map<String, Map<String, String>> data) {

        //Start date update to currentDate+1 month
        //enterProductDataPage.enterStartDate(data.get(TestData.PRODUCT_DATA).get("startDate"))
        enterProductDataPage.enterStartDate(DateUtils.getCurrentDatePlusOneMonth())
                .enterInsureSum(data.get(TestData.PRODUCT_DATA).get("insuranceSum"))
                .enterDamageSum(data.get(TestData.PRODUCT_DATA).get("damageInsurance"))
                .selectOptionalProducts(data.get(TestData.PRODUCT_DATA).get("OptionalProducts"))
                .goToPriceOptionPage();
        ExtentLogger.info("All Fields are entered in Product Data Page");
        return new PriceOptionScreen();


    }

    public PriceOptionScreen populateAllDetailsForAutoMobile(Map<String, Map<String, String>> data) {

        //Start date update to currentDate+1 month
        //enterProductDataPage.enterStartDate(data.get(TestData.PRODUCT_DATA).get("startDate"))
        enterProductDataPage.enterStartDate(DateUtils.getCurrentDatePlusOneMonth())
                .enterInsureSum(data.get(TestData.PRODUCT_DATA).get("insuranceSum"))
                .enterDamageSum(data.get(TestData.PRODUCT_DATA).get("damageInsurance"))
                .enterMeritRating(data.get(TestData.PRODUCT_DATA).get("meritRating"))
                .selectOptionalProducts(data.get(TestData.PRODUCT_DATA).get("OptionalProducts"))
                .enterCourtesyCar(data.get(TestData.PRODUCT_DATA).get("courtesyCar"))
                .goToPriceOptionPage();
        ExtentLogger.info("All Fields are entered in Product Data Page");
        return new PriceOptionScreen();


    }
}
