package com.hemebiotech.analytics.business;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.hemebiotech.analytics.service.ISymptomSort;

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
 * @see ISymptomSort
 *
 */
public class SortSymptom implements ISymptomSort {

	private static Logger logger = null;
	static {
		System.setProperty("java.util.logging.SimpleFormatter.format", "[%1$tF %1$tT] [%4$-7s] %5$s %n");
		logger = Logger.getLogger(SortSymptom.class.getName());
	}

	private Map<String, Integer> agregatedSymptomsList;

	/**
	 * 
	 * Constructor
	 * 
	 * <ul>
	 * <li>read the input ArrayList</li>
	 * </ul>
	 * 
	 * @param agregatedSymptomsList RawList of symptoms
	 * 
	 */
	public SortSymptom(Map<String, Integer> agregatedSymptomsList) {
		this.agregatedSymptomsList = agregatedSymptomsList;
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
	public Map<String, Integer> sortSymptoms() {

		Map<String, Integer> sortedagregatedSymptomsList = new HashMap<String, Integer>();

		if (!agregatedSymptomsList.isEmpty()) {

			logger.log(Level.INFO, "\nTri des symptomes : \n");
			ArrayList<String> sortKeys = new ArrayList<String>(agregatedSymptomsList.keySet());
			Collections.sort(sortKeys);

			for (String symptom : sortKeys) {

				sortedagregatedSymptomsList.put(symptom, agregatedSymptomsList.get(symptom));
			}
		} else
			logger.log(Level.WARNING, "\n" + "La liste en entrée est vide !");

		return sortedagregatedSymptomsList;
		// TODO Auto-generated method stub

	}

}
