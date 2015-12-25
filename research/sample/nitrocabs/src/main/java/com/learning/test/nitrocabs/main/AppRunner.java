package com.learning.test.nitrocabs.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.learning.test.nitrocabs.domain.BookingRequest;
import com.learning.test.nitrocabs.domain.BookingResponse;
import com.learning.test.nitrocabs.domain.SectorsInfoData;
import com.learning.test.nitrocabs.exception.CabBusinessException;
import com.learning.test.nitrocabs.log.LogMessage;
import com.learning.test.nitrocabs.travel.CabBooking;
import com.learning.test.nitrocabs.travel.impl.CabBookingImpl;

/**
 * This is the entry point for the Nitro cab service problem.
 * 
 * This class is having the main method to run from command prompt.
 * 
 * This class is creating a number of threads equal to the number of requests for cab booking.
 * 
 * <ul>
 * This is having a few assumptions :
 * <br>
 * <br>
 * <li> All the cabs are accessible to all requests. </li>
 * <li> while booking for the cab. The booking is checked with current timestamp.</li>
 * <li> Assuming the data would come from DB. I've made a singleton having required information {@link SectorsInfoData}.</li>
 * </ul>
 * 
 * 
 * @author mandheer
 *
 */
public class AppRunner 
{
	public static Logger logger = LoggerFactory.getLogger("AppRunner");
    public static void main( String[] args )
    {
    	SectorsInfoData infoData = SectorsInfoData.getInstance();
    	for(final String requestId:infoData.getBookingData().keySet()){
    		final BookingRequest request = infoData.getBookingData().get(requestId);
    		final CabBooking cabBooking= new CabBookingImpl();
    		
    		new Thread(new Runnable() {
				
				public void run() {
					BookingResponse response = null;
					try {
						response = cabBooking.cabBook(request);
					} catch (CabBusinessException e) {
						logger.error(LogMessage.CAB00003E+requestId, e);
					}
					if(response != null){
						logger.info(LogMessage.CAB00001I,response.getBookingId(),response.getCabId(),request.getPickupTime());
					} else {
						logger.info(LogMessage.CAB00002I,requestId);
					}
				}
			}).start();
    		
    	}
    }
}
