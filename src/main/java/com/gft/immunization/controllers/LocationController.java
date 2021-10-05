package com.gft.immunization.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gft.immunization.entities.Location;
import com.gft.immunization.services.LocationService;

@Controller
@RequestMapping("location")
public class LocationController {
	
	@Autowired
	public LocationService locationService;

	@RequestMapping(path = "edit") //localhost:8080/location/edit (botão editar com id)
	public ModelAndView editLocation(@RequestParam(required = false) Long id) {
		
		ModelAndView mv = new ModelAndView("location/form.html");
		
		Location location;
		
		if(id == null) {
			location = new Location();
		}else {
			try {
				location = locationService.obtainLocation(id);
			}catch(Exception e) {
				location = new Location();
				mv.addObject("message", e.getMessage());
			}
		}
		
		mv.addObject("location", location);
		
		return mv;
		
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "edit") //localhost:8080/location/edit (cadastrar)
	public ModelAndView saveLocation(@Valid Location location, BindingResult bindingResult) {
		
		ModelAndView mv = new ModelAndView("location/form.html");
		
		boolean nu = true;
		
		if(bindingResult.hasErrors()) {
			mv.addObject("location", location);
			return mv;
		}
		
		locationService.saveLocation(location);
		
		if(nu) {
			mv.addObject("location", new Location());
		}else {
			mv.addObject("location", location);
		}
		
		mv.addObject("message", "Local cadastrado com sucesso!");
		
		return mv;
		
	}
	
	@RequestMapping //localhost:8080/location (listar)
	public ModelAndView listLocation(String name) {
		
		ModelAndView mv = new ModelAndView("location/list.html");
		
		mv.addObject("list", locationService.listLocations(name));
		
		return mv;
		
	}
	
	@RequestMapping("/delete") //localhost:8080/location/delete (botão excluir)
	public ModelAndView delLocation(@RequestParam Long id, RedirectAttributes redirectedAttributes) {
		
		ModelAndView mv = new ModelAndView("redirect:/location");
		
		try {
			locationService.delLocation(id);
			redirectedAttributes.addFlashAttribute("message", "Local excluído!");
		}catch(Exception e) {
			redirectedAttributes.addFlashAttribute("message", "Erro ao excluir local! " + e.getMessage());
		}
		
		return mv;
		
	}
	
}
