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
import org.testng.asserts.SoftAssert;
import salesforce.gui.pages.IndividualFormPage;
import salesforce.gui.pages.IndividualListPage;
import salesforce.gui.pages.IndividualRecordPage;

public class CreateIndividualTest extends Basetest {

    @Test(groups = "Create")
    public void createIndividualWithLastname() {
        IndividualFormPage individualFormPage = pageTransporter.navigateToIndividualFormPage();
        individualFormPage.setLastnameTextbox("Paul");
        IndividualRecordPage individualRecordPage = individualFormPage.clickOnsave();
        String expected = "was created.";
        String fullname = "Paul";

        String resultMessage = individualFormPage.getCreatedSuccessMessage();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(resultMessage.contains(expected));

        String headerNameText = individualRecordPage.getNameHeaderText();
        softAssert.assertEquals(headerNameText, fullname);

        individualRecordPage.clickonDetailsTab();
        String nameDetail = individualRecordPage.getNameDetail();
        softAssert.assertEquals(nameDetail, fullname);

        IndividualListPage individualListPage = pageTransporter.navigateToIndividualListPage();
        softAssert.assertTrue(individualListPage.isThereRecordWithName(fullname));
        softAssert.assertAll();
    }

    @Test(groups = "Create")
    public void createIndividualWithAllFields() {
        IndividualFormPage individualFormPage = pageTransporter.navigateToIndividualFormPage();
        individualFormPage.setLastnameTextbox("Paul");
        individualFormPage.setFirstnameTextbox("Jake");
        individualFormPage.clickOnBlockGeolocationCheckbox();
        individualFormPage.clickOnDontMarketCheckbox();
        individualFormPage.clickOnDontProcessCheckbox();
        individualFormPage.clickOnDontProfileCheckbox();
        individualFormPage.clickOnDontTrackCheckbox();
        individualFormPage.clickOnExportIndividualDataCheckbox();
        individualFormPage.clickOnOkToStorePiiDataCheckbox();
        individualFormPage.clickOnForgetThisIndividualCheckbox();
        individualFormPage.clickOnSalutationDropDownMenu();
        individualFormPage.clickOnMrOption();
        individualFormPage.setBirthdateDateField("1/7/2000");
        individualFormPage.clickOnIndividualAgeSelector();
        individualFormPage.clickOnAge16Option();

        IndividualRecordPage individualRecordPage = individualFormPage.clickOnsave();
        String expected = "was created.";
        String fullName = "Mr. Jake Paul";
        String name = "Jake Paul";

        String resultMessage = individualFormPage.getCreatedSuccessMessage();
        Assert.assertTrue(resultMessage.contains(expected));

        String headerNameText = individualRecordPage.getNameHeaderText();
        Assert.assertEquals(headerNameText, fullName);

        individualRecordPage.clickonDetailsTab();
        String nameDetail = individualRecordPage.getNameDetail();
        Assert.assertEquals(nameDetail, fullName);

        IndividualListPage individualListPage = pageTransporter.navigateToIndividualListPage();
        Assert.assertTrue(individualListPage.isThereRecordWithName(name));
    }
}
