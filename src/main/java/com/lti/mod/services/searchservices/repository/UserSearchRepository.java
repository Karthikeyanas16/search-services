package com.lti.mod.services.searchservices.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lti.mod.services.searchservices.model.User;

public interface UserSearchRepository extends JpaRepository<User, BigInteger>{

	User findById(String id);

}
