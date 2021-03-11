package com.hemebiotech.analytics;

import java.util.ArrayList;

/**
 * Interface , returning a list of strings, that may contain many duplications
 * 
 * The implementation does not need to order the list
 * 
 */
public interface ISymptomReader {
	/**
	 * If no data is available, return an empty List
	 * 
	 * @return a raw listing of all Symptoms obtained from a data source, duplicates
	 *         are possible/probable
	 * @throws Exception
	 */
	ArrayList<String> getRawSymptoms();
}
