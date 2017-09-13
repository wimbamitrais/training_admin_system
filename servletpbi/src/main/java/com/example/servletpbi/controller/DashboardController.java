package com.example.servletpbi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public String showDashboard() {
		return "dashboard/dashboard";
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
    public ModelAndView showUser() {
        return new ModelAndView("redirect:/user");
    }
	
	@RequestMapping(value = "/schedule", method = RequestMethod.GET)
    public ModelAndView showSchedule() {
        return new ModelAndView("redirect:/schedule");
    }

}
