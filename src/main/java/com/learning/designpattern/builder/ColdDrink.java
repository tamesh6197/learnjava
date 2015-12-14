package com.learning.designpattern.builder;

public abstract class ColdDrink implements Item {

	@Override
	public Packing packing() {
		return new PlasticBottle();
	}

}
