/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.gui.page_object.views;

import config.ConfigManager;

/**
 * Contains the salesforce view's links.
 */
public enum Views {

    CREATE_INDIVIDUAL(String.format("%s%s", ConfigManager.getConfiguration().baseUrl(),
            "lightning/o/Individual/new?count=1")),
    INDIVIDUAL_RECENT_LIST(String.format("%s%s", ConfigManager.getConfiguration().baseUrl(),
            "lightning/o/Individual/list?filterName=Recent"));

    private String view;

    /**
     * Constructor for the view elements.
     * @param viewEnum
     */
    Views(final String viewEnum) {
        this.view = viewEnum;
    }

    /**
     * Returns the string values.
     * @return a String.
     */
    public String get() {
        return view;
    }
}
