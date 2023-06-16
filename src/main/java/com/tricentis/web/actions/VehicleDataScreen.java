package com.tricentis.web.actions;

import com.tricentis.common.reports.ExtentLogger;
import com.tricentis.web.pages.EnterVehicleDataPage;

import java.util.Map;

public class VehicleDataScreen {
    private EnterVehicleDataPage enterVehicleDataPage;
    public VehicleDataScreen(){
        enterVehicleDataPage= new EnterVehicleDataPage();
    }

    public EnterVehicleDataPage getEnterVehicleDataPage() {
        return enterVehicleDataPage;
    }

    public InsurantDataScreen populateAllDetailsForMotorCycle(Map<String, Map<String, String>> data ){
        enterVehicleDataPage.selectMake(data.get("vehicleData").get("make"))
                .selectModel(data.get("vehicleData").get("model"))
                .enterCylindercapcity(data.get("vehicleData").get("cylinderCap"))
                .enterEngPerformance(data.get("vehicleData").get("engPerformance"))
                .enterDateManfacture(data.get("vehicleData").get("dateOfManfct"))
                .enterNoSeatsMotorCycle(data.get("vehicleData").get("noOfSeats"))
                .enterListPrice(data.get("vehicleData").get("lstPrice"))
                .enterAnnualMilage(data.get("vehicleData").get("annMilage"))
                .goToInsurancePage();
        ExtentLogger.info("All Fields are entered in Vehicle Data Page");
        return new InsurantDataScreen();

    }
}
