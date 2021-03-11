package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.Map;

/**
 * * <u><b>Program input</b></u> : "symptoms.txt" <u><b>program ouput</b></u> :
 * "result.out"<br>
 * <br>
 * 
 * <u><b>Program specification : </b></u> As input to this program, we have a
 * file called <u>"symptoms.txt"</u>, the lines of which contain the symptoms
 * listed, one symptom per line. The symptoms can repeat on different lines. The
 * main function of this program is, from the input file, to produce an output
 * file named <u>"result.out"</u>, which contains a single line per symptom
 * specifying the number of times this symptom has appeared in the input
 * file<br>
 * <br>
 *
 * <u><b>Example :</b></u><br>
 * <br>
 * 
 * <u>input : symptoms.txt</u><br>
 * <br>
 * 
 * anxiety<br>
 * cough<br>
 * anxiety<br>
 * blurred<br>
 * vision<br>
 * <br>
 * <u>output : output.txt</u><br>
 * <br>
 * 
 * anxiety 2<br>
 * cough 1<br>
 * blurred 1<br>
 * vision 1<br>
 * <br>
 * 
 * @author SOUE<br>
 * 
 * 
 */
public class AnalyticsCounter {

	/**
	 * <b>Main fonction</b> og the program : <br>
	 * 1- Read the file symptoms.txt by the class <b>ReadSymptomDataFromFile</b><br>
	 * 2- <b>readSymptomDataFromFile.GetSymptoms()</b> return a Map of list of the
	 * symptoms<br>
	 * 3- Read the raw list of symptoms by the class
	 * <b>WriteSymptomDataToFile</b><br>
	 * 4- <b>writeSymptomDataToFile.SetSymptoms()</b> agregates the symptoms and
	 * write in the output file<br>
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String args[]) throws Exception {
		/**
		 * 
		 */
		ISymptomReader symptomReader = new ReadSymptomDataFromFile("Project02Eclipse/symptoms.txt");
		ArrayList<String> rawSymptomsList = symptomReader.getRawSymptoms();
		/**
		 * 
		 */
		ISymptomAgregate symptomAgregate = new AgregateSymptom(rawSymptomsList);
		Map<String, Integer> agregateSymptomsList = symptomAgregate.agregateSymptoms();
		/**
		 * 
		 */
		ISymptomWriter symptomWriter = new WriteSymptomDataToFile("Project02Eclipse/result.out", agregateSymptomsList);
		symptomWriter.setSymptoms();
	}
}
