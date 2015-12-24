package com.learning.designpattern.builder;

public class ChickenBurger extends Burger {

	@Override
	public String name() {
		return "NonVegBurger";
	}

	@Override
	public float price() {
		return 50.5f;
	}

}
