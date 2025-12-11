package com.property.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.property.PropertyServiceApplication;
import com.property.dto.APIResponse;
import com.property.dto.PropertyDto;
import com.property.dto.RoomsDto;
import com.property.entity.Area;
import com.property.entity.City;
import com.property.entity.Property;
import com.property.entity.PropertyPhotos;
import com.property.entity.RoomAvailability;
import com.property.entity.Rooms;
import com.property.entity.State;
import com.property.repository.AreaRepository;
import com.property.repository.CityRepository;
import com.property.repository.PropertyPhotosRepository;
import com.property.repository.PropertyRepository;
import com.property.repository.RoomAvailabilityRepository;
import com.property.repository.RoomRepository;
import com.property.repository.StateRepository;

@Service
public class PropertyService {

    private final PropertyServiceApplication propertyServiceApplication;
	
	private PropertyRepository propertyRepository;
	private AreaRepository areaRepository;
	private CityRepository cityRepository;
	private StateRepository stateRepository;
	private S3Service s3Service;
	private PropertyPhotosRepository photosRepository;
	private RoomAvailabilityRepository availabilityRepository; 
	private RoomRepository roomRepository;
	
	public PropertyService(PropertyRepository propertyRepository, AreaRepository areaRepository,
			CityRepository cityRepository, StateRepository stateRepository, S3Service s3Service, PropertyPhotosRepository photosRepository,
			PropertyServiceApplication propertyServiceApplication, RoomAvailabilityRepository availabilityRepository, RoomRepository roomRepository) {
		super();
		this.propertyRepository = propertyRepository;
		this.areaRepository = areaRepository;
		this.cityRepository = cityRepository;
		this.stateRepository = stateRepository;
		this.s3Service = s3Service;
		this.photosRepository = photosRepository;
		this.propertyServiceApplication = propertyServiceApplication;
		this.availabilityRepository = availabilityRepository;
		this.roomRepository = roomRepository;
	}


	public PropertyDto addProperty(PropertyDto dto, MultipartFile[] files) {	
		
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
	    
	 // Upload files to S3
	    List<String> fileUrls = s3Service.uploadFiles(files);
	    
		for(String url : fileUrls) {
			PropertyPhotos photos = new PropertyPhotos();
			photos.setUrl(url);
			photos.setProperty(savedProperty);
			
			photosRepository.save(photos);
			
		}
		return dto;
	}
	
	public APIResponse searchProperty(String city, LocalDate date) {
		List<Property> properties = propertyRepository.searchProperty(city,date);
		APIResponse<List<Property>> response = new APIResponse<>();
		
		response.setMessage("Search result");
		response.setStatus(200);
		response.setData(properties);
		
		return response;
	}
	
	public APIResponse<PropertyDto> findPropertyById(long id){
		APIResponse<PropertyDto> response = new APIResponse<>();
		PropertyDto dto  = new PropertyDto();
		Optional<Property> opProp = propertyRepository.findById(id);
		if(opProp.isPresent()) {
			Property property = opProp.get();
			dto.setArea(property.getArea().getName());
			dto.setCity(property.getCity().getName());
			dto.setState(property.getState().getName());
			List<Rooms> rooms = property.getRooms();
			List<RoomsDto> roomsDto = new ArrayList<>();
			for(Rooms room:rooms) {
				RoomsDto roomDto = new RoomsDto();
				BeanUtils.copyProperties(room, roomDto);
				roomsDto.add(roomDto);
			}
			dto.setRooms(roomsDto);
			BeanUtils.copyProperties(property, dto);
			response.setMessage("Matching Record");
			response.setStatus(200);
			response.setData(dto);
			return response;
		}
		
		return null;
	}

	public List<RoomAvailability> getTotalRoomsAvailable(long id) {
		return availabilityRepository.findByRoomId(id);
		
	}
	
	public Rooms getRoomById(long id) {
		return roomRepository.findById(id).get();
	}

}
