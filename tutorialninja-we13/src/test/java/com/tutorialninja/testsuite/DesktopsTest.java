package com.tutorialninja.testsuite;

import com.tutorialninja.testbase.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Test
public class DesktopsTest extends TestBase {

    /*Write the following Test:
       1.Test name verifyProductArrangeInAlphaBaticalOrder()*/

    public void verifyProductArrangeInAlphaBaticalOrder() throws InterruptedException {

        // 1.1 Mouse hover on Desktops Tab.and click
        mouseHoverToElementAndClick(By.xpath("//a[text()='Desktops']"));

        // 1.2 Click on “Show All Desktops”
        selectMenu("Show All Desktops");
        clickOnElement(By.xpath("//a[text()='Show AllDesktops']"));

        // 1.3 Select Sort By position "Name: Z to A"

        WebElement dropDown = driver.findElement(By.id("input-sort"));
        Select select = new Select(dropDown);
        dropDown.findElement(By.xpath("//select[@id='input-sort']/option[3]")).click();

        Thread.sleep(3000);
        // 1.4 Verify the Product will arrange in Descending order.
        /*List<WebElement> productList = driver.findElements(By.cssSelector(".product-thumb .caption a"));
        List<String> productNames = new ArrayList<>();

        for (WebElement product : productList) {
            productNames.add(product.getText());
        }
        List<String> sortedProductNames = new ArrayList<>(productNames);
        Collections.sort(sortedProductNames, Collections.reverseOrder());

        Assert.assertEquals("Products are not sorted in descending order", productNames, sortedProductNames);*/
    }

    // 2. Test name verifyProductAddedToShoppingCartSuccessFully()
    @Test (groups = { " regression " } )
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {

        // 2.1 Mouse hover on Desktops Tab. and click
        Actions actions = new Actions(driver);
        WebElement desktopTab = driver.findElement(By.xpath("//a[text()='Desktops']"));
        actions.moveToElement(desktopTab).click().perform();

        // 2.2 Click on “Show All Desktops”
        selectMenu("Show All Desktops");
        clickOnElement(By.xpath("//a[text()='Show AllDesktops']"));

        //2.3 Select Sort By position "Name: A to Z"
        WebElement dropDown = driver.findElement(By.id("input-sort"));
        Select select = new Select(dropDown);
        clickOnElement(By.xpath("//select[@id='input-sort']/option[2]"));

        // 2.4 Select product “HP LP3065”
        clickOnElement(By.linkText("HP LP3065"));

        // 2.5 Verify the Text "HP LP3065"
        SoftAssert softAssertHpText = new SoftAssert();
        String actualHpText = driver.findElement(By.linkText("HP LP3065")).getText();
        String expectedHpText = "HP LP3065";
        softAssertHpText.assertEquals(expectedHpText, actualHpText);

        // 2.6 Select Delivery Date "2022-11-30"
        driver.findElement(By.id("input-option225")).clear();
        driver.findElement(By.id("input-option225")).sendKeys("2022-11-30");

        // 2.7.Enter Qty "1” using Select class.
        driver.findElement(By.xpath("//input[@id='input-quantity']")).clear();
        driver.findElement(By.xpath("//input[@id='input-quantity']")).sendKeys("1");

        //2.8 Click on “Add to Cart” button
        clickOnElement(By.id("button-cart"));

        // 2.9 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
        SoftAssert softAssertDisplayMsg = new SoftAssert();
        String actualDisplayMsg = driver.findElement(By.xpath("//div[@id='product-product']/div[1]")).getText();
        System.out.println(actualDisplayMsg);
        String expectingDisplayMsg = "Success: You have added HP LP3065 to your shopping cart!\n" + "x";
        softAssertDisplayMsg.assertEquals(actualDisplayMsg,expectingDisplayMsg);

        // 2.10 Click on link “shopping cart” display into success message
        clickOnElement(By.linkText("Shopping Cart"));

        // 2.11 Verify the text "Shopping Cart"
        SoftAssert softAssertCratMsg = new SoftAssert();
        String actualCartMsg = driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
        String expectedCartMsg = "Shopping Cart  (1.00kg)";
        softAssertCratMsg.assertEquals(actualCartMsg, expectedCartMsg);

        // 2.12 Verify the Product name "HP LP3065"
        SoftAssert softAssertProductName = new SoftAssert();
        String actualName = driver.findElement(By.xpath("//*[@id='content']/form/div/table/tbody/tr/td[2]/a")).getText();
        String expectingName = "HP LP3065";
        softAssertProductName.assertEquals(actualName, expectingName);

        //2.13 Verify the Delivery Date "2022-11-30"
        SoftAssert softAssertDeliveryDate = new SoftAssert();
        String actualDeliveryDate = driver.findElement(By.xpath("//small[text()='Delivery Date:2022-11-30']")).getText();
        String expectedDeliveryDate = "Delivery Date:2022-11-30";
        softAssertDeliveryDate.assertEquals(actualDeliveryDate, expectedDeliveryDate);

        //2.14 Verify the Model "Product21"
        SoftAssert softAssertModel = new SoftAssert();
        String actualModel = driver.findElement(By.xpath("//td[text()='Product 21']")).getText();
        String expectedModel = "Product 21";
        softAssertModel.assertEquals(actualModel, expectedModel);

        //2.15 Verify the Total "$122.00"
        SoftAssert softAssertTotal = new SoftAssert();
        String actualTotal = driver.findElement(By.xpath("//div[@id='content']/form/div/table/tbody/tr/td[6]")).getText();
        String expectedTotal = "$122.00";
        softAssertTotal.assertEquals(actualTotal, expectedTotal);

    }


}

