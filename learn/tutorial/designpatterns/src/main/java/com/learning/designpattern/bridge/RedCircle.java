package com.learning.designpattern.bridge;

public class RedCircle implements DrawAPI {

	@Override
	public void drawCircle(int radius, int x, int y) {
		System.out.printf("\nDraw Circle[color:red,radius:%s,x:%s,y:%s]",radius,x,y);

	}

}
