package com.mvc;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mvc.controller.UserController;
import com.mvc.service.UserService;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {
	
	@Mock
	private UserService mockService;
	
	@InjectMocks
	private UserController controller;
	
	@Test
    void testGetUserName_Found() {
		when(mockService.getUserName(1)).thenReturn("Alice");
		
		 // Call method & assert
        assertEquals("Alice", controller.getUserName(1));	
        
     // Verify interaction
        verify(mockService, times(1)).getUserName(1);

		
	}
	
	 @Test
	    void testGetUserName_NotFound() {
//		 UserService mockService = mock(UserService.class);
	        when(mockService.getUserName(2)).thenReturn("Unknown User");

//	        UserController controller = new UserController(mockService);

	        assertEquals("Unknown User", controller.getUserName(2));

//	        verify(mockService, times(1)).getUserName(2);
	    }

}
