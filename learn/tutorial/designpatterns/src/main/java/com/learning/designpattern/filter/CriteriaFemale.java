package com.learning.designpattern.filter;

import java.util.ArrayList;
import java.util.List;

public class CriteriaFemale implements Criteria {

	@Override
	public List<Person> meetCriteria(List<Person> persons) {
		List<Person> femaleCriteria = new ArrayList<Person>();
		
		for(Person person:persons){
			if("FEMALE".equalsIgnoreCase(person.getGender())){
				femaleCriteria.add(person);
			}
		}
		
		return femaleCriteria;
	}

}
