package com.tricentis.web.actions;

import com.tricentis.common.reports.ExtentLogger;
import com.tricentis.web.pages.EnterPriceOptionPage;

public class PriceOptionScreen {
    private EnterPriceOptionPage enterPriceOptionPage;

    public PriceOptionScreen(){

        enterPriceOptionPage= new EnterPriceOptionPage();

    }
    public EnterPriceOptionPage getEnterPriceOptionPage() {
        return enterPriceOptionPage;
    }
    public SendQuoteScreen populateAllDetailsForMotorCycle(String price){

        enterPriceOptionPage.selectPriceOption(price)
                .goToSendQuotePage();
        ExtentLogger.info(price+"is selected in Enter Price Option page");
        return new SendQuoteScreen();



    }
}
