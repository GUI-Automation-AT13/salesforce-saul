/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package core.utils;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Formats a String in different variants.
 */
public final class StringFormat {

    private static final String WORD_SEPARATOR = " ";

    /**
     * Converts the given String to camel case format.
     *
     * @param text represents the text to be converted
     * @return a String
     */
    public static String convertToCamelCase(final String text) {
        if (text == null || text.isEmpty()) {
            return text;
        }

        return Arrays
                .stream(text.split(WORD_SEPARATOR))
                .map(word -> word.isEmpty()
                        ? word
                        : Character.toTitleCase(word.charAt(0)) + word
                        .substring(1)
                        .toLowerCase())
                .collect(Collectors.joining(WORD_SEPARATOR));
    }

    /**
     * Converts a text to pascal case.
     *
     * @param text represents the text to be converted
     * @return a String
     */
    public static String convertToPascalCase(final String text) {
        convertToCamelCase(text);
        String firstLetter = text.substring(0, 1);
        String remainingLetters = text.substring(1);
        String camelCaseString = "";
        camelCaseString += firstLetter.toUpperCase() + remainingLetters + " ";
        return camelCaseString;
    }

    /**
     * Removes white spaces from a text.
     *
     * @param text represents the text to be formatted.
     * @return a String
     */
    public static String removeWhiteSpaces(final String text) {
        return text.replaceAll("\\s+", "");
    }
}
