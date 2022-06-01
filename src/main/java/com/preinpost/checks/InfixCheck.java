package com.preinpost.checks;

import java.util.List;

public class InfixCheck {

    /* Checks if expression is a valid infix expression */
    public static boolean infix_check(String exp, List<Character> operators) {
        char last_char = exp.charAt(exp.length() - 1);
        char second_last_char = exp.charAt(exp.length() - 2);
        if (last_char >= 'a' && last_char <= 'z') {
            if (operators.contains(second_last_char))
                return true;
            return false;
        }
        else
            return false;
    }
}
