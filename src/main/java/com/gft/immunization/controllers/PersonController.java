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

import com.gft.immunization.entities.Person;
import com.gft.immunization.services.PersonService;


@Controller
@RequestMapping("person")
public class PersonController {
	
	@Autowired
	private PersonService personService;

	@RequestMapping(path = "edit") //localhost:8080/person/edit (botão editar)
	public ModelAndView editPerson(@RequestParam(required = false) Long id) {
		
		ModelAndView mv = new ModelAndView("person/form.html");
		
		Person person;
		
		if(id == null) {
			person = new Person();
		}else {
			try {
				person = personService.obtainPerson(id);
			}catch(Exception e) {
				person = new Person();
				mv.addObject("message", e.getMessage());
			}
		}
		
		mv.addObject("person", person);
		
		return mv;
		
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "edit") //localhost:8080/person/edit (cadastrar)
	public ModelAndView savePerson(@Valid Person person, BindingResult bindingResult) {
		
		ModelAndView mv = new ModelAndView("person/form.html");
		
		boolean nu = true;
		
		if(bindingResult.hasErrors()) {
			mv.addObject("person", person);
			return mv;
		}
		
		personService.savePerson(person);
		
		if(nu) {
			mv.addObject("person", new Person());
		}else {
			mv.addObject("person", person);
		}
		
		mv.addObject("message", "Pessoa cadastrada com sucesso!");
		
		return mv;
		
	}
	
	@RequestMapping //localhost:8080/person (listar)
	public ModelAndView listPerson(String cpf) {
		
		ModelAndView mv = new ModelAndView("person/list.html");
		
		mv.addObject("list", personService.listPerson(cpf));
		
		return mv;
		
	}
	
	@RequestMapping("/delete") //localhost:8080/person/delete (botão deletar)
	public ModelAndView delPerson(@RequestParam Long id, RedirectAttributes redirectedAttributes) {
		
		ModelAndView mv = new ModelAndView("redirect:/person");
		
		try {
			personService.delPerson(id);
			redirectedAttributes.addFlashAttribute("message", "Pessoa excluída!");
		}catch(Exception e) {
			redirectedAttributes.addFlashAttribute("message", "Erro ao excluir pessoa! " + e.getMessage());
		}
		
		return mv;
		
	}
	
}