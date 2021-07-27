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
import org.openqa.selenium.json.Json;
import org.testng.Assert;
import salesforce.gui.Entities.IndividualEntity;
import salesforce.gui.pages.IndividualFormPage;
import salesforce.gui.pages.PageTransporter;

import java.util.Map;

public class CreateIndividualSteps {

    private Logger logger = LogManager.getLogger(getClass());
    private PageTransporter pageTransporter;
    private IndividualFormPage individualFormPage;

    public CreateIndividualSteps(PageTransporter pageTransporter) {
        this.pageTransporter = pageTransporter;
    }

    @Given("^I go to the new Individual formular$")
    public void iGoToTheNewIndividualFormular() {
        System.out.println("==================gO FORMULAR------------------");
        individualFormPage = pageTransporter.navigateToIndividualFormPage();
    }

    @When("^I set the lastname \"(.*?)\"$")
    public void iSetTheEntityValues(String name) {
        individualFormPage.setLastnameTextbox(name);
        individualFormPage.clickOnsave();
    }

    @When("^I create an individual$")
    public void iCreateAnIndividual(final Map<String, String> table) {
        ObjectMapper objectMapper = new ObjectMapper();
        IndividualEntity individualEntity = objectMapper.convertValue(table, IndividualEntity.class);
        //IndividualEntity individualEntity = new Json().Map(table);
        individualFormPage.createIndividual(table.keySet(), individualEntity);
    }

    @Then("^The Individual's name is displayed in the header$")
    public void theIndividualsNameIsDisplayedInTheHeader() {
        String resultMessage = individualFormPage.getCreatedSuccessMessage();
        Assert.assertTrue(resultMessage.contains("was created."));
    }
}
