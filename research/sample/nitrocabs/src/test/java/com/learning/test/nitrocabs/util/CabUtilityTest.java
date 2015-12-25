/**
 * 
 */
package com.learning.test.nitrocabs.util;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import com.learning.test.nitrocabs.domain.BookingRequest;
import com.learning.test.nitrocabs.exception.CabBusinessException;
import com.learning.test.nitrocabs.util.CabUtility;


/**
 * @author mandheer
 *
 */
public class CabUtilityTest {

	/**
	 * Test method for {@link com.learning.test.nitrocabs.util.CabUtility#cabProfit(int, int, int)}.
	 */
	@Test
	public final void testCabProfit() {
		Assert.assertNotNull(CabUtility.cabProfit(100100, 100001, 100100));
	}

	/**
	 * Test method for {@link com.learning.test.nitrocabs.util.CabUtility#formatDate(java.lang.String)}.
	 * @throws ParseException 
	 */
	@Test(expected=ParseException.class)
	public final void testFormatDateNegative() throws ParseException {
		CabUtility.formatDate("10:35:25 AM");
	}
	
	/**
	 * Test method for {@link com.learning.test.nitrocabs.util.CabUtility#formatDate(java.lang.String)}.
	 * @throws ParseException 
	 */
	@Test
	public final void testFormatDatePositive() throws ParseException {
		Assert.assertNotNull(CabUtility.formatDate("10 PM"));
	}

	/**
	 * Test method for {@link com.learning.test.nitrocabs.util.CabUtility#isBookingTimeAllowed(int, int, java.util.Date)}.
	 */
	@Test
	public final void testIsBookingTimeAllowed() {
		Assert.assertFalse(CabUtility.isBookingTimeAllowed(100001, 100001, Calendar.getInstance().getTime()));
	}

	/**
	 * Test method for {@link com.learning.test.nitrocabs.util.CabUtility#validateRequest(com.learning.test.nitrocabs.domain.BookingRequest)}.
	 * @throws CabBusinessException 
	 */
	@Test(expected=CabBusinessException.class)
	public final void testValidateRequestNegative_1() throws CabBusinessException {
		CabUtility.validateRequest(null);
	}
	
	/**
	 * Test method for {@link com.learning.test.nitrocabs.util.CabUtility#validateRequest(com.learning.test.nitrocabs.domain.BookingRequest)}.
	 * @throws CabBusinessException 
	 */
	@Test(expected=CabBusinessException.class)
	public final void testValidateRequestNegative_2() throws CabBusinessException {
		CabUtility.validateRequest(getRequestData("BH002",500,100100));
	}
	
	/**
	 * Test method for {@link com.learning.test.nitrocabs.util.CabUtility#validateRequest(com.learning.test.nitrocabs.domain.BookingRequest)}.
	 * @throws CabBusinessException 
	 */
	@Test(expected=CabBusinessException.class)
	public final void testValidateRequestNegative_3() throws CabBusinessException {
		CabUtility.validateRequest(getRequestData("BH002",100100,100));
	}
	
	/**
	 * Test method for {@link com.learning.test.nitrocabs.util.CabUtility#validateRequest(com.learning.test.nitrocabs.domain.BookingRequest)}.
	 * @throws CabBusinessException 
	 */
	@Test(expected=CabBusinessException.class)
	public final void testValidateRequestNegative_4() throws CabBusinessException {
		CabUtility.validateRequest(getRequestData(null,500,100100));
	}
	
	private BookingRequest getRequestData(String requestId, int startPin,int dropPin){
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, cal.get(Calendar.HOUR_OF_DAY)+2);
		Date afterTwoHours = cal.getTime();
		return new BookingRequest(requestId, startPin,
				dropPin, afterTwoHours);
		
	}

}
