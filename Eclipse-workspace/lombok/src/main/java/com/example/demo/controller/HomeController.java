package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.domain.Student;

@Controller
public class HomeController {
	@RequestMapping("/home")
	//@ResponseBody
	public String index() {
		return "index";
	}
	
}
