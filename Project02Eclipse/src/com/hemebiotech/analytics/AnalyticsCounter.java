package com.hemebiotech.analytics;

import java.util.Map;

public class AnalyticsCounter {
	public static void main(String args[]) throws Exception {
		ReadSymptomDataFromFile readSymptomDataFromFile = new ReadSymptomDataFromFile("Project02Eclipse/symptoms.txt");
		Map<String, Integer> symptomsList = readSymptomDataFromFile.GetSymptoms();
		WriteSymptomDataToFile writeSymptomDataToFile = new WriteSymptomDataToFile("Project02Eclipse/result.out",
				symptomsList);
		writeSymptomDataToFile.SetSymptoms();
	}
}
