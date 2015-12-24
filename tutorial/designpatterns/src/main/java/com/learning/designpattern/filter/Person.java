package com.learning.designpattern.filter;

public class Person {
	private String name;
	private String gender;
	private String martialStatus;
	private int age;
	
	public int getAge() {
		return age;
	}
	public String getName() {
		return name;
	}
	public String getGender() {
		return gender;
	}
	public String getMartialStatus() {
		return martialStatus;
	}
	
	public Person(String name,String gender,String maritalStatus,int age){
		this.gender = gender;
		this.name = name;
		this.martialStatus = maritalStatus;
		this.age = age;
	}
}
