package com.gft.immunization.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gft.immunization.entities.Batch;

@Repository
public interface BatchRepository extends JpaRepository<Batch, Long> {
	
	List<Batch> findByIdentificationContains(String identification);

}
