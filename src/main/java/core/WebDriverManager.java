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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public final class WebDriverManager {

    private static WebDriver driver;
    private static WebDriverWait driverWait;

    private WebDriverManager() {
    }

    /**
     * Returns an instance of the WebDriverManager.
     *
     * @return WebDriver
     */
    public static WebDriver getDriver() {
        if (driver == null) {
            if (ConfigManager.getConfiguration().browser().equals(Browser.CHROME.get())) {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-notifications");
                System.setProperty("webdriver.chrome.driver",
                        ConfigManager.getConfiguration().driverPath());
                driver = new ChromeDriver(options);
            } else {
                driver = new FirefoxDriver();
                System.setProperty("webdriver.firefox.driver",
                        ConfigManager.getConfiguration().driverPath());
            }
        }
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
