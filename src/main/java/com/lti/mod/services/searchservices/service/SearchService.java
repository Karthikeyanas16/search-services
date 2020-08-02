package com.lti.mod.services.searchservices.service;

import java.util.List;

import com.lti.mod.services.searchservices.model.Course;

public interface SearchService {

	List<Course> findAllbyTechnology(String technology);
	
	List<Course> findAllByMentor(String mentor);

	List<Course> findAll();

	Object createCourse(Course course);

	List<Course> findAllbyName(String name);

	void deleteCourse(Long id);

	List<Course> findAllbyMentorandTechnology(String technology, String mentor);

}
