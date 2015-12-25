/**
 * 
 */
package com.learning.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

/**
 * @author mandheer
 *
 */
public class CommandHelloWorld extends HystrixCommand<String>{
	
	private final String name;
	
	public CommandHelloWorld(String name) {
		super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
		this.name = name;
	}
	
	@Override
	protected String run() throws Exception {
		
		return "Hello "+name+" !";
	}

}
