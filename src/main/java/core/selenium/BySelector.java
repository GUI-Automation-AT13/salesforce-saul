/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package core.selenium;

import org.openqa.selenium.By;

public final class BySelector {

    private BySelector() {
    }

    /**
     * Returns a By selector given a parametrized selector and its value.
     * Distinguishes xpath from css and accepts both.
     *
     * @param parametrizedSelector
     * @param value
     * @return By
     */
    public static By withParameter(final String parametrizedSelector, final String value) {
        if (parametrizedSelector.startsWith("//")) {
            return By.xpath(String.format(parametrizedSelector, value));
        } else {
            return By.cssSelector(String.format(parametrizedSelector, value));
        }
    }
}
