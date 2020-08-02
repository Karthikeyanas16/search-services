package com.lti.mod.services.searchservices.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.mod.services.searchservices.model.Course;
import com.lti.mod.services.searchservices.repository.SearchRepository;

@Service
@Transactional
public class SearchServiceImpl implements SearchService{

	@Autowired
	SearchRepository searchRepository;
	
	
	  @Override 
	  public List<Course> findAllbyTechnology(String technology) { 
		  return searchRepository.findByTechnology(technology); 
	  }
	
	 @Override 
	 public List<Course> findAllByMentor(String mentor) { 
		 return searchRepository.findAllByMentor(mentor); 
	 }
	

	@Override
	public List<Course> findAll() {
		return searchRepository.findAll();
	}

	@Override
	public Object createCourse(Course course) {
		return searchRepository.save(course);
	}


	@Override
	public List<Course> findAllbyName(String name) {
		return searchRepository.findByName(name);
	}

	@Override
	public void deleteCourse(Long id) {
		searchRepository.deleteById(id);;
	}

	@Override
	public List<Course> findAllbyMentorandTechnology(String technology, String mentor) {
		return searchRepository.findAllByTechnologyandMentor(technology, mentor);
	}
	
	

}
