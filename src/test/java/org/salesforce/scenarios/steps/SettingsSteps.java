/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package org.salesforce.scenarios.steps;

import io.cucumber.java.en.Given;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.asserts.SoftAssert;
import salesforce.gui.pages.PageTransporter;
import salesforce.gui.pages.settings.LanguageAndTimeZonePage;

public class SettingsSteps {

    private Logger logger = LogManager.getLogger(getClass());
    private SoftAssert softAssert = new SoftAssert();
    private PageTransporter pageTransporter;
    private Object entity;

    public SettingsSteps(PageTransporter pageTransporter, Object entity) {
        this.pageTransporter = pageTransporter;
        this.entity = entity;
    }

    @Given("^I set the language settings to Spanish$")
    public void iSetTheLanguageSettingsToSpanish() {
        logger.info("============ Given I set the language settings to Spanish ============");
        LanguageAndTimeZonePage languageAndTimeZonePage = pageTransporter.navigateToTheLanguageAndTimeZonePage();
        languageAndTimeZonePage.changeLanguageToSpanish();
    }
}
