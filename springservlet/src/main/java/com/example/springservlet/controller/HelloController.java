// This is for Spring PBI

package com.example.springservlet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping ("/spring")
public class HelloController {
	
	@RequestMapping
    @ResponseBody
    public String root() {
        return "Hello I am in root page of spring";
    }
	
	@RequestMapping("/hello")
	@ResponseBody
	public String hello() {
		return "Greetings from Spring Boot!";
	}
	
	@RequestMapping("/hello2")
	@ResponseBody
	public String hello(@RequestParam String message) {
		return "Hello " + message + ", nice to meet you! :)" ;
	}
	
	@RequestMapping("/hello3")
    public String hello(ModelMap modelMap, @RequestParam String message) {
        modelMap.addAttribute("message", "Hello " + message + ", greetings from JSP! :)" );
        return "hello";
    }
	
}
