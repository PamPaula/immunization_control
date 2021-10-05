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
import com.gft.immunization.services.BatchService;
import com.gft.immunization.services.VaccineService;

@Controller
@RequestMapping("batch")
public class BatchController {

	@Autowired
	private BatchService batchService;

	@Autowired
	private VaccineService vaccineService;

	@RequestMapping(path = "edit") //localhost:8080/batch/edit (botão editar com id)
	public ModelAndView editBatch(@RequestParam(required = false) Long id) {
		
		ModelAndView mv = new ModelAndView("batch/form.html");
		
		Batch batch;
		
		if(id == null) {
			batch = new Batch();
		}else {
			try {
				batch = batchService.obtainBatch(id);
			}catch(Exception e) {
				batch = new Batch();
				mv.addObject("message", e.getMessage());
			}
		}
		
		mv.addObject("batch", batch);
		mv.addObject("listVaccine", vaccineService.listAllVaccines());
		
		return mv;
		
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "edit") //localhost:8080/batch/edit (cadastrar)
	public ModelAndView saveBatch(@Valid Batch batch, BindingResult bindingResult) {
		
		ModelAndView mv = new ModelAndView("batch/form.html");
		
		boolean nu = true;
		
		if(bindingResult.hasErrors()) {
			mv.addObject("batch", batch);
			return mv;
		}
		
		batchService.saveBatch(batch);
		
		if(nu) {
			mv.addObject("batch", new Batch());
		}else {
			mv.addObject("batch", batch);
		}
		
		mv.addObject("message", "Lote cadastrado com sucesso!");
		
		return mv;
		
	}
	
	@RequestMapping //localhost:8080/batch (listar)
	public ModelAndView listBatch(String identification) {
		
		ModelAndView mv = new ModelAndView("batch/list.html");
		
		mv.addObject("list", batchService.listBatches(identification));
		
		return mv;
		
	}
	
	@RequestMapping("/delete") //localhost:8080/batch/delete (botão excluir)
	public ModelAndView delBatch(@RequestParam Long id, RedirectAttributes redirectedAttributes) {
		
		ModelAndView mv = new ModelAndView("redirect:/batch");
		
		try {
			batchService.delBatch(id);
			redirectedAttributes.addFlashAttribute("message", "Lote excluído!");
		}catch(Exception e) {
			redirectedAttributes.addFlashAttribute("message", "Erro ao excluir lote! " + e.getMessage());
		}
		
		return mv;
		
	}
}
