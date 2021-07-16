/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package org.salesforce.scripts.Individual;

import config.ConfigManager;
import config.PropertiesConfig;
import core.selenium.ChromeBrowser;
import core.selenium.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import salesforce.gui.pages.HomePage;
import salesforce.gui.pages.IndividualListPage;
import salesforce.gui.pages.LoginPage;

public class Basetest {

    protected static WebDriver driver;
    PropertiesConfig propertiesConfig = ConfigManager.getConfiguration();

    @BeforeSuite
    public void setUp() {
        PropertiesConfig propertiesConfig = ConfigManager.getConfiguration();
        driver = WebDriverManager.getDriver(new ChromeBrowser());
        driver.get(propertiesConfig.baseUrl());
        login();
    }

    public void login() {
        LoginPage loginpage = new LoginPage();
        loginpage.setUsernameTextbox(propertiesConfig.username());
        loginpage.setPasswordTextbox(propertiesConfig.password());
        HomePage homePage = loginpage.login();
        Assert.assertTrue(homePage.labelObjectManageriIsVisible());
    }


    @AfterMethod(onlyForGroups = {"Create"})
    public void deleteCreatedIndividual() {
        IndividualListPage individualListPage = new IndividualListPage();
        individualListPage.deleteCreatedIndividual();
        Assert.assertTrue(individualListPage.recentlyViewedSpanVisible());
    }

    @AfterSuite
    public void quitDriver() {
        driver.quit();
    }
}
