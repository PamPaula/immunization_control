package com.gft.immunization.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gft.immunization.entities.Location;
import com.gft.immunization.repositories.LocationRepository;

@Service
public class LocationService {

	@Autowired
	private LocationRepository locationRepository;
	
	public Location saveLocation(Location location) {
		
		return locationRepository.save(location);
		
	}
	
	public List<Location> listLocations(String name) {

		if(name != null)
			return listLocationByName(name);
		
		return listAllLocations();
	}
	
	public List<Location> listAllLocations() {
		
		return locationRepository.findAll();
		
	}

	private List<Location> listLocationByName(String name) {
		
		return locationRepository.findByNameContains(name);
		
	}
	

	public Location obtainLocation(Long id) throws Exception {
		
		Optional<Location> location = locationRepository.findById(id);
		
		if(location.isEmpty()) {
			throw new Exception("Local não encontrado!");
		}
		
		return location.get();
		
	}
	
	public void delLocation(Long id) {

		locationRepository.deleteById(id);
		
	}

}
