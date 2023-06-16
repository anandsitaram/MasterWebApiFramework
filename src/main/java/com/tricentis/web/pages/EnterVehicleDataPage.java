package com.tricentis.web.pages;

import com.tricentis.common.exceptions.ValueNotFoundException;
import com.tricentis.web.utils.SeleniumHelper;
import org.openqa.selenium.By;

public class EnterVehicleDataPage extends HomePage {



    private By makeSel =By.id("make");

    private By fuelSel =By.id("fuel");
    private By modelSel =By.id("model");
    private By cylCapTxtBx =By.id("cylindercapacity");
    private By engPerfTxtBx =By.id("engineperformance");
    private By dtMftreTxtBx =By.id("dateofmanufacture");
    private By noSeatsMotorSel =By.id("numberofseatsmotorcycle");

    private By noSeatsSel=By.id("numberofseats");

    private By priceTxtBx =By.id("listprice");
    private By milageTxtBx =By.id("annualmileage");

    private By payloadTxtBx =By.id("payload");

    private By weightTxtBx =By.id("totalweight");
    private By insurnBtn =By.id("nextenterinsurantdata");

    private By rightDriverNoChkBx =By.id("righthanddriveno");

    private By rightDriverYsChkBx =By.id("righthanddriveyes");

    private By headerTxt =By.xpath("//*[@class='idealsteps-step-active']//*[@id='entervehicledata']");
    public EnterVehicleDataPage( ) {
        SeleniumHelper.waitForPageLoad(this.getClass().getSimpleName());

    }

    public boolean isVehicleDataPageDisplayed(){
        return SeleniumHelper.isElementDisplayed(headerTxt);
    }

    public EnterVehicleDataPage selectMake(String make){
        SeleniumHelper.selectVisibleTextFromDropdown(makeSel,make,make+" is selected from the make dropdown");
        return this;
    }

    public EnterVehicleDataPage selectModel(String model){
        SeleniumHelper.selectVisibleTextFromDropdown(modelSel,model,model+" is selected from the model dropdown");
        return this;
    }

    public EnterVehicleDataPage enterCylindercapcity(String cylinder){
        SeleniumHelper.sendKeys(cylCapTxtBx,cylinder,cylinder+" text is entered in cylinder field");
        return this;
    }

    public EnterVehicleDataPage enterEngPerformance(String eng){
        SeleniumHelper.sendKeys(engPerfTxtBx,eng,eng+" text is entered in EngPerformance field");
        return this;
    }

    public EnterVehicleDataPage enterDateManfacture(String dt){
        SeleniumHelper.sendKeys(dtMftreTxtBx,dt,dt+" text is entered in Date Manufacture field");
        return this;
    }

    public EnterVehicleDataPage enterNoSeatsMotorCycle(String seats){
        SeleniumHelper.selectVisibleTextFromDropdown(noSeatsMotorSel,seats,seats+" is selected in No of seats dropdown");
        return this;
    }

    public EnterVehicleDataPage enterNoSeats(String seats){
        SeleniumHelper.selectVisibleTextFromDropdown(noSeatsSel,seats,seats+" is selected in No of seats dropdown");
        return this;
    }
    public EnterVehicleDataPage enterFuelType(String fuelType){
        SeleniumHelper.selectVisibleTextFromDropdown(fuelSel,fuelType,fuelType+" is selected in fuelType dropdown");
        return this;
    }

    public EnterVehicleDataPage enterListPrice(String price){
        SeleniumHelper.sendKeys(priceTxtBx,price,price+" text is entered in List price field");
        return this;
    }

    public EnterVehicleDataPage enterAnnualMilage(String milage){
        SeleniumHelper.sendKeys(milageTxtBx,milage,milage+" text is entered in annual milage field");
        return this;
    }

    public EnterInsurantDataPage goToInsurancePage( ){
        SeleniumHelper.click(insurnBtn,"Next button is clicked to navigate into Insurant Data Page");
        return new EnterInsurantDataPage();
    }

    public EnterVehicleDataPage enterPayload(String payload){
        SeleniumHelper.sendKeys(payloadTxtBx,payload,payload+" text is entered in payload field");
        return this;
    }

    public EnterVehicleDataPage enterWeight(String weight){
        SeleniumHelper.sendKeys(weightTxtBx,weight,weight+" text is entered in weight field");
        return this;
    }

    public EnterVehicleDataPage checkRightHandDrive(String selection){
        switch(selection.toLowerCase()){
            case "yes":   SeleniumHelper.jsClick(rightDriverYsChkBx,"RightHandDriver check box is selected as YES");
                break;
            case "no":   SeleniumHelper.jsClick(rightDriverNoChkBx,"RightHandDriver check box is selected as NO");
                break;

            default: throw new ValueNotFoundException("Incorrect value passed in the argument");
        }
        return this;
    }

}


