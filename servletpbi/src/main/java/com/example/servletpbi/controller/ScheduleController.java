package com.example.servletpbi.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.servletpbi.Schedule;
import com.example.servletpbi.ScheduleRepository;

@Controller
@RequestMapping ("/schedule")

public class ScheduleController {
	
	@Autowired
	private ScheduleRepository scheduleRepository;
	
//	@RequestMapping(value = "", method=RequestMethod.GET) 
//	public ModelAndView findAll(Model model){
//		model.addAttribute("schedule", scheduleRepository.findAll());
//		return new ModelAndView("redirect:/schedule");
//	}

	@RequestMapping(value = "", method=RequestMethod.GET) 
	public ModelAndView root(){
		return new ModelAndView("redirect:/schedule/all");
	}
	
	@RequestMapping(value = "/all", method=RequestMethod.GET) 
	public String findAll(Model model){
		model.addAttribute("schedule", scheduleRepository.findAll());
		return "schedules/list";
	}
	
	@RequestMapping (value = "/new", method = RequestMethod.GET)
	public String newProject (){
		return "schedules/new"; 
	}
	
	@RequestMapping (value = "/create", method = RequestMethod.POST)
	public ModelAndView create (@RequestParam("topic") String topic, 
								@RequestParam("date") String date) {
		scheduleRepository.save(new Schedule (topic, date));
		return new ModelAndView("redirect:/schedule/all");
	}
	
	@RequestMapping (value = "/{id}/delete", method = RequestMethod.GET)
	public ModelAndView delete (@PathVariable long id) {
		scheduleRepository.delete(id);
		return new ModelAndView("redirect:/schedule");
	}
		
	@RequestMapping (value = "/update", method = RequestMethod.POST)
	public ModelAndView update (@RequestParam("id") long id,
								@RequestParam("topic") String topic,
								@RequestParam("date") String date) {
		Schedule schedule = scheduleRepository.findOne(id);
		schedule.setTopic(topic);
		schedule.setDate(date);
		scheduleRepository.save(schedule);
		return new ModelAndView("redirect:/schedule");
	}
	
	@RequestMapping (value = "/{id}/edit", method = RequestMethod.GET)
	public String edit (@PathVariable long id, Model model) {
		Schedule schedule = scheduleRepository.findOne(id);
		model.addAttribute("schedule", schedule);
		return "schedules/edit";
	}
	
	@RequestMapping (value = "/search", method = RequestMethod.GET)
	public String find (@RequestParam ("keyword") String keyword, Model model) {
		model.addAttribute("schedule", scheduleRepository.findByTopicIgnoreCaseContaining(keyword));
		return "schedules/list";
	}

}
