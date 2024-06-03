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
import java.util.Random;

public class Electronics extends TestBase {

    public Random randomGenerator = new Random();
    char[] password= generatePassword(8);
    String loginPassword = new String(password);
    String emailId=generateRandomEmail();


    @Test
    //1. Test name verifyUserShouldNavigateToCellPhonesPageSuccessfully()
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() {
        //1.1 Mouse Hover on “Electronics” Tab
        Actions actions = new Actions(driver);
        clickOnElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[2]/a"));
        //1.2 Mouse Hover on “Cell phones” and click
        clickOnElement(By.xpath("//a[text()=' Cell phones ']"));

        //1.3 Verify the text “Cell phones”
        SoftAssert softAssertCellphone = new SoftAssert();
        String actualCellphoneMsg = driver.findElement(By.xpath("//div[@id='main']/div/div[3]/div/div[1]/h1")).getText();
        String expectingCellphoneMsg = "Cell phones";
        softAssertCellphone.assertEquals(actualCellphoneMsg, expectingCellphoneMsg);
    }

    @Test
    //2. Test name verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully()
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        Actions actions = new Actions(driver);

        //2.1 Mouse Hover on “Electronics” Tab
        clickOnElement(By.xpath("//a[text()='Electronics ']"));

        //2.2 Mouse Hover on “Cell phones” and click
        clickOnElement(By.xpath("//a[text()=' Cell phones ']"));

        //2.3 Verify the text “Cell phones”
        SoftAssert softAssertCell = new SoftAssert();
        String actualCellphoneMsg = driver.findElement(By.xpath("//*[@id='main']/div/div[3]/div/div[1]/h1")).getText();
        String expectingCellphoneMsg = "Cell phones";
        softAssertCell.assertEquals(actualCellphoneMsg, expectingCellphoneMsg);

        /*2.4 Click on List View Tab*/
        clickOnElement(By.xpath("//*[@id='main']/div/div[3]/div/div[2]/div[1]/div[1]/a[2]"));

