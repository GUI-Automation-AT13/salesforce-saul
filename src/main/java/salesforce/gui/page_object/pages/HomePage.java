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

public class HomePage extends BasePage {

    @FindBy(css = ".hasActions .title")
    private WebElement labelObjectManager;

    @FindBy(css = "css=div[title=\"Delete\"]")
    private WebElement deleteIndividualButton;

    @FindBy(css = "button[title=\"Delete\"] span")
    private WebElement confirmDeleteIndividualButton;

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
        return labelObjectManager.isDisplayed();
    }

    /**
     * Deletes the created individual element.
     *
     * @return HomePage
     */
    public HomePage deleteCreatedIndividual() {
        deleteIndividualButton.click();
        confirmDeleteIndividualButton.click();
        return new HomePage();
    }

    /**
     * Method to wait for a page to load.
     */
    @Override
    protected void waitForPageToLoad() {

    }
}
