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

public class IndividualRecordPage extends BasePage {

    private By nameHeaderLabel = By.cssSelector("h1 .uiOutputText");
    private By editHeaderButton = By.cssSelector("div[title=\"Edit\"]");
    private By deleteHeaderButton = By.cssSelector("div[title=\"Delete\"]");
    private By cloneHeaderButton = By.cssSelector("div[title=\"Clone\"]");

    private By confirmDeleteIndividualButton = By.cssSelector("button[title=\"Delete\"] span");

    private By relatedIndividualHistoryLink = By.cssSelector("h2 [title=\"Individual History\"]");
    private By relatedContactsLink = By.cssSelector("h2 [title=\"Contacts\"]");
    private By relatedLeadsLink = By.cssSelector("h2 [title=\"Leads\"]");
    private By relatedContactPointEmailsLink = By.cssSelector("h2 [title="
            + "\"Contact Point Emails\"]");
    private By relatedContactPointPhonesLink = By.cssSelector("h2 [title="
            + "\"Contact Point Phones\"]");

    private By newContactButton = By.xpath("//span[@title=\"Contacts\"]/ancestor::div[contains("
            + "@class,\"slds-grid\")]//div[@title=\"New\"]");
    private By newLeadButton = By.cssSelector("//span[@title=\"Leads\"]/ancestor::div[contains("
            + "@class,\"slds-grid\")]//div[@title=\"New\"]");
    private By newContactPointEmailButton = By.xpath("//span[@title=\"Contact Point Emails\"]"
            + "/ancestor::div[contains(@class,\"slds-grid\")]//div[@title=\"New\"]");
    private By newContactPointPhoneButton = By.xpath("//span[@title=\"Contact Point Phones\"]"
            + "/ancestor::div[contains(@class,\"slds-grid\")]//div[@title=\"New\"]");

    private By labelNameDetail = By.xpath("//span[contains(text(),\"Name\")]/../.."
            + "//span[@class=\"uiOutputText\"]");
    private By labelBirthdateDetail = By.xpath("//span[contains(text(),\"Birth Date\")]"
            + "/../..//span[contains(@class,\"test-id__field-value\")]");
    private By checkboxDontProcess = By.xpath("//span[contains(text(),\"Don't Process\")]"
            + "/../..//img[@alt]");
    private By checkboxDontMarket = By.xpath("//span[contains(text(),\"Don't Market\")]"
            + "/../..//img[@alt]");
    private By checkboxExportIndividualData = By.xpath("//span[contains(text(),"
            + "\"Export Individual's Data\")]/../..//img[@alt]");
    private By checkboxOkToStorePiiDataElsewhere = By.xpath("//span[contains(text(),"
            + "\"OK to Store PII Data Elsewhere\")]/../..//img[@alt]");
    private By checkboxBlockGeolocationTracking = By.xpath("//span[contains(text(),"
            + "\"Block Geolocation Tracking\")]/../..//img[@alt]");
    private By checkboxDontTrack = By.xpath("//span[contains(text(),\"Don't Track\")]"
            + "/../..//img[@alt]");
    private By checkboxDontProfile = By.xpath("//span[contains(text(),\"Don't Profile\")]"
            + "/../..//img[@alt]");
    private By checkboxForgetThisIndividual = By.xpath("//span[contains(text(),"
            + "\"Forget this Individual\")]/../..//img[@alt]");
    private By labelIndividualsAgeDetail = By.xpath("//span[contains(text(),\"Individual's Age\")]"
            + "/../..//span[contains(@class,\"test-id__field-value\")]");

    private By deletedSuccessMessage = By.xpath("//span[contains(.,\"was deleted.\")]");
    private By detailsTabButton = By.xpath("//span[contains(.,\"Details\")]");

    /**
     * IndividualRecordPage constructor.
     */
    public IndividualRecordPage() {
        PageFactory.initElements(getDriver(), this);
    }

    /**
     * Deletes the created individual.
     *
     * @return a HomePage instance.
     */
    public IndividualListPage deleteCreatedIndividual() {
        WebElement webElement = getDriver().findElement(deleteHeaderButton);
        getWebElementAction().clickOnElement(webElement);
        webElement = getDriver().findElement(confirmDeleteIndividualButton);
        getWebElementAction().clickOnElement(webElement);
        return new IndividualListPage();
    }

    /**
     * Returns an alert message.
     * @return String
     */
    public String getDeletedSuccessMessage() {
        getWait().until(ExpectedConditions.visibilityOf(getDriver()
                .findElement(deletedSuccessMessage)));
        return getDriver().findElement(deletedSuccessMessage).getText();
    }

    /**
     * Returns the individual's full name in the Header.
     *
     * @return String
     */
    public String getNameHeaderText() {
        return getDriver().findElement(nameHeaderLabel).getText();
    }

    /**
     * Clicks on the Edit button in the header.
     */
    public void clickEditHeaderButton() {
        WebElement webElement = getDriver().findElement(editHeaderButton);
        getWebElementAction().clickOnElement(webElement);
    }

    /**
     * Clicks on the Delete button in the header.
     */
    public void clickDeleteHeaderButton() {
        WebElement webElement = getDriver().findElement(deleteHeaderButton);
        getWebElementAction().clickOnElement(webElement);
    }

