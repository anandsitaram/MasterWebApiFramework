package com.tricentis.web.actions;

import com.tricentis.common.reports.ExtentLogger;
import com.tricentis.web.constants.TestData;
import com.tricentis.web.pages.EnterVehicleDataPage;

import java.util.Map;

public class VehicleDataScreen {
    private EnterVehicleDataPage enterVehicleDataPage;

    public VehicleDataScreen() {
        enterVehicleDataPage = new EnterVehicleDataPage();
    }

    public EnterVehicleDataPage getEnterVehicleDataPage() {
        return enterVehicleDataPage;
    }

    public InsurantDataScreen populateAllDetailsForMotorCycle(Map<String, Map<String, String>> data) {
        enterVehicleDataPage.selectMake(data.get(TestData.VEHICLE_DATA).get("make"))
                .selectModel(data.get(TestData.VEHICLE_DATA).get("model"))
                .enterCylindercapcity(data.get(TestData.VEHICLE_DATA).get("cylinderCap"))
                .enterEngPerformance(data.get(TestData.VEHICLE_DATA).get("engPerformance"))
                .enterDateManfacture(data.get(TestData.VEHICLE_DATA).get("dateOfManfct"))
                .enterNoSeatsMotorCycle(data.get(TestData.VEHICLE_DATA).get("noOfSeats"))
                .enterListPrice(data.get(TestData.VEHICLE_DATA).get("lstPrice"))
                .enterAnnualMilage(data.get(TestData.VEHICLE_DATA).get("annMilage"))
                .goToInsurancePage();
        ExtentLogger.passStatus("All Fields are entered in Vehicle Data Page");
        return new InsurantDataScreen();

    }

    public InsurantDataScreen populateAllDetailsForTruck(Map<String, Map<String, String>> data) {
        enterVehicleDataPage.selectMake(data.get(TestData.VEHICLE_DATA).get("make"))
                .enterEngPerformance(data.get(TestData.VEHICLE_DATA).get("engPerformance"))
                .enterDateManfacture(data.get(TestData.VEHICLE_DATA).get("dateOfManfct"))
                .enterNoSeats(data.get(TestData.VEHICLE_DATA).get("noOfSeats"))
                .enterFuelType(data.get(TestData.VEHICLE_DATA).get("fuelType"))
                .enterPayload(data.get(TestData.VEHICLE_DATA).get("payLoad"))
                .enterWeight(data.get(TestData.VEHICLE_DATA).get("totalWeight"))
                .enterListPrice(data.get(TestData.VEHICLE_DATA).get("lstPrice"))
                .enterAnnualMilage(data.get(TestData.VEHICLE_DATA).get("annMilage"))
                .goToInsurancePage();
        ExtentLogger.passStatus("All Fields are entered in Vehicle Data Page");
        return new InsurantDataScreen();

    }

    public InsurantDataScreen populateAllDetailsForCamper(Map<String, Map<String, String>> data) {
        enterVehicleDataPage.selectMake(data.get(TestData.VEHICLE_DATA).get("make"))
                .enterEngPerformance(data.get(TestData.VEHICLE_DATA).get("engPerformance"))
                .enterDateManfacture(data.get(TestData.VEHICLE_DATA).get("dateOfManfct"))
                .enterNoSeats(data.get(TestData.VEHICLE_DATA).get("noOfSeats"))
                .checkRightHandDrive(data.get(TestData.VEHICLE_DATA).get("righthand"))
                .enterFuelType(data.get(TestData.VEHICLE_DATA).get("fuelType"))
                .enterPayload(data.get(TestData.VEHICLE_DATA).get("payLoad"))
                .enterWeight(data.get(TestData.VEHICLE_DATA).get("totalWeight"))
                .enterListPrice(data.get(TestData.VEHICLE_DATA).get("lstPrice"))
                .enterAnnualMilage(data.get(TestData.VEHICLE_DATA).get("annMilage"))
                .goToInsurancePage();
        ExtentLogger.passStatus("All Fields are entered in Vehicle Data Page");
        return new InsurantDataScreen();

    }

    public InsurantDataScreen populateAllDetailsForAutoMobile(Map<String, Map<String, String>> data) {
        enterVehicleDataPage.selectMake(data.get(TestData.VEHICLE_DATA).get("make"))
                .enterEngPerformance(data.get(TestData.VEHICLE_DATA).get("engPerformance"))
                .enterDateManfacture(data.get(TestData.VEHICLE_DATA).get("dateOfManfct"))
                .enterNoSeats(data.get(TestData.VEHICLE_DATA).get("noOfSeats"))
                .enterFuelType(data.get(TestData.VEHICLE_DATA).get("fuelType"))
                .enterListPrice(data.get(TestData.VEHICLE_DATA).get("lstPrice"))
                .enterAnnualMilage(data.get(TestData.VEHICLE_DATA).get("annMilage"))
                .goToInsurancePage();
        ExtentLogger.passStatus("All Fields are entered in Vehicle Data Page");
        return new InsurantDataScreen();

    }
}
