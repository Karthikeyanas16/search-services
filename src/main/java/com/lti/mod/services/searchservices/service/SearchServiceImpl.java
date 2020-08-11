package com.lti.mod.services.searchservices.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.lti.mod.services.searchservices.model.Role;
import com.lti.mod.services.searchservices.model.Technology;
import com.lti.mod.services.searchservices.model.TechnologyDto;
import com.lti.mod.services.searchservices.model.User;
import com.lti.mod.services.searchservices.repository.SearchRepository;
import com.lti.mod.services.searchservices.repository.UserSearchRepository;

@Service
@Transactional
public class SearchServiceImpl implements SearchService {

	@Autowired
	SearchRepository searchRepository;
	
	@Autowired
	UserSearchRepository userRepo;

	@Override
	public List<TechnologyDto> findAll() {
		
		List list = searchRepository.findAllData();
		List<TechnologyDto> listdata = new ArrayList<TechnologyDto>();
		System.out.println("list "+list.toString());
		Iterator it = list.iterator();
		
		while(it.hasNext()) {
			Object[] object = (Object[]) it.next();
			TechnologyDto dto = new TechnologyDto();
			dto.setId((BigInteger) object[0]);
			dto.setTechnology((String) object[1]);
			dto.setDescription((String) object[2]);
			dto.setStatus((String) object[3]);
			dto.setFees((BigInteger) object[4]);
			dto.setName((String) object[5]);
			dto.setMentorId((BigInteger) object[6]);
			listdata.add(dto);
		}
		
		return listdata;
	}

	@Override
	public List<TechnologyDto> getAllTechnology() {
		List list = searchRepository.findAllCourses();
		List<TechnologyDto> listdata = new ArrayList<TechnologyDto>();
		Iterator it = list.iterator();

		while(it.hasNext()) {
			Object[] object = (Object[]) it.next();
			TechnologyDto dto = new TechnologyDto();
			dto.setId((BigInteger) object[0]);
			dto.setTechnology((String) object[1]);
			dto.setDescription((String) object[2]);
			listdata.add(dto);
		}
		return  listdata;
	}

	@Override
	public List<Technology> finAllbyTechnology() {
		return searchRepository.findAll();
	}

	@Override
	public List<TechnologyDto> findAllbyText(String role, String text) {
		
		List list = searchRepository.findAllbyText(role, text);
		List<TechnologyDto> listdata = new ArrayList<TechnologyDto>();
		System.out.println("list "+list.toString());
		Iterator it = list.iterator();
		
		while(it.hasNext()) {
			Object[] object = (Object[]) it.next();
			TechnologyDto dto = new TechnologyDto();
			dto.setId((BigInteger) object[0]);
			dto.setTechnology((String) object[1]);
			dto.setDescription((String) object[2]);
			dto.setStatus((String) object[3]);
			dto.setFees((BigInteger) object[4]);
			dto.setName((String) object[5]);
			listdata.add(dto);
		}
		
		return listdata;
		
	}

	@Override
	public Optional<User> findbyId(Long id) {
		return userRepo.findById(id);
	}

	@Override
	public List<User> findAllUsers() {
		return userRepo.findAll();
	}

	@Override
	public List<User> getUsersByRole(String role) {
		List<User> userList = null;
		List<String> enumNames = Stream.of(Role.values())
                .map(Enum::name)
                .collect(Collectors.toList());
		if(role !=null ) {
			if(enumNames.contains(role)) {
				userList = userRepo.findByRole(role);
			}
		}
		return userList;
	}

	@Override
	public Optional<Technology> findTechnology(Long id) {
		return searchRepository.findById(id);
	}

	@Override
	public User findStudentUserById(Long id, String role) {
		return searchRepository.findStudentUserById(id, role);
	}
	
	

}
