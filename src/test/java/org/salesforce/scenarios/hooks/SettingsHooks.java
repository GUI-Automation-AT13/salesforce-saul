/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package org.salesforce.scenarios.hooks;

import config.ConfigManager;
import core.utils.internationalization.Language;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import salesforce.gui.pages.PageTransporter;
import salesforce.gui.pages.settings.LanguageAndTimeZonePage;

public class SettingsHooks {

    private Logger logger = LogManager.getLogger(getClass());
    private PageTransporter pageTransporter;
    private Object entity;

    public SettingsHooks(PageTransporter pageTransporter, Object entity) {
        this.pageTransporter = pageTransporter;
        this.entity = entity;
    }

    @Before(value = "@Internationalization and @Spanish", order = 2)
    public void setSystemLanguageProperty() {
        logger.info("============ SET SYSTEM LANGUAGE PROPERTY ============");
        ConfigManager.setSystemLanguageProperty(Language.SPANISH.get());
    }
    @After(value = "@Internationalization and @Spanish", order = 100)
    public void setLanguageToEnglish() {
        logger.info("============ SET LANGUAGE TO ENGLISH ============");
        LanguageAndTimeZonePage languageAndTimeZonePage = pageTransporter.navigateToTheLanguageAndTimeZonePage();
        languageAndTimeZonePage.changeLanguageToEnglish();
        ConfigManager.setSystemLanguageProperty(Language.ENGLISH.get());
    }
}
