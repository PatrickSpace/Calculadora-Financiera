package com.aleman.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class mainController {

	@RequestMapping("/")
	public String returnbono() {
		String red = "";
		red = "redirect:/bono/s/aleman/new";
		return red;
	}

}
