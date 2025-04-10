package com.qafox.tests;

import com.qafox.drivers.DriverManager;
import com.qafox.utils.BrowserActions;
import com.qafox.utils.CustomSoftAssertion;
import com.qafox.utils.JsonUtil;
import com.qafox.utils.PropertiesUtil;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class TestBase {
    //variables
    JsonUtil testData;
    //configurations
    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        DriverManager.createInstance("edge");
    }
    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        testData = new JsonUtil("test-data");
        PropertiesUtil.loadProperties();
    }


    @AfterSuite(alwaysRun = true)
    public void tearDown() {

        if (DriverManager.getDriver() != null) {
            BrowserActions.closeBrowser(DriverManager.getDriver());
        }
    }
    @AfterMethod
    public void afterEachTest(ITestResult result) {
        CustomSoftAssertion.customAssertAll(result);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
