package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Simple brute force implementation
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;

	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it,
	 *                 one per line
	 */
	public ReadSymptomDataFromFile(String filepath) {
		this.filepath = filepath;
	}

	@Override
	public Map<String, Integer> GetSymptoms() throws Exception {
		Map<String, Integer> result = new HashMap<String, Integer>();
		try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
			String line = reader.readLine();
			while (line != null) {
				System.out.println("symptom from file: " + line);
				if (result.get(line) != null)
					result.put(line, result.get(line) + 1);
				else
					result.put(line, 1);
				line = reader.readLine(); // get another symptom
			}
		}
		return result;
	}
}
