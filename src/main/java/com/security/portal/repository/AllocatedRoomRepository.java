package com.security.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.security.portal.models.AllocatedRoom;



@Repository
public interface AllocatedRoomRepository extends JpaRepository<AllocatedRoom, Long> {
	 @Query("select count(*) from AllocatedRoom")
	 Long countRoomAllocations();
}
