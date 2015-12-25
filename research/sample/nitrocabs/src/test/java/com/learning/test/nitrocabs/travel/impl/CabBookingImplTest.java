/**
 * 
 */
package com.learning.test.nitrocabs.travel.impl;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import com.learning.test.nitrocabs.domain.BookingRequest;
import com.learning.test.nitrocabs.domain.BookingResponse;
import com.learning.test.nitrocabs.exception.CabBusinessException;
import com.learning.test.nitrocabs.travel.CabBooking;
import com.learning.test.nitrocabs.travel.impl.CabBookingImpl;
import com.learning.test.nitrocabs.util.CabUtility;

/**
 * 
 * 
 * @author mandheer
 *
 */
public class CabBookingImplTest {

	private CabBooking cabBooking = new CabBookingImpl();

	/**
	 * Test method for
	 * {@link com.learning.test.nitrocabs.travel.impl.CabBookingImpl#cabBook(com.learning.test.nitrocabs.domain.BookingRequest)}
	 * .
	 * 
	 * @throws CabBusinessException
	 */
	@Test(expected = CabBusinessException.class)
	public final void testCabBookNegative() throws CabBusinessException {
		cabBooking.cabBook(null);
	}

	@Test
	public final void testCabPositive() throws CabBusinessException {

		BookingResponse response = cabBooking.cabBook(getRequestData("BR002", 100001, 100100));
		Assert.assertNotNull("Got Booking : ", response);
		Assert.assertEquals(response.getBookingId(), "BR002");
		Assert.assertNotNull(response.getCabId());
	}

	private BookingRequest getRequestData(String requestId, int startPin,int dropPin){
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, cal.get(Calendar.HOUR_OF_DAY)+2);
		Date afterTwoHours = cal.getTime();
		return new BookingRequest(requestId, startPin,
				dropPin, afterTwoHours);
		
	}

	@Test
	public final void TestNoCab() throws CabBusinessException {
		BookingResponse response = cabBooking.cabBook(getRequestData("BR004", 100001, 100001));
		Assert.assertNull("It should be null.", response);
	}

}
