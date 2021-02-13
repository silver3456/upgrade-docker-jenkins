package com.usa.web.selenium.utils;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static java.lang.String.format;

public class ElementHelper {
    private WebDriver driver;
    private static Logger LOG = Logger.getLogger(ElementHelper.class.getName());

    public ElementHelper(WebDriver driver) {
        this.driver = driver;
    }


    public void enterText(WebElement locator, String text) {
        LOG.info(format("Clear and set text: %s to an element with locator: %s", text, locator));
        locator.clear();
        locator.sendKeys(text);
    }


    public void clickOnElement(WebElement locator) {
        LOG.info("CLick on element with locator: " + locator);
        try {
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.elementToBeClickable(locator));
            locator.click();
        } catch (Exception ex) {
            LOG.info(ex.getMessage());
        }
    }

    public boolean selectElementWithOffset(WebElement element) {
        Actions actions = new Actions(driver);

        for (int x = 0; x < element.getSize().getWidth(); x++) {
            for (int y = 0; y < element.getSize().getHeight(); y++) {
                actions.moveToElement(element).moveByOffset(x, y).click().build().perform();
                if (element.isSelected()) {
                    return true;
                }
            }
        }
        return false;
    }

    public String getElementText(WebElement element) {
        try {
            return element.getText();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return null;
        }
    }

}
