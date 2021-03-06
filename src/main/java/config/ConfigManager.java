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
public class ConfigManager {

    private ConfigManager() {
    }

    /**
     * Returns an instance of the GeneralConfig class.
     * @return
     */
    public static PropertiesConfig getConfiguration() {
        return ConfigCache.getOrCreate(PropertiesConfig.class);
    }
}
