package com.app.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PublicController extends BaseController {
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("metaTitle", "Home - ProdemyCare");
		return "public/index";
	}

	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("metaTitle", "Login - ProdemyCare");
		return "public/login";
	}

	@GetMapping("/about")
	public String about(Model model) {
		model.addAttribute("greeting", "Hello awy");
		return "index";
	}

	@GetMapping("/admin")
	public String adminHome(Model model, Authentication auth) {
		if (this.hasRole("ROLE_ADMIN", auth))
			return "admin/index";
		if (this.hasRole("ROLE_ADMIN", auth))
			return "redirect:/accessdenied";

		return "admin";
	}

	@GetMapping("/user")
	public String userHome(Model model, Authentication auth) {
		if (this.hasRole("ROLE_USER", auth))
			return "user/index";
		if (this.hasRole("ROLE_USER", auth))
			return "redirect:/accessdenied";

		return "user";
	}

	@GetMapping("/accessdenied")
	public String accessdenied(Model model, Authentication auth) {
		return "accessdenied";
	}
}
