	package com.property.controller;
	
	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestParam;
	import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;
	import com.fasterxml.jackson.core.JsonProcessingException;

	
	import com.fasterxml.jackson.databind.ObjectMapper;
	import com.property.dto.APIResponse;
	import com.property.dto.PropertyDto;
	import com.property.service.PropertyService;
	
	@RestController
	@RequestMapping("/api/v1/property")
	public class PropertyController {
		
	
		private PropertyService propertyService;
		
		private static final Logger logger = LoggerFactory.getLogger(PropertyController.class);

	
		public PropertyController(PropertyService propertyService) {
			super();
			this.propertyService = propertyService;
		}
		
		
		@PostMapping(
			    value = "/add-property"
			)
		
		public ResponseEntity<APIResponse<PropertyDto>> addProperty(
		        @RequestParam("property") String propertyJson,  // Use RequestParam to get the property as a raw JSON string
		        @RequestParam("files") MultipartFile[] files) {
			
			ObjectMapper objectMapper = new ObjectMapper();
			PropertyDto dto = null;
			
			 try {
			        dto = objectMapper.readValue(propertyJson, PropertyDto.class);  // Convert JSON string to PropertyDto
			    } catch (JsonProcessingException e) {
			        logger.error("Error parsing property JSON", e);
			        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);  // Handle bad JSON
			    }
			 
			 
			 // Process the property and files
			    PropertyDto property = propertyService.addProperty(dto);
			    
			    
			    // Create response object
			    APIResponse<PropertyDto> response = new APIResponse<>();
			    response.setMessage("Property added");
			    response.setStatus(201);
			    response.setData(property);

			    return new ResponseEntity<>(response, HttpStatus.CREATED);
			}
		
			
		}
