package com.property.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.property.entity.Rooms;


public interface RoomRepository extends JpaRepository<Rooms, Long> {
	
	

}
