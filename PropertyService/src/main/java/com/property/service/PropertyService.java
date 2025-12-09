package com.property.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.property.dto.PropertyDto;
import com.property.entity.Area;
import com.property.entity.City;
import com.property.entity.Property;
import com.property.entity.State;
import com.property.repository.AreaRepository;
import com.property.repository.CityRepository;
import com.property.repository.PropertyRepository;
import com.property.repository.StateRepository;

@Service
public class PropertyService {
	
	private PropertyRepository propertyRepository;
	private AreaRepository areaRepository;
	private CityRepository cityRepository;
	private StateRepository stateRepository;
	
	public PropertyService(PropertyRepository propertyRepository, AreaRepository areaRepository,
			CityRepository cityRepository, StateRepository stateRepository) {
		super();
		this.propertyRepository = propertyRepository;
		this.areaRepository = areaRepository;
		this.cityRepository = cityRepository;
		this.stateRepository = stateRepository;
	}


	public PropertyDto addProperty(PropertyDto dto) {	
		
		Area area = areaRepository.findByName(dto.getArea());
		City city = cityRepository.findByName(dto.getCity());
		State state = stateRepository.findByName(dto.getState());
		
		
		Property property = new Property();
	    property.setName(dto.getName());
	    property.setNumberOfBathrooms(dto.getNumberOfBathrooms());
	    property.setNumberOfBeds(dto.getNumberOfBeds());
	    property.setNumberOfRooms(dto.getNumberOfRooms());
	    property.setNumberOfGuestAllowed(dto.getNumberOfGuestAllowed());
	    property.setArea(area);
	    property.setCity(city);
	    property.setState(state);
	    
	    Property savedProperty = propertyRepository.save(property);

		
		
		return dto;
	}
}
