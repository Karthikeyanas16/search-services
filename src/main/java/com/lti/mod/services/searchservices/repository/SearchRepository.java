package com.lti.mod.services.searchservices.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lti.mod.services.searchservices.model.Technology;
import com.lti.mod.services.searchservices.model.User;

public interface SearchRepository extends JpaRepository<Technology, Long> {

	@Query(value = "select t.id,t.technology, t.description,t.Status,t.Fees, c.name,c.id as mentorId "
	  +" from Technology t join User c on t.id = c.technology_id where c.status = 0" ,nativeQuery = true)
	List findAllData();


	@Query(value = "select t.id,t.technology, t.description,t.Status,t.Fees,c.name " 
			  +" from Technology t join User c on t.id = c.technology_id "
			  + "where c.status = 0 and c.role=?1  and t.technology like %?2% or c.name like %?2%" ,nativeQuery = true)
	List findAllbyText(String role, String text);
	
	
	@Query(value = "select * from User u where u.id = ?1 and where u.role =?2", nativeQuery = true)
	User findStudentUserById(Long id, String role);

	@Query(value = "SELECT t.* FROM technology t LEFT JOIN user u ON t.id = u.technology_id WHERE t.status='Started' and u.technology_id IS NULL", nativeQuery = true)
	List findAllCourses();
	
}
