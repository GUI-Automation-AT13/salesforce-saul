/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.gui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class IndividualListPage extends BasePage {

    private By deleteIndividualButton = By.cssSelector("div[title=\"Delete\"]");
    private By confirmDeleteIndividualButton = By.cssSelector("button[title=\"Delete\"] span");
    private By recentlyViewedSpan = By.cssSelector("span.triggerLinkText");
    private WebElement dropDownMenu;

    /**
     * Constructor for the IndividualListPage.
     */
    public IndividualListPage() {
        PageFactory.initElements(super.getDriver(), this);
    }

    /**
     * Deletes the created individual.
     *
     * @return a HomePage instance.
     */
    public HomePage deleteCreatedIndividual() {
        WebElement webElement = getDriver().findElement(deleteIndividualButton);
        getWebElementAction().clickOnElement(webElement);
        webElement = getDriver().findElement(confirmDeleteIndividualButton);
        getWebElementAction().clickOnElement(webElement);
        return new HomePage();
    }

    /**
     * Checks if the view list span is visible.
     *
     * @return boolean
     */
    public boolean recentlyViewedSpanVisible() {
        return getDriver().findElement(recentlyViewedSpan).isDisplayed();
    }

    /**
     * Clicks on a record from the list of Individual records given the name.
     * @param name
     */
    public void clickOnRecordByName(final String name) {
        WebElement webElement = getDriver().findElement(By.cssSelector("[title=\"" + name + "\"]"));
        getWebElementAction().clickOnElement(webElement);
    }

    /**
     * Clicks on options Drop down menu options given the name of record.
     * @param name
     */
    public void clickOnARecordDropDownMenuOption(final String name) {
        dropDownMenu = getDriver().findElement(By.xpath("//a[@title=\"" + name + "\"]"
                + "/ancestor::tr//a[contains(@class,\"slds-button\")]"));
        getWebElementAction().clickOnElement(dropDownMenu);
    }

    /**
     * Click on a record Drop down menu Edit.
     */
    public void clickOnARecordDropDownMenuEdit() {
        WebElement webElement = getDriver().findElement(By.cssSelector("div[aria-labelledby="
                + "\"" + dropDownMenu.getAttribute("id") + "\"] a[title=\"Edit\"]"));
        getWebElementAction().clickOnElement(webElement);
    }

    /**
     * Click on a record Drop down menu Delete.
     */
    public void clickOnARecordDropDownMenuDelete() {
        WebElement webElement = getDriver().findElement(By.cssSelector("div[aria-labelledby="
                + "\"" + dropDownMenu.getAttribute("id")     + "\"] a[title=\"Delete\"]"));
        getWebElementAction().clickOnElement(webElement);
    }

    /**
     * Method to wait for a page to load.
     */
    @Override
    protected void waitForPageToLoad() {
        getWait().until(ExpectedConditions.presenceOfElementLocated(recentlyViewedSpan));
    }
}
