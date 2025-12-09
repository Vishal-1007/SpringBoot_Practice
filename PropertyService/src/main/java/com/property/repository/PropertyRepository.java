package com.property.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.property.entity.Property;

public interface PropertyRepository extends JpaRepository<Property, Long> {

}
