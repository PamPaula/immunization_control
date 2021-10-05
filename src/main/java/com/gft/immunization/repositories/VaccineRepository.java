package com.gft.immunization.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gft.immunization.entities.Vaccine;

@Repository
public interface VaccineRepository extends JpaRepository<Vaccine, Long>{
	
	List<Vaccine> findByNameContains(String name);

}
