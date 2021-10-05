package com.gft.immunization.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gft.immunization.entities.Vaccine;
import com.gft.immunization.repositories.VaccineRepository;

@Service
public class VaccineService {
	
	@Autowired
	private VaccineRepository vaccineRepository;
	
	public Vaccine saveVaccine(Vaccine vaccine) {
		
		return vaccineRepository.save(vaccine);
		
	}
	
	public List<Vaccine> listVaccine(String name) {

		if(name != null)
			return listVaccineByName(name);
		
		return listAllVaccines();
	}
	
	public List<Vaccine> listAllVaccines() {
		
		return vaccineRepository.findAll();
		
	}

	private List<Vaccine> listVaccineByName(String name) {
		
		return vaccineRepository.findByNameContains(name);
		
	}
	
	public Vaccine obtainVaccine(Long id) throws Exception {
		
		Optional<Vaccine> vaccine = vaccineRepository.findById(id);
		
		if(vaccine.isEmpty()) {
			throw new Exception("Vacina não encontrada!");
		}
		
		return vaccine.get();
		
	}

	public void delVaccine(Long id) {

		vaccineRepository.deleteById(id);
		
	}
}
	

