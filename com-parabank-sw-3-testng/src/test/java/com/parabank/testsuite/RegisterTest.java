package com.parabank.testsuite;

import com.parabank.testbase.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Random;

public class RegisterTest extends TestBase {

    public Random randomGenerator = new Random();
    char[] password= generatePassword(8);
    String Password = new String(password);
    String username = generateRandomEmail();

    //1.verifyThatSigningUpPageDisplay
    //* click on the ‘Register’ link
    //* Verify the text ‘Signing up is easy!’

    @Test
    public void register(){
        clickOnElement(By.xpath("//a[text()='Register']"));

        String actualSignUpMsg = driver.findElement(By.cssSelector("[id='rightPanel']>h1")).getText();
        String expectedSignUpMsg = "Signing up is easy!";
        Assert.assertEquals(actualSignUpMsg,expectedSignUpMsg);
    }

    //2.userShouldRegisterAccountSuccessfully
    @Test (priority = 1)
    public void registerPage(){
        //* click on the ‘Register’ link
        clickOnElement(By.xpath("//a[text()='Register']"));
        //* Enter First name
        driver.findElement(By.cssSelector("[id='customer.firstName']")).sendKeys("Kunal");
        //* Enter Last name
        driver.findElement(By.cssSelector("[id='customer.lastName']")).sendKeys("Kapoor");
        //* Enter Address
        driver.findElement(By.id("customer.address.street")).sendKeys("25, King Street");
        //* Enter City
        driver.findElement(By.cssSelector("[id='customer.address.city']")).sendKeys("London");
        //* Enter State
        driver.findElement(By.cssSelector("[id='customer.address.state']")).sendKeys("Middlesex");
        //* Enter Zip Code
        driver.findElement(By.cssSelector("[id='customer.address.zipCode']")).sendKeys("HA9 7TP");
        //* Enter Phone
        driver.findElement(By.id("customer.phoneNumber")).sendKeys("07945121414");
        //* Enter SSN
        driver.findElement(By.id("customer.ssn")).sendKeys("21");
        //* Enter Username
        driver.findElement(By.id("customer.username")).sendKeys("KickStart");
        //* Enter Password
        driver.findElement(By.id("customer.password")).sendKeys(Password);
        //* Enter Confirm
        driver.findElement(By.id("repeatedPassword")).sendKeys(Password);
        //* Click on REGISTER button
        driver.findElement(By.xpath("//*[@id='customerForm']/table/tbody/tr[13]/td[2]/input")).click();

        //* Verify the text 'Your account was created successfully. You are now logged in.
        SoftAssert softAssertWelcome = new SoftAssert();
        String actualWelcomeMsg = driver.findElement(By.cssSelector("[id='rightPanel']>h1")).getText();
        String expectedWelcomeMsg = "Welcome QualityStreet";
        softAssertWelcome.assertEquals(actualWelcomeMsg,expectedWelcomeMsg);
    }
    //1.userShouldLoginSuccessfullyWithValidCredentials
    @Test (priority = 2)
    public void loginPage () {
        //* Enter valid username
        driver.findElement(By.cssSelector("#loginPanel > form > div:nth-child(2) > input")).sendKeys("KickStart");
        //* Enter valid password
        driver.findElement(By.cssSelector("#loginPanel > form > div:nth-child(4) > input")).sendKeys(Password);
        //* Click on ‘LOGIN’ button
        clickOnElement(By.cssSelector("#loginPanel > form > div:nth-child(5) > input"));

        //* Verify the ‘Accounts Overview’ text is display
        SoftAssert softAssertOverviewMsg = new SoftAssert();
        String actualAccOverviewMsg = driver.findElement(By.cssSelector("[id='showOverview']>h1")).getText();
        String expectedAccOverviewMsg = "Accounts Overview";
        softAssertOverviewMsg.assertEquals(actualAccOverviewMsg, expectedAccOverviewMsg);
    }

        //*3.userShouldLogOutSuccessfully
    @Test (priority = 3)
    public void Logout(){

        //* Enter valid username
        driver.findElement(By.xpath("//div[@class='login']/input")).sendKeys("Milkybar");
        //* Enter valid password
        driver.findElement(By.xpath("//div[@id='loginPanel']/form/div[2]/input")).sendKeys("Chocolate123");
        //* Click on ‘LOGIN’ button
        clickOnElement(By.xpath("//div[@id='loginPanel']/form/div[3]/input"));
//      * Click on ‘Log Out’ link
        driver.findElement(By.xpath("//a[text()='Log Out']")).click();
//      * Verify the text ‘Customer Login’*/
        SoftAssert softAssertLogin = new SoftAssert();
        String actualLoginMsg = driver.findElement(By.xpath("//h2[text()='Customer Login']")).getText();
        String expectingLoginMsg = "Customer Login";
        softAssertLogin.assertEquals(actualLoginMsg,expectingLoginMsg);
    }
}
