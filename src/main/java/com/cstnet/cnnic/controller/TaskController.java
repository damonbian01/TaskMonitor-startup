package com.cstnet.cnnic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/Task")
public class TaskController {

	
	@RequestMapping(path = "/tasks")
	public ModelAndView showTaskHome() {
		ModelAndView mv = new ModelAndView("jobs/jobs");
		return mv;
	}
	
}
