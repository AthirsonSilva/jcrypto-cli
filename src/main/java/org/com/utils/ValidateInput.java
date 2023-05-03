package org.com.utils;

import java.security.InvalidParameterException;

public class ValidateInput {
    public static boolean validate(String input) {
        if (input.isEmpty() || input.isBlank()) {
            throw new InvalidParameterException("Input cannot be empty");
        }

        return true;
    }
}
