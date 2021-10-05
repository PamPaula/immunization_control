package com.gft.immunization.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gft.immunization.entities.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long>{
	
	List<Location> findByNameContains(String name);

}
