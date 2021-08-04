/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.gui.pages;

import java.util.Map;

/**
 * Interface with the common methods for the Salesfoce record object pages.
 */
public interface ObjectRecordPage {

    /**
     * Clicks on the Details tab.
     */
    void clickOnTheDetailsTab();

    /**
     * Gets the Header name text.
     *
     * @return String represents the object name
     */
    String getHeaderName();

    boolean detailsMatch(Object object, Map<String, String> details);
}
