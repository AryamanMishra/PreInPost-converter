package com.preinpost.conversions.prefix;

import java.util.Stack;

public class Prefix_To_Postfix {
    public static String prefix_to_postfix(String exp) {
        String postfix_expression = "";
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
                String element = a + b + ch;
                stack.push(element);
            }
        }
        while (!stack.isEmpty())
            postfix_expression += stack.pop();
        return postfix_expression;
    }
}
