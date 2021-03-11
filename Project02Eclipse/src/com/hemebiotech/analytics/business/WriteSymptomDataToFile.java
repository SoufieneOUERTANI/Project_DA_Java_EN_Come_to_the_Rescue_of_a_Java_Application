package com.hemebiotech.analytics.business;

import java.io.FileWriter;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.hemebiotech.analytics.service.ISymptomAgregate;
import com.hemebiotech.analytics.service.ISymptomWriter;

/**
 * <ul>
 * <li>implements ISymptomWriter</li>
 * <li>read :
 * <ul>
 * <li>the param input HashMap of String/count</li>
 * <li>the param output file</li>
 * </ul>
 * <li>browse the param HashMap and write it into the param output file</li>
 * <li>return the HashMap</li>
 * </ul>
 * 
 * @author SOUE
 * 
 * @see ISymptomAgregate Intrface d'ecriture du fichier
 *
 */
public class WriteSymptomDataToFile implements ISymptomWriter {

	/**
	 * Using a Logger to display the file lines beeing read
	 */
	private static Logger logger = null;
	static {
		System.setProperty("java.util.logging.SimpleFormatter.format", "[%1$tF %1$tT] [%4$-7s] %5$s %n");
		logger = Logger.getLogger(WriteSymptomDataToFile.class.getName());
	}

	private String filepath;
	private Map<String, Integer> symptomsList;

	/**
	 * 
	 * Constructor
	 * 
	 * <ul>
	 * <li>read :
	 * <ul>
	 * <li>the param input HashMap of String/count</li>
	 * <li>the param output file</li>
	 * </ul>
	 * </ul>
	 * 
	 * @param filepath     Output file
	 * @param symptomsList Map of String/count
	 */
	public WriteSymptomDataToFile(String filepath, Map<String, Integer> symptomsList) {
		this.filepath = filepath;
		this.symptomsList = symptomsList;
	}

	/**
	 *
	 * browse the Map and write it into the output file
	 * 
	 */

	@Override
	public void setSymptoms() throws Exception {
		try (FileWriter writer = new FileWriter(filepath)) {
			if (!symptomsList.isEmpty()) {
				logger.log(Level.INFO, "\n\nSynthèse des symptomes: \n");
				logger.log(Level.INFO, "\n");
				for (Entry<String, Integer> entry : symptomsList.entrySet()) {
					writer.write(entry.getKey() + ": " + entry.getValue() + "\n");
					logger.log(Level.INFO, entry.getKey() + ": " + entry.getValue());
				}
			} else
				logger.log(Level.INFO, "/n" + "La synthèse est vide !");
		}
	}
}
