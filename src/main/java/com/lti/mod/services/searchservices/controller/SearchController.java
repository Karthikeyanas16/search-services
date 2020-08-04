package com.lti.mod.services.searchservices.controller;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.mod.services.searchservices.model.Technology;
import com.lti.mod.services.searchservices.model.TechnologyDto;
import com.lti.mod.services.searchservices.service.SearchService;

@RestController
public class SearchController {

	@Autowired
	SearchService searchService;
	
	public static String mentor_role = "mentor";

	@RequestMapping(value = "/courses", method = RequestMethod.GET)
    public ResponseEntity<?> findAllCourses() {
        System.out.println("Search service ####");      
		return new ResponseEntity<>(searchService.findAll(), HttpStatus.OK);
    }
	
	@GetMapping("/technology")
    public ResponseEntity<?> findAllTechnology() {
		System.out.println("Search Technology service ####");    
		List<Technology> technologies = searchService.finAllbyTechnology();
		Map technologyMap = new HashMap<BigInteger, String>();
		for (Technology technology : technologies) {
			technologyMap.put(technology.getId(), technology.getTechnology());
		}
        return new ResponseEntity<>(technologyMap, HttpStatus.OK);
    }
	
	@GetMapping("/search/courses/{text}")
    public ResponseEntity<?> findAllByText(@PathVariable String text) {
		System.out.println("Search Technology service ####");    
		List<TechnologyDto> technologies = searchService.findAllbyText(mentor_role, text);
        return new ResponseEntity<>(technologies, HttpStatus.OK);
    }
	
	
	@PostMapping("/courses/create")
    public ResponseEntity<?> createCourse(@RequestBody Technology technology) {
        return new ResponseEntity<>(searchService.createTechnology(technology), HttpStatus.CREATED);
    }
	
	@GetMapping("/courses/delete/{id}")
    public ResponseEntity<?> createCourse(@PathVariable BigInteger id) {
			searchService.deleteCourse(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
	/*
	 @GetMapping("/courses/search/name/{name}") 
	 public ResponseEntity<?> findAllbyName(@PathVariable String name) {
		 System.out.println(name+"by Name "+searchService.findAllbyName(name));
		 return new ResponseEntity<>(searchService.findAllbyName(name), HttpStatus.OK); 
	 }
	 
	 @GetMapping("/courses/search/technology/{technology}") 
	 public ResponseEntity<?> findAllbyTechnology(@PathVariable String technology) {
		 System.out.println(technology+"by Technology "+searchService.findAllbyTechnology(technology));
		 return new ResponseEntity<>(searchService.findAllbyTechnology(technology), HttpStatus.OK);
	 }
		
	  @GetMapping("/courses/search/mentor/{mentor}") 
	  public ResponseEntity<?> findAllbyMentor(@PathVariable String mentor) {
		  System.out.println(mentor+"by Mentor "+searchService.findAllByMentor(mentor));
		  return new ResponseEntity<>(searchService.findAllByMentor(mentor), HttpStatus.OK);
	  }

	  @GetMapping("/courses/search/findbyboth") 
	  public ResponseEntity<?> findAllbyMentorandTechnology(@RequestParam String tech,@RequestParam String mentor) {
		  System.out.println("Technology "+tech+" :: Mentor "+mentor);
		  return new ResponseEntity<>(searchService.findAllbyMentorandTechnology(tech,mentor), HttpStatus.OK);
	  }
	  */
}
