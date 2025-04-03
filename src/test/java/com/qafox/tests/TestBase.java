package com.qafox.tests;

import com.qafox.drivers.DriverManager;
import com.qafox.utils.BrowserActions;
import com.qafox.utils.JsonUtil;
import com.qafox.utils.PropertiesUtil;
import org.testng.annotations.*;

public class TestBase {
    //variables
    JsonUtil testData;
    //configurations
    @BeforeSuite(alwaysRun = true)
    public void beforeClass() {
        testData = new JsonUtil("test-data");
        DriverManager.createInstance("edge");
        PropertiesUtil.loadProperties();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {

        if (DriverManager.getDriver() != null) {
            BrowserActions.closeBrowser(DriverManager.getDriver());
            // CustomSoftAssertion.customAssertAll();
        }
    }
    @AfterMethod
    public void afterEachTest() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
