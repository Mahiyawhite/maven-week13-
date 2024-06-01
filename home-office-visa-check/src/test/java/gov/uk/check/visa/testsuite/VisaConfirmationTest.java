package gov.uk.check.visa.testsuite;

import gov.uk.check.visa.testbase.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VisaConfirmationTest extends TestBase {

    @Test (groups = { " smoke " , " sanity " , " regression "})
    public void anAustralianComingToUKForTourism(){
        /*Click on start button*/
        clickOnElement(By.xpath("//*[@id='content']/div[2]/div[1]/article/section[1]/a"));
        /*/*Select a Nationality 'Australia'*/
        WebElement nationalityDropdown = driver.findElement(By.cssSelector("select[id='response']"));
        nationalityDropdown.sendKeys("Australia");
        /*Click on Continue button*/
        clickOnElement(By.xpath("//*[@id='current-question']/button"));
        /*Select reason 'Tourism'*/
        clickOnElement(By.cssSelector("input[id='response-0']"));
        /*Click on Continue button*/
        clickOnElement(By.xpath("//*[@id='current-question']/button"));

        /*verify result 'You will not need a visa to come to the UK'*/
        String actualVerificationMsg = driver.findElement(By.xpath("//*[@id='result-info']/div[2]/div/h2")).getText();
        String expectedVerificationMsg = "You will not need a visa to come to the UK";
        Assert.assertEquals(actualVerificationMsg,expectedVerificationMsg);
    }
    @Test (groups = {" regression "})
    public void aChileanComingToTheUKForWorkAndPlansOnStayingForLongerThanSixMonths(){
        /*Click on start button*/
        clickOnElement(By.xpath("//*[@id='content']/div[2]/div[1]/article/section[1]/a"));
        /*Select a Nationality 'Chile'*/
        WebElement nationalityDropdown = driver.findElement(By.cssSelector("select[id='response']"));
        nationalityDropdown.sendKeys("chile");
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
        String actualNeedVisaMsg = driver.findElement(By.xpath("//*[@id='result-info']/div[2]/div/h2")).getText();
        String expectedNeedVisaMsg = "You need a visa to work in health and care";
        Assert.assertEquals(actualNeedVisaMsg,expectedNeedVisaMsg);
    }
    @Test (groups = {" sanity " , " regression " })
    public void aColumbianNationalComingToTheUKToJoinAPartnerForALongStayTheyDoHaveAnArticle10Or20Card(){
        /*Click on start button*/
        clickOnElement(By.xpath("//*[@id='content']/div[2]/div[1]/article/section[1]/a"));
        /*Select a Nationality 'Colombia'*/
        WebElement nationalityDropdown = driver.findElement(By.cssSelector("select[id='response']"));
        nationalityDropdown.sendKeys("Colombia");
        /*Click on Continue button*/
        clickOnElement(By.xpath("//*[@id='current-question']/button"));
        /*Select reason 'Join partner or family for a long stay'*/
        clickOnElement(By.cssSelector("input[id='response-4']"));
        /*Click on Continue button*/
        clickOnElement(By.xpath("//*[@id='current-question']/button"));

        /*verify result 'You’ll need a visa to join your family or partner in the UK'*/
        String actualVisaMsg = driver.findElement(By.xpath("//*[@id='result-info']/div[2]/div/h2")).getText();
        String expectedVisaMsg = "You may need a visa";
        Assert.assertEquals(actualVisaMsg,expectedVisaMsg);
    }

}
