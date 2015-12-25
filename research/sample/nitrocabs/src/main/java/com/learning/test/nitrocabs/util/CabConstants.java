package com.learning.test.nitrocabs.util;

/**
 * Interface would be having all constants .
 * 
 * @author mandheer
 */
public interface CabConstants {

	/**
	 * Distance b/w adjacent sectors.
	 */
	int DIST_ADJ_SECTOR_IN_KM = 2;
	
	/**
	 * travel time per km in minutes.
	 */
	int TRAVEL_TIME_PER_KM_IN_MINS = 2;
	
	/**
	 * company cost per kilometer in INR
	 */
	float COMP_COST_PER_KM_IN_INR = 5;
	
	/**
	 * Customer cost per kilometer in INR
	 */
	float CUST_COST_PER_KM_IN_INR = 10;
	
	/**
	 * lower bound for PIN request
	 */
	int REQUEST_MIN_PIN = 100001;
	
	/**
	 * upper bound for PIN request
	 */
	int REQUEST_MAX_PIN = 100100;
	
	/**
	 * minimum time before which cab should be at pickup point
	 */
	long MIN_TIME_ARRIVAL_GAP_IN_MIN = 15; 
	
	/**
	 * this is lower threshold for profit.
	 */
	float MIN_PROFIT_MARGIN = 20f;
}
