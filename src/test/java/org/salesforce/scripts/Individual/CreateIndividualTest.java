/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package org.salesforce.scripts.Individual;

import org.testng.Assert;
import org.testng.annotations.Test;
import salesforce.gui.pages.IndividualFormPage;

public class CreateIndividualTest extends Basetest {

    @Test(groups = "Create")
    public void createIndividualWithLastname() {
        IndividualFormPage individualFormPage = pageTransporter.navigateToIndividualFormPage();
        individualFormPage.setLastnameTextbox("Paul");
        individualFormPage.save();
        Assert.assertTrue(individualFormPage.createdIndividualLabelVisibility());
    }

    @Test(groups = "Create")
    public void createIndividualWithLastnameAndFirstname() {
        IndividualFormPage individualFormPage = pageTransporter.navigateToIndividualFormPage();
        individualFormPage.setLastnameTextbox("Paul");
        individualFormPage.setFirstnameTextbox("Jake");
        individualFormPage.save();
        String expected = "Jake Paul";
        Assert.assertEquals(individualFormPage.createdIndividualNameText(), expected);
    }
}
