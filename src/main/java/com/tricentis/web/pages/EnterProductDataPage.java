package com.tricentis.web.pages;

import com.tricentis.common.exceptions.ValueNotFoundException;
import com.tricentis.web.utils.SeleniumHelper;
import org.openqa.selenium.By;

public class EnterProductDataPage extends HomePage {

    public EnterProductDataPage() {
        SeleniumHelper.waitForPageLoad(this.getClass().getSimpleName());

    }

    private By startDtTxtBx = By.id("startdate");
    private By insuranceSumSel = By.id("insurancesum");

    private By damageSumSel = By.id("damageinsurance");

    private By euroProtectChkBx = By.id("EuroProtection");

    private By legalDefenseChkBx = By.id("LegalDefenseInsurance");
    private By priceOptBtn = By.id("nextselectpriceoption");
    private By meritRateingSel = By.id("meritrating");

    private By courtesycarSel = By.id("courtesycar");
    private By headerTxt = By.xpath("//*[@class='idealsteps-step-active']//*[@id='enterproductdata']");

    public boolean isProductDataPageDisplayed() {
        return SeleniumHelper.isElementDisplayed(headerTxt);
    }

    public EnterProductDataPage enterStartDate(String startDate) {
        SeleniumHelper.sendKeys(startDtTxtBx, startDate, startDate + " text is entered in Start Date field");
        return this;
    }

    public EnterProductDataPage enterInsureSum(String insureSum) {
        SeleniumHelper.selectVisibleTextFromDropdown(insuranceSumSel, insureSum, insureSum + " is selected from Insurance Sum dropdown");
        return this;
    }

    public EnterProductDataPage enterDamageSum(String damageSum) {
        SeleniumHelper.selectVisibleTextFromDropdown(damageSumSel, damageSum, damageSum + " is selected from Damage Insurance dropdown");
        return this;
    }

    public EnterProductDataPage enterMeritRating(String rating) {
        SeleniumHelper.selectVisibleTextFromDropdown(meritRateingSel, rating, rating + " is selected from Merit Rating dropdown");
        return this;
    }

    public EnterProductDataPage enterCourtesyCar(String courtesycar) {
        SeleniumHelper.selectVisibleTextFromDropdown(courtesycarSel, courtesycar, courtesycar + " is selected from Courtesy Car dropdown");
        return this;
    }

    public EnterProductDataPage selectOptionalProducts(String optionalProduct) {
        switch (optionalProduct) {
            case "Euro Protection":
                SeleniumHelper.jsClick(euroProtectChkBx, optionalProduct + " radio button is selected");
                break;
            case "Legal Defense Insurance":
                SeleniumHelper.jsClick(legalDefenseChkBx, optionalProduct + "radio button is selected");
                break;

            default:
                throw new ValueNotFoundException("Incorrect value passed in the argument");
        }
        return this;
    }

    public EnterPriceOptionPage goToPriceOptionPage() {
        SeleniumHelper.click(priceOptBtn, "Next button is clicked to navigate into Price Option Page");
        return new EnterPriceOptionPage();
    }

}


