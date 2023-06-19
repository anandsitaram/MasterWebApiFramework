package com.tricentis.common.testing;

import com.tricentis.common.reports.ExtentLogger;
import com.tricentis.common.utils.ConfigReader;
import com.tricentis.web.reports.ExtentWebLogger;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.StringDescription;

public final class Validate {

    private Validate() {

    }

    private static <T> String getText(T actual, Matcher<? super T> matcher) {
        Description description = new StringDescription();
        description.appendText("\nExpected: ").appendDescriptionOf(matcher)
                .appendText("\n     Actual: ");

        matcher.describeMismatch(actual, description);
        String msg = description.toString();

        msg = msg.replace("<", "").replace(">", "");
        return msg;
    }

    private static <T> boolean getResult(T actual, Matcher<? super T> matcher) {
        return matcher.matches(actual);


    }

    public static <T> boolean verifyThat(T actual, Matcher<? super T> matcher) {
        boolean result = getResult(actual, matcher);
        String msg = getText(actual, matcher);
        if (!result) {
            ExtentWebLogger.fail("Validation failed " + msg, ConfigReader.isValidationFailedScreenshot());
        } else {
            ExtentWebLogger.pass("Validation passed " + msg, ConfigReader.isValidationPassedScreenshot());
        }
        return result;
    }

    public static <T> void assertThat(T actual, Matcher<? super T> matcher) {
        boolean result = getResult(actual, matcher);
        String msg = getText(actual, matcher);
        if (!result) {
            throw new AssertionError("Validation failed - " + msg);
        }
     try {
         ExtentWebLogger.pass("Validation passed " + msg, ConfigReader.isValidationPassedScreenshot());
     }
     catch (Exception e){
         ExtentLogger.pass("Validation passed " + msg);

     }
    }

    public static <T> boolean verifyThat(String message, T actual, Matcher<? super T> matcher) {
        boolean result = getResult(actual, matcher);
        String msg = getText(actual, matcher);
        if (!result) {
            ExtentWebLogger.fail(message + " : Validation failed " + msg, ConfigReader.isValidationFailedScreenshot());
        } else {
            ExtentWebLogger.pass(message + " :  Validation passed " + msg, ConfigReader.isValidationPassedScreenshot());
        }
        return result;
    }

    public static <T> void assertThat(String message, T actual, Matcher<? super T> matcher) {
        boolean result = getResult(actual, matcher);
        String msg = getText(actual, matcher);
        if (!result) {
            throw new AssertionError(message + " : Validation failed - " + msg);
        }
        try {
            ExtentWebLogger.pass("Validation passed " + msg, ConfigReader.isValidationPassedScreenshot());
        }
        catch (Exception e){
            ExtentLogger.pass("Validation passed " + msg);

        }
    }


}
