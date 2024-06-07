package com.parabank.testbase;

import com.parabank.propertyreader.PropertyReader;
import com.parabank.utility.Utility;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase extends Utility {

    public String browser = PropertyReader.getInstance().getProperty("browser");

    @BeforeMethod(alwaysRun = true)
    public void setupTest() {
        selectBrowser(browser);
    }
    @AfterMethod
    public void tearDown(){
        // closeBrowser();
    }
}
