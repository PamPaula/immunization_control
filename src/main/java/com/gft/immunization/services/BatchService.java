package com.gft.immunization.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gft.immunization.entities.Batch;
import com.gft.immunization.repositories.BatchRepository;

@Service
public class BatchService {

	@Autowired
	private BatchRepository batchRepository;
	
	public Batch saveBatch(Batch batch) {
		
		return batchRepository.save(batch);
		
	}
	
	public List<Batch> listBatches(String identification) {

		if(identification != null)
			return listBatchByIdentification(identification);
		
		return listAllBatches();
	}
	
	public List<Batch> listAllBatches() {
		
		return batchRepository.findAll();
		
	}

	private List<Batch> listBatchByIdentification(String identification) {
		
		return batchRepository.findByIdentificationContains(identification);
		
	}

	public Batch obtainBatch(Long id) throws Exception {
		
		Optional<Batch> batch = batchRepository.findById(id);
		
		if(batch.isEmpty()) {
			throw new Exception("Lote não encontrado!");
		}
		
		return batch.get();
		
	}

	public void delBatch(Long id) {

		batchRepository.deleteById(id);
		
	}
}
