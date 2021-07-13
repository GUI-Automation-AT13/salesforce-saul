/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.gui.page_object.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndividualListPage extends BasePage {

    @FindBy(css = "div[title=\"Delete\"]")
    private WebElement deleteIndividualButton;

    @FindBy(css = "button[title=\"Delete\"] span")
    private WebElement confirmDeleteIndividualButton;

    @FindBy(css = "span.triggerLinkText")
    private WebElement recentlyViewedSpan;

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
        deleteIndividualButton.click();
        confirmDeleteIndividualButton.click();
        return new HomePage();
    }

    /**
     * Checks if the view list span is visible.
     *
     * @return boolean
     */
    public boolean recentlyViewedSpanVisible() {
        return recentlyViewedSpan.isDisplayed();
    }

    /**
     * Method to wait for a page to load.
     */
    @Override
    protected void waitForPageToLoad() {

    }
}
