package com.lti.mod.services.searchservices.service;

import java.math.BigInteger;
import java.util.List;

import com.lti.mod.services.searchservices.model.Technology;
import com.lti.mod.services.searchservices.model.TechnologyDto;

public interface SearchService {

	List<TechnologyDto> findAll();
	List<Technology> finAllbyTechnology();
	List<TechnologyDto> findAllbyText(String role, String text);
	Object createTechnology(Technology technology);
	void deleteCourse(BigInteger parseLong);
}
