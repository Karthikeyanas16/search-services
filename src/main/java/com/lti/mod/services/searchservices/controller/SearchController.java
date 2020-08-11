package com.lti.mod.services.searchservices.controller;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.mod.services.searchservices.model.Technology;
import com.lti.mod.services.searchservices.model.TechnologyDto;
import com.lti.mod.services.searchservices.model.User;
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

    @RequestMapping(value = "/get/technology", method = RequestMethod.GET)
    public ResponseEntity<?> getTechnology() {
        System.out.println("Search service ####");
        return new ResponseEntity<>(searchService.getAllTechnology(), HttpStatus.OK);
    }
	
	@GetMapping("/technology")
    public ResponseEntity<?> findAllTechnology() {
		System.out.println("Search Technology service ####");    
		List<Technology> technologies = searchService.finAllbyTechnology();
        return new ResponseEntity<>(technologies, HttpStatus.OK);
    }
	
	@GetMapping("/technology/{id}")
    public ResponseEntity<?> getTechnology(@PathVariable Long id) {
		System.out.println("Search getTechnology ####"+id);    
		Optional<Technology> technology = searchService.findTechnology(id);
        return new ResponseEntity<>(technology, HttpStatus.OK);
    }
	
	@GetMapping("/mentorTechnology/{text}")
    public ResponseEntity<?> findAllByText(@PathVariable String text) {
		System.out.println("Search by both ####"+text);    
		List<TechnologyDto> technologies = searchService.findAllbyText(mentor_role, text);
        return new ResponseEntity<>(technologies, HttpStatus.OK);
    }
	
	@GetMapping("/user/{id}")
    public ResponseEntity<?> findAllbyId(@PathVariable Long id) {
		System.out.println("Search User ####" +id);    
		Optional<User> user = searchService.findbyId(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
	
	
	@GetMapping("/users")
    public ResponseEntity<?> findAllUsers() {
		System.out.println("Search All Users ####");    
		List<User> users = searchService.findAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
	
    @GetMapping("/service/user/users-by-role")
    public ResponseEntity<List<User>> getUsersByRole(@RequestParam("role") String role){
        List<User> userList = searchService.getUsersByRole(role);
        System.out.println(userList);
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }
	
	
}
