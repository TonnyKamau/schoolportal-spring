package com.security.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.security.portal.models.Room;



@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
	 @Query("select count(*) from Room")
	 Long countRooms();
}
