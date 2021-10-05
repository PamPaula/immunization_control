package com.gft.immunization.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PrincipalController {
	
	@RequestMapping("index") //localhost:8080/index
	public ModelAndView index() {
		
		ModelAndView mv = new ModelAndView("index.html");
		
		return mv;
	}
	
	@RequestMapping("about") //localhost:8080/about
	public ModelAndView about() {
		
		ModelAndView mv = new ModelAndView("about.html");
		
		return mv;
	}
}
