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

import com.gft.immunization.entities.Vaccine;
import com.gft.immunization.services.VaccineService;

@Controller
@RequestMapping("vaccine")
public class VaccineController {
	
	@Autowired
	private VaccineService vaccineService;

	@RequestMapping(path = "edit") //localhost:8080/vaccine/edit (botão editar)
	public ModelAndView editVaccine(@RequestParam(required = false) Long id) {
		
		ModelAndView mv = new ModelAndView("vaccine/form.html");
		
		Vaccine vaccine;
		
		if(id == null) {
			vaccine = new Vaccine();
		}else {
			try {
				vaccine = vaccineService.obtainVaccine(id);
			}catch(Exception e) {
				vaccine = new Vaccine();
				mv.addObject("message", e.getMessage());
			}
		}
		
		mv.addObject("vaccine", vaccine);
		
		return mv;
		
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "edit") //localhost:8080/vaccine/edit (cadastrar)
	public ModelAndView saveVaccine(@Valid Vaccine vaccine, BindingResult bindingResult) {
		
		ModelAndView mv = new ModelAndView("vaccine/form.html");
		
		boolean nu = true;
		
		if(bindingResult.hasErrors()) {
			mv.addObject("vaccine", vaccine);
			return mv;
		}
		
		vaccineService.saveVaccine(vaccine);
		
		if(nu) {
			mv.addObject("vaccine", new Vaccine());
		}else {
			mv.addObject("vaccine", vaccine);
		}
		
		mv.addObject("message", "Vacina cadastrada com sucesso!");
		
		return mv;
		
	}
	
	@RequestMapping //localhost:8080/vaccine (listar)
	public ModelAndView listVaccine(String name) {
		
		ModelAndView mv = new ModelAndView("vaccine/list.html");
		
		mv.addObject("list", vaccineService.listVaccine(name));
		
		return mv;
		
	}
	
	@RequestMapping("/delete") //localhost:8080/vaccine/delete (botão deletar)
	public ModelAndView delVaccine(@RequestParam Long id, RedirectAttributes redirectedAttributes) {
		
		ModelAndView mv = new ModelAndView("redirect:/vaccine");
		
		try {
			vaccineService.delVaccine(id);
			redirectedAttributes.addFlashAttribute("message", "Local excluído!");
		}catch(Exception e) {
			redirectedAttributes.addFlashAttribute("message", "Erro ao excluir local! " + e.getMessage());
		}
		
		return mv;
		
	}
}
