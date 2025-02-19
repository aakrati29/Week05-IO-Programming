package com.ioprogramming.day02jasondatahandling.iplandcensoranalyzer;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String jsonInputFile = "D:/Capgemini/Week05-IO-Programming/src/main/java/com/ioprogramming/day02jasondatahandling/iplandcensoranalyzer/ipl.json";
        String jsonOutputFile = "D:/Capgemini/Week05-IO-Programming/src/main/java/com/ioprogramming/day02jasondatahandling/iplandcensoranalyzer/censored_ipl.json";
        String csvInputFile = "D:/Capgemini/Week05-IO-Programming/src/main/java/com/ioprogramming/day02jasondatahandling/iplandcensoranalyzer/ipl.csv";
        String csvOutputFile = "D:/Capgemini/Week05-IO-Programming/src/main/java/com/ioprogramming/day02jasondatahandling/iplandcensoranalyzer/censored_ipl.csv";

        // Process JSON
        List<IPLMatch> matchesJson = IPLForJSON.readJson(jsonInputFile);
        assert matchesJson != null;
        List<IPLMatch> censoredJsonMatches = IPLCensored.applyCensorship(matchesJson);
        IPLForJSON.writeJson(jsonOutputFile, censoredJsonMatches);
        System.out.println("Censored JSON saved to: " + jsonOutputFile);

        // Process CSV
        List<IPLMatch> matchesCsv = IPLForCSV.readCsv(csvInputFile);
        List<IPLMatch> censoredCsvMatches = IPLCensored.applyCensorship(matchesCsv);
        System.out.println("Censored CSV saved to: " + csvOutputFile);
    }
}

