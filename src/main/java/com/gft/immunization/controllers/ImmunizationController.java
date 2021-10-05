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

import com.gft.immunization.entities.Batch;
import com.gft.immunization.entities.Immunization;
import com.gft.immunization.services.BatchService;
import com.gft.immunization.services.ImmunizationService;
import com.gft.immunization.services.LocationService;
import com.gft.immunization.services.PersonService;

@Controller
@RequestMapping("immunization")
public class ImmunizationController {
	
	@Autowired
	private ImmunizationService immunizationService;
	
	@Autowired
	private PersonService personService;
	
	@Autowired
	private BatchService batchService;
	
	@Autowired
	private LocationService locationService;

	@RequestMapping(path = "edit") //localhost:8080/immunization/edit (botão editar com id)
	public ModelAndView editImmunization(@RequestParam(required = false) Long id) {
		
		ModelAndView mv = new ModelAndView("immunization/form.html");
		
		Immunization immunization;
		
		if(id == null) {
			immunization = new Immunization();
		}else {
			try {
				immunization = immunizationService.obtainImmunization(id);
			}catch(Exception e) {
				immunization = new Immunization();
				mv.addObject("message", e.getMessage());
			}
		}
		
		mv.addObject("immunization", immunization);
		mv.addObject("listPerson", personService.listAllPerson());
		mv.addObject("listBatch", batchService.listAllBatches());
		mv.addObject("listLocation", locationService.listAllLocations());
		
		return mv;
		
	}
	
	//ta aparecendo que não precisa da segunda dose, mesmo precisando, não deu tempo de arrumar =/
	@RequestMapping(method = RequestMethod.GET, path = "second") //localhost:8080/immunization/second (botão para atualizar dose sem entrar na pag)(com erro)
	public ModelAndView updateDosage(@RequestParam(required = false) Long id) {
		
		ModelAndView mv = new ModelAndView("immunization/second.html");
		
		Immunization immunization;
		
		if(id == null) {
			immunization = new Immunization();
		}else {
			try {
				immunization = immunizationService.updateDosage(null);
			}catch(Exception e) {
				immunization = new Immunization();
				mv.addObject("message", "A pessoa não precisa de segunda dose!");
			}
		}
		
		mv.addObject("immunization", immunization);
		mv.addObject("listPerson", personService.listAllPerson());
		mv.addObject("listBatch", batchService.listAllBatches());
		mv.addObject("listLocation", locationService.listAllLocations());
		
		return mv;
			
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "edit") //localhost:8080/immunization/edit (cadastrar)
	public ModelAndView saveImmunization(@Valid Immunization immunization, BindingResult bindingResult) {
		
		ModelAndView mv = new ModelAndView("immunization/form.html");
		
		try {
            Batch reducedBatch = batchService.obtainBatch(immunization.getBatch().getId());
            reducedBatch.setQtyRemaining(reducedBatch.getQtyRemaining() - 1);       
            batchService.saveBatch(reducedBatch);
        } catch(Exception e) {
            e.printStackTrace();
        }
		
		boolean nu = true;
		
		if(bindingResult.hasErrors()) {
			mv.addObject("immunization", immunization);
			return mv;
		}
		
		immunizationService.saveImmunization(immunization);
		
		if(nu) {
			mv.addObject("immunization", new Immunization());
		}else {
			mv.addObject("immunization", immunization);
		}
		
		mv.addObject("message", "Vacinação cadastrada com sucesso!");
		
		return mv;
		
	}
	
	@RequestMapping //localhost:8080/immunization (listar)
	public ModelAndView listImmunization() {
		
		ModelAndView mv = new ModelAndView("immunization/list.html");
		
		mv.addObject("list", immunizationService.listAllImmunizations());
		
		return mv;
		
	}
	
	//ta funcionando esse aqui, não, Davi
	@RequestMapping(method= RequestMethod.GET, path="/report") //localhost:8080/immunization/report (relatório)(com erro)
	public ModelAndView reportImmunization(Integer dosage) {
	
		ModelAndView mv = new ModelAndView("immunization/report.html");
		
		mv.addObject("listImmunization", immunizationService.listPersonDosage(dosage));
	
		return mv;
		
	}
	
	@RequestMapping("/delete") //localhost:8080/immunization/delete (botão excluir)
	public ModelAndView delImmunization(@RequestParam Long id, RedirectAttributes redirectedAttributes) {
		
		ModelAndView mv = new ModelAndView("redirect:/immunization");
		
		try {
			immunizationService.delImmunization(id);
			redirectedAttributes.addFlashAttribute("message", "Vacinação excluída!");
		}catch(Exception e) {
			redirectedAttributes.addFlashAttribute("message", "Erro ao excluir vacinação! " + e.getMessage());
		}
		
		return mv;
		
	}
	
}	

