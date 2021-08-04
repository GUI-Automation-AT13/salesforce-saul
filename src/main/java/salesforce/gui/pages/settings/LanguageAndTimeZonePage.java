/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.gui.pages.settings;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.gui.pages.BasePage;

/**
 * POM for the salesforce language and time zone page.
 */
public class LanguageAndTimeZonePage extends BasePage {

    private By languageDropDownMenu = By.xpath("//label[contains(.,'Language')]/ancestor::tr//select");
    private By optionEspanolBolivia = By.xpath("//label[contains(.,'Language')]/ancestor::tr//option[@value = '41']");
    private By optionEnglish = By.xpath("//label[contains(.,'Language')]/ancestor::tr//option[@value = '1']");
    private By saveButton = By.xpath("//input[@class='btn']");

    /**
     * Clicks on the language drop down menu.
     */
    public void clickOnLanguageDropDownMenu() {
        getWebElementActions().clickOnElement(languageDropDownMenu);
    }

    /**
     * Clicks on the spanish language option.
     */
    public void clickOnLanguageOptionSpanish() {
        getWebElementActions().clickOnElement(optionEspanolBolivia);
    }

    /**
     * Clicks on the english language option.
     */
    public void clickOnLanguageOptionEnglish() {
        getWebElementActions().clickOnElement(optionEnglish);
    }

    /**
     * Clicks on the save button.
     */
    public void clickOnSaveButton() {
        getWebElementActions().clickOnElement(saveButton);
    }

    /**
     * Changes the language settings to Spanish and saves.
     */
    public void changeLanguageToSpanish() {
        clickOnLanguageDropDownMenu();
        clickOnLanguageOptionSpanish();
        clickOnSaveButton();
    }

    /**
     * Changes the language settings to English and saves.
     */
    public void changeLanguageToEnglish() {
        clickOnLanguageDropDownMenu();
        clickOnLanguageOptionEnglish();
        clickOnSaveButton();
    }

    @Override
    protected void waitForPageToLoad() {
        getWait().until(ExpectedConditions.presenceOfElementLocated(languageDropDownMenu));
    }
}
