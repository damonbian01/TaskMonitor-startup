package com.cstnet.cnnic.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MenuController {

	@RequestMapping(path = "/TotalView", method= RequestMethod.GET)
	protected ModelAndView totalView(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("home");
		return mv;
	}
}