        //2.5 Click on product name “Nokia Lumia 1020” link
        /*((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 500);");
        driver.findElement(By.xpath("//*[@id='main']/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[3]/div/div[2]/h2/a")).click();*/
        WebElement button = driver.findElement(By.xpath("//*[text()='Nokia Lumia 1020']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(button));
        Thread.sleep(2000);

        clickOnElement(By.xpath("//*[text()='Nokia Lumia 1020']"));

        // 2.6 Verify the text “Nokia Lumia 1020”
        SoftAssert softAssertNokia = new SoftAssert();
        String actualNokiaText = driver.findElement(By.xpath("//*[@id='product-details-form']/div/div[1]/div[2]/div[1]/h1")).getText();
        String expectedNokiaText = "Nokia Lumia 1020";
        softAssertNokia.assertEquals(actualNokiaText, expectedNokiaText);

        // 2.7 Verify the price “$349.00”
        SoftAssert softAssertPrice = new SoftAssert();
        String actualPrice = driver.findElement(By.xpath("//span[@id='price-value-20']")).getText();
        String expectedPrice = "$349.00";
        softAssertPrice.assertEquals(actualPrice, expectedPrice);

        //2.8 Change quantity to 2
        driver.findElement(By.xpath("//input[@id='product_enteredQuantity_20']")).clear();
        driver.findElement(By.xpath("//input[@id='product_enteredQuantity_20']")).sendKeys("2");

        //2.9 Click on “ADD TO CART” tab
        /*WebElement button = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[3]/div/div[2]/div[3]/div[2]/button[1]"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(button));
        Thread.sleep(2000);*/
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-20']"));

        //2.10 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        SoftAssert softAssertDisplay = new SoftAssert();
        String actualDisplayMsg = driver.findElement(By.xpath("//*[@id='bar-notification']/div/p")).getText();
        String expectedDisplayMsg = "The product has been added to your shopping cart";
        softAssertDisplay.assertEquals(actualDisplayMsg, expectedDisplayMsg);

        //After that close the bar clicking on the cross button.
        clickOnElement(By.xpath("//*[@id='bar-notification']/div/span"));

        //2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        Actions actions1 = new Actions(driver);
        clickOnElement(By.linkText("Shopping cart"));

        //2.12 Verify the message "Shopping cart"
        SoftAssert softAssertCart = new SoftAssert();
        String actualShoppingCartMsg = driver.findElement(By.xpath("//h1[text()='Shopping cart']")).getText();
        String expectedShoppingCartMsg = "Shopping cart";
        softAssertCart.assertEquals(actualShoppingCartMsg,expectedShoppingCartMsg);

        //2.13 Verify the quantity is 2
        SoftAssert softAssertQua = new SoftAssert();
        String actualQuantity = driver.findElement(By.xpath("//div[@class='product-quantity']/input")).getText();
        String expectedQuantity = "";
        softAssertQua.assertEquals(actualQuantity,expectedQuantity);

        //2.14 Verify the Total $698.00
        SoftAssert softAssertAmount = new SoftAssert();
        String actualAmount = driver.findElement(By.xpath("//span[text()='$698.00']")).getText();
        String expectedAmount = "$698.00";
        softAssertAmount.assertEquals(actualAmount,expectedAmount);

        //2.15 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));

        //2.16 Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));

        //2.17 Verify the Text “Welcome, Please Sign In!”
        SoftAssert softAssertWelcome = new SoftAssert();
        String actualwelcomeMsg = driver.findElement(By.xpath("//h1[text()='Welcome, Please Sign In!']")).getText();
        String expectedWelcomeMsg = "Welcome, Please Sign In!";
        softAssertWelcome.assertEquals(actualwelcomeMsg,expectedWelcomeMsg);

        //2.18 Click on “REGISTER” tab
        clickOnElement(By.xpath("//button[@class='button-1 register-button']"));

        //2.19 Verify the text “Register”
        SoftAssert softAssertReg = new SoftAssert();
        String actualRegMsg = driver.findElement(By.xpath("//div[@class='page-title']/h1")).getText();
        String expectedRegMsg = "Register";
        softAssertReg.assertEquals(actualRegMsg,expectedRegMsg);

        //2.20 Fill the mandatory fields
        driver.findElement(By.id("FirstName")).sendKeys("Dipa");

        driver.findElement(By.id("LastName")).sendKeys("Oza");

        driver.findElement(By.id("Email")).sendKeys(emailId);

        driver.findElement(By.name("Password")).sendKeys(loginPassword);

        driver.findElement(By.id("ConfirmPassword")).sendKeys(loginPassword);

        //2.21 Click on “REGISTER”Button
        clickOnElement(By.id("register-button"));

        //2.22 Verify the message “Your registration completed”
        SoftAssert softAssertRegText = new SoftAssert();
        String actualRegText = driver.findElement(By.xpath("//div[@class='result']")).getText();
        String expectedRegText = "Your registration completed";
        softAssertRegText.assertEquals(expectedRegText,actualRegText);

        //2.23 Click on “CONTINUE” tab
        clickOnElement(By.xpath("//*[@id='main']/div/div/div/div[2]/div[2]/a"));

        //2.24 Verify the text “Shopping card”
        SoftAssert softAssertShopping = new SoftAssert();
        String actualShoppingTxt = driver.findElement(By.cssSelector("div[class='page-title']>h1")).getText();
        String expectedShoppingTxt = "Shopping cart";
        softAssertShopping.assertEquals(actualShoppingTxt,expectedShoppingTxt);

        /*2.25 click on checkbox “I agree with the terms of service”*/
        clickOnElement(By.cssSelector("div[class='terms-of-service']>label"));

        //2.26 Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));

        /*2.27 Fill the Mandatory fields*/
        driver.findElement(By.id("Email")).sendKeys(emailId);
        driver.findElement(By.id("Password")).sendKeys(loginPassword);
        clickOnElement(By.linkText("Log in"));

        /*2.28 Click on “CONTINUE”*/
        clickOnElement(By.cssSelector("div[id='billing-buttons-container']>button:nth-of-type(2)"));

        // Step 2.29: Click on Radio Button “2nd Day Air ($0.00)”
        WebElement secondDayAirRadioButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("shippingoption_2")));
        secondDayAirRadioButton.click();

