/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.gui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    private By labelObjectManager = By.cssSelector(".hasActions .title");
    private By deleteIndividualButton = By.cssSelector("css=div[title=\"Delete\"]");
    private By confirmDeleteIndividualButton = By.cssSelector("button[title=\"Delete\"] span");

    /**
     * Constructor for the HomePage class.
     */
    public HomePage() {
        PageFactory.initElements(super.getDriver(), this);
    }

    /**
     * Checks if the ObjectManager label is visible.
     *
     * @return boolean.
     */
    public boolean labelObjectManageriIsVisible() {
        return super.getDriver().findElement(labelObjectManager).isDisplayed();
    }

    /**
     * Deletes the created individual element.
     *
     * @return HomePage
     */
    public HomePage deleteCreatedIndividual() {
        super.getDriver().findElement(deleteIndividualButton).click();
        super.getDriver().findElement(confirmDeleteIndividualButton).click();
        return new HomePage();
    }

    /**
     * Method to wait for a page to load.
     */
    @Override
    protected void waitForPageToLoad() {
        super.getWait().until(ExpectedConditions.presenceOfElementLocated(deleteIndividualButton));
    }
}
