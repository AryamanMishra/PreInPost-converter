package com.preinpost.expression;

public class Get_Expression_Type {

    /* Gives type of expression specified by the user */
    public static String get_expression_type(String form) {
        int idx_equal_to = 0;
        for (int i=0;i<form.length();i++) {
            if (form.charAt(i) == '=')
                idx_equal_to = i;
        }
        String exp_type = form.substring(idx_equal_to+1);
        return exp_type;
    }
}
