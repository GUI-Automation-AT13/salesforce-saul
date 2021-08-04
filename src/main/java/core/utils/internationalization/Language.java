/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package core.utils.internationalization;

/**
 * Represents language settings.
 */
public enum Language {

    SPANISH("es"),
    ENGLISH("en"),
    GERMAN("de");

    private String language;

    Language(final String language) {
        this.language = language;
    }

    public String get() {
        return language;
    }
}
