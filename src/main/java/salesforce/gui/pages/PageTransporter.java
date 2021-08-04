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
import core.utils.ClassGetter;

/**
 * Navigates trough Salesforce pages and returns its POM classes.
 */
public final class PageTransporter {

    private final String baseUrl = ConfigManager.getConfiguration().baseUrl();
    private final String newObjectPageUrl = "/lightning/o/%s/new?count=1";
    private final String objectListPageUrl = "/lightning/o/%s/list?filterName=Recent";
    private final String newObjectEntity = "salesforce.gui.pages.New%sPage";
    private final String featureRecordPage = "salesforce.gui.pages.%sRecordPage";
    private final String featureListPage = "salesforce.gui.pages.%sListPage";

    /**
     * Navigates to a url.
     *
     * @param url represents the url to navigate to
     */
    public void goToUrl(final String url) {
        WebDriverManager.getDriver().navigate().to(url);
    }

    public LoginPage navigateToLoginPage() {
        goToUrl(baseUrl);
        return new LoginPage();
    }

    /**
     * Navigates to the page of creation of the given feature.
     */
    public NewObjectPage navigateToNewObjectPage(final String feature) {
        goToUrl(baseUrl.concat(String.format(newObjectPageUrl, feature)));
        return (NewObjectPage) ClassGetter.get(String.format(newObjectEntity, feature));
    }

    /**
     * Navigates to the given feature list page.
     */
    public ObjectListPage navigateToObjectListPage(final String feature) {
        goToUrl(baseUrl.concat(String.format(objectListPageUrl, feature)));
        return (ObjectListPage) ClassGetter.get(String.format(featureListPage, feature));
    }

    /**
     * Navigates to the given feature list page.
     */
    public void navigateToObjectRecordPage(final String feature) {
        goToUrl(baseUrl.concat(String.format(objectListPageUrl, feature)));
    }

    /**
     * Navigates to the given feature list page.
     */
    public ObjectRecordPage getRecordPage(final String feature) {
        return (ObjectRecordPage) ClassGetter.get(String.format(featureRecordPage, feature));
    }
}
