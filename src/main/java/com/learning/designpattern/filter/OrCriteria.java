package com.learning.designpattern.filter;

import java.util.List;

public class OrCriteria implements Criteria {
	private Criteria criteria;
	private Criteria otherCriteria;
	public OrCriteria(Criteria criteria, Criteria otherCriteria) {
		this.criteria = criteria;
		this.otherCriteria = otherCriteria;
	}

	@Override
	public List<Person> meetCriteria(List<Person> persons) {
		List<Person> overallCriteria = criteria.meetCriteria(persons);
		for(Person person:otherCriteria.meetCriteria(persons)){
			if(!overallCriteria.contains(person)){
				overallCriteria.add(person);
			}
		}
		return overallCriteria;
	}
}
