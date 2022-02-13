package com.security.portal.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.security.portal.models.User;




@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	@Query("select count(*) from User")
	   Long countUsers();
	Optional<User> findByUserName(String userName);
}