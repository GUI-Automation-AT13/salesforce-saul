/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package org.salesforce.scenarios.hooks;

import io.cucumber.java.After;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import salesforce.gui.pages.*;

public class IndividualScenarioHooks {

    private Logger logger = LogManager.getLogger(getClass());
    private PageTransporter pageTransporter;
    private Object entity;

    public IndividualScenarioHooks(PageTransporter pageTransporter, Object entity) {
        this.pageTransporter = pageTransporter;
        this.entity = entity;
    }

    @After(value = "@CreateIndividual")
    public void setLast() {
        logger.info("============ DELETE CREATED INDIVIDUAL ============");
        pageTransporter.navigateToObjectListPage("Individual");
        IndividualListPage individualListPage = new IndividualListPage();
        individualListPage.deleteLastModifiedRecord();
        String actual = individualListPage.getDeletedSuccessMessage();
        String expected = "was deleted.";
        Assert.assertTrue(actual.contains(expected));
    }
}
