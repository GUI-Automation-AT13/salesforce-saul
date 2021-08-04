/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package org.salesforce.scenarios.steps;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import salesforce.gui.entities.IndividualEntity;
import salesforce.gui.pages.IndividualFormPage;
import salesforce.gui.pages.IndividualListPage;
import salesforce.gui.pages.IndividualRecordPage;
import salesforce.gui.pages.PageTransporter;

import java.util.Map;

public class CreateIndividualSteps {

    private Logger logger = LogManager.getLogger(getClass());
    private PageTransporter pageTransporter;
    private IndividualFormPage individualFormPage;
    private IndividualEntity individualEntity;

    public CreateIndividualSteps(PageTransporter pageTransporter) {
        this.pageTransporter = pageTransporter;
    }

    @Given("^I go to the new Individual formular$")
    public void iGoToTheNewIndividualFormular() {
        logger.info("=====================");
        individualFormPage = pageTransporter.navigateToIndividualFormPage();
    }

    @When("^I create an Individual with the following values$")
    public void iCreateAnIndividualWithTheFollowingValues(final Map<String, String> table) {
        ObjectMapper objectMapper = new ObjectMapper();
        individualEntity = objectMapper.convertValue(table, IndividualEntity.class);
        //IndividualEntity individualEntity = new Json().Map(table);
        individualFormPage.createIndividual(table.keySet(), individualEntity);
    }

    @When("^I set the lastname \"(.*?)\"$")
    public void iSetTheEntityValues(String name) {
        individualFormPage.setLastnameTextbox(name);
        individualFormPage.clickOnsave();
    }

    @When("^I create an individual$")
    public void iCreateAnIndividual(final Map<String, String> table) {
        ObjectMapper objectMapper = new ObjectMapper();
        individualEntity = objectMapper.convertValue(table, IndividualEntity.class);
        //IndividualEntity individualEntity = new Json().Map(table);
        individualFormPage.createIndividual(table.keySet(), individualEntity);
    }

    @Then("^The Individual's name is displayed in the header$")
    public void theIndividualsNameIsDisplayedInTheHeader() {
        String resultMessage = individualFormPage.getCreatedSuccessMessage();
        Assert.assertTrue(resultMessage.contains("was created."));
    }

    @Then("^The name displayed should contain (.*) (.*) and (.*)$")
    public void theNameDisplayedShouldContain(final String salutation, final String firstname, final String lastname) {
        IndividualRecordPage individualRecordPage = new IndividualRecordPage();
        String headerNameText = individualRecordPage.getNameHeaderText();
        String fullname = String.format("%s %s %s", salutation, firstname, lastname);
        Assert.assertEquals(headerNameText, fullname);
    }

    @Then("^The created individual details should match the given values$")
    public void theCreatedIndividualDetailsShouldMatchTheGivenValues() {
        IndividualRecordPage individualRecordPage = new IndividualRecordPage();
        individualRecordPage.clickonDetailsTab();
        String nameDetail = individualRecordPage.getNameDetail();
        Assert.assertEquals(nameDetail, String.format("%s %s %s", individualEntity
                .getSalutation(), individualEntity.getFirstname(), individualEntity.getLastname()));
    }

    @Then("^The Individual Records Page should contain a record with (.*) and (.*)$")
    public void theIndividualRecordsPageShouldContainArecordWith(final String firstname, final String lastname) {
        IndividualListPage individualListPage = pageTransporter.navigateToIndividualListPage();
        Assert.assertTrue(individualListPage.isThereRecordWithName(firstname.concat(" ").concat(lastname)));
    }
}
