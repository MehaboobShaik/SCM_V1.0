package com.SmartContactManager_2.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.SmartContactManager_2.modelDto.UserDto;
import com.SmartContactManager_2.service.Fileservice;
import com.SmartContactManager_2.service.UserService;


import com.SmartContactManager_2.helper.Message;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private Fileservice fileservice;

	@RequestMapping("/signup")
	public String signUp(Model model) {
		model.addAttribute("user", new UserDto());
		return "signup";
	}

	@RequestMapping("/index")
	public String dashBoard(Model model) {
		model.addAttribute("user", new UserDto());
		return "normal/base";
	}

	@Value("${project.image}")
	public String path;

	@PostMapping("/do_register")
	public String registerUSer(@Valid @ModelAttribute UserDto userDto, BindingResult result,
			@RequestParam(value = "agreement", defaultValue = "false") boolean agreement, HttpSession session,
			@RequestParam("profileImage") MultipartFile file, Model model) {
		int registerUser = 0;
		try {
			if (result.hasErrors()) {
				model.addAttribute("user", userDto);
				System.out.println(result);
				return "signup";

			}

			if (file == null) {
				userDto.setImage("user.png");
			} else {
				String fileName = fileservice.uploadImage(path, file);
				userDto.setImage(fileName);
			}
			if (agreement == false) {
				throw new Exception("pls accept terms and conditions");
			} else {
				userDto.setEnabled("true");
			}
			registerUser = userService.registerUser(userDto);
		} catch (Exception e) {
			session.setAttribute("message",
					new Message("something went wrong" + "\n" + e.getMessage(), "alert-danger"));
			model.addAttribute("user", userDto);
			return "signup";
		}
		session.setAttribute("message", new Message("Record added sucessfully ID :" + registerUser, "alert-success"));
		model.addAttribute("user", userDto);
		return "signup";

	}
}
