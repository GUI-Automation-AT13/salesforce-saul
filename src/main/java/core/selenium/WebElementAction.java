/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package core.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebElementAction {

    private WebDriver driver;
    private WebDriverWait wait;

    /**
     * WebElementAction constructor.
     */
    public WebElementAction() {
        driver = WebDriverManager.getDriver();
        wait = WebDriverManager.getDriverWait();
    }

    /**
     * Sends keys to the given WebElement.
     *
     * @param selector
     * @param input
     */
    public void setInputField(final By selector, final String input) {
        driver.findElement(selector).clear();
        driver.findElement(selector).sendKeys(input);
//        wait.until(ExpectedConditions.visibilityOf(webElement));
//        webElement.clear();
//        webElement.sendKeys(input);
    }

    /**
     * Returns the text from a Web Element.
     *
     * @param selector
     * @return String
     */
    public String getText(final By selector) {
        return driver.findElement(selector).getText();
    }

    /**
     * Returns the text from a Web Element given a parametrized By selector and its value.
     *
     * @param parametrizedSelector
     * @param value
     * @return String
     */
    public String getText(final String parametrizedSelector, final String value) {
        return driver.findElement(withParameter(parametrizedSelector, value)).getText();
    }

    /**
     * Clicks on the given WebElement.
     *
     * @param selector
     */
    public void clickOnElement(final By selector) {
        driver.findElement(selector).click();
        //wait.until(ExpectedConditions.visibilityOf(webElement));
        //webElement.click();
    }

    /**
     * Clicks on the given WebElement.
     *
     * @param parametrizedSelector
     * @param value
     */
    public void clickOnElement(final String parametrizedSelector, final String value) {
        driver.findElement(withParameter(parametrizedSelector, value)).click();
    }

    /**
     * Returns a By selector given a parametrized selector and its value.
     * Distinguishes xpath from css and accepts both.
     *
     * @param parametrizedSelector
     * @param value
     * @return By
     */
    public static By withParameter(final String parametrizedSelector, final String value) {
        if (parametrizedSelector.startsWith("//")) {
            return By.xpath(String.format(parametrizedSelector, value));
        } else {
            return By.cssSelector(String.format(parametrizedSelector, value));
        }
    }

    /**
     * Checks if the element is displayed.
     *
     * @param selector
     * @return boolean
     */
    public boolean isDisplayed(final By selector) {
        return driver.findElement(selector).isDisplayed();
    }

    /**
     * Checks if the element is selected.
     *
     * @param selector
     * @return boolean
     */
    public boolean isSelected(final By selector) {
        return driver.findElement(selector).isSelected();
    }

    /**
     * Returns a Web Element out of a By selector.
     *
     * @param selector
     * @return WebElement
     */
    public WebElement getElement(final By selector) {
        return driver.findElement(selector);
    }
}
