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

public class IndividualListPage extends BasePage {

    private By deleteIndividualButton = By.cssSelector("div[title=\"Delete\"]");
    private By confirmDeleteIndividualButton = By.cssSelector("button[title=\"Delete\"] span");
    private By recentlyViewedSpan = By.cssSelector("span.triggerLinkText");

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
        super.getDriver().findElement(deleteIndividualButton).click();
        super.getDriver().findElement(confirmDeleteIndividualButton).click();
        return new HomePage();
    }

    /**
     * Checks if the view list span is visible.
     *
     * @return boolean
     */
    public boolean recentlyViewedSpanVisible() {
        return super.getDriver().findElement(recentlyViewedSpan).isDisplayed();
    }

    /**
     * Method to wait for a page to load.
     */
    @Override
    protected void waitForPageToLoad() {
        super.getWait().until(ExpectedConditions.presenceOfElementLocated(deleteIndividualButton));
    }
}
