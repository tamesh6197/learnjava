/**
 * 
 */
package com.learning.test.nitrocabs.domain;

import java.io.Serializable;

/**
 * This is booking response made for successful bookings.
 * This is immutable object.
 * 
 * @author mandheer
 *
 */
public class BookingResponse implements Serializable{
	
	/**
	 * default serialversion id
	 */
	private static final long serialVersionUID = -6104190807327493791L;
	
	/**
	 * @param bookingId
	 * @param cabId
	 */
	public BookingResponse(String bookingId, String cabId){
		this.bookingId = bookingId;
		this.cabId = cabId;
	}
	/**
	 * 
	 */
	private String bookingId;
	/**
	 * 
	 */
	private String cabId;
	/**
	 * @return the bookingId
	 */
	public String getBookingId() {
		return this.bookingId;
	}
	/**
	 * @return the cabId
	 */
	public String getCabId() {
		return this.cabId;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BookingResponse [bookingId=");
		builder.append(this.bookingId);
		builder.append(", cabId=");
		builder.append(this.cabId);
		builder.append("]");
		return builder.toString();
	}

}
