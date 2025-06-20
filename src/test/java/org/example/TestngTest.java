package org.example;

import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import static org.testng.AssertJUnit.assertTrue;
//@Ignore
public class TestngTest {

    @Test(priority = 0, enabled = true, timeOut = 10000)
    @Parameters({"a", "b"})
    public void firstTest(String at, @Optional("hj") String bt){
        System.out.println("first test");
        System.out.println(at);
        System.out.println(bt);

    }

//    @Ignore
    @Test(priority = 1, groups = {"sanity", "smoke"})
    public void afirstTestb(){
        System.out.println("afirstb test");
//        assertTrue(false);
//        SoftAssert sa = new SoftAssert();
    }

    @Test(priority = 0, dependsOnGroups = {"sanity"})
    public void afirstTesta(){
        System.out.println("afirsta test");
    }


    @Test(dataProvider = "giveData2")
    public void testDataProvider(String s){
        System.out.println(s);
    }

    @DataProvider(name = "giveData2", parallel = true)
    public Object[][] giveData(){
        return new Object[][]{{"2"}, {"5"}, {"h"}, {"jh"}};
    }

    @Test(dataProvider = "gg", dataProviderClass = DataProviderStatic.class)
    public void testDataProviderStatic(int s, int u){
        System.out.println(s+u);
    }
}
