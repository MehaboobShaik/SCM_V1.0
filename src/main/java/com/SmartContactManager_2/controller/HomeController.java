package com.SmartContactManager_2.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String home() {
	    return "home";
	}
	@RequestMapping("/about")
	public String about() {
	    return "about";
	}
	
	@RequestMapping("/signin")
	public String login(Model model) {
	    return "login";
	}
}
