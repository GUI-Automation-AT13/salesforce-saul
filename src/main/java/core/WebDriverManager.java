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
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public final class WebDriverManager {

    private static WebDriver driver;
    private static WebDriverWait driverWait;

    private WebDriverManager() {
    }

    /**
     * Returns an instance of the WebDriver.
     *
     * @return WebDriver
     * @param browser
     */
    public static WebDriver getDriver(final Browser browser) {
        if (driver == null) {
            System.setProperty(browser.getDriverName(),
                    browser.getDriverPath());
            driver = browser.getDriver();
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(ConfigManager.getConfiguration()
                .implicitWaitTime(), TimeUnit.SECONDS);
        return driver;
    }

    /**
     * Overload method to get the driver instance.
     *
     * @return WebDriver
     */
    public static WebDriver getDriver() {
        return driver;
    }

    /**
     * Returns the instance of WebDriverWait.
     *
     * @return WebDriverWait.
     */
    public static WebDriverWait getDriverWait() {
        if (driverWait == null) {
            driverWait = new WebDriverWait(driver, ConfigManager.getConfiguration()
                    .implicitWaitTime());
        }
        return driverWait;
    }
}
