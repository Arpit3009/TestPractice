package org.example;

import org.testng.annotations.DataProvider;

public class DataProviderStatic {

    @DataProvider
    public static Object[][] gg(){
        return new Object[][]{{5,6}, {5,8}};
    }
}
