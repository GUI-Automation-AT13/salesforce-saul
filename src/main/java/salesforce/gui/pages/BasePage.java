/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.gui.pages;

import core.selenium.WebDriverManager;
import core.selenium.WebElementAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Base for the salesforce POMs containing instances of required classes.
 */
public abstract class BasePage {

    private WebDriver driver = WebDriverManager.getDriver();
    private WebDriverWait wait = WebDriverManager.getDriverWait();
    private WebElementAction webElementActions = new WebElementAction();
    private Actions action = new Actions(WebDriverManager.getDriver());
    private PageTransporter pageTransporter = new PageTransporter();

    /**
     * Waits for a page to load.
     */
    protected abstract void waitForPageToLoad();

    /**
     * Returns the driver.
     *
     * @return WebDriver
     */
    public WebDriver getDriver() {
        return driver;
    }

    /**
     * Returns the DriverWait.
     *
     * @return WebDroverWait.
     */
    public WebDriverWait getWait() {
        return wait;
    }

    /**
     * Returns the WebElementAction.
     *
     * @return WebElementAction
     */
    public WebElementAction getWebElementActions() {
        return webElementActions;
    }

    /**
     * Returns the Actions instance.
     *
     * @return Actions instance
     */
    public Actions getActions() {
        return action;
    }

    /**
     * Returns a Web Element found from the provided selector.
     *
     * @param bySelector represents a by selector
     * @return a WebElement
     */
    public WebElement findElement(final By bySelector) {
        return driver.findElement(bySelector);
    }

    /**
     * Return the PageTransporter instance.
     *
     * @return PageTransporter instance
     */
    public PageTransporter getPageTransporter() {
        return pageTransporter;
    }
}
