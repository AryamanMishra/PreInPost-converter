package com.preinpost.conversions.infix;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Infix_To_Prefix {
    public static String infix_to_prefix(String exp) {

        String prefix_expression = "";
        Map<Character,Integer> operator_precedence = new HashMap<>();
        operator_precedence.put('^',3);
        operator_precedence.put('*',2);
        operator_precedence.put('/',2);
        operator_precedence.put('+',1);
        operator_precedence.put('-',1);

        Stack<Character> stack = new Stack<>();

        for (int i=exp.length()-1;i>=0;i--) {
            char ch = exp.charAt(i);
            if (ch >= 'a' && ch <= 'z')
                prefix_expression += ch;
            else {
                if (stack.isEmpty())
                    stack.push(ch);
                else {
                    if (operator_precedence.get(ch) > operator_precedence.get(stack.peek()))
                        stack.push(ch);
                    else  {
                        while (!stack.isEmpty() &&
                                operator_precedence.get(ch)
                                        <= operator_precedence.get(stack.peek())) {
                            prefix_expression += stack.pop();
                        }
                        stack.push(ch);
                    }
                }
            }
        }
        while (!stack.isEmpty())
            prefix_expression += stack.pop();

        StringBuilder str = new StringBuilder(prefix_expression);
        str = str.reverse();
        return str.toString();
    }
}
