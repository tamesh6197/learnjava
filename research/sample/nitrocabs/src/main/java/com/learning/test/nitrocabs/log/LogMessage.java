package com.learning.test.nitrocabs.log;

/**
 * This is having the messages used for logging.
 * 
 * @author mandheer
 *
 */
public interface LogMessage {
	
	/**
	 * date parsing log error message
	 */
	String CAB00001E = "The date provided is in incorrect format.";
	
	/**
	 * error message for invalid pin. Pin requested is out of allowed area.
	 */
	String CAB00002E = "The requested pin is invalid. This doesn't lie in the coverage area.";
	
	/**
	 * error for invalid request.
	 */
	String CAB00003E = "Exception caught while processing request : ";
	/**
	 * message for invalid request
	 */
	String CAB00004E = "Invalid request.";
	/**
	 * message for invalid booking id
	 */
	String CAB00005E = "Invalid bookingId";
	/**
	 * info message for successful booking.
	 */
	String CAB00001I = "Thank you. Your requestId is {} successfully approved. \nThe cab {} will reach you atleast 15 minutes before your travel time at {}";
	
	/**
	 * info message for no booking available.
	 */
	String CAB00002I = "Sorry. There are no cabs available in your area. The booking Id {} can't be processed.";
	
	/**
	 * debug message for developers for profit margin
	 */
	String CAB00001D = "The requestId {} is having {} profit with cabId {}.";
}
