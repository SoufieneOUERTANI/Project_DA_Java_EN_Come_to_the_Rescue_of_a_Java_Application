package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Simple brute force implementation
 *
 */
public class WriteSymptomDataToFile implements ISymptomWriter {
	private static Logger logger = null;

	static {
		System.setProperty("java.util.logging.SimpleFormatter.format", "[%1$tF %1$tT] [%4$-7s] %5$s %n");
		logger = Logger.getLogger(WriteSymptomDataToFile.class.getName());
	}

	private String filepath;
	private Map<String, Integer> symptomsList;

	/**
	 * 
	 * @param filepath     a full or partial path to file with symptom strings in
	 *                     it, one per line
	 * @param symptomsList
	 */
	public WriteSymptomDataToFile(String filepath, Map<String, Integer> symptomsList) {
		this.filepath = filepath;
		this.symptomsList = symptomsList;
	}

	@Override
	public void SetSymptoms() throws Exception {
		try (FileWriter writer = new FileWriter(filepath)) {
			if (!symptomsList.isEmpty()) {
				logger.log(Level.INFO, "\n" + "Synthèse des symptomes : " + "\n");
				for (Entry<String, Integer> entry : symptomsList.entrySet()) {
					writer.write(entry.getKey() + ": " + entry.getValue() + "\n");
					logger.log(Level.INFO, entry.getKey() + ": " + entry.getValue());
				}
			} else
				logger.log(Level.INFO, "/n" + "La synthèse est vide !");
		}
	}
}
