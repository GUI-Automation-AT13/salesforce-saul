/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.gui.pages;

/**
 * Interface with the common methods for the Salesforce features List Pages.
 */
public interface ObjectListPage {

    /**
     * Gets the Header name text.
     *
     * @return String represents the object name
     */
    String getHeaderName();

    /**
     * Checks if there is a record on the list with the given name.
     *
     * @param name represents the name to look for.
     * @return a boolean
     */
    boolean isThereRecordWithName(final String name);
}
