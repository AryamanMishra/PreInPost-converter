package com.preinpost.conversions.infix;
import java.util.Map;
import java.util.HashMap;
import java.util.Stack;

public class Infix_To_Postfix {

    public static String infix_to_postfix(String exp) {
        String postfix_expression = "";
        Map<Character,Integer> operator_precedence = new HashMap<>();
        operator_precedence.put('^',3);
        operator_precedence.put('*',2);
        operator_precedence.put('/',2);
        operator_precedence.put('+',1);
        operator_precedence.put('-',1);

        Stack<Character> stack = new Stack<>();

        for (char ch:exp.toCharArray()) {
            if (ch >= 'a' && ch <= 'z')
                postfix_expression += ch;
            else {
                if (stack.isEmpty())
                    stack.push(ch);
                else {
                    if (operator_precedence.get(ch) > operator_precedence.get(stack.peek()))
                        stack.push(ch);
                    else {
                        while (!stack.isEmpty() &&
                                operator_precedence.get(ch)
                                        <= operator_precedence.get(stack.peek())) {
                            postfix_expression += stack.pop();
                        }
                        stack.push(ch);
                    }
                }
            }
        }
        while (!stack.isEmpty())
            postfix_expression += stack.pop();
        return postfix_expression;
    }
}   
