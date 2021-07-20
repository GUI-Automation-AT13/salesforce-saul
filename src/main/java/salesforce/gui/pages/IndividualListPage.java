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

    private By recentlyViewedSpan = By.cssSelector("span.triggerLinkText");
    private By deletedSuccessMessage = By.xpath("//span[contains(.,\"was deleted.\")]");
    private WebElement dropDownMenu;

    /**
     * Constructor for the IndividualListPage.
     */
    public IndividualListPage() {
        PageFactory.initElements(super.getDriver(), this);
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
     * Deletes the last created or modified record.
     */
    public void deleteLastModifiedRecord() {
        getDriver().findElement(By.xpath("//tbody/tr[1]//span/span[contains(.,\"Show Actions\")]"
                + "/preceding-sibling::span")).click();
        dropDownMenu = getDriver().findElement(By.xpath("//tbody/tr[1]//a[@title="
                + "\"Show 2 more actions\"]/ancestor::div[@id and @data-interactive-uid]"));
        clickOnARecordDropDownMenuDelete();
    }

    /**
     * Returns an alert message.
     * @return String
     */
    public String getDeletedSuccessMessage() {
        getWait().until(ExpectedConditions.visibilityOf(getDriver()
                .findElement(deletedSuccessMessage)));
        return getDriver().findElement(deletedSuccessMessage).getText();
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
     * Search for a record given the name.
     * @param name
     * @return boolean
     */
    public boolean isThereRecordWithName(final String name) {
        return getDriver().findElement(By.cssSelector("[title=\"" + name + "\"]"))
                .getText().equals(name);
    }

    /**
     * Clicks on options Drop down menu options given the name of record.
     * @param name
     */
    public void clickOnARecordDropDownMenuOption(final String name) {
        getDriver().findElement(By.xpath("//a[@title=\"" + name + "\"]/ancestor::tr//"
                + "span/span[contains(.,\"Show Actions\")]/preceding-sibling::span\"")).click();
        dropDownMenu = getDriver().findElement(By.xpath("//a[@title=\"" + name + "\"]"
                + "/ancestor::tr//a[@title=\"Show 2 more actions\"]"
                + "/ancestor::div[@id and @data-interactive-uid]"));
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
        getWait().until(ExpectedConditions.visibilityOf(dropDownMenu));
        getDriver().findElement(By.cssSelector("div[aria-labelledby="
                + "\"" + dropDownMenu.getAttribute("id") + "\"] a[title=\"Delete\"]")).click();
        WebElement webElement = getDriver().findElement(By
                .xpath("//span[contains(text(),\"Delete\")]"));
        webElement.click();
    }

    /**
     * Method to wait for a page to load.
     */
    @Override
    protected void waitForPageToLoad() {
        getWait().until(ExpectedConditions.presenceOfElementLocated(recentlyViewedSpan));
    }
}
