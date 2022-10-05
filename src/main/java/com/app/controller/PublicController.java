package com.app.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PublicController extends BaseController {
	@GetMapping("/thymeleaf")
	public String thyme(Model model) {
		model.addAttribute("user", "Tes");
		return "thymeleaf";
	}

	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("greeting", "Hello awy");
		return "index";
	}

	@GetMapping("/about")
	public String about(Model model) {
		model.addAttribute("greeting", "Hello awy");
		return "index";
	}

	@GetMapping("/admin")
	public String adminHome(Model model, Authentication auth) {
		if (this.hasRole("ROLE_ADMIN", auth))
			return "adminhome";
		if (this.hasRole("ROLE_ADMIN", auth))
			return "redirect:/accessdenied";

		return "admin";
	}

	@GetMapping("/user")
	public String userHome(Model model, Authentication auth) {
		if (this.hasRole("ROLE_USER", auth))
			return "userhome";
		if (this.hasRole("ROLE_USER", auth))
			return "redirect:/accessdenied";

		return "user";
	}

	@GetMapping("/accessdenied")
	public String accessdenied(Model model, Authentication auth) {
		return "accessdenied";
	}
}
