package com.kps.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping("/")
	public String home(){
		return "index";
	}
	
	@GetMapping("/admin")
	public String admin(){
		return "admin/admin";
	}
	
	@GetMapping("/dba")
	public String dba(){
		return "dba/dba";
	}
	
	@GetMapping("/user")
	public String user(){
		return "user/user";
	}
	
	@GetMapping("/login")
	public String login(){
		return "login";
	}
	
}
