package com.security.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.security.portal.models.SitAllocation;


@Repository
public interface SitAllocationRepository extends JpaRepository<SitAllocation, Long>{

}
