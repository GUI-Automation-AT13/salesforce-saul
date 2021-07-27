/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package org.salesforce.scenarios.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features"
        ,glue = {"org/salesforce/scenarios/hooks","org/salesforce/scenarios/steps"}
        ,tags = "@CreateIndividual,@SmokeTest"
        )
public class CucumberRunner extends AbstractTestNGCucumberTests {
}
