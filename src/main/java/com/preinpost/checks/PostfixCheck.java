package com.preinpost.checks;

import java.util.List;

public class PostfixCheck {

    /* Checks if expression is a valid postfix expression */
    public static boolean postfix_check(String exp, List<Character> operators) {
        char last_char = exp.charAt(exp.length() - 1);
        if (operators.contains(last_char))
            return true;
        return false;
    }
}
