package com.lti.mod.services.searchservices.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.lti.mod.services.searchservices.model.Course;
import com.lti.mod.services.searchservices.service.SearchService;

@RestController
public class SearchController {

	@Autowired
	SearchService searchService;

	@RequestMapping(value = "/courses", method = RequestMethod.GET)
    public List<Course> findAllCourses() {
        System.out.println("Search service ####");
		return searchService.findAll();
    }
	
	@GetMapping("/courses/search/technology")
    public Set<String> findAllTechnology() {
		List<Course> course = searchService.findAll();
		Set<String> tech = new HashSet<String>();
		for (Course course2 : course) {
			tech.add(course2.getTechnology());
		}
        return tech;
    }
	
	@GetMapping("/courses/search/mentor")
    public Set<String> findAllMentors() {
		List<Course> course = searchService.findAll();
		Set<String> mentor = new HashSet<String>();
		for (Course course2 : course) {
			mentor.add(course2.getMentor());
		}
        return mentor;
    }
	
	@PostMapping("/courses/create")
    public ResponseEntity<?> createCourse(@RequestBody Course course) {
        return new ResponseEntity<>(searchService.createCourse(course), HttpStatus.CREATED);
    }
	
	@GetMapping("/courses/delete/{id}")
    public ResponseEntity<?> createCourse(@PathVariable String id) {
		searchService.deleteCourse(Long.parseLong(id));
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
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

	  @PostMapping("/courses/search/findbyboth") 
	  public ResponseEntity<?> findAllbyMentorandTechnology(@RequestBody String tech,@RequestBody String mentor) {
		  System.out.println("Technology "+tech+" :: Mentor "+mentor);
		  return new ResponseEntity<>(searchService.findAllbyMentorandTechnology(tech,mentor), HttpStatus.OK);
	  }
}
