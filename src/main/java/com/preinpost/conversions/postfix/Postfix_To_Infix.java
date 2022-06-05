package com.preinpost.conversions.postfix;

import java.util.Stack;

public class Postfix_To_Infix {
    public static String postfix_to_infix(String exp) {
        String infix_expression = "";
        Stack<String> stack = new Stack<>();
        for (char ch : exp.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                String ch_string = Character.toString(ch);
                stack.push(ch_string);
            }
            else {
                String b = stack.pop();
                String a = stack.pop();
                String element = '(' + a + ch + b + ')';
                stack.push(element);
            }
        }
        while (!stack.isEmpty())
            infix_expression += stack.pop();
        return infix_expression;
    }
}
