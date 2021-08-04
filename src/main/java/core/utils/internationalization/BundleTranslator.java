/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package core.utils.internationalization;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Translates to the defined bundle.
 */
public class BundleTranslator {

    public static final String bundlePath = "Bundle_%s.properties";

    /**
     * Translates a word with the defined bundle.s
     *
     * @param key represents the key for the bundle file
     * @return a String
     */
    public String translate(final String key) {
        Locale locale = new Locale("en", "US");
        String language = System.getProperty("language");
        ResourceBundle labels = ResourceBundle.getBundle(String.format(bundlePath, language), locale);
        return labels.getString(key);
    }
}
