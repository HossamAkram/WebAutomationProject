package com.qafox.drivers;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserFactory {
    public static WebDriver getBrowser(String browserName){
        switch (browserName.toLowerCase()){
            case "chrome":
                return new ChromeDriver(getchromeOptions());
            case "firefox":
                return new FirefoxDriver(getfirefoxOptions());
            default:
                return new EdgeDriver(getedgeOptions());
        }
    }

    public static ChromeOptions getchromeOptions(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--disable-extensions");
        chromeOptions.addArguments("--disable-infobars");
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--allow-remote-origins=*");
        //<Map String , Object> prefs=
        //chromeOptions.setExperimentalOption("prefs",prefs);
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        //chromeOptions.addArguments("--headless");
        return chromeOptions;
    }
    public static FirefoxOptions getfirefoxOptions(){
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("--start-maximized");
        firefoxOptions.addArguments("--disable-extensions");
        firefoxOptions.addArguments("--disable-infobars");
        firefoxOptions.addArguments("--disable-notifications");
        firefoxOptions.addArguments("--allow-remote-origins=*");
        firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        firefoxOptions.setAcceptInsecureCerts(true);
        return firefoxOptions;
    }

    public static EdgeOptions getedgeOptions(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");
        edgeOptions.addArguments("--disable-extensions");
        edgeOptions.addArguments("--disable-infobars");
        edgeOptions.addArguments("--disable-notifications");
        edgeOptions.addArguments("--allow-remote-origins=*");
        //<Map String , Object> prefs=
        //edgeOptions.setExperimentalOption("prefs",prefs);
        edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        //edgeOptions.addArguments("--headless");
        return edgeOptions;
    }
}
