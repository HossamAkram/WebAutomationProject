package com.qafox.tests;

import com.qafox.drivers.DriverManager;
import com.qafox.utils.BrowserActions;
import com.qafox.utils.JsonUtil;
import com.qafox.utils.PropertiesUtil;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class TestBase {
    //variables
    JsonUtil testData;
    //configurations
    @BeforeClass
    public void beforeClass() {
        testData = new JsonUtil("test-data");
        DriverManager.createInstance("edge");
        PropertiesUtil.loadProperties();
    }

    @AfterClass
    public void tearDown() {

        if (DriverManager.getDriver() != null) {
            BrowserActions.closeBrowser(DriverManager.getDriver());
            // CustomSoftAssertion.CustomAssertAll();
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
