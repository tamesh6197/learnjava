package com.learning.designpattern.filter;

import java.util.ArrayList;
import java.util.List;

public class FilterPatternDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		List<Person> listPersons = new ArrayList<>();
		listPersons.add(new Person("Mandheer", "male", "single", 24));
		listPersons.add(new Person("Robert", "male", "married", 29));
		listPersons.add(new Person("Jigyasa", "female", "single", 21));
		listPersons.add(new Person("Kavita", "female", "married", 16));
		listPersons.add(new Person("Rajesh", "male", "single", 55));
		listPersons.add(new Person("Lara", "female", "married", 27));
		listPersons.add(new Person("Patrick", "male", "single", 26));
		listPersons.add(new Person("Alok", "male", "single", 11));
		
		Criteria single = new CriteriaSingle();
		Criteria male =  new CriteriaMale();
		Criteria female = new CriteriaFemale();
		Criteria singleMale = new AndCriteria(male, single);
		Criteria singleOrFemale = new OrCriteria(single, female);
		
		System.out.println("Males : ");
		printPersons(male.meetCriteria(listPersons));
		System.out.println("Females : ");
		printPersons(female.meetCriteria(listPersons));
		System.out.println("Single Males : ");
		printPersons(singleMale.meetCriteria(listPersons));
		System.out.println("Single OR Females : ");
		printPersons(singleOrFemale.meetCriteria(listPersons));
		
	}
	
	private static void printPersons(List<Person> persons ){
		for(Person person:persons){
			System.out.printf("Name: %s,Gender: %s,Marital Status: %s,Age: %s\n",person.getName(),person.getGender(),person.getMartialStatus(),person.getAge());
		}
	}

}
