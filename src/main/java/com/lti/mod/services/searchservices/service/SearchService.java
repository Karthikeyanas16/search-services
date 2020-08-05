package com.lti.mod.services.searchservices.service;

import java.util.List;

import com.lti.mod.services.searchservices.model.Technology;
import com.lti.mod.services.searchservices.model.TechnologyDto;
import com.lti.mod.services.searchservices.model.User;

public interface SearchService {

	List<TechnologyDto> findAll();
	List<Technology> finAllbyTechnology();
	List<TechnologyDto> findAllbyText(String role, String text);
	User findbyId(String id);
	List<User> findAllUsers();
	List<User> getUsersByRole(String role);

}
