package com.hemebiotech.analytics.business;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
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
 * @see ISymptomAgregate
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
	public void setSymptoms() {
		try (FileWriter writer = new FileWriter(filepath)) {
			if (!symptomsList.isEmpty()) {

				logger.log(Level.INFO, "\nEcriture des symptomes dans le fichier : " + filepath + "\n");
				ArrayList<String> sortKeys = new ArrayList<String>(symptomsList.keySet());
				Collections.sort(sortKeys);

				for (String symptom : sortKeys) {
					writer.write(symptom + ": " + symptomsList.get(symptom) + "\n");
					logger.log(Level.FINEST, symptom + ": " + symptomsList.get(symptom));
				}
			} else
				logger.log(Level.WARNING, "\n" + "La liste des symptmes est vide !");

		} catch (IOException e) {
			// SOUE : Logger(leverl.error)
			e.printStackTrace();
		}
	}
}
