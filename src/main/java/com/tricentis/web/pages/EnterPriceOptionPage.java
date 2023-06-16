package com.tricentis.web.pages;

import com.tricentis.common.exceptions.ValueNotFoundException;
import com.tricentis.web.utils.SeleniumHelper;
import org.openqa.selenium.By;

public class EnterPriceOptionPage extends HomePage{

    public EnterPriceOptionPage(){
        SeleniumHelper.waitForPageLoad(this.getClass().getSimpleName());

    }
    private By goldChkBx =By.id("selectgold");

    private By ultimateChkBx =By.id("selectultimate");

    private By silverChkBx =By.id("selectsilver");

    private By platinumChkBx =By.id("selectplatinum");
    private By sendQuoteBtn=By.id("nextsendquote");
    private By headerTxt =By.id("priceTable");;

    public boolean isPriceOptionPageDisplayed(){
        return SeleniumHelper.isElementDisplayed(headerTxt);
    }

    public EnterPriceOptionPage selectPriceOption(String priceOption){
        //TODO IF LOOP
        switch(priceOption){
            case "ultimate":   SeleniumHelper.jsClick(ultimateChkBx,priceOption+" radio button in selected");
                break;
            case "gold":   SeleniumHelper.jsClick(goldChkBx,priceOption+" radio button in selected");
                break;
            case "silver":   SeleniumHelper.jsClick(silverChkBx,priceOption+" radio button in selected");
                break;
            case "platinum":   SeleniumHelper.jsClick(platinumChkBx,priceOption+" radio button in selected");
                break;
            default: throw new ValueNotFoundException("Incorrect value passed in the argument");
        }
        return this;

    }

    public SendQuotePage goToSendQuotePage( ){
        SeleniumHelper.click(sendQuoteBtn,"Next button is clicked to navigate into Send Quote Page");
        return new SendQuotePage();
    }

}
