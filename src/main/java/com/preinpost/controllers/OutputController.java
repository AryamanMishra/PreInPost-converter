package com.preinpost.controllers;

import java.util.*;
import classes.Form;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.util.MultiValueMap;


@Controller
public class OutputController {


    /* Get method for output route */
    @GetMapping("/output")
    public String home() {
        return "output";
    }


    /* Post method for output route */
    @PostMapping(value = "/output")
//            consumes = MediaType.APPLICATION_JSON_VALUE,
//            produces = MediaType.APPLICATION_JSON_VALUE)
    public String check(@RequestBody String form,
                        Model model) {
        boolean check = false;
        String exp = getexp(form);
        exp = exp.trim();
        String exp_type = getexpType(form);
        exp_type = exp_type.trim();

        if (basic_check(exp)) {
            if (exp_type.equals("infix")) {
                check = infix_check(exp);
            } else if (exp_type.equals("postfix")) {
                check = postfix_check(exp);
            } else {
                check = prefix_check(exp);
            }
            check = true;
        }
        model.addAttribute("exp", exp);
        model.addAttribute("check",check);
        return "output";
    }


    /* Gives expression specified by the user */
    public String getexp(String form) {
        int idx_equal_to = 0;
        for (int i=0;i<form.length();i++) {
            if (form.charAt(i) == '=') {
                idx_equal_to = i;
                break;
            }
        }
        int idx = form.indexOf("expression");
        String exp = form.substring(idx_equal_to+1,idx);
        return exp;
    }


    /* Gives type of expression specified by the user */
    public String getexpType(String form) {
        int idx_equal_to = 0;
        for (int i=0;i<form.length();i++) {
            if (form.charAt(i) == '=')
                idx_equal_to = i;
        }
        String exp_type = form.substring(idx_equal_to+1);
        return exp_type;
    }


    /* Checks if expression is a valid expression containing operators and operands */
    public boolean basic_check(String exp) {
        ArrayList<Character> operators = new ArrayList<>();
        operators.add('+');operators.add('-');operators.add('*');operators.add('/');operators.add('^');
        int operands_count = 0;
        int operators_count = 0;
        for (char ch:exp.toCharArray()) {
            if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'))
                ++operands_count;
            else if (operators.indexOf(ch) != -1)
                ++operators_count;
            else
                return false;
        }

        if (operands_count - operators_count == 1)
            return true;
        return false;
    }


    /* Checks if expression is a infix valid expression */
    public boolean infix_check(String exp) {
        return true;
    }


    /* Checks if expression is a postfix valid expression */
    public boolean postfix_check(String exp) {
        return false;
    }


    /* Checks if expression is a prefix valid expression */
    public boolean prefix_check(String exp) {
        return false;
    }

}