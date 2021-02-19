package com.usa.web.selenium;


//import com.usa.web.selenium.listeners.LogListener;
//import com.usa.web.selenium.supplier.DriverFactory;
import com.usa.web.selenium.utils.CaptureScreenshots;
import com.usa.web.selenium.utils.StringRandomGenerator;
import io.qameta.allure.Attachment;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static com.usa.web.selenium.utils.PropertyLoader.getDefaultWait;


//@Listeners(value = {LogListener.class})
public class TestRunner {
    protected WebDriver driver;


//    @BeforeClass
//    @Parameters("browser")
//    public void beforeSetUp(@Optional("chrome") String browser) {
//        this.driver = DriverFactory.getDriver(browser);
//
//        driver.manage().timeouts().implicitlyWait(getDefaultWait(), TimeUnit.SECONDS);
//        driver.manage().window().maximize();
//    }


    @BeforeClass
    public void setupDriver() throws MalformedURLException {
        String host = "localhost";
        DesiredCapabilities dc = DesiredCapabilities.chrome();

        if (System.getProperty("BROWSER") != null &&
                System.getProperty("BROWSER").equalsIgnoreCase("firefox")) {
            dc = DesiredCapabilities.firefox();
        }

        if (System.getProperty("HUB_HOST") != null) {
            host = System.getProperty("HUB_HOST");
        }

        String completeUrl = "http://" + host + ":4444/wd/hub";
        this.driver = new RemoteWebDriver(new URL(completeUrl), dc);
    }


    @BeforeTest
    public void generateCredentials() {
        StringRandomGenerator.saveCreds();
    }


    @BeforeMethod
    public void beforeTest() {
        driver.manage().deleteAllCookies();
    }


    @AfterMethod
    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] tearDown(ITestResult result) {
        if (!result.isSuccess() && driver != null) {
            return CaptureScreenshots.captureScreenByte(driver);
        }

        return null;
    }

    @AfterClass
    public void afterSuiteTearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
