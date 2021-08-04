/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package core.selenium;

import config.ConfigManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Class for the Chrome Browser properties.
 */
public class ChromeBrowser implements Browser {

    /**
     * Returns the chrome driver name.
     *
     * @return a String
     */
    @Override
    public String getDriverName() {
        return "webdriver.chrome.driver";
    }

    /**
     * Returns the chrome driver path.
     *
     * @return a String
     */
    @Override
    public String getDriverPath() {
        return ConfigManager.getConfiguration().driverPath();
    }

    /**
     * Returns the chrome driver.
     *
     * @return the WebDriver
     */
    @Override
    public WebDriver getDriver() {
        return new ChromeDriver();
    }
}
