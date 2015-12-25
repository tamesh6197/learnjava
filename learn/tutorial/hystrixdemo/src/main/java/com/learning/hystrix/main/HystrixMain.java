/**
 * 
 */
package com.learning.hystrix.main;

import java.util.concurrent.Future;

import com.learning.hystrix.CommandHelloWorld;

import rx.Observable;

/**
 * @author mandheer
 *
 */
public class HystrixMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = new CommandHelloWorld("Bob").execute();
		Future<String> str = new CommandHelloWorld("Mandheer").queue();
		//Observable<String> strObs = new CommandHelloWorld("Prashant").observe();
	
		
	}

}
