package com.security.portal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.security.portal.models.Room;
import com.security.portal.repository.RoomRepository;



@Service
public class RoomService {
	@Autowired
    private RoomRepository repo;
	
	public List<Room> listAll() {
        return repo.findAll();
    }
     
    public void save(Room rm) {
        repo.save(rm);
    }
     
    public Room get(long id) {
        return repo.findById(id).get();
    }
     
    public void delete(long id) {
        repo.deleteById(id);
    
    }
}
