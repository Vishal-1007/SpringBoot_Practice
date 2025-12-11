package com.property.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.property.entity.PropertyPhotos;

public interface PropertyPhotosRepository extends JpaRepository <PropertyPhotos, Long> {

}