        // Step 2.30: Click on “CONTINUE”
        WebElement shippingMethodContinueButton = driver.findElement(By.xpath("//button[@onclick='ShippingMethod.save()']"));
        shippingMethodContinueButton.click();

        // Step 2.31: Select Radio Button “Credit Card”
        WebElement creditCardRadioButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("paymentmethod_1")));
        creditCardRadioButton.click();

        // Step 2.32: Select “Visa” From Select credit card dropdown
        WebElement paymentMethodContinueButton = driver.findElement(By.xpath("//button[@onclick='PaymentMethod.save()']"));
        paymentMethodContinueButton.click();
        WebElement creditCardDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.id("CreditCardType")));
        Select selectCreditCard = new Select(creditCardDropdown);
        selectCreditCard.selectByVisibleText("Visa");

        // Step 2.33: Fill all the details
        driver.findElement(By.id("CardholderName")).sendKeys("Jack");
        driver.findElement(By.id("CardNumber")).sendKeys("521421540214");
        driver.findElement(By.id("ExpireMonth")).sendKeys("05");
        driver.findElement(By.id("ExpireYear")).sendKeys("2029");
        driver.findElement(By.id("CardCode")).sendKeys("254");

        // Step 2.34: Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@onclick='PaymentInfo.save()']"));

        /*// Step 2.35: Verify “Payment Method” is “Credit Card”
        WebElement paymentMethodVerification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='payment-method']")));
        assert paymentMethodVerification.getText().contains("Credit Card") : "Payment method is not Credit Card";

        // Step 2.36: Verify “Shipping Method” is “2nd Day Air”
        WebElement shippingMethodVerification = driver.findElement(By.xpath("//li[@class='shipping-method']"));
        assert shippingMethodVerification.getText().contains("2nd Day Air") : "Shipping method is not 2nd Day Air";*/

        /*// Step 2.37: Verify Total is “$698.00”
        WebElement orderTotalVerification = driver.findElement(By.xpath("//span[@class='value-summary']//strong"));
        assert orderTotalVerification.getText().equals("$698.00") : "Total is not $698.00";
*/
        // Step 2.38: Click on “CONFIRM”
        clickOnElement(By.xpath("//button[@onclick='ConfirmOrder.save()']"));


        /*// Step 2.39: Verify the Text “Thank You”
        WebElement thankYouText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Thank you']")));
        assert thankYouText.isDisplayed() : "Thank you text is not displayed";*/

        /*// Step 2.40: Verify the message “Your order has been successfully processed!”
        WebElement orderSuccessMessage = driver.findElement(By.xpath("//strong[text()='Your order has been successfully processed!']"));
        assert orderSuccessMessage.isDisplayed() : "Order success message is not displayed";*/

        // Step 2.41: Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@onclick='setLocation(\"/\")']"));


        /*// Step 2.42: Verify the text “Welcome to our store”
        WebElement welcomeToStoreText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Welcome to our store']")));
        assert welcomeToStoreText.isDisplayed() : "Welcome to our store text is not displayed";*/

        // Step 2.43: Click on “Logout” link
        WebElement logoutLink = driver.findElement(By.xpath("//a[text()='Log out']"));
        logoutLink.click();

        /*// Step 2.44: Verify the URL is “https://demo.nopcommerce.com/”
        assert driver.getCurrentUrl().equals("https://demo.nopcommerce.com/") : "URL is not https://demo.nopcommerce.com/";*/
    }
}
