package com.learning.designpattern.builder;

public class BuilderPatternDemo {
	public static void main(String [] args) {
		
		MealBuilder builder = new MealBuilder();
		
		Meal vegMeal = builder.prepareVegMeal();
		System.out.println("VEG MEAL");
		vegMeal.showItems();
		System.out.println("Total cost : "+ vegMeal.getCost());
		
		Meal nonVegMeal = builder.prepareNonVegMeal();
		System.out.println("NON VEG MEAL");
		nonVegMeal.showItems();
		System.out.println("Total cost : "+nonVegMeal.getCost());
		
	}

}
