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

public class IndividualRecordPage extends BasePage {

    private By nameHeaderLabel = By.cssSelector("h1 .uiOutputText");
    private By editHeaderButton = By.cssSelector("div[title=\"Edit\"]");
    private By deleteHeaderButton = By.cssSelector("div[title=\"Delete\"]");
    private By cloneHeaderButton = By.cssSelector("div[title=\"Clone\"]");

    private By confirmDeleteIndividualButton = By.cssSelector("button[title=\"Delete\"] span");

    private final String relatedFeatureLink = "h2 [title=\"%s\"]";

    private final String newFeatureButton = "//span[@title=\"%s\"]/ancestor::div[contains("
            + "@class,\"slds-grid\")]//div[@title=\"New\"]";

    private By labelNameDetail = By.xpath("//span[contains(text(),\"Name\")]/../.."
            + "//span[@class=\"uiOutputText\"]");
    private By labelBirthdateDetail = By.xpath("//span[contains(text(),\"Birth Date\")]"
            + "/../..//span[contains(@class,\"test-id__field-value\")]");
    private String checkboxDetail = "//span[contains(text(),\"%s\")]/../..//img[@alt]";
    private By labelIndividualsAgeDetail = By.xpath("//span[contains(text(),\"Individual's Age\")]"
            + "/../..//span[contains(@class,\"test-id__field-value\")]");
    private By deletedSuccessMessage = By.xpath("//span[contains(.,\"was deleted.\")]");
    private By detailsTabButton = By.xpath("//span[contains(.,\"Details\")]");

    /**
     * Deletes the created individual.
     *
     * @return a HomePage instance.
     */
    public IndividualListPage deleteCreatedIndividual() {
        findElement(deleteHeaderButton).click();
        findElement(confirmDeleteIndividualButton).click();
        return new IndividualListPage();
    }

    /**
     * Returns an alert message.
     *
     * @return String
     */
    public String getDeletedSuccessMessage() {
        getWait().until(ExpectedConditions.visibilityOf(findElement(deletedSuccessMessage)));
        return findElement(deletedSuccessMessage).getText();
    }

    /**
     * Returns the individual's full name in the Header.
     *
     * @return String
     */
    public String getNameHeaderText() {
        return findElement(nameHeaderLabel).getText();
    }

    /**
     * Clicks on the Edit button in the header.
     */
    public void clickEditHeaderButton() {
        findElement(editHeaderButton).click();
    }

    /**
     * Clicks on the Delete button in the header.
     */
    public void clickDeleteHeaderButton() {
        findElement(deleteHeaderButton).click();
    }

    /**
     * Clicks on the Clone button in the header.
     */
    public void clickCloneHeaderButton() {
        findElement(cloneHeaderButton).click();
    }

    /**
     * Clicks on the relatedIndividualHistoryLink.
     */
    public void clickRelatedIndividualHistoryLink() {
        findElement(BySelector.withParameter(relatedFeatureLink, "Individual History")).click();
    }

    /**
     * Clicks on the relatedContactsLink.
     */
    public void clickRelatedContactsLink() {
        findElement(BySelector.withParameter(relatedFeatureLink, "Contacts")).click();
    }

    /**
     * Clicks on the relatedLeadsLink.
     */
    public void clickRelatedLeadsLink() {
        findElement(BySelector.withParameter(relatedFeatureLink, "Leads")).click();
    }

    /**
     * Clicks on the relatedContactPointEmailsLink.
     */
    public void clickRelatedContactPointEmailsLink() {
        findElement(BySelector.withParameter(relatedFeatureLink, "Contact Point Emails")).click();
    }

    /**
     * Clicks on the relatedContactPointPhonesLink.
     */
    public void clickRelatedContactPointPhonesLink() {
        findElement(BySelector.withParameter(relatedFeatureLink, "Contact Point Phones")).click();
    }

    /**
     * Clicks on the Details tab.
     */
    public void clickonDetailsTab() {
        findElement(detailsTabButton).click();
    }

    /**
     * Returns the name text in the details tab.
     *
     * @return String
     */
    public String getNameDetail() {
        return findElement(labelNameDetail).getText();
    }

    /**
     * Returns the birthdate text in the details tab.
     *
     * @return String
     */
    public String getBrithdateDetail() {
        return findElement(labelBirthdateDetail).getText();
    }

    /**
     * Returns the value of the Don't Process checkbox.
     *
     * @return boolean
     */
    public boolean checkIfDontProcess() {
        return findElement(BySelector.withParameter(checkboxDetail, "Don't Process")).isSelected();
    }

    /**
     * Returns the value of the Don't Market checkbox.
     *
     * @return boolean
     */
    public boolean checkIfDontMarket() {
        return findElement(BySelector.withParameter(checkboxDetail, "Don't Market")).isSelected();
    }

    /**
     * Returns the value of the Export Individual's Data checkbox.
     *
     * @return boolean
     */
    public boolean checkIfExportIndividualsData() {
        return findElement(BySelector.withParameter(checkboxDetail, "Export Individual's Data"))
                .isSelected();
    }

    /**
     * Returns the value of the OK to Store PII Data Elsewhere checkbox.
     *
     * @return boolean
     */
    public boolean checkIfOkToStorePiiDataElsewhere() {
        return findElement(BySelector.withParameter(checkboxDetail, "OK to Store PII Data Elsewhere"))
                .isSelected();
    }

    /**
     * Returns the value of the BlockGeolocation checkbox.
     *
     * @return boolean
     */
    public boolean checkIfBlockGeolocationTracking() {
        return findElement(BySelector.withParameter(checkboxDetail, "Block Geolocation Tracking"))
                .isSelected();
    }

    /**
     * Returns the value of the Don't Profile checkbox.
     *
     * @return boolean
     */
    public boolean checkIfDontProfile() {
        return findElement(BySelector.withParameter(checkboxDetail, "Don't Profile")).isSelected();
    }

    /**
     * Returns the value of the Don't Track checkbox.
     *
     * @return boolean
     */
    public boolean checkIfDontTrack() {
        return findElement(BySelector.withParameter(checkboxDetail, "Don't Track")).isSelected();
    }

    /**
     * Returns the value of the ForgetThisIndividual checkbox.
     *
     * @return boolean
     */
    public boolean checkIfForgetThisIndividual() {
        return findElement(BySelector.withParameter(checkboxDetail, "Forget This Individual")).isSelected();
    }

    /**
     * Returns the individual's age in the details tab.
     *
     * @return String
     */
    public String getIndividualAgeDetail() {
        return findElement(labelIndividualsAgeDetail).getText();
    }

    /**
     * Clicks on the new Contact button.
     */
    public void clickOnNewContactButton() {
        findElement(BySelector.withParameter(newFeatureButton, "Contact")).click();
    }

    /**
     * Clicks on the new Lead button.
     */
    public void clickOnNewLeadButton() {
        findElement(BySelector.withParameter(newFeatureButton, "Lead")).click();
    }

    /**
     * Clicks on the new Contact Point Emails button.
     */
    public void clickNewContactPointEmailButton() {
        findElement(BySelector.withParameter(newFeatureButton, "Contact Point Emails")).click();
    }

    /**
     * Clicks on the new Contact Point Phones button.
     */
    public void clickNewContactPointPhoneButton() {
        findElement(BySelector.withParameter(newFeatureButton, "Contact Point Phones")).click();
    }

    /**
     * Waits for the nameHeader element to load.
     */
    @Override
    protected void waitForPageToLoad() {
        getWait().until(ExpectedConditions.presenceOfElementLocated(nameHeaderLabel));
    }
}
