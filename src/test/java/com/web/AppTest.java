package com.web;

import com.tricentis.common.testdata.JsonData;
import com.tricentis.common.testing.Validate;
import com.tricentis.web.actions.*;
import com.tricentis.web.pages.HomePage;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.util.Map;

public class AppTest extends BaseWebTest {

    // Test Using Builder Pattern
    @Test
    public void testMotorCycle() {
        Map<String, Map<String, String>> data = JsonData.readTestData("motorCycle");
        HomePage homePage = new HomePage();
        homePage.goToMenu()
                .selectVehicleType("motorcycle")
                .selectMake(data.get("vehicleData").get("make"))
                .selectModel(data.get("vehicleData").get("model"))
                .enterCylindercapcity(data.get("vehicleData").get("cylinderCap"))
                .enterEngPerformance(data.get("vehicleData").get("engPerformance"))
                .enterDateManfacture(data.get("vehicleData").get("dateOfManfct"))
                .enterNoSeatsMotorCycle(data.get("vehicleData").get("noOfSeats"))
                .enterListPrice(data.get("vehicleData").get("lstPrice"))
                .enterAnnualMilage(data.get("vehicleData").get("annMilage"))
                .goToInsurancePage()
                .enterFirstName(data.get("insurantData").get("firstName"))
                .enterLastName(data.get("insurantData").get("lastName"))
                .enterDob(data.get("insurantData").get("dateOfBirth"))
                .checkGenderBtn(data.get("insurantData").get("gender"))
                .enterStreetAddrs(data.get("insurantData").get("streetAddress"))
                .selectCountry(data.get("insurantData").get("country"))
                .enterZipCode(data.get("insurantData").get("zipcode"))
                .enterCity(data.get("insurantData").get("city"))
                .selectOccp(data.get("insurantData").get("occupation"))
                .selectHobbies(data.get("insurantData").get("Hobbies"))
                .goToProductDataPage()
                .enterStartDate(data.get("productData").get("startDate"))
                .enterInsureSum(data.get("productData").get("insuranceSum"))
                .enterDamageSum(data.get("productData").get("damageInsurance"))
                .selectOptionalProducts(data.get("productData").get("OptionalProducts"))
                .goToPriceOptionPage()
                .selectPriceOption(data.get("selectPrice").get("priceOption"))
                .goToSendQuotePage()
                .enterEmail(data.get("sendQuote").get("email"))
                .enterPhoneNo(data.get("sendQuote").get("phone"))
                .enterUserName(data.get("sendQuote").get("userName"))
                .enterPassowrd(data.get("sendQuote").get("password"))
                .enterConfirmPassowrd(data.get("sendQuote").get("password"))
                .clickMailBtn()
                .waitForSpinnerToDisappear()
                .clickConfrimBtn();

    }

    // Test Using Individual Components
    @Test
    public void testMotorCycleUpdated() {
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


}