package com.preinpost.checks;

public class PrefixCheck {

    /* Checks if expression is a valid prefix expression */
    public static boolean prefix_check(String exp) {
        char last_char = exp.charAt(exp.length() - 1);
        char second_last_char = exp.charAt(exp.length() - 2);
        if ((last_char >= 'a' && last_char <= 'z') && (second_last_char >= 'a' && second_last_char <= 'z'))
            return true;
        return false;
    }
}
