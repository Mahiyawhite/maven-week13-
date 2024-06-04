package com.nopcommerce.testsuite;

import com.nopcommerce.testbase.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class TestSuite extends TestBase {

    @Test( groups = {" smoke "})
    public void verifyProductArrangeInAlphaBaticalOrder() {
        //1.1 Click on Computer Menu.
        clickOnElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[1]/a"));

        //1.2 Click on Desktop
        clickOnElement(By.linkText("Desktops"));

        //1.3 Select Sort By position "Name: Z to A"
        selectByContainsTextFromDropDown(By.xpath("//*[@id='products-orderby']"), "Name: Z to A");
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        //2.1 Click on Computer Menu.
        clickOnElement(By.linkText("Computers"));

        //2.2 Click on Desktop
        clickOnElement(By.linkText("Desktops"));

        //2.3 Select Sort By position "Name: A to Z"
        selectByContainsTextFromDropDown(By.xpath("//*[@id='products-orderby']"), "Name: A to Z");

        //2.4 Click on "Add To Cart"
        WebElement button = driver.findElement(By.xpath("//div[@class='item-grid']/div[1]/div/div[2]/div[3]/div[2]/button[1]"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(button));
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='item-grid']/div[1]/div/div[2]/div[3]/div[2]/button[1]")).click();

        //2.5 Verify the Text "Build your own computer"

            SoftAssert softAssertText = new SoftAssert();
            String actualText = driver.findElement(By.xpath("//h1[text()='Build your own computer']")).getText();
            String expectingText = "Build your own computer";
            softAssertText.assertEquals(expectingText, actualText);


        //2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        WebElement ProcessorSelect = driver.findElement(By.xpath("//select[@id='product_attribute_1']"));
        Select selectP = new Select(ProcessorSelect);
        selectP.selectByVisibleText("2.2 GHz Intel Pentium Dual-Core E2200");

        //2.7.Select "8GB [+$60.00]" using Select class.
        WebElement RamSelect = driver.findElement(By.xpath("//select[@id='product_attribute_2']"));
        Select selectR = new Select(RamSelect);
        selectR.selectByVisibleText("8GB [+$60.00]");

        //2.8 Select HDD radio "400 GB [+$100.00]"
        clickOnElement(By.xpath("//input[@id='product_attribute_3_7']"));

        //2.9 Select OS radio "Vista Premium [+$60.00]"
        clickOnElement(By.xpath("//input[@id='product_attribute_4_9']"));

        //2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"
        clickOnElement(By.xpath("//input[@id='product_attribute_5_10']"));
        clickOnElement(By.xpath("//input[@id='product_attribute_5_12']"));

        //2.11 Verify the price "$1,475.00"
        /*SoftAssert softAssertPrice = new SoftAssert();
        String actualPrice = driver.findElement(By.xpath("//*[@id='price-value-1']")).getText();
        String expectingPrice = "$1,315.00";
        softAssertPrice.assertEquals(expectingPrice,actualPrice);*/

        //2.12 Click on "ADD TO CARD" Button.
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-1']"));

        /*2.13 Verify the Message "The product has been added to your shopping cart" on Top green Bar
           After that close the bar clicking on the cross button.*/
        SoftAssert softAssertProductAdded = new SoftAssert();
        String actualVerifyMsg = driver.findElement(By.xpath("//div[@id='bar-notification']/div/p")).getText();
        System.out.println(actualVerifyMsg);
        String expectedVerifyMsg = "The product has been added to your shopping cart";
        softAssertProductAdded.assertEquals(actualVerifyMsg,expectedVerifyMsg);

        clickOnElement(By.xpath("//div[@id='bar-notification']/div/span"));

        //2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        Actions actions = new Actions(driver);
        clickOnElement(By.linkText("Shopping cart"));

        //2.15 Verify the message "Shopping cart"
        SoftAssert softAssertCart = new SoftAssert();
        String actualShoppingCartText = driver.findElement(By.cssSelector("div[class='page-title']")).getText();
        String expectedShoppingCartText = "Shopping cart";
        softAssertCart.assertEquals(actualShoppingCartText,expectedShoppingCartText);

        //2.16 Change the Qty to "2" and Click on "Update shopping cart"
        clickOnElement(By.cssSelector("*[class='quantity up']"));


        //2.17 Verify the Total"$2,950.00"
        /*SoftAssert softAssertTotal = new SoftAssert();
        String actualPriceT = driver.findElement(By.xpath("//form[@id='shopping-cart-form']/div[1]/table/tbody/tr/td[6]/span")).getText();
        String expectedPriceT = "$2,950.00";
        softAssertTotal.assertEquals(actualPriceT,expectedPriceT);*/

        //2.18 click on checkbox “I agree with the terms of service”
        driver.findElement(By.xpath("//div[@class='terms-of-service']/label")).click();

        //2.19 Click on “CHECKOUT”
        clickOnElement(By.cssSelector("button[id='checkout']"));

        //2.20 Verify the Text “Welcome, Please Sign In!”
        SoftAssert softAssertWelcome = new SoftAssert();
        String actualWelcomeText = driver.findElement(By.xpath("//div[@class='page-title']/h1")).getText();
        String expectedWelcomeText = "Welcome, Please Sign In!";
        softAssertWelcome.assertEquals(actualWelcomeText,expectedWelcomeText);

        //2.21Click on “CHECKOUT AS GUEST” Tab
        Actions actions1 = new Actions(driver);
        clickOnElement(By.xpath("//div[@class='new-wrapper checkout-as-guest-or-register-block']/div[3]/button"));

        //2.22 Fill the all mandatory field
        driver.findElement(By.id("BillingNewAddress_FirstName")).sendKeys("pooja");
        driver.findElement(By.id("BillingNewAddress_LastName")).sendKeys("patel");
        driver.findElement(By.name("BillingNewAddress.Email")).sendKeys("pooja_patel@yahoo.com");
        selectByVisibleTextFromDropDown(By.id("BillingNewAddress_CountryId"),"United Kingdom");
        driver.findElement(By.xpath("//*[@id='BillingNewAddress_CountryId']")).sendKeys("London");
        driver.findElement(By.xpath("//*[@id='BillingNewAddress_City']")).sendKeys("slough");
        driver.findElement(By.xpath("//*[@id='BillingNewAddress_Address1']")).sendKeys("22, AltonRoad Road");
        driver.findElement(By.xpath("//*[@id='BillingNewAddress_ZipPostalCode']")).sendKeys("sl0 7uj");
        driver.findElement(By.xpath("//*[@id='BillingNewAddress_PhoneNumber']")).sendKeys("07950209041");

        //2.23 Click on “CONTINUE”
        clickOnElement(By.xpath("//*[@id='billing-buttons-container']/button[2]"));

        //2.24 Click on Radio Button “Next Day Air($0.00)”
        clickOnElement(By.xpath("//*[@id='shippingoption_1']"));

        //2.25 click on continue
        clickOnElement(By.xpath("//*[@id='shipping-method-buttons-container']/button"));

        //2.26 Select Radio Button “Credit Card”
        clickOnElement(By.xpath("//*[@id='paymentmethod_1']"));
        clickOnElement(By.cssSelector("#payment-method-buttons-container > button"));

        //2.27 Select “Master card” From Select credit card dropdown
        clickOnElement(By.cssSelector("[class='dropdownlists'] :nth-of-type(2)"));

        //2.28 Fill all the details
        driver.findElement(By.xpath("//*[@id='CardholderName']")).sendKeys("Pooja Patel");
        driver.findElement(By.xpath("//*[@id='CardNumber']")).sendKeys("374245455400126");
        driver.findElement(By.xpath("//*[@id='ExpireMonth']")).sendKeys("05");
        driver.findElement(By.xpath("//*[@id=\"ExpireYear\"]")).sendKeys("2026");
        driver.findElement(By.xpath("//*[@id='CardCode']")).sendKeys("901");
        driver.findElement(By.xpath("//*[@id='payment-info-buttons-container']/button")).click();

        // Step 2.29: Click on “CONTINUE”
        clickOnElement(By.cssSelector("#confirm-order-buttons-container > button"));

        // Step 2.30: Verify “Payment Method” is “Credit Card”
        SoftAssert softAssertPayment = new SoftAssert();
        WebElement paymentMethodText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='payment-method']/span[@class='value']")));
        assert paymentMethodText.getText().equals("Credit Card") : "Payment Method is not Credit Card";

        // Step 2.32: Verify “Shipping Method” is “Next Day Air”
        SoftAssert softAssertShipping = new SoftAssert();
        WebElement shippingMethodText = driver.findElement(By.xpath("//li[@class='shipping-method']/span[@class='value']"));
        assert shippingMethodText.getText().equals("Next Day Air") : "Shipping Method is not Next Day Air";

        // Step 2.33: Verify Total is “$2,950.00”
        /*SoftAssert softAssertOrderTotal = new SoftAssert();
        WebElement orderTotalAmount = driver.findElement(By.xpath("//span[@class='value-summary']//strong"));
        assert orderTotalAmount.getText().equals("$2,950.00") : "Order total is not $2,950.00";*/

        // Step 2.35: Verify the Text “Thank You”
        SoftAssert softAssertThankYou = new SoftAssert();
        WebElement thankYouText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Thank you']")));
        assert thankYouText.isDisplayed() : "Thank You text is not displayed";

        // Step 2.36: Verify the message “Your order has been successfully processed!”
        SoftAssert softAssertOrderSuccess = new SoftAssert();
        WebElement orderSuccessMessage = driver.findElement(By.xpath("//strong[text()='Your order has been successfully processed!']"));
        assert orderSuccessMessage.isDisplayed() : "Order success message is not displayed";

        // Step 2.37: Click on “CONTINUE”
        clickOnElement(By.xpath("//*[@id='main']/div/div/div/div[2]/div/div[3]/button"));

        // Step 2.38: Verify the text “Welcome to our store”
        SoftAssert softAssertOurStore = new SoftAssert();
        WebElement welcomeToStoreText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Welcome to our store']")));
        assert welcomeToStoreText.isDisplayed() : "Welcome to our store text is not displayed";

    }
}

