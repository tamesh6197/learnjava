package com.sapient.test.nitrocabs.travel;

import com.sapient.test.nitrocabs.domain.BookingRequest;
import com.sapient.test.nitrocabs.domain.BookingResponse;
import com.sapient.test.nitrocabs.exception.CabBusinessException;

/**
 * It would be responsible for having all checks before allocating cab Id to the requests. 
 * 
 * 
 * @author mandheer
 *
 */
public interface CabBooking{
	/**
	 * Method called for cabBoooking.
	 * 
	 * @param request
	 * @return
	 * @throws CabBusinessException 
	 */
	BookingResponse cabBook(BookingRequest request) throws CabBusinessException;
}
