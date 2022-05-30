package com.preinpost.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OutputController {

    @GetMapping("/output")
    public String home() {
        return "output";
    }
}