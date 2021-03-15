package com.hemebiotech.analytics.business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

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
	 * Using a Logger to display the file lines beeing read
	 */
	private Logger logger = null;
	{
		System.setProperty("java.util.logging.SimpleFormatter.format", "[%1$tF %1$tT] [%4$-7s] %5$s %n");
		logger = Logger.getLogger(AgregateSymptom.class.getName());
	}

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
		Map<String, Integer> agregateSymptomsList = new HashMap<String, Integer>();
		logger.log(Level.INFO, "\nAgrérer la liste de symptomes par symptome :\n");
		for (String mySymptom : rawSymptomsList) {
			if (agregateSymptomsList.get(mySymptom) != null)
				agregateSymptomsList.put(mySymptom, agregateSymptomsList.get(mySymptom) + 1);
			else
				agregateSymptomsList.put(mySymptom, 1);
		}
		return agregateSymptomsList;
	}

}
