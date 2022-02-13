package com.security.portal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.security.portal.models.Department;
import com.security.portal.repository.DepartmentRepository;





@Service 
public class DepartmentService {
	@Autowired
    private DepartmentRepository repo;
	
	public List<Department> listAll() {
        return repo.findAll();
    }
     
    public void save(Department saving) {
        repo.save(saving);
    }
     
    public Department get(long id) {
        return repo.findById(id).get();
    }
     
    public void delete(long id) {
        repo.deleteById(id);
    }
}
