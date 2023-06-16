package com.tricentis.web.actions;

import com.tricentis.common.reports.ExtentLogger;
import com.tricentis.web.pages.EnterProductDataPage;

import java.util.Map;

public class ProductDataScreen {
    private static EnterProductDataPage enterProductDataPage;
    public ProductDataScreen(){

        enterProductDataPage= new EnterProductDataPage();

    }
    public static EnterProductDataPage getEnterProductDataPage() {
        return enterProductDataPage;
    }
    public PriceOptionScreen populateAllDetailsForMotorCycle(Map<String, Map<String, String>> data ){

        enterProductDataPage.enterStartDate(data.get("productData").get("startDate"))
                .enterInsureSum(data.get("productData").get("insuranceSum"))
                .enterDamageSum(data.get("productData").get("damageInsurance"))
                .selectOptionalProducts(data.get("productData").get("OptionalProducts"))
                .goToPriceOptionPage();
        ExtentLogger.info("All Fields are entered in Product Data Page");
        return new PriceOptionScreen();


    }
}
