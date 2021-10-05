package com.gft.immunization.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gft.immunization.entities.Immunization;


@Repository
public interface ImmunizationRepository extends JpaRepository<Immunization, Long>{

	@Query(value="select * from immunization i INNER JOIN person p WHERE i.person_id = p.id AND cpf like %:cpf%", nativeQuery=true)
	List<Immunization> findImmunizationPersonId(@Param("cpf") String cpf);
	
	@Query(value="select * from immunization i INNER JOIN person p WHERE i.person_id = p.id AND dosage like %:dosage%", nativeQuery=true)
	List<Immunization> findPersonDosage(@Param("dosage") Integer dosage);
	
	
	@Query(value="select * from immunization i INNER JOIN immunization i WHERE i.id = i.id AND dosage like %:dosage%", nativeQuery=true)
	List<Immunization> updateDosage(@Param("dosage") Integer dosage);
	
}
