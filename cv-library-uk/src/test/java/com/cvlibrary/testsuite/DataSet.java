package com.cvlibrary.testsuite;

import com.cvlibrary.testbase.TestBase;
import org.testng.annotations.DataProvider;

public class DataSet extends TestBase {

    @DataProvider(name = "jobSearchData")
    public Object[][] createData1() {

        return new Object[][]{
                {"Tester", "Harrow, Greater London", "5 mile", "30000", "500000", "Per annum", "Permanent","Permanent Tester jobs in Harrow"},
                {"Bank Manager", "Wembley, Greater London", "10 mile", "20000", "300000", "per month", "contract", "contract Bank Manager jobs in Wembley"},
                {"Quality Assurance", "Ealing, Greater London", "5 mile", "10000", "250000", "per week", "part time", "part time Quality Assurance jobs in ealing"},
                {"Customer Assistant", "Greenford, Greater London", "2 mile", "12000", "220000", "per day", "temporary", "temporary Customer Assistant jobs in Greenford"},
                {"Environmental Officer", "Edgware, Greater London", "1 mile", "15000", "200000", "per hour", "apprenticeship", "apprenticeship Environmental Officer jobs in Edgware"}
        };
    }

}





