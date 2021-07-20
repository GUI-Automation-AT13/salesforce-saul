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

    private By createdSuccessMessage = By.xpath("//span[contains(.,\"was created.\")]");

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
        WebElement webElement = getDriver().findElement(salutationSelector);
        getWebElementAction().clickOnElement(webElement);
    }

    /**
     * Clicks the Mr. option
     */
    public void selectMrOption() {
        WebElement webElement = getDriver().findElement(mrOption);
        getWebElementAction().clickOnElement(webElement);
    }

    /**
     * Clicks the Mrs. option
     */
    public void selectMrsOption() {
        WebElement webElement = getDriver().findElement(mrsOption);
        getWebElementAction().clickOnElement(webElement);
    }

    /**
     * Clicks the Ms. option
     */
    public void selectMsOption() {
        WebElement webElement = getDriver().findElement(msOption);
        getWebElementAction().clickOnElement(webElement);
    }

    /**
     * Clicks the Dr. option
     */
    public void selectDrOption() {
        WebElement webElement = getDriver().findElement(drOption);
        getWebElementAction().clickOnElement(webElement);
    }

    /**
     * Clicks the Prof. option
     */
    public void selectProfOption() {
        WebElement webElement = getDriver().findElement(profOption);
        getWebElementAction().clickOnElement(webElement);
    }

    /**
     * Sets the firstname value to the field.
     *
     * @param firstname
     */
    public void setFirstnameTextbox(final String firstname) {
        WebElement webElement = getDriver().findElement(firstnameTextbox);
        getWebElementAction().setInputField(webElement, firstname);
    }

    /**
     * Sets the lastname value to the field.
     *
     * @param lastname
     */
    public void setLastnameTextbox(final String lastname) {
        WebElement webElement = getDriver().findElement(lastnameTextbox);
        getWebElementAction().setInputField(webElement, lastname);
    }

    /**
     * Sets the date for the birthdate field.
     *
     * @param date
     */
    public void setBirthdateDateField(final String date) {
        WebElement webElement = getDriver().findElement(birthdateDateField);
        getWebElementAction().setInputField(webElement, date);
    }

    /**
     * Clicks on the don't process checkbox.
     */
    public void checkDontProcessCheckbox() {
        WebElement webElement = getDriver().findElement(dontProcessCheckbox);
        getWebElementAction().clickOnElement(webElement);
    }

    /**
     * Clicks on the don't market checkbox.
     */
    public void checkDontMarketCheckbox() {
        WebElement webElement = getDriver().findElement(dontMarketCheckbox);
        getWebElementAction().clickOnElement(webElement);
    }

    /**
     * Clicks on the ExportIndividualData checkbox.
     */
    public void checkExportIndividualDataCheckbox() {
        WebElement webElement = getDriver().findElement(exportIndividualDataCheckbox);
        getWebElementAction().clickOnElement(webElement);
    }

    /**
     * Clicks on the OkToStorePiiData checkbox.
     */
    public void checkOkToStorePiiDataCheckbox() {
        WebElement webElement = getDriver().findElement(okToStorePiiDataCheckbox);
        getWebElementAction().clickOnElement(webElement);
    }

    /**
     * Clicks on the BlockGeolocation checkbox.
     */
    public void checkBlockGeolocationCheckbox() {
        WebElement webElement = getDriver().findElement(blockGeolocationCheckbox);
        getWebElementAction().clickOnElement(webElement);
    }

    /**
     * Clicks on the Don'tProfile checkbox.
     */
    public void checkDontProfileCheckbox() {
        WebElement webElement = getDriver().findElement(dontProfileCheckbox);
        getWebElementAction().clickOnElement(webElement);
    }

    /**
     * Clicks on the Don'tTrackCheckbox.
     */
    public void checkDontTrackCheckbox() {
        WebElement webElement = getDriver().findElement(dontTrackCheckbox);
        getWebElementAction().clickOnElement(webElement);
    }

    /**
     * Clicks on the ForgetThisIndividual checkbox.
     */
    public void checkForgetThisIndividualCheckbox() {
        WebElement webElement = getDriver().findElement(forgetThisIndividualCheckbox);
        getWebElementAction().clickOnElement(webElement);
    }

    /**
     * Clicks on the IndividualAgeSelector.
     */
    public void selectIndividualAgeSelector() {
        WebElement webElement = getDriver().findElement(individualAgeSelector);
        getWebElementAction().clickOnElement(webElement);
    }

    /**
     * Clicks on the Age13 option.
     */
    public void selectAge13Option() {
        WebElement webElement = getDriver().findElement(age13Option);
        getWebElementAction().clickOnElement(webElement);
    }

    /**
     * Clicks on the Age16 option.
     */
    public void selectAge16Option() {
        WebElement webElement = getDriver().findElement(age16Option);
        getWebElementAction().clickOnElement(webElement);
    }

    /**
     * Clicks on the save button.
     * @return IndividualRecordPage
     */
    public IndividualRecordPage save() {
        WebElement webElement = getDriver().findElement(saveButton);
        getWebElementAction().clickOnElement(webElement);
        return new IndividualRecordPage();
    }

    /**
     * Returns an alert message.
     * @return String
     */
    public String getCreatedSuccessMessage() {
        getWait().until(ExpectedConditions.visibilityOf(getDriver()
                .findElement(createdSuccessMessage)));
        return getDriver().findElement(createdSuccessMessage).getText();
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
     * Returns the text of the IndividualName element.
     * @return String
     */
    public String createdIndividualNameText() {
        return getDriver().findElement(createdIndividualLabel).getText();
    }

    /**
     * Method to wait for a page to load.
     */
    @Override
    protected void waitForPageToLoad() {
        getWait().until(ExpectedConditions.presenceOfElementLocated(saveButton));
    }
}
