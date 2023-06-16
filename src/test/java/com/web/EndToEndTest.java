package com.web;

import com.tricentis.common.testdata.JsonData;
import com.tricentis.web.pages.HomePage;
import org.testng.annotations.Test;

import java.util.Map;

public class EndToEndTest extends BaseWebTest {

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


    @Test
    public void testTruck() {


        Map<String, Map<String, String>> data = JsonData.readTestData("truck");
        HomePage homePage = new HomePage();
        homePage.goToMenu()
                .selectVehicleType("truck")
                .selectMake(data.get("vehicleData").get("make"))
                .enterEngPerformance(data.get("vehicleData").get("engPerformance"))
                .enterDateManfacture(data.get("vehicleData").get("dateOfManfct"))
                .enterNoSeats(data.get("vehicleData").get("noOfSeats"))
                .enterFuelType(data.get("vehicleData").get("fuelType"))
                .enterPayload(data.get("vehicleData").get("payLoad"))
                .enterWeight(data.get("vehicleData").get("totalWeight"))
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

    @Test
    public void testCamper() {

        Map<String, Map<String, String>> data = JsonData.readTestData("camper");
        HomePage homePage = new HomePage();
        homePage.goToMenu()
                .selectVehicleType("camper")
                .selectMake(data.get("vehicleData").get("make"))
                .enterEngPerformance(data.get("vehicleData").get("engPerformance"))
                .enterDateManfacture(data.get("vehicleData").get("dateOfManfct"))
                .enterNoSeats(data.get("vehicleData").get("noOfSeats"))
                .checkRightHandDrive(data.get("vehicleData").get("righthand"))
                .enterFuelType(data.get("vehicleData").get("fuelType"))
                .enterPayload(data.get("vehicleData").get("payLoad"))
                .enterWeight(data.get("vehicleData").get("totalWeight"))
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

    @Test
    public void testAutomobile() {

        Map<String, Map<String, String>> data = JsonData.readTestData("automobile");
        HomePage homePage = new HomePage();
        homePage.goToMenu()
                .selectVehicleType("automobile")
                .selectMake(data.get("vehicleData").get("make"))
                .enterEngPerformance(data.get("vehicleData").get("engPerformance"))
                .enterDateManfacture(data.get("vehicleData").get("dateOfManfct"))
                .enterNoSeats(data.get("vehicleData").get("noOfSeats"))
                .enterFuelType(data.get("vehicleData").get("fuelType"))
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
                .enterMeritRating(data.get("productData").get("meritRating"))
                .selectOptionalProducts(data.get("productData").get("OptionalProducts"))
                .enterCourtesyCar(data.get("productData").get("courtesyCar"))
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


}