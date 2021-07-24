/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.gui.page_object.pages;

import core.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    private WebDriver driver = WebDriverManager.getDriver();
    private WebDriverWait wait = WebDriverManager.getDriverWait();

    /**
     * Method to wait for a page to load.
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
}