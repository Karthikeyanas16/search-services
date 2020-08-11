package com.lti.mod.services.searchservices.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import com.lti.mod.services.searchservices.model.Technology;
import com.lti.mod.services.searchservices.model.TechnologyDto;
import com.lti.mod.services.searchservices.model.User;

public interface SearchService {

	List<TechnologyDto> findAll();
	List<TechnologyDto> getAllTechnology();
	List<Technology> finAllbyTechnology();
	List<TechnologyDto> findAllbyText(String role, String text);
	Optional<User> findbyId(Long id);
	List<User> findAllUsers();
	List<User> getUsersByRole(String role);
	Optional<Technology> findTechnology(Long id);
	
	User findStudentUserById(Long id, String role); 

}
