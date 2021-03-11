package com.hemebiotech.analytics.service;

import java.util.Map;

/**
 * Interface, returning a HashMap of String/count, that agregate the items from
 * the input
 * 
 */
public interface ISymptomAgregate {
	/**
	 * If no data is available, return an empty Map
	 * 
	 * @return HashMap of String/count
	 * 
	 */
	Map<String, Integer> agregateSymptoms();
}
