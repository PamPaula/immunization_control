package com.gft.immunization.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gft.immunization.entities.Immunization;
import com.gft.immunization.repositories.ImmunizationRepository;

@Service
public class ImmunizationService {

	@Autowired
	private ImmunizationRepository immunizationRepository;
	
	public Immunization saveImmunization(Immunization immunization) {
		
		return immunizationRepository.save(immunization);
		
	}
	
	public List<Immunization> listImmunization(String cpf) {

		if(cpf != null)
			return listImmunizationByCpf(cpf);
		
		return listAllImmunizations();
	}
	
	public List<Immunization> listAllImmunizations() {
		
		return immunizationRepository.findAll();
		
	}

	private List<Immunization> listImmunizationByCpf(String cpf) {
		
		return immunizationRepository.findImmunizationPersonId(cpf);
		
	}

	public List<Immunization> listImmunizationPersonId(String cpf){
	
		return immunizationRepository.findImmunizationPersonId(cpf);
	
	}
	
	public List<Immunization> listPersonDosage(Integer dosage){
	
		return immunizationRepository.findPersonDosage(dosage);
		
	}
	
	public Immunization obtainImmunization(Long id) throws Exception {
		
		Optional<Immunization> immunization = immunizationRepository.findById(id);
		
		if(immunization.isEmpty()) {
			throw new Exception("Vacinação não encontrada!");
		}
		
		return immunization.get();
		
	}
	
	public Immunization updateDosage(Immunization immunization) throws Exception {
			
			if(immunization.getDosage() != 1) {
				if(immunizationRepository.updateDosage(immunization.getDosage()) == null) {
					return immunizationRepository.save(immunization);
				} else {
					throw new Exception("A pessoa não precisa de segunda dose!");
				}
			}
			
			return immunizationRepository.save(immunization);
			
	}

	public void delImmunization(Long id) {

		immunizationRepository.deleteById(id);
		
	}
}
