package com.preinpost.checks;

import java.util.List;

public class BasicCheck {

    /* Checks if expression is a valid expression containing operators and operands */
    public static boolean basic_check(String exp, List<Character> operators) {
        if (exp.length() <= 2)
            return false;
        int operands_count = 0;
        int operators_count = 0;
        for (char ch:exp.toCharArray()) {
            if (ch >= 'a' && ch <= 'z')
                ++operands_count;
            else if (operators.contains(ch))
                ++operators_count;
            else if (ch == ')' || ch == '(' || ch == ']' || ch == '[' || ch == '{' || ch == '}')
                return false;
            else
                return false;
        }

        if (operands_count - operators_count == 1)
            return true;
        return false;
    }
}
