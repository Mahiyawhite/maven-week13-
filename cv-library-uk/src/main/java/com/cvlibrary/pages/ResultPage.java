package com.cvlibrary.pages;

import com.cvlibrary.pagefactory.ManageDriver;
import com.cvlibrary.utility.Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ResultPage extends Utility {
    public ResultPage(WebDriver driver) {
        ManageDriver.driver = driver;
        PageFactory.initElements(driver, this);
    }

    WebElement resultText1;

    public void verifyTheResults(String expected) {
        String actual = resultText1.getText();
        if (!actual.contains(expected)) {
            throw new AssertionError("Expected text not found! Expected: " + expected + ", but found: " + actual);
        }
    }
}



