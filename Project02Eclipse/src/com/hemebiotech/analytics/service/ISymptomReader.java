package com.hemebiotech.analytics.service;

import java.util.ArrayList;

/**
 * Interface , returning a list of strings, that may contain duplications
 * 
 * The implementation does not need to order the list
 * 
 */
public interface ISymptomReader {
	/**
	 * 
	 * @return a raw listing of all Symptoms obtained from a data source, duplicates
	 *         are possible/probable. If no data is available, return an empty List
	 */
	ArrayList<String> getRawSymptoms();
}
