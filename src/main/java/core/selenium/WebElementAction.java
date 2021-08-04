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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * The Class that will interact with POM elements.
 */
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
     * @param selector represents a By locator
     * @param input represents the value to be entered in the text box
     */
    public void setInputField(final By selector, final String input) {
        driver.findElement(selector).clear();
        driver.findElement(selector).sendKeys(input);
    }

    /**
     * Returns the text from a Web Element.
     *
     * @param selector represents a By locator
     * @return String representing the text gotten prom the web element.
     */
    public String getText(final By selector) {
        return driver.findElement(selector).getText();
    }

    /**
     * Returns the text from a Web Element given a parametrized By selector and its value.
     *
     * @param parametrizedSelector represents a selector with parameters.
     * @param value represents the value to be set in the locator.
     * @return String representing the text gotten prom the web element.
     */
    public String getText(final String parametrizedSelector, final String value) {
        return driver.findElement(withParameter(parametrizedSelector, value)).getText();
    }

    /**
     * Clicks on the given WebElement.
     *
     * @param selector represents a By selector
     */
    public void clickOnElement(final By selector) {
        wait.until(ExpectedConditions.visibilityOf(getElement(selector)));
        driver.findElement(selector).click();
    }

    /**
     * Clicks on the given WebElement.
     *
     * @param parametrizedSelector selector represents a parametrized selector
     * @param value represents the custom value for the parametrized selector
     */
    public void clickOnElement(final String parametrizedSelector, final String value) {
        driver.findElement(withParameter(parametrizedSelector, value)).click();
    }

    /**
     * Returns a By selector given a parametrized selector and its value.
     * Distinguishes xpath from css and accepts both.
     *
     * @param parametrizedSelector selector represents a parametrized selector
     * @param value represents the custom value for the parametrized selector
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
     * @param selector represents a By selector
     * @return boolean indicating is the element is displayed.
     */
    public boolean isDisplayed(final By selector) {
        return driver.findElement(selector).isDisplayed();
    }

    /**
     * Checks if the element is selected.
     *
     * @param selector represents a By selector
     * @return boolean indicating is the element is selected.
     */
    public boolean isSelected(final By selector) {
        return driver.findElement(selector).isSelected();
    }

    /**
     * Checks if the element is selected given a parametrized Selector.
     *
     * @param parametrizedSelector selector represents a parametrized selector
     * @param value represents the custom value for the parametrized selector
     * @return boolean indicating is the element is selected.
     */
    public boolean isSelected(final String parametrizedSelector, final String value) {
        return driver.findElement(withParameter(parametrizedSelector, value)).isSelected();
    }

    /**
     * Returns a Web Element out of a By selector.
     *
     * @param selector represents a By selector
     * @return WebElement gotten from the selector
     */
    public WebElement getElement(final By selector) {
        return driver.findElement(selector);
    }
}
