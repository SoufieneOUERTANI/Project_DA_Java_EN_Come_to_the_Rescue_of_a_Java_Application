package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.Map;

import com.hemebiotech.analytics.business.AgregateSymptom;
import com.hemebiotech.analytics.business.ReadSymptomDataFromFile;
import com.hemebiotech.analytics.business.SortSymptom;
import com.hemebiotech.analytics.business.WriteSymptomDataToFile;
import com.hemebiotech.analytics.service.ISymptomAgregate;
import com.hemebiotech.analytics.service.ISymptomReader;
import com.hemebiotech.analytics.service.ISymptomSort;
import com.hemebiotech.analytics.service.ISymptomWriter;

/**
 * <u><b>Program input</b></u> : "symptoms.txt"<br>
 * <u><b>program ouput</b></u> : "result.out"<br>
 * <br>
 * 
 * <u><b>Program specification : </b></u> As input to this program, we have a
 * file called <u>"symptoms.txt"</u>, the lines of which contain the symptoms
 * listed, one symptom per line. The symptoms can repeat on different lines. The
 * main function of this program is, from the input file, to produce an output
 * file named <u>"result.out"</u>, which contains a single line per symptom
 * specifying the number of times this symptom has appeared in the input file,
 * and sorted on the symptom. All the output symptoms must be lowercase. <br>
 * <br>
 *
 * <u><b>Example :</b></u><br>
 * <br>
 * 
 * <u>input : symptoms.txt</u><br>
 * <br>
 * 
 * Anxiety<br>
 * cough<br>
 * anxiety<br>
 * blurred<br>
 * vision<br>
 * <br>
 * <u>output : output.txt</u><br>
 * <br>
 * 
 * anxiety 2<br>
 * blurred 1<br>
 * cough 1<br>
 * vision 1<br>
 * <br>
 * 
 * @author SOUE<br>
 * 
 * 
 */
public class AnalyticsCounter {

	/**
	 * <ul>
	 * <li>Read line by line the input file of symptoms "symptoms.txt" into an
	 * ArrayList</li>
	 * <li>Agregate the ArrayList into a HashMap, so that there will have one line
	 * per symptom for which we will have the count of occurences of this
	 * symptom</li>
	 * <li>Sort the HashMap into a sorted HashMap, so that the list of symptoms will
	 * be sorted by symptom</li>
	 * <li>Write the soretd HashMap into the output file</li>
	 * </ul>
	 * 
	 * @param args without param
	 * 
	 * @throws Exception To read the input file and to write the output file
	 * 
	 */
	public static void main(String args[]) throws Exception {

		String inputFile = "Project02Eclipse/symptoms.txt";
		String outputFile = "Project02Eclipse/result.out";

		ArrayList<String> rawSymptomsList = loadSymptomsInputFile(inputFile);

		Map<String, Integer> agregatedSymptomsList = countPerSymptom(rawSymptomsList);

		Map<String, Integer> sortedagregatedSymptomsList = sortBySymptom(agregatedSymptomsList);

		writeOutputFile(sortedagregatedSymptomsList, outputFile);

	}

	/**
	 * Read the input file and return a raw ArrayList of all the lines of the input
	 * file. Each line is turned to lowercase before writing into the output
	 * ArrayList
	 * 
	 * @param inputFile : An input file of symptoms
	 * @return a raw ArrayList of symptoms
	 */
	private static ArrayList<String> loadSymptomsInputFile(String inputFile) {
		ISymptomReader symptomReader = new ReadSymptomDataFromFile(inputFile);
		ArrayList<String> rawSymptomsList = symptomReader.getRawSymptoms();
		return rawSymptomsList;
	}

	/**
	 * Read the input ArrayList and return a HashMap agregated by key, counting the
	 * number of occurences for each key
	 * 
	 * @param rawSymptomsList : A raw ArrayList of symptoms
	 * @return an agregated HashMap key/count
	 */
	private static Map<String, Integer> countPerSymptom(ArrayList<String> rawSymptomsList) {
		ISymptomAgregate symptomAgregate = new AgregateSymptom(rawSymptomsList);
		Map<String, Integer> agregatedSymptomsList = symptomAgregate.agregateSymptoms();
		return agregatedSymptomsList;
	}

	/**
	 * Read a input HashMap and return a the same HashMap sorted by key
	 * 
	 * @param agregatedSymptomsList : A non sorted HashMap
	 * @return A sorted HashMap by key
	 */
	private static Map<String, Integer> sortBySymptom(Map<String, Integer> agregatedSymptomsList) {
		ISymptomSort symptomSort = new SortSymptom(agregatedSymptomsList);
		Map<String, Integer> sortedagregatedSymptomsList = symptomSort.sortSymptoms();
		return sortedagregatedSymptomsList;
	}

	/**
	 * Read the input HashMap and wrtie it in the output file
	 * 
	 * @param sortedagregatedSymptomsList
	 * @param outputFile
	 */
	private static void writeOutputFile(Map<String, Integer> sortedagregatedSymptomsList, String outputFile) {
		ISymptomWriter symptomWriter = new WriteSymptomDataToFile(outputFile, sortedagregatedSymptomsList);
		symptomWriter.setSymptoms();
	}

}
