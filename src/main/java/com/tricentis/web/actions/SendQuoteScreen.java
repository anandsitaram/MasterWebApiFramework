package com.tricentis.web.actions;

import com.tricentis.common.reports.ExtentLogger;
import com.tricentis.web.pages.SendQuotePage;

import java.util.Map;

public class SendQuoteScreen {
    private SendQuotePage sendQuotePage;

    public SendQuoteScreen(){
        sendQuotePage= new SendQuotePage();
    }
    public SendQuotePage getSendQuotePage() {
        return sendQuotePage;
    }
    public void populateAllDetailsForMotorCycle(Map<String, Map<String, String>> data ){
        sendQuotePage.enterEmail(data.get("sendQuote").get("email"))
                .enterPhoneNo(data.get("sendQuote").get("phone"))
                .enterUserName(data.get("sendQuote").get("userName"))
                .enterPassowrd(data.get("sendQuote").get("password"))
                .enterConfirmPassowrd(data.get("sendQuote").get("password"))
                .clickMailBtn()
                .waitForSpinnerToDisappear();
        ExtentLogger.info("All Fields are entered in Send Quote Page");


    }
}
