/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package org.salesforce.scenarios.hooks;

import config.ConfigManager;
import core.selenium.WebDriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import salesforce.gui.pages.*;

public class GeneralHooks {

    private Logger logger = LogManager.getLogger(getClass());
    private PageTransporter pageTransporter;
    private Object entity;

    public GeneralHooks(PageTransporter pageTransporter, Object entity) {
        this.pageTransporter = pageTransporter;
        this.entity = entity;
    }

    @Before(order  = 1)
    public void setUp() {
        login();
    }

    public void login() {
        logger.info("============ LOGIN ============");
        LoginPage loginpage = pageTransporter.navigateToLoginPage();
        loginpage.setUsernameTextbox(ConfigManager.getConfiguration().username());
        loginpage.setPasswordTextbox(ConfigManager.getConfiguration().password());
        HomePage homePage = loginpage.login();
        Assert.assertTrue(homePage.labelObjectManageriIsVisible());
    }

    @After(order = 1000)
    public void tearDown() {
        WebDriverManager.getDriver().quit();
    }
}
