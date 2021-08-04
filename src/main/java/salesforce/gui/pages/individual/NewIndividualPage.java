/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.gui.pages.individual;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.gui.entities.IndividualEntity;
import salesforce.gui.pages.BasePage;
import salesforce.gui.pages.NewObjectPage;

/**
 * POM for the Salesforce new Individual page.
 */
public class NewIndividualPage extends BasePage implements NewObjectPage {

    private final String generalSalutationOptionSelector = "[title=\"%s\"]";
    private final String generalCheckboxSelector = "//div[label[contains(.,\"%s\")]]/input";
    private final String ageGeneralSelector = "//a[contains(text(),\'%s\')]";
    private By salutationSelector = By.cssSelector(".salutation a");
    private By firstnameTextbox = By.cssSelector(".firstName");
    private By lastnameTextbox = By.cssSelector(".lastName");
    private By birthdateDateField = By.cssSelector("input[class=' input']");
    private By individualAgeSelector = By.xpath("//div[span[span[contains(text(),'Age')]]]/div//a");
    private By saveButton = By.cssSelector("button[title=\"Save\"]");
    private By createdIndividualLabel = By.cssSelector(".slds-page-header__title > .uiOutputText");
    private By createdSuccessMessage = By.xpath("//span[contains(.,\"was created.\")]");

    /**
     * Clicks the saluatation selector.
     */
    public void clickOnSalutationDropDownMenu() {
        getWebElementActions().clickOnElement(salutationSelector);
    }

    /**
     * Clicks the Mr. option
     */
    public void clickOnMrOption() {
        getWebElementActions().clickOnElement(generalSalutationOptionSelector, "Mr.");
    }

    /**
     * Clicks the Mrs. option
     */
    public void clickOnMrsOption() {
        getWebElementActions().clickOnElement(generalSalutationOptionSelector, "Mrs.");
    }

    /**
     * Clicks the Ms. option
     */
    public void clickOnMsOption() {
        getWebElementActions().clickOnElement(generalSalutationOptionSelector, "Ms.");
    }

    /**
     * Clicks the Dr. option
     */
    public void clickOnDrOption() {
        getWebElementActions().clickOnElement(generalSalutationOptionSelector, "Dr.");
    }

    /**
     * Clicks the Prof. option
     */
    public void clickOnProfOption() {
        getWebElementActions().clickOnElement(generalSalutationOptionSelector, "Prof.");
    }

    /**
     * Sets the firstname value to the field.
     *
     * @param firstname represents the Individual's firstname
     */
    public void setFirstnameTextbox(final String firstname) {
        getWebElementActions().setInputField(firstnameTextbox, firstname);
    }

    /**
     * Sets the lastname value to the field.
     *
     * @param lastname represents the Individual's lastname
     */
    public void setLastnameTextbox(final String lastname) {
        getWebElementActions().setInputField(lastnameTextbox, lastname);
    }

    /**
     * Sets the date for the birthdate field.
     *
     * @param date represents the birthdate date.
     */
    public void setBirthdateDateField(final String date) {
        getWebElementActions().setInputField(birthdateDateField, date);
    }

    /**
     * Clicks on the Don't Process checkbox.
     */
    public void clickOnDontProcessCheckbox() {
        getWebElementActions().clickOnElement(generalCheckboxSelector, "Don't Process");
    }

    /**
     * Clicks on the Don't Market checkbox.
     */
    public void clickOnDontMarketCheckbox() {
        getWebElementActions().clickOnElement(generalCheckboxSelector, "Don't Market");
    }

    /**
     * Clicks on the Export Individual's Data checkbox.
     */
    public void clickOnExportIndividualDataCheckbox() {
        getWebElementActions().clickOnElement(generalCheckboxSelector, "Export Individual's Data");
    }

    /**
     * Clicks on the OK to Store PII Data checkbox.
     */
    public void clickOnOkToStorePiiDataCheckbox() {
        getWebElementActions().clickOnElement(generalCheckboxSelector, "OK to Store PII Data");
    }

    /**
     * Clicks on the Block Geolocation checkbox.
     */
    public void clickOnBlockGeolocationCheckbox() {
        getWebElementActions().clickOnElement(generalCheckboxSelector, "Block Geolocation");
    }

    /**
     * Clicks on the Don't Profile checkbox.
     */
    public void clickOnDontProfileCheckbox() {
        getWebElementActions().clickOnElement(generalCheckboxSelector, "Don't Profile");
    }

