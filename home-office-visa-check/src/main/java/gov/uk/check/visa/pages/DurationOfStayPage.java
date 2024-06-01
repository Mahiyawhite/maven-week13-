package gov.uk.check.visa.pages;

import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class DurationOfStayPage extends Utility {

    public DurationOfStayPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectLengthOfStay(String moreOrLess){
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
}
