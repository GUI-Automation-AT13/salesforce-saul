/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package core;

import org.openqa.selenium.WebDriver;

public interface Browser {

    /**
     * Returns the driver name.
     *
     * @return String
     */
    String getDriverName();

    /**
     * Returns the driver path.
     *
     * @return String
     */
    String getDriverPath();

    /**
     * Returns the driver instance.
     *
     * @return WebDriver
     */
    WebDriver getDriver();
}
