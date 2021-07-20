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
import salesforce.gui.pages.*;
import core.selenium.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class Basetest {

    protected WebDriver driver;
    protected PageTransporter pageTransporter;
    protected PropertiesConfig propertiesConfig;

    @BeforeSuite
    public void setUp() {
        propertiesConfig = ConfigManager.getConfiguration();
        driver = WebDriverManager.getDriver(new ChromeBrowser());
        pageTransporter = new PageTransporter();
        login();
    }

    public void login() {
        LoginPage loginpage = pageTransporter.navigateToLoginPage();
        loginpage.setUsernameTextbox(propertiesConfig.username());
        loginpage.setPasswordTextbox(propertiesConfig.password());
        HomePage homePage = loginpage.login();
        Assert.assertTrue(homePage.labelObjectManageriIsVisible());
    }

    @AfterMethod(onlyForGroups = {"Create"})
    public void deleteCreatedIndividual() {
        IndividualListPage individualListPage = pageTransporter.navigateToIndividualListPage();
        individualListPage.deleteLastModifiedRecord();
        String actual = individualListPage.getDeletedSuccessMessage();
        String expected = "was deleted.";
        Assert.assertTrue(actual.contains(expected));
    }

    @AfterSuite
    public void quitDriver() {
        driver.quit();
    }
}
