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
	 * The input file
	 * 
	 */
	private String inputFile;

	/**
	 * 
	 * Constructor
	 * 
	 * <ul>
	 * <li>read the input file</li>
	 * </ul>
	 * 
	 * @param inputFile : A full or partial path to file with symptom strings in it,
	 *                  one per line
	 */
	public ReadSymptomDataFromFile(String inputFile) {
		this.inputFile = inputFile;
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
		ArrayList<String> rawSymptomsList = new ArrayList<String>();
		if (inputFile != null) {
			try {
				BufferedReader reader = new BufferedReader(new FileReader(inputFile));
				logger.log(Level.INFO, "\nLecture des symptomes à partir du fichier: " + inputFile + "\n");
				String line = reader.readLine();
				while (line != null) {
					logger.log(Level.FINEST, "symptom from file: " + line);
					rawSymptomsList.add(line.toLowerCase());
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				logger.log(Level.SEVERE, "Erreur lecture fichier : " + inputFile);
				e.printStackTrace();
			}
		}
		return rawSymptomsList;
	}
}
