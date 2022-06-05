package com.preinpost.conversions.prefix;

import java.util.Stack;

public class Prefix_To_Infix {
    public static String prefix_to_infix(String exp) {
        String infix_expression = "";
        Stack<String> stack = new Stack<>();
        for (int i=exp.length()-1;i>=0;i--) {
            char ch = exp.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                String ch_string = Character.toString(ch);
                stack.push(ch_string);
            }
            else {
                String a = stack.pop();
                String b = stack.pop();
                String element = '(' + a + ch + b + ')';
                stack.push(element);
            }
        }
        while (!stack.isEmpty())
            infix_expression += stack.pop();
        return infix_expression;
    }
}
