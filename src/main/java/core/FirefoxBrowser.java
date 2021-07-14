/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package core;

import config.ConfigManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxBrowser implements Browser {

    /**
     * Returns the firefox driver name.
     *
     * @return String
     */
    @Override
    public String getDriverName() {
        return "webdriver.decko.driver";
    }

    /**
     * Returns the firefox driver path.
     *
     * @return String
     */
    @Override
    public String getDriverPath() {
        return ConfigManager.getConfiguration().driverPath();
    }

    /**
     * Returns the firefox driver.
     *
     * @return WebDriver
     */
    @Override
    public WebDriver getDriver() {
        return new FirefoxDriver();
    }
}
