/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package org.salesforce.scenarios.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import salesforce.gui.pages.NewObjectPage;
import salesforce.gui.pages.ObjectListPage;
import salesforce.gui.pages.ObjectRecordPage;
import salesforce.gui.pages.PageTransporter;

public class GeneralSteps {

    private Logger logger = LogManager.getLogger(getClass());
    private SoftAssert softAssert = new SoftAssert();
    private PageTransporter pageTransporter;
    private NewObjectPage newObjectPage;
    private ObjectRecordPage objectRecordPage;
    private ObjectListPage objectListPage;
    private Object entity;

    public GeneralSteps(PageTransporter pageTransporter, Object entity) {
        this.pageTransporter = pageTransporter;
        this.entity = entity;
    }

    @Given("^I navigate to the new (.*?) page$")
    public void iNavigateToThePage(final String page) {
        newObjectPage = pageTransporter.navigateToNewObjectPage(page);
    }

    @When("^I create a new (.*?) record with the following parameters$")
    public void iCreateAnewRecordWithTheFollowingParameters(final String feature, final Map<String, String> table) {
        entity = newObjectPage.createObject(table);
    }

    @Then("^The message should contain the (.*?) text$")
    public void theMessageShouldContainTheText(final String text) {
        newObjectPage.getStatusMessage();
        softAssert.assertEquals(newObjectPage.getStatusMessage(), text);
    }

    @Then("^The (.*?) record header's name title should match the (.*) text$")
    public void theRecordHeadersNameTitleShouldMatchTheText(final String feature, final String text) {
        objectRecordPage = pageTransporter.getRecordPage(feature);
        softAssert.assertEquals(objectRecordPage.getHeaderName(), text);
    }
    @When("^I click on the (.*?) Details tab$")
    public void iClickOnTheDetailsTab(final String feature) {
        objectRecordPage.clickOnTheDetailsTab();
    }

    @Then("^The details from the (.*?) object should match the given parameters$")
    public void theDetailsFromTheObjectShouldMatchTheGivenParameters(final String object, final Map<String, String> details) {
        softAssert.assertTrue(objectRecordPage.detailsMatch(entity, details));
    }

    @Then("^The Individual List Page should contain a record with (.*) and (.*)$")
    public void theIndividualListPageShouldContainArecordWith(final String firstname, final String lastname) {
        objectListPage = pageTransporter.navigateToObjectListPage("Individual");
        Assert.assertTrue(objectListPage.isThereRecordWithName(firstname.concat(" ").concat(lastname)));
    }
}