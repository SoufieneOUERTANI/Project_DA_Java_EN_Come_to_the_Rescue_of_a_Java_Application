package com.hemebiotech.analytics.business;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.hemebiotech.analytics.service.ISymptomReader;

/**
 * <ul>
 * <li>implements ISymptomReader</li>
 * <li>read the param input file</li>
 * <li>write each line of the param input file into an ArrayList</li>
 * <li>return the ArrayList</li>
 * </ul>
 * 
 * @author SOUE
 * 
 * @see ISymptomReader
 *
 */

public class ReadSymptomDataFromFile implements ISymptomReader {

	/**
	 * Using a Logger to display the file lines beeing read
	 */
	private Logger logger = null;
	{
		System.setProperty("java.util.logging.SimpleFormatter.format", "[%1$tF %1$tT] [%4$-7s] %5$s %n");
		logger = Logger.getLogger(ReadSymptomDataFromFile.class.getName());
	}

	/**
	 * 
	
	 */
	private String filepath;

	/**
	 * 
	 * Constructor
	 * 
	 * <ul>
	 * <li>read the input file</li>
	 * </ul>
	 * 
	 * @param filepath : A full or partial path to file with symptom strings in it,
	 *                 one per line
	 */
	public ReadSymptomDataFromFile(String filepath) {
		this.filepath = filepath;
	}

	/**
	 * <ul>
	 * <li>browse the input file, line by line</li>
	 * <li>write each line of the input file into the ArrayList</li>
	 * <li>return the ArrayList</li>
	 * </ul>
	 * 
	 * @return and ArrayList of strings
	 * 
	 */

	@Override
	public ArrayList<String> getRawSymptoms() {
		ArrayList<String> result = new ArrayList<String>();

		if (filepath != null) {
			try {
				BufferedReader reader = new BufferedReader(new FileReader(filepath));
				String line = reader.readLine();
				logger.log(Level.INFO, "\n\nListe des symptomes: \n");
				logger.log(Level.INFO, "\n");
				while (line != null) {
					logger.log(Level.INFO, "symptom from file: " + line);
					result.add(line);
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return result;
	}
}
