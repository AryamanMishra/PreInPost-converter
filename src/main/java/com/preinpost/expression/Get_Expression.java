package com.preinpost.expression;

public class Get_Expression {

    /* Gives expression specified by the user */
    public static String get_expression(String form) {
        int idx_equal_to = 0;
        int idx_ampersand = 0;
        for (int i=0;i<form.length();i++) {
            if (form.charAt(i) == '=') {
                idx_equal_to = i;
                break;
            }
        }
        for (int i=0;i<form.length();i++) {
            if (form.charAt(i) == '&')
                idx_ampersand = i;
        }
        String exp = form.substring(idx_equal_to+1,idx_ampersand);
        return exp;
    }
}
