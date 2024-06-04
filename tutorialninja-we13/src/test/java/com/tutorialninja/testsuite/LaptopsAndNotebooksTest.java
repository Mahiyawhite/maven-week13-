package com.tutorialninja.testsuite;

import com.tutorialninja.testbase.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Test
public class LaptopsAndNotebooksTest extends TestBase {

    public void verifyProductsPriceDisplayHighToLowSuccessfully() {
        //1.1 Mouse hover on Laptops & Notebooks Tab.and click
        Actions actions = new Actions(driver);
        clickOnElement(By.xpath("//a[text()='Laptops & Notebooks']"));

        //1.2 Click on “Show All Laptops & Notebooks”
        clickOnElement(By.xpath("//a[text()='Show AllLaptops & Notebooks']"));

        //1.3 Select Sort By "Price (High > Low)"
        WebElement dropDown = driver.findElement(By.id("input-sort"));
        Select select = new Select(dropDown);
        dropDown.findElement(By.xpath("//select[@id='input-sort']/option[5]")).click();

        //1.4 Verify the Product price will arrange in High to Low order.
    }

    @Test (groups = { " sanity "} )
    // 2. Test name verifyThatUserPlaceOrderSuccessfully()
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException {
        // 2.1 Mouse hover on Laptops & Notebooks Tab and click
        Actions actions = new Actions(driver);
        driver.findElement(By.xpath("//a[text()='Laptops & Notebooks']")).click();

        // 2.2 Click on “Show All Laptops & Notebooks”
        clickOnElement(By.xpath("//a[text()='Show AllLaptops & Notebooks']"));

        // 2.3 Select Sort By "Price (High > Low)"
        WebElement dropDown = driver.findElement(By.id("input-sort"));
        Select select = new Select(dropDown);
        dropDown.findElement(By.xpath("//select[@id='input-sort']/option[5]")).click();

        // 2.4 Select Product “MacBook”
        clickOnElement(By.linkText("MacBook"));

        // 2.5 Verify the text “MacBook”
        SoftAssert softAssertMacbookText = new SoftAssert();
        String actualMacbookText = driver.findElement(By.xpath("//h1[text()='MacBook']")).getText();
        String expectingMacbookText = "MacBook";
        softAssertMacbookText.assertEquals(actualMacbookText,expectingMacbookText);

        driver.findElement(By.xpath("//input[@id='input-quantity']")).clear();
        driver.findElement(By.xpath("//input[@id='input-quantity']")).sendKeys("1");

        // 2.6 Click on ‘Add To Cart’ button
        driver.findElement(By.id("button-cart")).click();

        // 2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
        SoftAssert softAssertSuccessMsg = new SoftAssert();
        String actualSuccessMsg = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText();
        System.out.println(actualSuccessMsg);
        String expectedSuccessMsg = "Success: You have added MacBook to your shopping cart!\n" + "×";
        softAssertSuccessMsg.assertEquals(expectedSuccessMsg,actualSuccessMsg);

        // 2.8 Click on link “shopping cart” display into success message
        clickOnElement(By.xpath("//a[text()='shopping cart']"));

        // 2.9 Verify the text "Shopping Cart"
        SoftAssert softAssertCartMsg = new SoftAssert();
        String actualCartMsg = driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
        String expectedCartMsg = "Shopping Cart  (0.00kg)";
        softAssertCartMsg.assertEquals(actualCartMsg,expectedCartMsg);

        // 2.10 Verify the Product name "MacBook"
        SoftAssert softAssertName = new SoftAssert();
        String actualName = driver.findElement(By.xpath("//*[@id='content']/form/div/table/tbody/tr/td[2]/a")).getText();
        String expectedName = "MacBook ***";
        softAssertName.assertEquals(actualName,expectedName);

        //2.11 Change Quantity "2"
        driver.findElement(By.cssSelector("input[name='quantity']")).sendKeys("2");
        //2.12 Click on “Update” Tab
        clickOnElement(By.cssSelector("button[data-original-title='Update']"));

        //2.13 Verify the message “Success: You have modified your shopping cart!”
        SoftAssert softAssertSuccess = new SoftAssert();
        softAssertSuccess.assertTrue(driver.findElement(By.cssSelector(".alert-success")).getText().contains("Success: You have modified your shopping cart!"));

        //2.14 Verify the Total £737.45
        SoftAssert softAssertPrice = new SoftAssert();
        String actualPrice = driver.findElement(By.xpath("//td[text()='£737.45']")).getText();
        String expectedPrice = "Total £737.45 not found";
        softAssertPrice.assertEquals(actualPrice,expectedPrice);

        //2.15 Click on “Checkout” button
        clickOnElement(By.linkText("Checkout"));

        //2.16 Verify the text “Checkout”
        SoftAssert softAssertCheckout = new SoftAssert();
        String actualText = driver.findElement(By.xpath("//h1[text()='Checkout']")).getText();
        String expectedText = "Checkout text not displayed";
        softAssertCheckout.assertEquals(actualText,expectedText);

        //2.17 Verify the Text “New Customer”
        SoftAssert softAssertNewCustomer = new SoftAssert();
        String actualNewCustomerText = driver.findElement(By.xpath("//h2[text()='New Customer']")).getText();
        String expectedNewCustomer = "New Customer text not displayed";
        softAssertNewCustomer.assertEquals(actualNewCustomerText,expectedNewCustomer);

        //2.18 Click on “Guest Checkout” radio button
        clickOnElement(By.cssSelector("input[value='guest']"));

        //2.19 Click on “Continue” tab
        clickOnElement(By.id("button-account"));

        /*
2.20 Fill the mandatory fields
2.21 Click on “Continue” Button
2.22 Add Comments About your order into text area
2.23 Check the Terms & Conditions check box
2.24 Click on “Continue” button
2.25 Verify the message “Warning: Payment method required!”*/
    }


}
