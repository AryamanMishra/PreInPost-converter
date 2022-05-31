package com.preinpost.controllers;

import java.util.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class OutputController {

    @GetMapping("/output")
    public String home() {
        return "output";
    }

    @PostMapping("/output")
    public String check(@RequestBody String form,
                        Model model) {
        boolean check;
        String exp = getexp(form);
        String exp_type = getexpType(form);
        if (exp_type.equals("infix")) {
            check = infix_check(exp);
        }
        else if (exp_type.equals("postfix")) {
            check = postfix_check(exp);
        }
        else {
            check = prefix_check(exp);
        }
        model.addAttribute("check",check);
        return "output";
    }

    public String getexp(String form) {
        int idx_ampersand = 0;
        int idx_equal_to = 0;
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
    public String getexpType(String form) {
        int idx_equal_to = 0;
        for (int i=0;i<form.length();i++) {
            if (form.charAt(i) == '=')
                idx_equal_to = i;
        }
        String exp_type = form.substring(idx_equal_to+1);
        return exp_type;
    }

    public boolean infix_check(String exp) {
        return true;
    }
    public boolean postfix_check(String exp) {
        return false;
    }
    public boolean prefix_check(String exp) {
        return false;
    }

}