package com.learning.test.nitrocabs.domain;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.learning.test.nitrocabs.exception.CabBusinessException;
import com.learning.test.nitrocabs.util.CabUtility;

/**
 * This is singleton class having all information. As the data is used for
 * readonly purpose we don't to make a clone before returning the reference from
 * the getters.
 * 
 * @author mandheer
 */
public class SectorsInfoData implements Serializable {

	private static Logger LOG = LoggerFactory.getLogger(SectorsInfoData.class);

	/**
	 * default serialversion id
	 */
	private static final long serialVersionUID = 5916644212980739466L;

	/**
	 * default constructor is private for singleton
	 * 
	 * The key will be sector ID and valus would be the sector pin code.
	 */
	private SectorsInfoData() {
		try {
			initData();
		} catch (ParseException e) {
			LOG.error("ParseException caught.",e);
		}
	}
	
	private void initData() throws ParseException{
		LOG.trace("Initialise ....");
		cabData = new ConcurrentHashMap<String, Integer>();
		cabData.put("DL01HB001", 100020);
		cabData.put("DL01HB002", 100040);
		cabData.put("DL01HB003", 100060);
		cabData.put("DL01HB004", 100080);
		bookingData = new ConcurrentHashMap<String, BookingRequest>();
		bookingData.put("BR001", new BookingRequest("BR001", 100025, 100036, CabUtility.formatDate("10 am")));
		bookingData.put("BR002", new BookingRequest("BR002", 100056, 100042, CabUtility.formatDate("11 am")));
		bookingData.put("BR003", new BookingRequest("BR003", 100044, 100056, CabUtility.formatDate("12 pm")));
		bookingData.put("BR004", new BookingRequest("BR004", 100028, 100036, CabUtility.formatDate("03 pm")));
		LOG.trace("Loaded ....");
	}

	/**
	 * 
	 */
	private Map<String, Integer> cabData;

	/**
	 * 
	 */
	private Map<String, BookingRequest> bookingData;

	/**
	 * @author mandheer
	 *
	 */
	private static class SingletonHolder {
		/**
		 * 
		 */
		public static final SectorsInfoData INSTANCE = new SectorsInfoData();
	}

	/**
	 * @return
	 */
	public static SectorsInfoData getInstance() {
		return SingletonHolder.INSTANCE;
	}

	/**
	 * @return the cabData
	 */
	public Map<String, Integer> getCabData() {
		return this.cabData;
	}

	/**
	 * @return the bookingData
	 */
	public Map<String, BookingRequest> getBookingData() {
		return this.bookingData;
	}
}
