package com.preinpost.controllers;

import java.util.*;
import com.preinpost.checks.*;
import com.preinpost.conversions.infix.*;
import com.preinpost.conversions.postfix.*;
import com.preinpost.conversions.prefix.*;
import com.preinpost.expression.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@Controller
public class OutputController {

    List<Character> operators = Arrays.asList('+','-','*','/','^');
    String infix_to_prefix = "";
    String infix_to_postfix = "";
    String prefix_to_infix = "";
    String prefix_to_postfix = "";
    String postfix_to_infix = "";
    String postfix_to_prefix = "";
    boolean check = false;


    /* Get method for output route */
    @GetMapping("/output")
    public String output() {
        return "output";
    }



    /* Post method for output route */
    @PostMapping(value = "/output")
//            consumes = MediaType.APPLICATION_JSON_VALUE,
//            produces = MediaType.APPLICATION_JSON_VALUE

    public String output(@RequestBody String form, Model model) {

        String expression = Get_Expression.get_expression(form);
        expression = expression.trim();
        expression = expression.toLowerCase();

        String expression_type = Get_Expression_Type.get_expression_type(form);
        expression_type = expression_type.trim();

//        System.out.println(exp + " " + exp_type);

        if (BasicCheck.basic_check(expression,operators)) {
            if (expression_type.equals("infix")) {
                check = InfixCheck.infix_check(expression,operators);
            } else if (expression_type.equals("postfix")) {
                check = PostfixCheck.postfix_check(expression,operators);
            } else {
                check = PrefixCheck.prefix_check(expression);
            }
        }
        else {
            check = false;
        }
//        System.out.println(expression + " " + check);

        if (check) {
            if (expression_type.equals("infix")) {
                infix_to_prefix = Infix_To_Prefix.infix_to_prefix(expression);
                infix_to_postfix = Infix_To_Postfix.infix_to_postfix(expression);
            }
            else if (expression_type.equals("prefix")) {
                prefix_to_infix = Prefix_To_Infix.prefix_to_infix(expression);
                prefix_to_postfix = Prefix_To_Postfix.prefix_to_postfix(expression);
            }
            else {
                postfix_to_infix = Postfix_To_Infix.postfix_to_infix(expression);
                postfix_to_prefix = Postfix_To_Prefix.postfix_to_prefix(expression);
            }
        }

        model.addAttribute("check",check);
        model.addAttribute("expression", expression);
        model.addAttribute("expression_type",expression_type);
        model.addAttribute("infix_to_postfix", infix_to_postfix);
        model.addAttribute("infix_to_prefix", infix_to_prefix);
        return "output";
    }























}