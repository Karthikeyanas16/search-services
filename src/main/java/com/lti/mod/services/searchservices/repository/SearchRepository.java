package com.lti.mod.services.searchservices.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lti.mod.services.searchservices.model.Course;

public interface SearchRepository extends JpaRepository<Course, Long> {

	List<Course> findByTechnology(String technology);

	List<Course> findByName(String name);

	List<Course> findAllByMentor(String mentor);

	@Query("select c from Course c where c.technology = ?1 or c.mentor=?2")
	List<Course> findAllByTechnologyandMentor(String technology, String mentor);
}
