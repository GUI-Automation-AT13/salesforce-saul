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
import salesforce.gui.pages.IndividualListPage;
import salesforce.gui.pages.IndividualRecordPage;

public class CreateIndividualTest extends Basetest {

    @Test(groups = "Create")
    public void createIndividualWithLastname() {
        IndividualFormPage individualFormPage = pageTransporter.navigateToIndividualFormPage();
        individualFormPage.setLastnameTextbox("Paul");
        IndividualRecordPage individualRecordPage = individualFormPage.save();
        String expected = "was created.";
        String fullname = "Paul";

        String resultMessage = individualFormPage.getCreatedSuccessMessage();
        Assert.assertTrue(resultMessage.contains(expected));

        String headerNameText = individualRecordPage.getNameHeaderText();
        Assert.assertEquals(headerNameText, fullname);

        individualRecordPage.clickonDetailsTab();
        String nameDetail = individualRecordPage.getNameDetail();
        Assert.assertEquals(nameDetail, fullname);

        IndividualListPage individualListPage = pageTransporter.navigateToIndividualListPage();
        Assert.assertTrue(individualListPage.isThereRecordWithName(fullname));
    }

    @Test(groups = "Create")
    public void createIndividualWithLastnameAndFirstname() {
        IndividualFormPage individualFormPage = pageTransporter.navigateToIndividualFormPage();
        individualFormPage.setLastnameTextbox("Paul");
        individualFormPage.setFirstnameTextbox("Jake");
        IndividualRecordPage individualRecordPage = individualFormPage.save();
        String expected = "was created.";
        String fullName = "Jake Paul";

        String resultMessage = individualFormPage.getCreatedSuccessMessage();
        Assert.assertTrue(resultMessage.contains(expected));

        String headerNameText = individualRecordPage.getNameHeaderText();
        Assert.assertEquals(headerNameText, fullName);

        individualRecordPage.clickonDetailsTab();
        String nameDetail = individualRecordPage.getNameDetail();
        Assert.assertEquals(nameDetail, fullName);

        IndividualListPage individualListPage = pageTransporter.navigateToIndividualListPage();
        Assert.assertTrue(individualListPage.isThereRecordWithName(fullName));
    }
}
