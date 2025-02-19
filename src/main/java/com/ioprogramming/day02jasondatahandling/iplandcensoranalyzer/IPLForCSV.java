package com.ioprogramming.day02jasondatahandling.iplandcensoranalyzer;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.io.*;
import java.util.*;

public class IPLForCSV {

    public static List<IPLMatch> readCsv(String filePath) {
        List<IPLMatch> matches = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            List<String[]> records = reader.readAll();
            records.remove(0); // Removing header row

            for (String[] row : records) {
                int match_id = Integer.parseInt(row[0].trim()); // Trim spaces
                String team1 = row[1].trim();
                String team2 = row[2].trim();
                int scoreTeam1 = Integer.parseInt(row[3].trim()); // Trim spaces
                int scoreTeam2 = Integer.parseInt(row[4].trim()); // Trim spaces
                String winner = row[5].trim();
                String playerOfMatch = row[6].trim();

                Map<String, Integer> scoreMap = new HashMap<>();
                scoreMap.put(team1, scoreTeam1);
                scoreMap.put(team2, scoreTeam2);

                matches.add(new IPLMatch(match_id, team1, team2, scoreMap, winner, playerOfMatch));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return matches;
    }
}

