package com.security.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.security.portal.models.Unit;


@Repository
public interface UnitRepository extends JpaRepository<Unit, Long> {
	 @Query("select count(*) from Unit")
	 Long countCourseunits();
}
