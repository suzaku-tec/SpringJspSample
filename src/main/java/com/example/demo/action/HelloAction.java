package com.example.demo.action;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloAction  {

	@GetMapping("/hello")
	public String hello(Model model) {
		
		List<String> memberList = Arrays.asList("yusei", "jack", "crow");
		model.addAttribute("memberList", memberList);
		
		// 利用するJSP
		return "hello";
	}
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
}