package com.cvlibrary.testsuite;

import org.testng.annotations.DataProvider;

public class DataSet {

    @DataProvider(name = "JobSearchData")
    public Object[][] createData1() {

        return new Object[][] {
                { "Tester", "harrow", "5 mile", "30000", "500000", "Per annum", "Permanent"},

        };
    }

}
