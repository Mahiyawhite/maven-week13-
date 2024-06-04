package com.tutorialninja.testsuite;

import com.tutorialninja.testbase.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TopMenuTest extends TestBase {

    public void selectMenu(String menu){
        driver.findElement(By.xpath("//a[text()='Show AllDesktops']")).getText();
        driver.findElement(By.xpath("//a[text()='Show AllLaptops & Notebooks']")).getText();
        driver.findElement(By.xpath("//a[text()='Show AllComponents']")).getText();
    }
    // 1. verifyUserShouldNavigateToDesktopsPageSuccessfully()
    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {

        // 1.1 Mouse hover on “Desktops” Tab and click
        Actions actions = new Actions(driver);
        WebElement desktopsTab = driver.findElement(By.xpath("//a[text()='Desktops']"));
        actions.moveToElement(desktopsTab).click().perform();

        // 1.2 call selectMenu method and pass the menu = “Show All Desktops”
        selectMenu("Show All Desktops");
        clickOnElement(By.xpath("//a[text()='Show AllDesktops']"));

        // 1.3 Verify the text ‘Desktops’
        WebElement desktopsHeaderText = driver.findElement(By.xpath("//div[@id='content']/h2"));
        Assert.assertTrue(desktopsHeaderText.isDisplayed());
    }

    // 2. verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully()
    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {

        // 2.1 Mouse hover on “Laptops & Notebooks” Tab and click
        Actions actions = new Actions(driver);
        WebElement laptopsAndNotebooksTab = driver.findElement(By.xpath("//a[contains(text(),'Laptops & Notebooks')]"));
        actions.moveToElement(laptopsAndNotebooksTab).click().perform();

        // 2.2 call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
        selectMenu("Show All Laptops & Notebooks");
        clickOnElement(By.xpath("//a[text()='Show AllLaptops & Notebooks']"));

        // 2.3 Verify the text ‘Laptops & Notebooks’
        WebElement laptopsAndNotebooksHeaderText = driver.findElement(By.xpath("//h2[contains(text(),'Laptops & Notebooks')]"));
        Assert.assertTrue(laptopsAndNotebooksHeaderText.isDisplayed());
    }
    @Test (groups = { " sanity " , " smoke " } )
    //3. verifyUserShouldNavigateToComponentsPageSuccessfully()

    public void verifyUserShouldNavigateToComponentsPageSuccessfully() {

        // 3.1 Mouse hover on “Components” Tab and click
        Actions actions = new Actions(driver);
        WebElement componentsTab = driver.findElement(By.xpath("//a[contains(text(),'Components')]"));
        actions.moveToElement(componentsTab).click().perform();

        // 3.2 call selectMenu method and pass the menu = “Show All Components”
        selectMenu("Show All Components");
        clickOnElement(By.xpath("//a[text()='Show AllComponents']"));

        // 3.3 Verify the text ‘Components’
        WebElement componentsHeaderText = driver.findElement(By.xpath("//h2[contains(text(),'Components')]"));
        Assert.assertTrue(componentsHeaderText.isDisplayed());
    }

}
