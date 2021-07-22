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
import org.openqa.selenium.support.ui.ExpectedConditions;

public class IndividualListPage extends BasePage {

    private By recentlyViewedSpan = By.cssSelector("span.triggerLinkText");
    private By deletedSuccessMessage = By.xpath("//span[contains(.,\"was deleted.\")]");
    private WebElement dropDownMenu;

    /**
     * Checks if the view list span is visible.
     *
     * @return boolean
     */
    public boolean recentlyViewedSpanVisible() {
        return findElement(recentlyViewedSpan).isDisplayed();
    }

    /**
     * Deletes the last created or modified record.
     */
    public void deleteLastModifiedRecord() {
        findElement(By.xpath("//tbody/tr[1]//span/span[contains(.,\"Show Actions\")]"
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
        getWait().until(ExpectedConditions.visibilityOf(findElement(deletedSuccessMessage)));
        return findElement(deletedSuccessMessage).getText();
    }
    /**
     * Clicks on a record from the list of Individual records given the name.
     * @param name
     */
    public void clickOnRecordByName(final String name) {
        findElement(By.cssSelector("[title=\"" + name + "\"]")).click();
    }

    /**
     * Search for a record given the name.
     * @param name
     * @return boolean
     */
    public boolean isThereRecordWithName(final String name) {
        return findElement(By.cssSelector("[title=\"" + name + "\"]")).getText().equals(name);
    }

    /**
     * Clicks on options Drop down menu options given the name of record.
     * @param name
     */
    public void clickOnARecordDropDownMenuOption(final String name) {
        findElement(By.xpath("//a[@title=\"" + name + "\"]/ancestor::tr//"
                + "span/span[contains(.,\"Show Actions\")]/preceding-sibling::span\"")).click();
        findElement(By.xpath("//a[@title=\"" + name + "\"]/ancestor::tr//a[@title="
                + "\"Show 2 more actions\"]/ancestor::div[@id and @data-interactive-uid]")).click();
    }

    /**
     * Click on a record Drop down menu Edit.
     */
    public void clickOnARecordDropDownMenuEdit() {
        findElement(By.cssSelector("div[aria-labelledby=\""
                + dropDownMenu.getAttribute("id") + "\"] a[title=\"Edit\"]")).click();
    }

    /**
     * Click on a record Drop down menu Delete.
     */
    public void clickOnARecordDropDownMenuDelete() {
        getWait().until(ExpectedConditions.visibilityOf(dropDownMenu));
        findElement(By.cssSelector("div[aria-labelledby="
                + "\"" + dropDownMenu.getAttribute("id") + "\"] a[title=\"Delete\"]")).click();
        findElement(By.xpath("//span[contains(text(),\"Delete\")]")).click();
    }

    /**
     * Method to wait for a page to load.
     */
    @Override
    protected void waitForPageToLoad() {
        getWait().until(ExpectedConditions.presenceOfElementLocated(recentlyViewedSpan));
    }
}
