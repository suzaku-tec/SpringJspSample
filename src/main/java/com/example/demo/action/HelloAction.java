package com.example.demo.action;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jp.fintan.keel.spring.web.token.transaction.TransactionTokenCheck;
import jp.fintan.keel.spring.web.token.transaction.TransactionTokenType;

@Controller
@TransactionTokenCheck("user")
public class HelloAction  {

	@Autowired
	DefaultListableBeanFactory beanFactory;
	
	@PostMapping("/hello")
	@TransactionTokenCheck(type = TransactionTokenType.BEGIN)
	public String hello(Model model) {
		
		List<String> memberList = Arrays.asList("yusei", "jack", "crow");
		model.addAttribute("memberList", memberList);
		
		for(String name: beanFactory.getBeanDefinitionNames()) {
			if("requestDataValueProcessor".equals(name)) {
				System.out.println(beanFactory.getBean(name).getClass());
			}
		}
		
		// 利用するJSP
		return "hello";
	}
	
	@GetMapping("/")
	public String index() {
		for(String name: beanFactory.getBeanDefinitionNames()) {
			if("requestDataValueProcessor".equals(name)) {
				System.out.println(beanFactory.getBean(name).getClass());
			}
		}
		return "index";
	}
}