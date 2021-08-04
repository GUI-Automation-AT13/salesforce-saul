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
 * Represents a Salesforce page for new a new Object.
 */
public interface NewObjectPage {

    <T> T createObject(final Map<String, String> data);

    String getStatusMessage();
}
