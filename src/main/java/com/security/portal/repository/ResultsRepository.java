package com.security.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.security.portal.models.Results;



@Repository
public interface ResultsRepository extends JpaRepository<Results, Long> {
	 @Query("select count(*) from Results")
	 Long countResults();
}
