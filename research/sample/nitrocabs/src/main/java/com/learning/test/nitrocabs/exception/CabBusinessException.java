/**
 * 
 */
package com.learning.test.nitrocabs.exception;

/**
 * @author mandheer
 *
 */
public class CabBusinessException extends Exception {

	/**
	 * default serial version ID.
	 */
	private static final long serialVersionUID = -38218841144626609L;

	public CabBusinessException(){
		super();
	}
	
	public CabBusinessException(String message){
		super(message);
	}
	
	public CabBusinessException(String message,Throwable cause){
		super(message,cause);
	}
	
	public CabBusinessException(Throwable cause){
		super(cause);
	}
}
