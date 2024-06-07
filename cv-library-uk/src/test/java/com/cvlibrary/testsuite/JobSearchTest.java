package com.cvlibrary.testsuite;

import com.cvlibrary.pages.HomePage;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class JobSearchTest extends DataSet {

        HomePage homePage = new HomePage(driver);


    @Test(dataProvider = "jobSearchData", dataProviderClass = JobSearchTest.class)
    public void verifyJobSearchResultUsingDifferentDataSet(String jobTitle,
                                                           String location,
                                                           String distance,
                                                           String salaryMin,
                                                           String salaryMax,
                                                           String salaryType,
                                                           String jobType,
                                                           String result) {


        driver.switchTo().frame("gdpr-consent-notice");
        driver.findElement(By.xpath("//span[text()='Accept All']")).click();
        driver.switchTo().defaultContent();

        homePage.enterJobTitle(jobTitle);
        homePage.enterLocation(location);
        homePage.selectDistance(distance);
        homePage.clickMoreSearchOptions();
        homePage.enterSalaryMin(salaryMin);
        homePage.enterSalaryMax(salaryMax);
        homePage.selectSalaryType(salaryType);
        homePage.selectJobType(jobType);
        homePage.clickFindJobsButton();
        homePage.getResultText(result);
    }
}







