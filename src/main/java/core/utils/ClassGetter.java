/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package core.utils;

import java.security.InvalidParameterException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * Returns a class instance given a String name.
 */
public class ClassGetter {

    private static final Logger logger = LogManager.getLogger(ClassGetter.class);

    /**
     * Returns an object instance from the given classname.
     *
     * @param className represents the class to be instanciated
     * @return T represents an object instance
     */
    public static Object get(final String className) {
        String result = StringFormat.convertToPascalCase(className);
        result = StringFormat.removeWhiteSpaces(className);
        try {
            Class<?> clazz = Class.forName(result);
            return clazz.getConstructor().newInstance();
        } catch (Exception e) {
            logger.error(String.format("Invalid classname for <%s> \n%s", className, e));
            throw new InvalidParameterException("Invalid classname");
        }
    }
}
