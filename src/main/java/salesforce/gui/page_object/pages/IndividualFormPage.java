/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.gui.page_object.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class IndividualFormPage extends BasePage {

    private By salutationSelector = By.cssSelector(".salutation a");
    private By mrOption = By.cssSelector("[title=\"Mr.\"]");
    private By msOption = By.cssSelector("[title=\"Ms.\"]");
    private By mrsOption = By.cssSelector("[title=\"Mrs.\"]");
    private By drOption = By.cssSelector("[title=\"Dr.\"]");
    private By profOption = By.cssSelector("[title=\"Prof.\"]");
    private By firstnameTextbox = By.cssSelector(".firstName");
    private By lastnameTextbox = By.cssSelector(".lastName");
    private By birthdateDateField = By.cssSelector("input[class=' input']");
    private By dontProcessCheckbox = By.xpath("//div[label[contains(.,\"Don't Process\")]]/input");
    private By dontMarketCheckbox = By.xpath("//div[label[contains(.,\"Don't Market\")]]/input");
    private By exportIndividualDataCheckbox = By.xpath("//div[label[contains(.,\""
            + "Export Individual's Data\")]]/input");
    private By okToStorePiiDataCheckbox = By.xpath("//div[label[contains(.,\""
            + "OK to Store PII Data Elsewhere\")]]/input");
    private By blockGeolocationCheckbox = By.xpath("//div[label[contains(.,\""
            + "Block Geolocation Tracking\")]]/input");
    private By dontProfileCheckbox = By.xpath("//div[label[contains(.,\"Don't Profile\")]]/input");
    private By dontTrackCheckbox = By.xpath("//div[label[contains(.,\"Don't Track\")]]/input");
    private By forgetThisIndividualCheckbox = By.xpath("//div[label[contains(.,\""
            + "Forget this Individual\")]]/input");
    private By individualAgeSelector = By.xpath("//div[span[span[contains(text(),'Age')]]]/div//a");
    private By age13Option = By.xpath("//a[contains(text(),\'13 or Older\')]");
    private By age16Option = By.xpath("//a[contains(text(),\'16 or Older\')]");
    private By saveButton = By.cssSelector("button[title=\"Save\"]");
    private By createdIndividualLabel = By.cssSelector(".slds-page-header__title > .uiOutputText");

    /**
     * Constructor for WebDriver.
     */
    public IndividualFormPage() {
        PageFactory.initElements(super.getDriver(), this);
    }

    /**
     * Clicks the saluatation selector.
     */
    public void selectSalutation() {
        getDriver().findElement(salutationSelector).click();
    }

    /**
     * Clicks the Mr. option
     */
    public void selectMrOption() {
        getDriver().findElement(mrOption).click();
    }

    /**
     * Clicks the Mrs. option
     */
    public void selectMrsOption() {
        getDriver().findElement(mrsOption).click();
    }

    /**
     * Clicks the Ms. option
     */
    public void selectMsOption() {
        getDriver().findElement(msOption).click();
    }

    /**
     * Clicks the Dr. option
     */
    public void selectDrOption() {
        getDriver().findElement(drOption).click();
    }

    /**
     * Clicks the Prof. option
     */
    public void selectProfOption() {
        getDriver().findElement(profOption).click();
    }

    /**
     * Sets the firstname value to the field.
     *
     * @param firstname
     */
    public void setFirstnameTextbox(final String firstname) {
        getDriver().findElement(firstnameTextbox).sendKeys(firstname);
    }

    /**
     * Sets the lastname value to the field.
     *
     * @param lastname
     */
    public void setLastnameTextbox(final String lastname) {
        getDriver().findElement(lastnameTextbox).sendKeys(lastname);
    }

    /**
     * Sets the date for the birthdate field.
     *
     * @param date
     */
    public void setBirthdateDateField(final String date) {
        getDriver().findElement(birthdateDateField).sendKeys(date);
    }

    /**
     * Clicks on the don't process checkbox.
     */
    public void checkDontProcessCheckbox() {
        getDriver().findElement(dontProcessCheckbox).click();
    }

    /**
     * Clicks on the don't market checkbox.
     */
    public void checkDontMarketCheckbox() {
        getDriver().findElement(dontMarketCheckbox).click();
    }

    /**
     * Clicks on the ExportIndividualData checkbox.
     */
    public void checkExportIndividualDataCheckbox() {
        getDriver().findElement(exportIndividualDataCheckbox).click();
    }

    /**
     * Clicks on the OkToStorePiiData checkbox.
     */
    public void checkOkToStorePiiDataCheckbox() {
        getDriver().findElement(okToStorePiiDataCheckbox).click();
    }

    /**
     * Clicks on the BlockGeolocation checkbox.
     */
    public void checkBlockGeolocationCheckbox() {
        getDriver().findElement(blockGeolocationCheckbox).click();
    }

    /**
     * Clicks on the Don'tProfile checkbox.
     */
    public void checkDontProfileCheckbox() {
        getDriver().findElement(dontProfileCheckbox).click();
    }

    /**
     * Clicks on the Don'tTrackCheckbox.
     */
    public void checkDontTrackCheckbox() {
        getDriver().findElement(dontTrackCheckbox).click();
    }

    /**
     * Clicks on the ForgetThisIndividual checkbox.
     */
    public void checkForgetThisIndividualCheckbox() {
        getDriver().findElement(forgetThisIndividualCheckbox).click();
    }

    /**
     * Clicks on the IndividualAgeSelector.
     */
    public void selectIndividualAgeSelector() {
        getDriver().findElement(individualAgeSelector).click();
    }

    /**
     * Clicks on the Age13 option.
     */
    public void selectAge13Option() {
        getDriver().findElement(age13Option).click();
    }

    /**
     * Clicks on the Age16 option.
     */
    public void selectAge16Option() {
        getDriver().findElement(age16Option).click();
    }

    /**
     * Clicks on the save button.
     */
    public void save() {
        getDriver().findElement(saveButton).click();
    }

    /**
     * Checks if the createdIndividual label element is visible.
     *
     * @return a boolean
     */
    public Boolean createdIndividualLabelVisibility() {
        return getDriver().findElement(createdIndividualLabel).isDisplayed();
    }

    /**
     * Method to wait for a page to load.
     */
    @Override
    protected void waitForPageToLoad() {
        getWait().until(ExpectedConditions.presenceOfElementLocated(saveButton));
    }
}
