package com.rs.app.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sample")
public class TestController {

	@GetMapping("/test")
	public String test(Map<String, Object> modelMap, HttpServletRequest request) {
		
		System.out.println("test....");
		request.setAttribute("success", true);
		request.getSession().setAttribute("name", "Ramesh");
		System.out.println(request.getSession().getId());
		return "test";
	}
	
	@GetMapping("test1")
	public String test1() {
		return "redirect:/sample/test";
	}
}
