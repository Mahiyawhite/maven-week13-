package com.tutorialninja.pages;

import com.tutorialninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class HomePage extends Utility {
    WebDriver driver;
    By desktopsTabs = By.linkText("Desktops");
    By laptopsAndNotebooksTab = By.linkText("Laptops & Notebooks");
    By myAccountLink = By.linkText("My Account");

public void mouseHoverAndClick(By by) {
    Actions actions = new Actions(driver);
    actions.moveToElement(driver.findElement(by)).click().perform();
    }
    public void selectMenu(String menu) {
        driver.findElement(By.linkText(menu)).click();
    }

    public void clickMyAccount() {
        driver.findElement(myAccountLink).click();
    }

}
