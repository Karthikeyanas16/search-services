package com.lti.mod.services.searchservices.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.mod.services.searchservices.model.Technology;
import com.lti.mod.services.searchservices.model.TechnologyDto;
import com.lti.mod.services.searchservices.repository.SearchRepository;

@Service
@Transactional
public class SearchServiceImpl implements SearchService {

	@Autowired
	SearchRepository searchRepository;

	@Override
	public List<TechnologyDto> findAll() {
		return searchRepository.findAllData();
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
	public Object createTechnology(Technology technology) {
		return searchRepository.save(technology);
	}

	@Override
	public void deleteCourse(BigInteger parseLong) {
		searchRepository.deleteById(parseLong);
	}

}
