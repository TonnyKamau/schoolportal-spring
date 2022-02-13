package com.security.portal.service;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.security.portal.models.User;
import com.security.portal.repository.UserRepository;

 
@Service
public class UserService {

	@Autowired
    private UserRepository repo;
	
	public List<User> listAll() {
        return repo.findAll();
    }
     
    public void save(User std) {
        repo.save(std);
    }
     
    public User get(Integer id) {
        return repo.findById(id).get();
    }
     
    public void delete(Integer id) {
        repo.deleteById(id);
    }
 
}