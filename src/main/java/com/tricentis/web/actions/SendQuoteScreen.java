package com.tricentis.web.actions;

import com.tricentis.common.reports.ExtentLogger;
import com.tricentis.web.constants.TestData;
import com.tricentis.web.pages.SendQuotePage;

import java.util.Map;

public class SendQuoteScreen {
    private SendQuotePage sendQuotePage;

    public SendQuoteScreen() {
        sendQuotePage = new SendQuotePage();
    }

    public SendQuotePage getSendQuotePage() {
        return sendQuotePage;
    }

    public void populateAllDetailsForVehicle(Map<String, Map<String, String>> data) {
        sendQuotePage.enterEmail(data.get(TestData.SENDQUOTE).get("email"))
                .enterPhoneNo(data.get(TestData.SENDQUOTE).get("phone"))
                .enterUserName(data.get(TestData.SENDQUOTE).get("userName"))
                .enterPassowrd(data.get(TestData.SENDQUOTE).get("password"))
                .enterConfirmPassowrd(data.get(TestData.SENDQUOTE).get("password"))
                .clickMailBtn()
                .waitForSpinnerToDisappear();
        ExtentLogger.info("All Fields are entered in Send Quote Page");


    }
}
