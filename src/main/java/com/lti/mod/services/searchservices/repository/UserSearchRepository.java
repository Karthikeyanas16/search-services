package com.lti.mod.services.searchservices.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lti.mod.services.searchservices.model.User;

public interface UserSearchRepository extends JpaRepository<User, Long>{

	User findById(String id);

    @Query("SELECT u FROM User u WHERE u.role = ?1")
	List<User> findByRole(String role);

}
