package com.learning.test.nitrocabs.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.learning.test.nitrocabs.domain.BookingRequest;
import com.learning.test.nitrocabs.exception.CabBusinessException;
import com.learning.test.nitrocabs.log.LogMessage;

/**
 * This is the utility class for various utility methods.
 * 
 * @author mandheer
 *
 */
public class CabUtility {
	
	public static Logger LOG = LoggerFactory.getLogger(CabUtility.class);
	
	/**
	 * default constructor is private as this is utility and all members would be static .
	 */
	private CabUtility(){
		
	}
	
	/**
	 * @param initialPin
	 * @param pickupPin
	 * @param dropPin
	 * @return
	 */
	private static int totalDistCalc(final int initialPin,final int pickupPin,final int dropPin){
		return cabDistToPick(initialPin,pickupPin) + distanceCustomer(pickupPin,dropPin);
	}
	
	/**
	 * @param initialPin
	 * @param pickupPin
	 * @return
	 */
	private static int cabDistToPick(final int initialPin,final int pickupPin){
		int distance = 0;
		if(pickupPin >= initialPin){
			distance+=pickupPin-initialPin;
		} else {
			distance+=initialPin-pickupPin;
		}
		return distance*CabConstants.DIST_ADJ_SECTOR_IN_KM;
	}
	
	/**
	 * @param pickupPin
	 * @param dropPin
	 * @return
	 */
	private static int distanceCustomer(final int pickupPin,final int dropPin){
		int distance = 0;
		if(dropPin >= pickupPin){
			distance +=dropPin - pickupPin;
		} else {
			distance += pickupPin - dropPin;
		}
		return distance*CabConstants.DIST_ADJ_SECTOR_IN_KM;
	}
	
	/**
	 * @param initialPin
	 * @param pickupPin
	 * @return
	 */
	private static long cabTimeToPick(final int initialPin,final int pickupPin){
		return cabDistToPick(initialPin,pickupPin)*CabConstants.TRAVEL_TIME_PER_KM_IN_MINS*60*1000;
	}
	
	/**
	 * @param initialPin
	 * @param pickupPin
	 * @param dropPin
	 * @return
	 */
	public static double cabProfit(final int initialPin,final int pickupPin, final int dropPin){
		float income = distanceCustomer(pickupPin,dropPin)*CabConstants.CUST_COST_PER_KM_IN_INR;
		float cost = totalDistCalc(initialPin,pickupPin,dropPin)*CabConstants.COMP_COST_PER_KM_IN_INR;
		
		return Float.compare(cost, 0f) > 0 ? 100*(income/cost -1) : income*100;
	}
	
	/**
	 * @param stringDate
	 * @return
	 * @throws ParseException 
	 */
	public static Date formatDate(String stringDate) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("KK aa");
		Calendar calParsed = Calendar.getInstance(Locale.US);
		Calendar cal = Calendar.getInstance(Locale.US);
		try {
			calParsed.setTime(sdf.parse(stringDate));
		} catch (ParseException e) {
			LOG.error(LogMessage.CAB00001E, e);
			throw e;
		}
		cal.set(Calendar.HOUR_OF_DAY, calParsed.get(Calendar.HOUR_OF_DAY));
		cal.set(Calendar.MINUTE, calParsed.get(Calendar.MINUTE));
		cal.set(Calendar.SECOND, calParsed.get(Calendar.SECOND));
		cal.set(Calendar.MILLISECOND, calParsed.get(Calendar.MILLISECOND));
		return cal.getTime();
		
	}
	
	/**
	 * it checks if the pin requested is having existance.
	 * 
	 * @param requestPin
	 * @return
	 * @throws CabBusinessException 
	 */
	private static int checkPinBoundary(final int requestPin) throws CabBusinessException{
		if(requestPin < CabConstants.REQUEST_MIN_PIN || requestPin > CabConstants.REQUEST_MAX_PIN){
			throw new CabBusinessException(LogMessage.CAB00002E);
		}
		return requestPin;
	}
	
	/**
	 * @param initialPin
	 * @param pickupPin
	 * @param pickUpTime
	 * @return
	 */
	public static boolean isBookingTimeAllowed(final int initialPin,final int pickupPin,Date pickUpTime){
		long reachTime = cabTimeToPick(initialPin,pickupPin)+Calendar.getInstance().getTimeInMillis();
		long pickTimeMilli = pickUpTime.getTime();
		
		return (pickTimeMilli - reachTime) > CabConstants.MIN_TIME_ARRIVAL_GAP_IN_MIN*60*1000 ? true : false;
		
	}
	
	/**
	 * @param request
	 * @return
	 * @throws CabBusinessException 
	 */
	public static void validateRequest(BookingRequest request) throws CabBusinessException{
		if(request == null){
			throw new CabBusinessException(LogMessage.CAB00004E);
		}
		if(request.getBookingId()==null){
			throw new CabBusinessException(LogMessage.CAB00005E);
		}
		checkPinBoundary(request.getPickupPin());
		checkPinBoundary(request.getDropPin());
	}
	
}
