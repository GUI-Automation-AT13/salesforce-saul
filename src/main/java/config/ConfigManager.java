/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package config;

import org.aeonbits.owner.ConfigCache;

/**
 * Singleton for a GeneralConfig class.
 */
public final class ConfigManager {

    private static final String languageKey = "language";

    private ConfigManager() {

    }

    /**
     * Returns an instance of the GeneralConfig class.
     *
     * @return a PropertiesConfig instance
     */
    public static PropertiesConfig getConfiguration() {
        return ConfigCache.getOrCreate(PropertiesConfig.class);
    }

    /**
     * Sets a system property from the given key and value.
     *
     * @param value represents the property value
     */
    public static void setSystemLanguageProperty(final String value) {
        System.setProperty(languageKey, value);
    }
}