    /**
     * Clicks on the Clone button in the header.
     */
    public void clickCloneHeaderButton() {
        WebElement webElement = getDriver().findElement(cloneHeaderButton);
        getWebElementAction().clickOnElement(webElement);
    }

    /**
     * Clicks on the relatedIndividualHistoryLink.
     */
    public void clickRelatedIndividualHistoryLink() {
        WebElement webElement = getDriver().findElement(relatedIndividualHistoryLink);
        getWebElementAction().clickOnElement(webElement);
    }

    /**
     * Clicks on the relatedContactsLink.
     */
    public void clickRelatedContactsLink() {
        WebElement webElement = getDriver().findElement(relatedContactsLink);
        getWebElementAction().clickOnElement(webElement);
    }

    /**
     * Clicks on the relatedLeadsLink.
     */
    public void clickRelatedLeadsLink() {
        WebElement webElement = getDriver().findElement(relatedLeadsLink);
        getWebElementAction().clickOnElement(webElement);
    }

    /**
     * Clicks on the relatedContactPointEmailsLink.
     */
    public void clickRelatedContactPointEmailsLink() {
        WebElement webElement = getDriver().findElement(relatedContactPointEmailsLink);
        getWebElementAction().clickOnElement(webElement);
    }

    /**
     * Clicks on the relatedContactPointPhonesLink.
     */
    public void clickRelatedContactPointPhonesLink() {
        WebElement webElement = getDriver().findElement(relatedContactPointPhonesLink);
        getWebElementAction().clickOnElement(webElement);
    }

    /**
     * Clicks on the Details tab.
     */
    public void clickonDetailsTab() {
        WebElement webElement = getDriver().findElement(detailsTabButton);
        getWebElementAction().clickOnElement(webElement);
    }
    /**
     * Returns the name text in the details tab.
     *
     * @return String
     */
    public String getNameDetail() {
        return getDriver().findElement(labelNameDetail).getText();
    }

    /**
     * Returns the birthdate text in the details tab.
     *
     * @return String
     */
    public String getBrithdateDetail() {
        return getDriver().findElement(labelBirthdateDetail).getText();
    }

    /**
     * Returns the value of the Don't Process checkbox.
     *
     * @return boolean
     */
    public boolean checkIfDontProcess() {
        return getDriver().findElement(checkboxDontProcess).isSelected();
    }

    /**
     * Returns the value of the Don't Market checkbox.
     *
     * @return boolean
     */
    public boolean checkIfDontMarket() {
        return getDriver().findElement(checkboxDontMarket).isSelected();
    }

    /**
     * Returns the value of the Export Individual's Data checkbox.
     *
     * @return boolean
     */
    public boolean checkIfExportIndividualsData() {
        return getDriver().findElement(checkboxExportIndividualData).isSelected();
    }

    /**
     * Returns the value of the OkToStorePiiDataElsewhere checkbox.
     *
     * @return boolean
     */
    public boolean checkIfOkToStorePiiDataElsewhere() {
        return getDriver().findElement(checkboxOkToStorePiiDataElsewhere).isSelected();
    }

    /**
     * Returns the value of the BlockGeolocation checkbox.
     *
     * @return boolean
     */
    public boolean checkIfBlockGeolocationTracking() {
        return getDriver().findElement(checkboxBlockGeolocationTracking).isSelected();
    }

    /**
     * Returns the value of the Don't Profile checkbox.
     *
     * @return boolean
     */
    public boolean checkIfDontProfile() {
        return getDriver().findElement(checkboxDontProfile).isSelected();
    }

    /**
     * Returns the value of the Don't Track checkbox.
     *
     * @return boolean
     */
    public boolean checkIfDontTrack() {
        return getDriver().findElement(checkboxDontTrack).isSelected();
    }

    /**
     * Returns the value of the ForgetThisIndividual checkbox.
     *
     * @return boolean
     */
    public boolean checkIfForgetThisIndividual() {
        return getDriver().findElement(checkboxForgetThisIndividual).isSelected();
    }

    /**
     * Returns the individual's age in the details tab.
     *
     * @return String
     */
    public String getIndividualAgeDetail() {
        return getDriver().findElement(labelIndividualsAgeDetail).getText();
    }

    /**
     * Clicks on the New Contact button.
     */
    public void clickOnNewContactButton() {
        WebElement webElement = getDriver().findElement(newContactButton);
        getWebElementAction().clickOnElement(webElement);
    }

    /**
     * Clicks on the New Lead button.
     */
    public void clickOnNewLeadButton() {
        WebElement webElement = getDriver().findElement(newLeadButton);
        getWebElementAction().clickOnElement(webElement);
    }

    /**
     * Clicks on the New Contact Point Email button.
     */
    public void clickNewContactPointEmailButton() {
        WebElement webElement = getDriver().findElement(newContactPointEmailButton);
        getWebElementAction().clickOnElement(webElement);
    }

    /**
     * Clicks on the New Contact Point Phone button.
     */
    public void clickNewContactPointPhoneButton() {
        WebElement webElement = getDriver().findElement(newContactPointPhoneButton);
        getWebElementAction().clickOnElement(webElement);
    }

    /**
     * Waits for the nameHeader element to load.
     */
    @Override
    protected void waitForPageToLoad() {
        getWait().until(ExpectedConditions.presenceOfElementLocated(nameHeaderLabel));
    }
}
