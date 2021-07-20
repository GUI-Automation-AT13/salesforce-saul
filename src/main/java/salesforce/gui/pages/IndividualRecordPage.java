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

    private By relatedIndividualHistoryLink = By.cssSelector("h2 [title=\"Individual History\"]");
    private By relatedContacts = By.cssSelector("h2 [title=\"Contacts\"]");
    private By relatedLeads = By.cssSelector("h2 [title=\"Leads\"]");
    private By relatedContactPointEmails = By.cssSelector("h2 [title=\"Contact Point Emails\"]");
    private By relatedContactPointPhones = By.cssSelector("h2 [title=\"Contact Point Phones\"]");

    private By nameDetailField = By.xpath("//span[contains(text(),\"Name\")]/../.."
            + "//span[@class=\"uiOutputText\"]");
    private By birthdateDetailField = By.xpath("//span[contains(text(),\"Birth Date\")]"
            + "/../..//span[contains(@class,\"test-id__field-value\")]");
    private By dontProcessCheckbox = By.xpath("//span[contains(text(),\"Don't Process\")]"
            + "/../..//img[@alt]");
    private By dontMarketCheckbox = By.xpath("//span[contains(text(),\"Don't Market\")]"
            + "/../..//img[@alt]");
    private By exportIndividualDataCheckbox = By.xpath("//span[contains(text(),"
            + "\"Export Individual's Data\")]/../..//img[@alt]");
    private By okToStorePiiDataElsewhereCheckbox = By.xpath("//span[contains(text(),"
            + "\"OK to Store PII Data Elsewhere\")]/../..//img[@alt]");
    private By blockGeolocationTrackingCheckbox = By.xpath("//span[contains(text(),"
            + "\"Block Geolocation Tracking\")]/../..//img[@alt]");
    private By dontProfileCheckbox = By.xpath("//span[contains(text(),\"Don't Profile\")]"
            + "/../..//img[@alt]");
    private By forgetThisIndividualCheckbox = By.xpath("//span[contains(text(),"
            + "\"Forget this Individual\")]/../..//img[@alt]");
    private By individualsAgeDetailField = By.xpath("//span[contains(text(),\"Individual's Age\")]"
            + "/../..//span[contains(@class,\"test-id__field-value\")]");

    /**
     * IndividualRecordPage constructor.
     */
    public IndividualRecordPage() {
        PageFactory.initElements(getDriver(), this);
    }

    /**
     * Returns the individual's full name in the Header.
     *
     * @return String
     */
    public String getNameHeaderLabel() {
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
     * Waits for the nameHeader element to load.
     */
    @Override
    protected void waitForPageToLoad() {
        getWait().until(ExpectedConditions.presenceOfElementLocated(nameHeaderLabel));
    }
}
