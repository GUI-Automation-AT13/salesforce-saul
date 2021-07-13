/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.gui.page_object.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    @FindBy(css = ".username")
    private WebElement usernameTextbox;

    @FindBy(css = ".password")
    private WebElement passwordTextbox;

    @FindBy(id = "Login")
    private WebElement loginButton;

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
        usernameTextbox.sendKeys(username);
    }

    /**
     * Sets the given lastname to the lastname textbox.
     *
     * @param password
     */
    public void setPasswordTextbox(final String password) {
        passwordTextbox.sendKeys(password);
    }

    /**
     * Clicks on the login button.
     *
     * @return HomePage
     */
    public HomePage login() {
        loginButton.click();
        return new HomePage();
    }

    /**
     * Method to wait for a page to load.
     */
    @Override
    protected void waitForPageToLoad() {

    }
}
