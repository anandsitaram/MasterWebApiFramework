package com.tricentis.web.pages;

import com.tricentis.common.exceptions.ValueNotFoundException;
import com.tricentis.web.enums.GENDERTYPE;
import com.tricentis.web.utils.SeleniumHelper;
import org.openqa.selenium.By;

public class EnterInsurantDataPage extends HomePage {
    public EnterInsurantDataPage(){
        SeleniumHelper.waitForPageLoad(this.getClass().getSimpleName());

    }

    private By firstNmTxtBx =By.id("firstname");
    private By lastNmTxtBx =By.id("lastname");
    private By birthDtTxtBx =By.id("birthdate");
    private By genderMaleChkBx =By.id("gendermale");
    private By genderFeMaleChkBx =By.id("genderfemale");
    private By strtAddressTxtBx =By.id("streetaddress");
    private By countrySel =By.id("country");
    private By zipcodeTxtBx =By.id("zipcode");

    private By cityTxtBx =By.id("city");
    private By occpSel =By.id("occupation");
    private By skyDivingChkBx =By.id("skydiving");

    private By speedingChkBx =By.id("speeding");

    private By bungeejumpingChkBx =By.id("bungeejumping");

    private By cliffdivingChkBx =By.id("cliffdiving");

    private By otherChkBx =By.id("other");
    private By productDataBtn =By.id("nextenterproductdata");
    private By headerTxt =By.xpath("//*[@class='idealsteps-step-active']//*[@id='enterinsurantdata']");

    public boolean isInsurantPageDisplayed(){
        return SeleniumHelper.isElementDisplayed(headerTxt);
    }

    public EnterInsurantDataPage enterFirstName(String firstName){
        SeleniumHelper.sendKeys(firstNmTxtBx,firstName,firstName+" text is entered in first name field");
        return this;
    }

    public EnterInsurantDataPage enterLastName(String lastname){
        SeleniumHelper.sendKeys(lastNmTxtBx,lastname,lastname+" text is entered in lastname field");
        return this;
    }

    public EnterInsurantDataPage enterDob(String dob){
        SeleniumHelper.sendKeys(birthDtTxtBx,dob,dob+"  is selected in DOB field");
        return this;
    }

    public EnterInsurantDataPage checkGenderBtn(String value){
        GENDERTYPE type = GENDERTYPE.valueOf(value.toUpperCase());
        //TODO IF LOOP
        switch(type){
            case MALE:   SeleniumHelper.jsClick(genderMaleChkBx,"Male radio Btn is selected");
                break;
            case FEMALE:   SeleniumHelper.jsClick(genderFeMaleChkBx,"Female Btn is selected");
                break;

            default: throw new ValueNotFoundException("Incorrect value passed");
        }

        return this;
    }

    public EnterInsurantDataPage enterStreetAddrs(String address){
        SeleniumHelper.sendKeys(strtAddressTxtBx,address,address+" text is entered in address field");
        return this;
    }

    public EnterInsurantDataPage selectCountry(String country){
        SeleniumHelper.selectVisibleTextFromDropdown(countrySel,country,country+" is selected from the dropdown");
        return this;
    }
    public EnterInsurantDataPage enterZipCode(String code){
        SeleniumHelper.sendKeys(zipcodeTxtBx,code,code+" text is entered in zipcode field");
        return this;
    }

    public EnterInsurantDataPage enterCity(String city){
        SeleniumHelper.sendKeys(cityTxtBx,city,city+" text is entered in city field");
        return this;
    }

    public EnterInsurantDataPage selectOccp(String value){
        SeleniumHelper.selectVisibleTextFromDropdown(occpSel,value,value+" is selected from dropdown");
        return this;
    }

    public EnterInsurantDataPage selectHobbies(String hobby){
        //TODO IF LOOP
        switch(hobby){
            case "Speeding":   SeleniumHelper.jsClick(speedingChkBx,"Speeding radio Btn is selected");
                break;
            case "Bungee Jumping":   SeleniumHelper.jsClick(bungeejumpingChkBx,"Bungee Jumping radio Btn is selected");
                break;
            case "Cliff Diving":   SeleniumHelper.jsClick(cliffdivingChkBx,"Cliff Diving radio Btn is selected");
                break;
            case "Skydiving":   SeleniumHelper.jsClick(skyDivingChkBx,"Skydiving radio Btn is selected");
                break;
            case "Other":   SeleniumHelper.jsClick(otherChkBx,"Other radio Btn is selected");
                break;

            default: throw new ValueNotFoundException("Incorrect value passed in the argument");
        }
        return this;
    }

    public EnterProductDataPage goToProductDataPage( ){
        SeleniumHelper.click(productDataBtn,"Next button is clicked to navigate into Product Data Page");
        return new EnterProductDataPage();
    }

}
