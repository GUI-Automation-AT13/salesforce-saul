/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package core.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
     * @param webElement
     * @param input
     */
    public void setInputField(final WebElement webElement, final String input) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
        webElement.clear();
        webElement.sendKeys(input);
    }

    /**
     * Clicks on the given WebElement.
     * @param webElement
     */
    public void clickOnElement(final WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
        webElement.click();
    }
}
