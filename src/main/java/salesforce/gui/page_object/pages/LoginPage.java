/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.gui.page_object.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    private By usernameTextbox = By.className("username");
    private By passwordTextbox = By.className("password");
    private By loginButton = By.id("Login");

    /**
     * Constructor for LoginPage.
     */
    public LoginPage() {
        PageFactory.initElements(super.getDriver(), this);
    }

    /**
     * Sets the given username to the username textbox.
     *
     * @param username
     */
    public void setUsernameTextbox(final String username) {
        getDriver().findElement(usernameTextbox).sendKeys(username);
    }

    /**
     * Sets the given password to the password textbox.
     *
     * @param password
     */
    public void setPasswordTextbox(final String password) {
        getDriver().findElement(passwordTextbox).sendKeys(password);
    }

    /**
     * Clicks on the login button.
     *
     * @return HomePage
     */
    public HomePage login() {
        getDriver().findElement(loginButton).click();
        return new HomePage();
    }

    /**
     * Method to wait for a page to load.
     */
    @Override
    protected void waitForPageToLoad() {
        getWait().until(ExpectedConditions.presenceOfElementLocated(loginButton));
    }
}