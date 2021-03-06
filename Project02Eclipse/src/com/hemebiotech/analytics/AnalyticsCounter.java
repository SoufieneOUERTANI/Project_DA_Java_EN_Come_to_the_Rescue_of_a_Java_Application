package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class AnalyticsCounter {
	private static int headacheCount = 0; // initialize to 0
	private static int rashCount = 0; // initialize to 0
	private static int pupilCount = 0; // initialize to 0

	public static void main(String args[]) throws Exception {
		Map<String, Integer> symptomsList = new HashMap<String, Integer>();

		try (// first get input
				BufferedReader reader = new BufferedReader(new FileReader("Project02Eclipse/symptoms.txt"))) {
			String line = reader.readLine();

			// SOUE 77 int i = 0; // set i to 0
			int headCount = 0; // counts headaches
			while (line != null) {
				// SOUE77 i++; // increment i
				System.out.println("symptom from file: " + line);
				if (symptomsList.get(line) != null)
					symptomsList.put(line, symptomsList.get(line) + 1);
				else
					symptomsList.put(line, 1);
				if (line.equals("headache")) {
					headCount++;
					System.out.println("number of headaches: " + headCount);
				} else if (line.equals("rush")) {
					rashCount++;
				} else if (line.contains("pupils")) {
					pupilCount++;
				}

				line = reader.readLine(); // get another symptom
			}
		}
		// next generate output
		FileWriter writer = new FileWriter("result.out");
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
		writer.close();
		for (Entry<String, Integer> entry : symptomsList.entrySet()) {
			String k = entry.getKey();
			Integer v = entry.getValue();
			System.out.println("Symptom: " + k + ", Value: " + v);
		}
	}
}
