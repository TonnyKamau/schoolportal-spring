package com.security.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.security.portal.models.Department;


@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
	@Query("select count(*) from Department")
	 Long countDepartments();
}
