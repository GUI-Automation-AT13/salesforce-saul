/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.gui.pages;

import core.selenium.BySelector;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class IndividualFormPage extends BasePage {

    private By salutationSelector = By.cssSelector(".salutation a");

    private final String generalSalutationOptionSelector = "[title=\"%s\"]";
    private final String generalCheckboxSelector = "//div[label[contains(.,\"%s\")]]/input";

    private By firstnameTextbox = By.cssSelector(".firstName");
    private By lastnameTextbox = By.cssSelector(".lastName");
    private By birthdateDateField = By.cssSelector("input[class=' input']");

    private By individualAgeSelector = By.xpath("//div[span[span[contains(text(),'Age')]]]/div//a");
    private By age13Option = By.xpath("//a[contains(text(),\'13 or Older\')]");
    private By age16Option = By.xpath("//a[contains(text(),\'16 or Older\')]");
    private By saveButton = By.cssSelector("button[title=\"Save\"]");
    private By createdIndividualLabel = By.cssSelector(".slds-page-header__title > .uiOutputText");

    private By createdSuccessMessage = By.xpath("//span[contains(.,\"was created.\")]");

    /**
     * Clicks the saluatation selector.
     */
    public void clickOnSalutationDropDownMenu() {
        findElement(salutationSelector).click();
    }

    /**
     * Clicks the Mr. option
     */
    public void clickOnMrOption() {
        findElement(BySelector.withParameter(generalSalutationOptionSelector, "Mr.")).click();
    }

    /**
     * Clicks the Mrs. option
     */
    public void clickOnMrsOption() {
        findElement(BySelector.withParameter(generalSalutationOptionSelector, "Mrs.")).click();
    }

    /**
     * Clicks the Ms. option
     */
    public void clickOnMsOption() {
        findElement(BySelector.withParameter(generalSalutationOptionSelector, "Ms.")).click();
    }

    /**
     * Clicks the Dr. option
     */
    public void clickOnDrOption() {
        findElement(BySelector.withParameter(generalSalutationOptionSelector, "Dr.")).click();
    }

    /**
     * Clicks the Prof. option
     */
    public void clickOnProfOption() {
        findElement(BySelector.withParameter(generalSalutationOptionSelector, "Prof.")).click();
    }

    /**
     * Sets the firstname value to the field.
     *
     * @param firstname
     */
    public void setFirstnameTextbox(final String firstname) {
        getWebElementAction().setInputField(findElement(firstnameTextbox), firstname);
    }

    /**
     * Sets the lastname value to the field.
     *
     * @param lastname
     */
    public void setLastnameTextbox(final String lastname) {
        getWebElementAction().setInputField(findElement(lastnameTextbox), lastname);
    }

    /**
     * Sets the date for the birthdate field.
     *
     * @param date
     */
    public void setBirthdateDateField(final String date) {
        getWebElementAction().setInputField(findElement(birthdateDateField), date);
    }

    /**
     * Clicks on the Don't Process checkbox.
     */
    public void clickOnDontProcessCheckbox() {
        findElement(BySelector.withParameter(generalCheckboxSelector, "Don't Process")).click();
    }

    /**
     * Clicks on the Don't Market checkbox.
     */
    public void clickOnDontMarketCheckbox() {
        findElement(BySelector.withParameter(generalCheckboxSelector, "Don't Market")).click();
    }

    /**
     * Clicks on the Export Individual's Data checkbox.
     */
    public void clickOnExportIndividualDataCheckbox() {
        findElement(BySelector
                .withParameter(generalCheckboxSelector, "Export Individual's Data")).click();
    }

    /**
     * Clicks on the OK to Store PII Data checkbox.
     */
    public void clickOnOkToStorePiiDataCheckbox() {
        findElement(BySelector
                .withParameter(generalCheckboxSelector, "OK to Store PII Data")).click();
    }

    /**
     * Clicks on the Block Geolocation checkbox.
     */
    public void clickOnBlockGeolocationCheckbox() {
        findElement(BySelector
                .withParameter(generalCheckboxSelector, "Block Geolocation")).click();
    }

    /**
     * Clicks on the Don't Profile checkbox.
     */
    public void clickOnDontProfileCheckbox() {
        findElement(BySelector.withParameter(generalCheckboxSelector, "Don't Profile")).click();
    }

    /**
     * Clicks on the Don't Track Checkbox.
     */
    public void clickOnDontTrackCheckbox() {
        findElement(BySelector.withParameter(generalCheckboxSelector, "Don't Track")).click();
    }

    /**
     * Clicks on the Forget This Individual checkbox.
     */
    public void clickOnForgetThisIndividualCheckbox() {
        findElement(BySelector
                .withParameter(generalCheckboxSelector, "Forget This Individual")).click();
    }

    /**
     * Clicks on the IndividualAgeSelector.
     */
    public void clickOnIndividualAgeSelector() {
        findElement(individualAgeSelector).click();
    }

    /**
     * Clicks on the Age13 option.
     */
    public void clickOnAge13Option() {
        findElement(age13Option).click();
    }

    /**
     * Clicks on the Age16 option.
     */
    public void clickOnAge16Option() {
        findElement(age16Option).click();
    }

    /**
     * Clicks on the save button.
     * @return IndividualRecordPage
     */
    public IndividualRecordPage clickOnsave() {
        findElement(saveButton).click();
        return new IndividualRecordPage();
    }

    /**
     * Returns an alert message.
     * @return String
     */
    public String getCreatedSuccessMessage() {
        getWait().until(ExpectedConditions.visibilityOf(findElement(createdSuccessMessage)));
        return findElement(createdSuccessMessage).getText();
    }

    /**
     * Checks if the createdIndividual label element is visible.
     *
     * @return a boolean
     */
    public Boolean isVisibleIndividualNameInHeader() {
        return findElement(createdIndividualLabel).isDisplayed();
    }

    /**
     * Returns the text of the IndividualName element.
     * @return String
     */
    public String getCreatedIndividualNameInHeader() {
        return findElement(createdIndividualLabel).getText();
    }

    /**
     * Method to wait for a page to load.
     */
    @Override
    protected void waitForPageToLoad() {
        getWait().until(ExpectedConditions.presenceOfElementLocated(saveButton));
    }
}
