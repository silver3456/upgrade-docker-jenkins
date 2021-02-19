package com.usa.web.pages;

import com.usa.web.selenium.utils.ElementHelper;
import com.usa.web.selenium.utils.WaitUtil;
//import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public abstract class BasePage {

    protected WebDriver driver;
    protected ElementHelper helper;
//    Logger LOG;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        helper = new ElementHelper(driver);
//        LOG = Logger.getLogger(this.getClass().getName());
        refresh();
    }

    protected void refresh() {
        Assert.assertTrue(WaitUtil.waitForAjax(driver));
        PageFactory.initElements(driver, this);
    }
}
