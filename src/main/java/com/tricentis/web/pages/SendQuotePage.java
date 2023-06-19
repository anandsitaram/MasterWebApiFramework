package com.tricentis.web.pages;

import com.tricentis.common.utils.EncryptUtil;
import com.tricentis.web.utils.SeleniumHelper;
import org.openqa.selenium.By;

public class SendQuotePage extends HomePage {

    public SendQuotePage() {
        SeleniumHelper.waitForPageLoad(this.getClass().getSimpleName());

    }

    private By emailTxtBx = By.id("email");

    private By phoneTxtBx = By.id("phone");

    private By userNameTxtBx = By.id("username");

    private By passwordTxtBx = By.id("password");

    private By confirmPasswordTxtBx = By.id("confirmpassword");

    private By sendMailBtn = By.id("sendemail");

    private By confimBtn = By.xpath("//button[@class='confirm']");

    private By spinner = By.id("LoadingPDF");

    private By headerTxt = By.id("sendQuoteForm");

    private By successMsgTxt = By.xpath("//h2");

    private By confirmMailPopUp = By.xpath("//div[@class='sweet-alert showSweetAlert visible']");

    public boolean isSendQuotePageDisplayed() {
        return SeleniumHelper.isElementDisplayed(headerTxt);
    }

    public boolean isConfirmMailPopUpDisplayed() {
        return SeleniumHelper.isElementDisplayed(confirmMailPopUp);
    }

    public SendQuotePage enterEmail(String email) {
        SeleniumHelper.sendKeys(emailTxtBx, email, email + " text is entered in email field");
        return this;
    }

    public String getSuccessMsgTxt() {
        return SeleniumHelper.getText(successMsgTxt, "Confirm Mail is displayed");
    }

    public SendQuotePage enterPhoneNo(String phone) {
        SeleniumHelper.sendKeys(phoneTxtBx, phone, phone + " text is entered in phone field");
        return this;
    }

    public SendQuotePage enterUserName(String username) {
        SeleniumHelper.sendKeys(userNameTxtBx, username, username + " text is entered in username field");
        return this;
    }

    public SendQuotePage enterPassowrd(String password) {
        SeleniumHelper.sendKeys(passwordTxtBx, EncryptUtil.getDecryptedValue(password), password + " encrypted text is entered in password field");
        return this;
    }

    public SendQuotePage enterConfirmPassowrd(String confirmPwd) {
        SeleniumHelper.sendKeys(confirmPasswordTxtBx, EncryptUtil.getDecryptedValue(confirmPwd), confirmPwd + " encrypted text is entered in confirm password field");
        return this;
    }

    public SendQuotePage clickMailBtn() {
        SeleniumHelper.click(sendMailBtn, "Mail Button is clicked");
        return this;
    }

    public SendQuotePage waitForSpinnerToDisappear() {
        SeleniumHelper.waitUntilIsInvisible(spinner, "Waiting for spinner to disappear");
        return this;
    }

    public SendQuotePage clickConfrimBtn() {
        SeleniumHelper.click(confimBtn, " Confirm button is clicked");
        return this;
    }
}

