/**
 * 
 */
package com.learning.test.nitrocabs.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * This is the domain object contains input booking request.
 * This is immutable object.
 * 
 * @author mandheer
 *
 */
public class BookingRequest implements Serializable{
	/**
	 * default serial version Id
	 */
	private static final long serialVersionUID = -6000428667820721363L;
	
	/**
	 * @param bookingId
	 * @param pickupPin
	 * @param dropPin
	 * @param pickupTime
	 */
	public BookingRequest(String bookingId,int pickupPin,int dropPin,Date pickupTime){
		this.bookingId = bookingId;
		this.pickupPin = pickupPin;
		this.dropPin = dropPin;
		this.pickupTime = (Date) pickupTime.clone();
	}
	
	/**
	 * 
	 */
	private String bookingId;
	/**
	 * 
	 */
	private int pickupPin;
	/**
	 * 
	 */
	private int dropPin;
	/**
	 * 
	 */
	private Date pickupTime;
	/**
	 * @return the bookingId
	 */
	public String getBookingId() {
		return this.bookingId;
	}
	/**
	 * @return the pickupPin
	 */
	public int getPickupPin() {
		return this.pickupPin;
	}
	/**
	 * @return the dropPin
	 */
	public int getDropPin() {
		return this.dropPin;
	}
	/**
	 * @return the pickupTime
	 */
	public Date getPickupTime() {
		return (Date) this.pickupTime.clone();
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BookingRequest [bookingId=");
		builder.append(this.bookingId);
		builder.append(", pickupPin=");
		builder.append(this.pickupPin);
		builder.append(", dropPin=");
		builder.append(this.dropPin);
		builder.append(", pickupTime=");
		builder.append(this.pickupTime);
		builder.append("]");
		return builder.toString();
	}

}
