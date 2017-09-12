package com.example.servletpbi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public String loginProcess() {
		return "login/login";
	}
	
	@RequestMapping(value = "", method=RequestMethod.POST)
    public ModelAndView create(@RequestParam("username") String u, @RequestParam("password") String p) {
        if(u.equals("admin") && p.equals("admin")) {
        	return new ModelAndView("redirect:/schedule");
        } else {
        	return new ModelAndView("redirect:/login");
        }
    }
	
}
