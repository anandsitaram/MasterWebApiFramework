package com.web;

import com.tricentis.common.testdata.JsonData;
import com.tricentis.common.testing.Validate;
import com.tricentis.web.actions.*;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.util.Map;

public class EndToEndTest extends BaseWebTest {

    @Test
    public void testMotorCycle() {
        Map<String, Map<String, String>> data = JsonData.readTestData("motorCycle");

        HomeScreen homeScreen = new HomeScreen();
        VehicleDataScreen vehicleDataScreen = homeScreen.navigateToVehicleScreen("motorcycle");
        Validate.assertThat("Verify whether Vehicle Data Screen is Displayed", vehicleDataScreen.getEnterVehicleDataPage().isVehicleDataPageDisplayed(), Matchers.equalTo(true));

        InsurantDataScreen insurantDataScreen = vehicleDataScreen.populateAllDetailsForMotorCycle(data);
        Validate.assertThat("Verify whether Insurant Data Screen is Displayed", insurantDataScreen.getEnterInsurantDataPage().isInsurantPageDisplayed(), Matchers.equalTo(true));

        ProductDataScreen productDataScreen = insurantDataScreen.populateAllDetailsForVehicle(data);
        Validate.assertThat("Verify whether Product Data Screen is Displayed", productDataScreen.getEnterProductDataPage().isProductDataPageDisplayed(), Matchers.equalTo(true));

        PriceOptionScreen priceOptionScreen = productDataScreen.populateAllDetailsForMotorCycle(data);
        Validate.assertThat("Verify whether Price Option Data Screen is Displayed", priceOptionScreen.getEnterPriceOptionPage().isPriceOptionPageDisplayed(), Matchers.equalTo(true));

        SendQuoteScreen sendQuoteScreen = priceOptionScreen.populateAllDetailsForVehicle(data.get("selectPrice").get("priceOption"));
        Validate.assertThat("Verify whether Send Quote Page Screen is Displayed", sendQuoteScreen.getSendQuotePage().isSendQuotePageDisplayed(), Matchers.equalTo(true));

        sendQuoteScreen.populateAllDetailsForVehicle(data);
        Validate.assertThat("Verify whether Confirm pop up is Displayed", sendQuoteScreen.getSendQuotePage().isConfirmMailPopUpDisplayed(), Matchers.equalTo(true));
        Validate.assertThat("Verify Success message", sendQuoteScreen.getSendQuotePage().getSuccessMsgTxt(), Matchers.equalTo("Sending e-mail success!"));

        sendQuoteScreen.getSendQuotePage().clickConfrimBtn();
    }


    @Test
    public void testTruck() {

        Map<String, Map<String, String>> data = JsonData.readTestData("truck");

        HomeScreen homeScreen = new HomeScreen();
        VehicleDataScreen vehicleDataScreen = homeScreen.navigateToVehicleScreen("truck");
        Validate.assertThat("Verify whether Vehicle Data Screen is Displayed", vehicleDataScreen.getEnterVehicleDataPage().isVehicleDataPageDisplayed(), Matchers.equalTo(true));

        InsurantDataScreen insurantDataScreen = vehicleDataScreen.populateAllDetailsForTruck(data);
        Validate.assertThat("Verify whether Insurant Data Screen is Displayed", insurantDataScreen.getEnterInsurantDataPage().isInsurantPageDisplayed(), Matchers.equalTo(true));

        ProductDataScreen productDataScreen = insurantDataScreen.populateAllDetailsForVehicle(data);
        Validate.assertThat("Verify whether Product Data Screen is Displayed", productDataScreen.getEnterProductDataPage().isProductDataPageDisplayed(), Matchers.equalTo(true));

        PriceOptionScreen priceOptionScreen = productDataScreen.populateAllDetailsForTruck(data);
        Validate.assertThat("Verify whether Price Option Data Screen is Displayed", priceOptionScreen.getEnterPriceOptionPage().isPriceOptionPageDisplayed(), Matchers.equalTo(true));

        SendQuoteScreen sendQuoteScreen = priceOptionScreen.populateAllDetailsForVehicle(data.get("selectPrice").get("priceOption"));
        Validate.assertThat("Verify whether Send Quote Page Screen is Displayed", sendQuoteScreen.getSendQuotePage().isSendQuotePageDisplayed(), Matchers.equalTo(true));

        sendQuoteScreen.populateAllDetailsForVehicle(data);
        Validate.assertThat("Verify whether Confirm pop up is Displayed", sendQuoteScreen.getSendQuotePage().isConfirmMailPopUpDisplayed(), Matchers.equalTo(true));
        Validate.assertThat("Verify Success message", sendQuoteScreen.getSendQuotePage().getSuccessMsgTxt(), Matchers.equalTo("Sending e-mail success!"));

        sendQuoteScreen.getSendQuotePage().clickConfrimBtn();

    }

