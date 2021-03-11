package com.hemebiotech.analytics.business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.hemebiotech.analytics.service.ISymptomAgregate;

/**
 * <ul>
 * <li>implements ISymptomAgregate</li>
 * <li>read the param input ArrayList of Stirng</li>
 * <li>Agregate the param ArrayList of String into a HashMap of
 * String/count</li>
 * <li>return the HashMap of String/count</li>
 * </ul>
 * 
 * @author SOUE
 * 
 * @see ISymptomAgregate
 *
 */
public class AgregateSymptom implements ISymptomAgregate {
	private ArrayList<String> rawSymptomsList;

	/**
	 * 
	 * Constructor
	 * 
	 * <ul>
	 * <li>read the input ArrayList</li>
	 * </ul>
	 * 
	 * @param rawSymptomsList RawList of symptoms
	 * 
	 */
	public AgregateSymptom(ArrayList<String> rawSymptomsList) {
		this.rawSymptomsList = rawSymptomsList;
	}

	/**
	 * <ul>
	 * <li>browse the ArrayList, item by item</li>
	 * <li>Integrate each item of the ArrrayList into an the HashMap</li>
	 * <li>return the ArrayList</li>
	 * </ul>
	 * 
	 * @return a Map String/count
	 */
	@Override
	public Map<String, Integer> agregateSymptoms() {
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
