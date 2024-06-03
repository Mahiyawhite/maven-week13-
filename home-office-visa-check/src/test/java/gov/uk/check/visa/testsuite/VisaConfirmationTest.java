package gov.uk.check.visa.testsuite;

import gov.uk.check.visa.pages.Page;
import gov.uk.check.visa.testbase.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class VisaConfirmationTest extends TestBase {

    Page page = new Page();

    @Test (groups = { " smoke " , " sanity " , " regression "})
    public void anAustralianComingToUKForTourism(){


        //cookies
        clickOnElement(By.xpath("//button[@class='gem-c-button govuk-button']"));

        //Click on start button
        page.clickStartNow(By.xpath("//*[@id='content']/div[2]/div[1]/article/section[1]/a"));
        //Select a Nationality 'Australia'
        page.selectNationality(By.id("response"),"Australia");
        //Click on Continue button
        clickOnElement(By.xpath("//*[@id='current-question']/button"));
        //Select reason 'Tourism'
        clickOnElement(By.cssSelector("input[id='response-0']"));
        //Click on Continue button
        clickOnElement(By.xpath("//*[@id='current-question']/button"));

        //verify result 'You will not need a visa to come to the UK'
        SoftAssert softAssertVerificationMsg = new SoftAssert();
        String actualVerificationMsg = driver.findElement(By.xpath("//*[@id='result-info']/div[2]/div/h2")).getText();
        String expectedVerificationMsg = "You will not need a visa to come to the UK";
        softAssertVerificationMsg.assertEquals(actualVerificationMsg,expectedVerificationMsg);

    }
    @Test (groups = {" regression "})
    public void aChileanComingToTheUKForWorkAndPlansOnStayingForLongerThanSixMonths(){

        //cookies
        clickOnElement(By.xpath("//button[@class='gem-c-button govuk-button']"));

        /*Click on start button*/
        page.clickStartNow(By.xpath("//*[@id='content']/div[2]/div[1]/article/section[1]/a"));
        /*Select a Nationality 'Chile'*/
        page.selectNationality(By.id("response"),"Chile");
        /*Click on Continue button*/
        clickOnElement(By.xpath("//*[@id='current-question']/button"));
        /*Select reason 'Work, academic visit or business'*/
        clickOnElement(By.cssSelector("input[id='response-1']"));
        /*Click on Continue button*/
        clickOnElement(By.xpath("//*[@id='current-question']/button"));
        /*Select intendent to stay for 'longer than 6 months'*/
        clickOnElement(By.cssSelector("input[id='response-1']"));
        /*Click on Continue button*/
        clickOnElement(By.xpath("//*[@id='current-question']/button"));
        /*Select have planning to work for 'Health and care professional'*/
        clickOnElement(By.id("response-0"));
        /*Click on Continue button*/
        clickOnElement(By.xpath("//*[@id='current-question']/button"));

        /*verify result 'You need a visa to work in health and care'*/
        SoftAssert needVisaMsg = new SoftAssert();
        String actualNeedVisaMsg = driver.findElement(By.xpath("//*[@id='result-info']/div[2]/div/h2")).getText();
        String expectedNeedVisaMsg = "You need a visa to work in health and care";
        needVisaMsg.assertEquals(actualNeedVisaMsg,expectedNeedVisaMsg);
    }
    @Test (groups = {" sanity " , " regression " })
    public void aColumbianNationalComingToTheUKToJoinAPartnerForALongStayTheyDoHaveAnArticle10Or20Card(){

        //cookies
        clickOnElement(By.xpath("//button[@class='gem-c-button govuk-button']"));

        /*Click on start button*/
        page.clickStartNow(By.xpath("//*[@id='content']/div[2]/div[1]/article/section[1]/a"));
        /*Select a Nationality 'Colombia'*/
        page.selectNationality(By.id("response"),"Colombia");
        /*Click on Continue button*/
        clickOnElement(By.xpath("//*[@id='current-question']/button"));
        /*Select reason 'Join partner or family for a long stay'*/
        clickOnElement(By.cssSelector("input[id='response-4']"));
        /*Click on Continue button*/
        clickOnElement(By.xpath("//*[@id='current-question']/button"));

        /*verify result 'You’ll need a visa to join your family or partner in the UK'*/
        SoftAssert softAssertVisaMsg = new SoftAssert();
        String actualVisaMsg = driver.findElement(By.xpath("//*[@id='result-info']/div[2]/div/h2")).getText();
        String expectedVisaMsg = "You may need a visa";
        softAssertVisaMsg.assertEquals(actualVisaMsg,expectedVisaMsg);
    }

}
