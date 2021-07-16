/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.gui.pages;

import config.ConfigManager;
import core.selenium.WebDriverManager;

public final class PageTransporter {

    private final String BASE_URL = ConfigManager.getConfiguration().baseUrl();

    /**
     * Navigates to a url.
     * @param url
     */
    public void goToUrl(final String url) {
        WebDriverManager.getDriver().navigate().to(url);
    }

    public LoginPage navigateToLoginPage() {
        goToUrl(BASE_URL);
        return new LoginPage();
    }
    /**
     * Navigates to the individual form page.
     * @return
     */
    public IndividualFormPage navigateToIndividualFormPage() {
        goToUrl(BASE_URL.concat("/lightning/o/Individual/new?count=1"));
        return new IndividualFormPage();
    }

    /**
     * Navigates to the page with the given String.
     * @param page
     * @param <T>
     * @return T
     */
    public <T> T navigateTo(String page) {
        return null;
    }
}
