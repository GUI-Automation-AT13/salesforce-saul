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
        getWebElementActions().clickOnElement(deleteHeaderButton);
        getWebElementActions().clickOnElement(confirmDeleteIndividualButton);
        return new IndividualListPage();
    }

    /**
     * Returns an alert message.
     *
     * @return String
     */
    public String getDeletedSuccessMessage() {
        getWait().until(ExpectedConditions.visibilityOf(findElement(deletedSuccessMessage)));
        return getWebElementActions().getText(deletedSuccessMessage);
    }

    /**
     * Returns the individual's full name in the Header.
     *
     * @return String
     */
    public String getNameHeaderText() {
        return getWebElementActions().getText(nameHeaderLabel);
    }

    /**
     * Clicks on the Edit button in the header.
     */
    public void clickEditHeaderButton() {
        getWebElementActions().clickOnElement(editHeaderButton);
    }

    /**
     * Clicks on the Delete button in the header.
     */
    public void clickDeleteHeaderButton() {
        getWebElementActions().clickOnElement(deleteHeaderButton);
    }

    /**
     * Clicks on the Clone button in the header.
     */
    public void clickCloneHeaderButton() {
        getWebElementActions().clickOnElement(cloneHeaderButton);
    }

    /**
     * Clicks on the relatedIndividualHistoryLink.
     */
    public void clickRelatedIndividualHistoryLink() {
        getWebElementActions().clickOnElement(relatedFeatureLink, "Individual History");
    }

    /**
     * Clicks on the relatedContactsLink.
     */
    public void clickRelatedContactsLink() {
        getWebElementActions().clickOnElement(relatedFeatureLink, "Contacts");
    }

    /**
     * Clicks on the relatedLeadsLink.
     */
    public void clickRelatedLeadsLink() {
        getWebElementActions().clickOnElement(relatedFeatureLink, "Leads");
    }

    /**
     * Clicks on the relatedContactPointEmailsLink.
     */
    public void clickRelatedContactPointEmailsLink() {
        getWebElementActions().clickOnElement(relatedFeatureLink, "Contact Point Emails");
    }

    /**
     * Clicks on the relatedContactPointPhonesLink.
     */
    public void clickRelatedContactPointPhonesLink() {
        getWebElementActions().clickOnElement(relatedFeatureLink, "Contact Point Phones");
    }

    /**
     * Clicks on the Details tab.
     */
    public void clickonDetailsTab() {
        getWebElementActions().clickOnElement(detailsTabButton);
    }

    /**
     * Returns the name text in the details tab.
     *
     * @return String
     */
    public String getNameDetail() {
        return getWebElementActions().getText(labelNameDetail);
    }

    /**
     * Returns the birthdate text in the details tab.
     *
     * @return String
     */
    public String getBrithdateDetail() {
        return getWebElementActions().getText(labelBirthdateDetail);
    }

    /**
     * Returns the value of the Don't Process checkbox.
     *
     * @return boolean
     */
    public boolean checkIfDontProcess() {
        return getWebElementActions().isSelected(BySelector.withParameter(checkboxDetail, "Don't Process"));
    }

    /**
     * Returns the value of the Don't Market checkbox.
     *
     * @return boolean
     */
    public boolean checkIfDontMarket() {
        return getWebElementActions().isSelected(BySelector.withParameter(checkboxDetail, "Don't Market"));
    }

    /**
     * Returns the value of the Export Individual's Data checkbox.
     *
     * @return boolean
     */
    public boolean checkIfExportIndividualsData() {
        return getWebElementActions().isSelected(BySelector.withParameter(checkboxDetail, "Export Individual's Data"));
    }

    /**
     * Returns the value of the OK to Store PII Data Elsewhere checkbox.
     *
     * @return boolean
     */
    public boolean checkIfOkToStorePiiDataElsewhere() {
        return getWebElementActions().isSelected(BySelector.
                withParameter(checkboxDetail, "OK to Store PII Data Elsewhere"));
    }

    /**
     * Returns the value of the BlockGeolocation checkbox.
     *
     * @return boolean
     */
    public boolean checkIfBlockGeolocationTracking() {
        return getWebElementActions().isSelected(BySelector
                .withParameter(checkboxDetail, "Block Geolocation Tracking"));
    }

    /**
     * Returns the value of the Don't Profile checkbox.
     *
     * @return boolean
     */
    public boolean checkIfDontProfile() {
        return getWebElementActions().isSelected(BySelector.withParameter(checkboxDetail, "Don't Profile"));
    }

    /**
     * Returns the value of the Don't Track checkbox.
     *
     * @return boolean
     */
    public boolean checkIfDontTrack() {
        return getWebElementActions().isSelected(BySelector.withParameter(checkboxDetail, "Don't Track"));
    }

    /**
     * Returns the value of the ForgetThisIndividual checkbox.
     *
     * @return boolean
     */
    public boolean checkIfForgetThisIndividual() {
        return getWebElementActions().isSelected(BySelector
                .withParameter(checkboxDetail, "Forget This Individual"));
    }

    /**
     * Returns the individual's age in the details tab.
     *
     * @return String
     */
    public String getIndividualAgeDetail() {
        return getWebElementActions().getText(labelIndividualsAgeDetail);
    }

    /**
     * Clicks on the new Contact button.
     */
    public void clickOnNewContactButton() {
        getWebElementActions().clickOnElement(newFeatureButton, "Contact");
    }

    /**
     * Clicks on the new Lead button.
     */
    public void clickOnNewLeadButton() {
        getWebElementActions().clickOnElement(newFeatureButton, "Lead");
    }

    /**
     * Clicks on the new Contact Point Emails button.
     */
    public void clickNewContactPointEmailButton() {
        getWebElementActions().clickOnElement(newFeatureButton, "Contact Point Emails");
    }

    /**
     * Clicks on the new Contact Point Phones button.
     */
    public void clickNewContactPointPhoneButton() {
        getWebElementActions().clickOnElement(newFeatureButton, "Contact Point Phones");
    }

    /**
     * Waits for the nameHeader element to load.
     */
    @Override
    protected void waitForPageToLoad() {
        getWait().until(ExpectedConditions.presenceOfElementLocated(nameHeaderLabel));
    }
}
