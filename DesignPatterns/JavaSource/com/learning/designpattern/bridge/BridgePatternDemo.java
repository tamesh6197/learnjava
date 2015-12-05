package com.learning.designpattern.bridge;

public class BridgePatternDemo {
	
	public static void main(String [] args) {
		Shape redShape = new Circle(3, 4, 50, new RedCircle());
		Shape greenShape = new Circle(6, 8, 10, new GreenCircle());
		
		redShape.draw();
		greenShape.draw();
	}

}
