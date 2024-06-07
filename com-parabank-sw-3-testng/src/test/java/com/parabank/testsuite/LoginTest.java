package com.parabank.testsuite;

import com.parabank.testbase.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class LoginTest extends TestBase {

    public Random randomGenerator = new Random();
    char[] password= generatePassword(8);
    String Password = new String(password);
    String username = generateRandomEmail();

    //4.Write down the following test into ‘LoginTest’ class

    //2.verifyTheErrorMessage
    @Test (groups = { " smoke " } )
    public void invalidUserId(){

        //Enter invalid username
        driver.findElement(By.xpath("//div[@class='login']/input")).sendKeys("Monkybar");
        //Enter invalid password
        driver.findElement(By.xpath("//div[@id='loginPanel']/form/div[2]/input")).sendKeys("Chocolate1");
        //Click on Login button
        clickOnElement(By.xpath("//div[@id='loginPanel']/form/div[3]/input"));


        //Verify the error message ‘The username and password could not be verified.’*/
        String actualErrorMsg = driver.findElement(By.xpath("//div[@id='rightPanel']/p")).getText();
        String expectedErrorMsg = "The username and password could not be verified.";
        Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
    }
}
