/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package core;

public enum Browser {
    CHROME("chrome"),
    FIREFOX("firefox");
    private String browser;

    Browser(final String browserOption) {
        this.browser = browserOption;
    }

    public String get() {
        return browser;
    }
}
