/**
 * 
 */
package com.learning.designpattern.builder;

/**
 * @author mandheer
 *
 */
public class PlasticBottle implements Packing {

	/* (non-Javadoc)
	 * @see com.learning.designpattern.builder.Packing#pack()
	 */
	@Override
	public String pack() {
		return "PlasticBottle";
	}

}
