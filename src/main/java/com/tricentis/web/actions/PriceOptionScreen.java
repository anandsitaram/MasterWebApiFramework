package com.tricentis.web.actions;

import com.tricentis.common.reports.ExtentLogger;
import com.tricentis.web.pages.EnterPriceOptionPage;

public class PriceOptionScreen {
    private EnterPriceOptionPage enterPriceOptionPage;

    public PriceOptionScreen() {

        enterPriceOptionPage = new EnterPriceOptionPage();

    }

    public EnterPriceOptionPage getEnterPriceOptionPage() {
        return enterPriceOptionPage;
    }

    public SendQuoteScreen populateAllDetailsForVehicle(String price) {

        enterPriceOptionPage.selectPriceOption(price)
                .goToSendQuotePage();
        ExtentLogger.passStatus(price + " is selected in Enter Price Option page");
        return new SendQuoteScreen();


    }


}
