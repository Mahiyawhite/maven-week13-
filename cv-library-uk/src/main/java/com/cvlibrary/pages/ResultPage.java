package com.cvlibrary.pages;

import com.cvlibrary.utility.Utility;
import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;

public class ResultPage extends Utility {

    public By resultText = By.xpath("//h1[@class='search-header__title']");

    public String getMessage(){
        return getTextFromElement(By.xpath("//h1[@class='search-header__title']"));
    }

    public void verifyTextSuccessfully(String expectedMessage) {
       String actualMessage = getMessage();
        Assert.isTrue(Boolean.parseBoolean(actualMessage),expectedMessage);

    }


}



