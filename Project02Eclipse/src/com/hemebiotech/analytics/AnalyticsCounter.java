package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.Map;

import com.hemebiotech.analytics.business.AgregateSymptom;
import com.hemebiotech.analytics.business.ReadSymptomDataFromFile;
import com.hemebiotech.analytics.business.WriteSymptomDataToFile;
import com.hemebiotech.analytics.service.ISymptomAgregate;
import com.hemebiotech.analytics.service.ISymptomReader;
import com.hemebiotech.analytics.service.ISymptomWriter;

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
	 * <ul>
	 * <li>Read the input file symptoms.txt into an ArrayList</li>
	 * <li>Agregate the ArrayList into a HashMap, so that there will be one line per
	 * symptom/count</li>
	 * <li>Write the agregate HashMap into the output file</li>
	 * </ul>
	 * 
	 * @param args without param
	 * 
	 * @throws Exception To read the input file and to write the output file
	 * 
	 */
	public static void main(String args[]) throws Exception {
		// Read the input file and return an ArrayList
		ISymptomReader symptomReader = new ReadSymptomDataFromFile("Project02Eclipse/symptoms.txt");
		ArrayList<String> rawSymptomsList = symptomReader.getRawSymptoms();

		// Read the input ArrayList and return a Map
		ISymptomAgregate symptomAgregate = new AgregateSymptom(rawSymptomsList);
		Map<String, Integer> agregateSymptomsList = symptomAgregate.agregateSymptoms();

		// Read the Map and write it into the output file
		ISymptomWriter symptomWriter = new WriteSymptomDataToFile("Project02Eclipse/result.out", agregateSymptomsList);
		symptomWriter.setSymptoms();
	}
}
