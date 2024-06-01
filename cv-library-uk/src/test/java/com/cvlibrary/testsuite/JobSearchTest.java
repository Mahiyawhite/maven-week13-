package com.cvlibrary.testsuite;

import com.cvlibrary.testbase.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class JobSearchTest extends TestBase {

    @Test(dataProvider = "JobSearchData",dataProviderClass = DataSet.class)
    public void verifyJobSearchResultUsingDifferentDataSet(String jobTitle,
                                                           String location,
                                                           String distance,
                                                           String salaryMin,
                                                           String salaryMax,
                                                           String salaryType,
                                                           String jobType,
                                                           String result){
        WebElement JobTitle = driver.findElement(By.xpath("//*[@id='keywords']"));
        JobTitle.sendKeys(jobTitle);

        WebElement Location = driver.findElement(By.xpath("//input[@id='location']"));
        Location.sendKeys(location);

        Select select = new Select(
                driver.findElement(By.xpath("//select[@id='distance']")));
        select.selectByVisibleText(distance);

        clickOnElement(By.xpath("//button[@id='toggle-hp-search']"));

        WebElement SalaryMin = driver.findElement(By.xpath("//input[@id='salarymin']"));
        SalaryMin.sendKeys(salaryMin);

        WebElement SalaryMax = driver.findElement(By.xpath("//input[@id='salarymax']"));
        SalaryMax.sendKeys(salaryMax);

        Select select1 = new Select(
                driver.findElement(By.xpath("//select[@id='salarytype']")));
        select1.selectByVisibleText(salaryType);

        Select select2 = new Select(
                driver.findElement(By.xpath("//select[@id='tempperm']")));
        select2.selectByVisibleText(jobType);

        clickOnElement(By.xpath("//input[@id='hp-search-btn']"));
    }
    /*String jobTitle*/
    /*public void verifyJobSearchResultUsingDifferentDataSet(){
    }

    public void jobTitle(String jobtitle){
        clickOnElement(By.xpath("//*[@id='keywords']"));
    }
    @Test
    public void verifyJobSearchResul(){
        jobTitle("Tester");
        driver.findElement(By.xpath("//*[@id='keywords']")).sendKeys("Tester");
    }
    /*String location*/
    /*public void location(String location){
        clickOnElement(By.xpath("//input[@id='location']"));
    }
    @Test
    public void verifyLocation(){
        location("Harrow");
        driver.findElement(By.xpath("//input[@id='location']")).sendKeys("Harrow");
    }
    /*String distance*/
    /*public void distance(String distance){
        clickOnElement(By.xpath("//select[@id='distance']"));
    }
    @Test
    public void verifyDistance(){
        distance("5 miles");
        driver.findElement(By.xpath("//select[@id='distance']")).sendKeys("5 miles");
    }
    @Test
    @Override
    public void clickOnElement(By by) {
        clickOnElement(By.xpath("//button[@id='toggle-hp-search']"));
    }
    /*String salaryMin*/
    /*public void salaryMin(String salaryMin){
        clickOnElement(By.xpath("//input[@id='salarymin']"));
    }
    @Test
    public void verifySalariMin(){
        salaryMin("30000");
        driver.findElement(By.xpath("//input[@id='salarymin']")).sendKeys("30000");
    }
    /* String salaryMax,*/
    /*public void salaryMax(String salaryMax){
        clickOnElement(By.xpath("//input[@id='salarymax']"));
    }
    @Test
    public void verifySalaryMax(){
        salaryMax("500000");
        driver.findElement(By.xpath("//input[@id='salarymax']")).sendKeys("500000");
    }
    /*String salaryType*/
    /*public void salaryType(String salaryType){
        clickOnElement(By.xpath("//select[@id='salarytype']"));
    }
    @Test
    public void verifySalaryType(){
        salaryType("per annum");
        driver.findElement(By.xpath("//select[@id='salarytype']")).sendKeys("per annum");
    }
    /*String jobType,*/
    /*public void jobType(String jobType){
        clickOnElement(By.xpath("//select[@id='tempperm']"));
    }
    @Test
    public void VerifyJobType(){
        jobType("Permanent");
        driver.findElement(By.xpath("//select[@id='tempperm']")).sendKeys("Permanent");
    }*/
}







