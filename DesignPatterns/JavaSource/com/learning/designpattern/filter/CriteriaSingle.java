package com.learning.designpattern.filter;

import java.util.ArrayList;
import java.util.List;

public class CriteriaSingle implements Criteria {

	@Override
	public List<Person> meetCriteria(List<Person> persons) {
		List<Person> singleCriteria = new ArrayList<>();
		
		for(Person person:persons){
			if("SINGLE".equalsIgnoreCase(person.getMartialStatus())){
				singleCriteria.add(person);
			}
		}
		
		return singleCriteria;
	}

}