    /**
     * Clicks on the Don't Track Checkbox.
     */
    public void clickOnDontTrackCheckbox() {
        getWebElementActions().clickOnElement(generalCheckboxSelector, "Don't Track");
    }

    /**
     * Clicks on the Forget This Individual checkbox.
     */
    public void clickOnForgetThisIndividualCheckbox() {
        getWebElementActions().clickOnElement(generalCheckboxSelector, "Forget this Individual");
    }

    /**
     * Clicks on the IndividualAgeSelector.
     */
    public void clickOnIndividualAgeSelector() {
        getWebElementActions().clickOnElement(individualAgeSelector);
    }

    /**
     * Clicks on the Age13 option.
     */
    public void clickOnAge13Option() {
        getWebElementActions().clickOnElement(ageGeneralSelector, "13 or Older");
    }

    /**
     * Clicks on the Age16 option.
     */
    public void clickOnAge16Option() {
        getWebElementActions().clickOnElement(ageGeneralSelector, "16 or Older");
    }

    /**
     * Clicks on the save button.
     *
     * @return IndividualRecordPage
     */
    public IndividualRecordPage clickOnsave() {
        getWebElementActions().clickOnElement(saveButton);
        return new IndividualRecordPage();
    }

    /**
     * Returns an alert message.
     *
     * @return String
     */
    public String getCreatedSuccessMessage() {
        getWait().until(ExpectedConditions.visibilityOf(findElement(createdSuccessMessage)));
        return getWebElementActions().getText(createdSuccessMessage);
    }

    /**
     * Checks if the createdIndividual label element is visible.
     *
     * @return a boolean
     */
    public Boolean isVisibleIndividualNameInHeader() {
        return getWebElementActions().isDisplayed(createdIndividualLabel);
    }

    /**
     * Returns the text of the IndividualName element.
     *
     * @return String
     */
    public String getCreatedIndividualNameInHeader() {
        return getWebElementActions().getText(createdIndividualLabel);
    }

    /**
     * Creates an individual with the given parameters in a map.
     *
     * @param fields represents the fields
     * @param entity represents a Salesforce object
     * @return IndividualFormPage
     */
    public NewIndividualPage createIndividual(final Set<String> fields, final IndividualEntity entity) {
        HashMap<String, Runnable> strategyMap = new HashMap<>();
        strategyMap.put("salutation", () -> clickOnSalutationOption(entity.getSalutation()));
        strategyMap.put("lastname", () -> setLastnameTextbox(entity.getLastname()));
        strategyMap.put("firstname", () -> setFirstnameTextbox(entity.getFirstname()));
        strategyMap.put("birthdate", () -> setBirthdateDateField(entity.getBirthdate()));
        strategyMap.put("dontProcess", () -> clickOnDontProcessCheckbox());
        strategyMap.put("dontMarket", () -> clickOnDontMarketCheckbox());
        strategyMap.put("exportIndividualsData", () -> clickOnExportIndividualDataCheckbox());
        strategyMap.put("okToStorePiiDataElsewhere", () -> clickOnOkToStorePiiDataCheckbox());
        strategyMap.put("blockGeolocationTracking", () -> clickOnBlockGeolocationCheckbox());
        strategyMap.put("dontProfile", () -> clickOnDontProfileCheckbox());
        strategyMap.put("dontTrack", () -> clickOnDontTrackCheckbox());
        strategyMap.put("forgetThisIndividual", () -> clickOnForgetThisIndividualCheckbox());
        strategyMap.put("individualsAge", () -> clickOnIndividualAgeOption(entity.getIndividualsAge()));
        fields.forEach(field -> strategyMap.get(field).run());
        clickOnsave();
        return this;
    }

    private void clickOnIndividualAgeOption(String age) {
        clickOnIndividualAgeSelector();
        getWebElementActions().clickOnElement(ageGeneralSelector, age);
    }

    private void clickOnSalutationOption(String salutation) {
        clickOnSalutationDropDownMenu();
        getWebElementActions().clickOnElement(generalSalutationOptionSelector, salutation);
    }

    /**
     * Method to wait for a page to load.
     */
    @Override
    protected void waitForPageToLoad() {
        getWait().until(ExpectedConditions.presenceOfElementLocated(saveButton));
    }

    @Override
    public <T> T createObject(final Map<String, String> dataTable) {
        ObjectMapper objectMapper = new ObjectMapper();
        IndividualEntity individualEntity = objectMapper.convertValue(dataTable, IndividualEntity.class);
        createIndividual(dataTable.keySet(), individualEntity);
        return (T) individualEntity;
    }

    @Override
    public String getStatusMessage() {
        return null;
    }
}
