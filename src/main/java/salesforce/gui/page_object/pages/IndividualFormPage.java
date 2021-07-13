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

public class IndividualFormPage extends BasePage {

    @FindBy(css = ".salutation a")
    private WebElement salutationSelector;

    @FindBy(xpath = "[title=\"Mr.\"]")
    private WebElement mrOption;

    @FindBy(xpath = "[title=\"Ms.\"]")
    private WebElement msOption;

    @FindBy(xpath = "[title=\"Mrs.\"]")
    private WebElement mrsOption;

    @FindBy(xpath = "[title=\"Dr.\"]")
    private WebElement drOption;

    @FindBy(xpath = "[title=\"Prof.\"]")
    private WebElement profOption;

    @FindBy(css = ".firstName")
    private WebElement firstnameTextbox;

    @FindBy(css = ".lastName")
    private WebElement lastnameTextbox;

    @FindBy(css = "input[class=' input']")
    private WebElement birthdateDateField;

    @FindBy(xpath = "//div[label[contains(.,\"Don't Process\")]]/input")
    private WebElement dontProcessCheckbox;

    @FindBy(xpath = "//div[label[contains(.,\"Don't Market\")]]/input")
    private WebElement dontMarketCheckbox;

    @FindBy(xpath = "//div[label[contains(.,\"Export Individual's Data\")]]/input")
    private WebElement exportIndividualDataCheckbox;

    @FindBy(xpath = "//div[label[contains(.,\"OK to Store PII Data Elsewhere\")]]/input")
    private WebElement okToStorePiiDataCheckbox;

    @FindBy(xpath = "//div[label[contains(.,\"Block Geolocation Tracking\")]]/input")
    private WebElement blockGeolocationCheckbox;

    @FindBy(xpath = "//div[label[contains(.,\"Don't Profile\")]]/input")
    private WebElement dontProfileCheckbox;

    @FindBy(xpath = "//div[label[contains(.,\"Don't Track\")]]/input")
    private WebElement dontTrackCheckbox;

    @FindBy(xpath = "//div[label[contains(.,\"Forget this Individual\")]]/input")
    private WebElement forgetThisIndividualCheckbox;

    @FindBy(xpath = "//div[span[span[contains(text(),'Age')]]]/div//a")
    private WebElement individualAgeSelector;

    @FindBy(xpath = "//a[contains(text(),\'13 or Older\')]")
    private WebElement age13Option;

    @FindBy(xpath = "//a[contains(text(),\'16 or Older\')]")
    private WebElement age16Option;

    @FindBy(css = "button[title=\"Save\"]")
    private WebElement saveButton;

    @FindBy(css = ".slds-page-header__title > .uiOutputText")
    private WebElement createdIndividualLabel;

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
        salutationSelector.click();
    }

    /**
     * Clicks the Mr. option
     */
    public void selectMrOption() {
        mrOption.click();
    }

    /**
     * Clicks the Mrs. option
     */
    public void selectMrsOption() {
        mrsOption.click();
    }

    /**
     * Clicks the Ms. option
     */
    public void selectMsOption() {
        msOption.click();
    }

    /**
     * Clicks the Dr. option
     */
    public void selectDrOption() {
        drOption.click();
    }

    /**
     * Clicks the Prof. option
     */
    public void selectProfOption() {
        profOption.click();
    }

    /**
     * Sets the firstname value to the field.
     *
     * @param firstname
     */
    public void setFirstnameTextbox(final String firstname) {
        firstnameTextbox.sendKeys(firstname);
    }

    /**
     * Sets the lastname value to the field.
     *
     * @param lastname
     */
    public void setLastnameTextbox(final String lastname) {
        lastnameTextbox.sendKeys(lastname);
    }

    /**
     * Sets the date for the birthdate field.
     *
     * @param date
     */
    public void setBirthdateDateField(final String date) {
        birthdateDateField.sendKeys(date);
    }

    /**
     * Clicks on the don't process checkbox.
     */
    public void checkDontProcessCheckbox() {
        dontProcessCheckbox.click();
    }

    /**
     * Clicks on the don't market checkbox.
     */
    public void checkDontMarketCheckbox() {
        dontMarketCheckbox.click();
    }

    /**
     * Clicks on the ExportIndividualData checkbox.
     */
    public void checkExportIndividualDataCheckbox() {
        exportIndividualDataCheckbox.click();
    }

    /**
     * Clicks on the OkToStorePiiData checkbox.
     */
    public void checkOkToStorePiiDataCheckbox() {
        okToStorePiiDataCheckbox.click();
    }

    /**
     * Clicks on the BlockGeolocation checkbox.
     */
    public void checkBlockGeolocationCheckbox() {
        blockGeolocationCheckbox.click();
    }

    /**
     * Clicks on the Don'tProfile checkbox.
     */
    public void checkDontProfileCheckbox() {
        dontProfileCheckbox.click();
    }

    /**
     * Clicks on the Don'tTrackCheckbox.
     */
    public void checkDontTrackCheckbox() {
        dontTrackCheckbox.click();
    }

    /**
     * Clicks on the ForgetThisIndividual checkbox.
     */
    public void checkForgetThisIndividualCheckbox() {
        forgetThisIndividualCheckbox.click();
    }

    /**
     * Clicks on the IndividualAgeSelector.
     */
    public void selectIndividualAgeSelector() {
        individualAgeSelector.click();
    }

    /**
     * Clicks on the Age13 option.
     */
    public void selectAge13Option() {
        age13Option.click();
    }

    /**
     * Clicks on the Age16 option.
     */
    public void selectAge16Option() {
        age16Option.click();
    }

    /**
     * Clicks on the save button.
     */
    public void save() {
        saveButton.click();
    }

    /**
     * Checks if the createdIndividual label element is visible.
     *
     * @return a boolean
     */
    public Boolean createdIndividualLabelVisibility() {
        return createdIndividualLabel.isDisplayed();
    }

    /**
     * Method to wait for a page to load.
     */
    @Override
    protected void waitForPageToLoad() {

    }
}
