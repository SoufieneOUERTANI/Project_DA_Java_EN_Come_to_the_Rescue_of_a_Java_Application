package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Simple brute force implementation
 *
 */
/**
 * @author SOUE
 *
 */
public class AgregateSymptom implements ISymptomAgregate {
	private ArrayList<String> rawSymptomsList;

	public AgregateSymptom(ArrayList<String> rawSymptomsList) {
		this.rawSymptomsList = rawSymptomsList;
	}

	/**
	 *
	 */
	@Override
	public Map<String, Integer> agregateSymptoms() throws Exception {
		Map<String, Integer> result = new HashMap<String, Integer>();
		for (String mySymptom : rawSymptomsList) {
			if (result.get(mySymptom) != null)
				result.put(mySymptom, result.get(mySymptom) + 1);
			else
				result.put(mySymptom, 1);
		}
		return result;
	}

}
