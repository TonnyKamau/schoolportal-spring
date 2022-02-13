package com.security.portal.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.security.portal.models.SitAllocation;
import com.security.portal.repository.SitAllocationRepository;



@Service
public class SitAllocationService {

	@Autowired
    private SitAllocationRepository repo;
	
	public List<SitAllocation> listAll() {
        return repo.findAll();
    }
     
    public void save(SitAllocation unit) {
        repo.save(unit);
    }
     
    public SitAllocation get(long id) {
        return repo.findById(id).get();
    }
     
    public void delete(long id) {
        repo.deleteById(id);
    }
}
