package com.preinpost.conversions.postfix;

import java.util.Stack;

public class Postfix_To_Prefix {
    public static String postfix_to_prefix(String exp) {
        String prefix_expression = "";
        Stack<String> stack = new Stack<>();
        for (char ch : exp.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                String ch_string = Character.toString(ch);
                stack.push(ch_string);
            }
            else {
                String b = stack.pop();
                String a = stack.pop();
                String element = ch + a + b;
                stack.push(element);
            }
        }
        while (!stack.isEmpty())
            prefix_expression += stack.pop();
        return prefix_expression;
    }
}
