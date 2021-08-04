/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package config;

import org.aeonbits.owner.Config;

/**
 * Represents an Owner Config class that retrieves the values of the defined property files.
 */
@Config.Sources({
    "file:general.properties",
    "system:properties"
})
public interface PropertiesConfig extends Config {

    @Config.Key("base_url")
    String baseUrl();

    @Config.Key("username")
    String username();

    @Config.Key("password")
    String password();

    @Config.Key("driver_path")
    String driverPath();

    @Config.Key("browser")
    String browser();

    @Config.Key("implicit_wait_time")
    int implicitWaitTime();

    @Config.Key("explicit_wait_time")
    int explicitWaitTime();

    @Config.Key("language")
    @DefaultValue("en")
    String language();
}

