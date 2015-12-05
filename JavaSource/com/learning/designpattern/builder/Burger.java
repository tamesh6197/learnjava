/**
 * 
 */
package com.learning.designpattern.builder;

/**
 * @author mandheer
 *
 */
public abstract class Burger implements Item {

	/* (non-Javadoc)
	 * @see com.learning.designpattern.builder.Item#packing()
	 */
	@Override
	public Packing packing() {
		return new PaperWrapper();
	}

}
