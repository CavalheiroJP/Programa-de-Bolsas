package com.project.products.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PortTestController {
	
	@RequestMapping("/")
	@ResponseBody
	public String hello() {
		return "Projeto Crud";
	}

}
