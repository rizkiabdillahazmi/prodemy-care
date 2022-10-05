package com.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@RequestMapping("/admin1")
public class AdminController {
    @GetMapping("/")
    public String adminA(Model model) {
        model.addAttribute("user", "Tes");
        return "thymeleaf";
    }

    @GetMapping("/category")
    public String category(Model model) {
        model.addAttribute("user", "Tes");
        return "thymeleaf";
    }

}
