package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Simple brute force implementation
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {
	private static Logger logger = null;

	static {
		System.setProperty("java.util.logging.SimpleFormatter.format", "[%1$tF %1$tT] [%4$-7s] %5$s %n");
		logger = Logger.getLogger(ReadSymptomDataFromFile.class.getName());
	}

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
			logger.log(Level.INFO, "\n" + "Lecture du ficher des symptomes: " + "\n");
			while (line != null) {
				logger.log(Level.INFO, "symptom from file: " + line);
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