    @Test
    public void testCamper() {

        Map<String, Map<String, String>> data = JsonData.readTestData("camper");

        HomeScreen homeScreen = new HomeScreen();
        VehicleDataScreen vehicleDataScreen = homeScreen.navigateToVehicleScreen("camper");
        Validate.assertThat("Verify whether Vehicle Data Screen is Displayed", vehicleDataScreen.getEnterVehicleDataPage().isVehicleDataPageDisplayed(), Matchers.equalTo(true));

        InsurantDataScreen insurantDataScreen = vehicleDataScreen.populateAllDetailsForCamper(data);
        Validate.assertThat("Verify whether Insurant Data Screen is Displayed", insurantDataScreen.getEnterInsurantDataPage().isInsurantPageDisplayed(), Matchers.equalTo(true));

        ProductDataScreen productDataScreen = insurantDataScreen.populateAllDetailsForVehicle(data);
        Validate.assertThat("Verify whether Product Data Screen is Displayed", productDataScreen.getEnterProductDataPage().isProductDataPageDisplayed(), Matchers.equalTo(true));

        PriceOptionScreen priceOptionScreen = productDataScreen.populateAllDetailsForCamper(data);
        Validate.assertThat("Verify whether Price Option Data Screen is Displayed", priceOptionScreen.getEnterPriceOptionPage().isPriceOptionPageDisplayed(), Matchers.equalTo(true));

        SendQuoteScreen sendQuoteScreen = priceOptionScreen.populateAllDetailsForVehicle(data.get("selectPrice").get("priceOption"));
        Validate.assertThat("Verify whether Send Quote Page Screen is Displayed", sendQuoteScreen.getSendQuotePage().isSendQuotePageDisplayed(), Matchers.equalTo(true));

        sendQuoteScreen.populateAllDetailsForVehicle(data);
        Validate.assertThat("Verify whether Confirm pop up is Displayed", sendQuoteScreen.getSendQuotePage().isConfirmMailPopUpDisplayed(), Matchers.equalTo(true));
        Validate.assertThat("Verify Success message", sendQuoteScreen.getSendQuotePage().getSuccessMsgTxt(), Matchers.equalTo("Sending e-mail success!"));

        sendQuoteScreen.getSendQuotePage().clickConfrimBtn();

    }

    @Test
    public void testAutomobile() {

        Map<String, Map<String, String>> data = JsonData.readTestData("automobile");

        HomeScreen homeScreen = new HomeScreen();
        VehicleDataScreen vehicleDataScreen = homeScreen.navigateToVehicleScreen("automobile");
        Validate.assertThat("Verify whether Vehicle Data Screen is Displayed", vehicleDataScreen.getEnterVehicleDataPage().isVehicleDataPageDisplayed(), Matchers.equalTo(true));

        InsurantDataScreen insurantDataScreen = vehicleDataScreen.populateAllDetailsForAutoMobile(data);
        Validate.assertThat("Verify whether Insurant Data Screen is Displayed", insurantDataScreen.getEnterInsurantDataPage().isInsurantPageDisplayed(), Matchers.equalTo(true));

        ProductDataScreen productDataScreen = insurantDataScreen.populateAllDetailsForVehicle(data);
        Validate.assertThat("Verify whether Product Data Screen is Displayed", productDataScreen.getEnterProductDataPage().isProductDataPageDisplayed(), Matchers.equalTo(true));

        PriceOptionScreen priceOptionScreen = productDataScreen.populateAllDetailsForAutoMobile(data);
        Validate.assertThat("Verify whether Price Option Data Screen is Displayed", priceOptionScreen.getEnterPriceOptionPage().isPriceOptionPageDisplayed(), Matchers.equalTo(true));

        SendQuoteScreen sendQuoteScreen = priceOptionScreen.populateAllDetailsForVehicle(data.get("selectPrice").get("priceOption"));
        Validate.assertThat("Verify whether Send Quote Page Screen is Displayed", sendQuoteScreen.getSendQuotePage().isSendQuotePageDisplayed(), Matchers.equalTo(true));

        sendQuoteScreen.populateAllDetailsForVehicle(data);
        Validate.assertThat("Verify whether Confirm pop up is Displayed", sendQuoteScreen.getSendQuotePage().isConfirmMailPopUpDisplayed(), Matchers.equalTo(true));
        Validate.assertThat("Verify Success message", sendQuoteScreen.getSendQuotePage().getSuccessMsgTxt(), Matchers.equalTo("Sending e-mail success!"));

        sendQuoteScreen.getSendQuotePage().clickConfrimBtn();


    }


}