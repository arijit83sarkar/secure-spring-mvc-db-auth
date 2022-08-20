package com.raven.webmvcapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomLoginController {

	@GetMapping("/showCustomLoginPage")
	public String showCustomLoginPage() {
		return "customLoginForm";
	}
}
