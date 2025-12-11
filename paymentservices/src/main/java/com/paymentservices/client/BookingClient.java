package com.paymentservices.client;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface BookingClient {
	
	@PutMapping("/api/v1/booking/update-status-booking")
		public boolean updateBooking(@RequestParam long id);
		

}
