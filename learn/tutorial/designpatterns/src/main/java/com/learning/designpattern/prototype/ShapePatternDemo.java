package com.learning.designpattern.prototype;

public class ShapePatternDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ShapeCache.loadCache();

		System.out.println("Shape : " + ShapeCache.getShape("1").getType());
		System.out.println("Shape : " + ShapeCache.getShape("2").getType());
		System.out.println("Shape : " + ShapeCache.getShape("3").getType());
	}

}
