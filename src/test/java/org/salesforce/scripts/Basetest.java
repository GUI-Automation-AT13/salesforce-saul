/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package org.salesforce.scripts;

import config.ConfigManager;
import config.PropertiesConfig;
import core.ChromeBrowser;
import core.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import salesforce.gui.page_object.pages.IndividualListPage;

public class Basetest {

    protected static WebDriver driver;

    @BeforeSuite
    public void setUp() {
        PropertiesConfig propertiesConfig = ConfigManager.getConfiguration();
        driver = WebDriverManager.getDriver(new ChromeBrowser());
        driver.get(propertiesConfig.baseUrl());
    }

    @AfterMethod
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
