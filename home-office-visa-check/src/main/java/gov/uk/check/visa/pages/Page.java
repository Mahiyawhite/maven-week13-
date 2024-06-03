package gov.uk.check.visa.pages;

import gov.uk.check.visa.driverfactory.ManageDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Page extends ManageDriver {

    //StartPage
    public void clickStartNow(By by) {
        WebElement clickStart = driver.findElement(by);
        clickStart.click();
    }

    //DurationOfStayPage
    public void DurationOfStayPage(WebDriver driver) {
        ManageDriver.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectLengthOfStay(String moreOrLess) {
        switch (moreOrLess.toLowerCase()) {
            case "less Then Six Month":
                break;
            case "more Then Six Month":
                break;
            default:
        }
    }

    public void clickNextStepButton() {

    }

    //FamilyImmigrationStatusPage
    public void selectImmigrationStatus(String status) {
    }

    //ReasonForTravelPage
    public void selectReasonForVisit(String reason) {
    }

    //ResultPage
    public void getResultMessage() {

    }

    public void confirmResultMessage(String expectedMessage) {
        WebElement resultMessage = driver.findElement(By.id(expectedMessage));
        resultMessage.click();
    }

    //SelectNationalityPage
    public void selectNationality(By by, String nationality) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByVisibleText(nationality);
        }

        //WorkTypePage extends Utility
    public void selectJobType(By by) {
        WebElement jobType = driver.findElement(by);
        jobType.click();
    }

}



