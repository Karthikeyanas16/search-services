package com.lti.mod.services.searchservices.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="course")
public class Course implements Serializable{
	/**
	 * Default Serial version UID
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "technology")
    private String technology;
    
    @Column(name = "mentor")
    private String mentor;
    
    @Column(name = "description")
    private String description;

	public Course() {
	}

	public Course(String name, String technology, String mentor, String description) {
		this.name = name;
		this.technology = technology;
		this.mentor = mentor;
		this.description = description;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public String getMentor() {
		return mentor;
	}

	public void setMentor(String mentor) {
		this.mentor = mentor;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", technology=" + technology + ", mentor=" + mentor
				+ ", description=" + description + "]";
	}
    
    
}
