/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.gui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * POM represents the Salesforce login page.
 */
public class LoginPage extends BasePage {

    private By usernameTextbox = By.className("username");
    private By passwordTextbox = By.className("password");
    private By loginButton = By.id("Login");

    /**
     * Sets the given username to the username textbox.
     *
     * @param username represents the username to be set on the text box
     */
    public void setUsernameTextbox(final String username) {
        getWebElementActions().setInputField(usernameTextbox, username);
    }

    /**
     * Sets the given password to the password textbox.
     *
     * @param password represents the password to be set on the text box
     */
    public void setPasswordTextbox(final String password) {
        getWebElementActions().setInputField(passwordTextbox, password);
    }

    /**
     * Clicks on the login button.
     *
     * @return HomePage page
     */
    public HomePage login() {
        getWebElementActions().clickOnElement(loginButton);
        return new HomePage();
    }

    /**
     * Method to wait for a page to load.
     */
    @Override
    protected void waitForPageToLoad() {
        super.getWait().until(ExpectedConditions.presenceOfElementLocated(loginButton));
    }
}
