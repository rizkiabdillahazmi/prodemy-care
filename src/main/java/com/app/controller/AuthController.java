package com.app.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class AuthController extends BaseController{
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/register")
	public String register() {
		return "register";
	}
}
