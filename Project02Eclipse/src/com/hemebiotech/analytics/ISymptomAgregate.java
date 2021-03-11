package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Interface , returning a list of strings, that may contain many duplications
 * 
 * The implementation does not need to order the list
 * 
 */
public interface ISymptomAgregate {
	/**
	 * If no data is available, return an empty List
	 * 
	 * @return a raw listing of all Symptoms obtained from a data source, duplicates
	 *         are possible/probable
	 * @throws Exception
	 */
	Map<String, Integer> agregateSymptoms() throws Exception;
}
