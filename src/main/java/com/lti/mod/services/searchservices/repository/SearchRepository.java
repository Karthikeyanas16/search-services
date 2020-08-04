package com.lti.mod.services.searchservices.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lti.mod.services.searchservices.model.Technology;
import com.lti.mod.services.searchservices.model.TechnologyDto;
import com.lti.mod.services.searchservices.model.User;

public interface SearchRepository extends JpaRepository<Technology, BigInteger> {

	@Query(value = "select t.id,t.technology, t.description,t.Status,t.Fees, c.name " 
	  +" from Technology t join User c on t.id = c.technology_id where c.status = 0" ,nativeQuery = true)
	List findAllData();


	@Query(value = "select t.id,t.technology, t.description,t.Status,t.Fees,c.name " 
			  +" from Technology t join User c on t.id = c.technology_id "
			  + "where c.status = 0 and c.role=?1  and t.technology like %?2% or c.name like %?2%" ,nativeQuery = true)
	List findAllbyText(String role, String text);
	
	
}
