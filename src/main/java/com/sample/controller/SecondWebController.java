package com.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sample.service.Service1;

@Controller
//@RequestMapping("/controller2")
public class SecondWebController {
	
	@Autowired
	Service1 service;
	
	@GetMapping("/home")
	public String displayMessage(Model model)    // behind the scene spring injects the implementation of Model the implementing class is BindingAwareModelMap
	{
		service.method1();
	model.addAttribute("name", " Home people");

	return "index";   //jsp file name should be welcome.jsp
	}
	
	@GetMapping("/home2")
	public String displayMessage2(Model model)  // behind the scene spring injects the implementation of Model the implementing class is BindingAwareModelMap
	{
		service.method2();
	model.addAttribute("name", "Home 2 people");

	return "index";   //jsp file name should be welcome.jsp
	}
	
	@GetMapping("/home3")
	public String displayMessage3(Model model)  // behind the scene spring injects the implementation of Model the implementing class is BindingAwareModelMap
	{
		String st = service.method3(1);
	model.addAttribute("name", st);

	return "index";   //jsp file name should be welcome.jsp
	}
	}


