package com.property.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.property.entity.Area;


public interface AreaRepository extends JpaRepository<Area, Long>  {
	
	Area findByName(String name);

}