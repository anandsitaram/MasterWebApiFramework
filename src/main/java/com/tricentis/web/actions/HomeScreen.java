package com.tricentis.web.actions;

import com.tricentis.web.pages.HomePage;

public class HomeScreen {

    private HomePage homePage;

    public HomeScreen() {
        homePage = new HomePage();
    }


    public VehicleDataScreen navigateToVehicleScreen(String vehicle) {
        homePage.goToMenu().selectVehicleType(vehicle);
        return new VehicleDataScreen();


    }
}