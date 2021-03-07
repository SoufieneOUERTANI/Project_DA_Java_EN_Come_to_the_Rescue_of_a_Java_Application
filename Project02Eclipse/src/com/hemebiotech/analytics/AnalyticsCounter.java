package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.util.Map;
import java.util.Map.Entry;

public class AnalyticsCounter {
	public static void main(String args[]) throws Exception {
		ReadSymptomDataFromFile readSymptomDataFromFile = new ReadSymptomDataFromFile("Project02Eclipse/symptoms.txt");
		Map<String, Integer> symptomsList = readSymptomDataFromFile.GetSymptoms();
		try (FileWriter writer = new FileWriter("Project02Eclipse/result.out")) {
			if (!symptomsList.isEmpty()) {
				for (Entry<String, Integer> entry : symptomsList.entrySet()) {
					writer.write(entry.getKey() + ": " + entry.getValue() + "\n");
				}
			}
		}
	}
}
