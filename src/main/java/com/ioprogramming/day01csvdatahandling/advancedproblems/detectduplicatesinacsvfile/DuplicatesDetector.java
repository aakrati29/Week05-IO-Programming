package com.ioprogramming.day01csvdatahandling.advancedproblems.detectduplicatesinacsvfile;

import java.io.*;
import java.util.*;

public class DuplicatesDetector {

    public static void detectDuplicates(String filePath) {
        Map<String, List<String>> recordMap = new HashMap<>();
        List<String> duplicateRecords = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("D:\\Capgemini\\Week05-IO-Programming\\src\\main\\java\\com\\ioprogramming\\day01csvdatahandling\\advancedproblems\\detectduplicatesinacsvfile\\Input.csv"))) {
            String line;
            boolean isFirstRow = true;

            while ((line = br.readLine()) != null) {
                if (isFirstRow) {
                    isFirstRow = false;
                    continue;
                }

                String[] columns = line.split(",");
                String id = columns[0].trim();

                if (recordMap.containsKey(id)) {
                    duplicateRecords.add(line);
                } else {
                    recordMap.put(id, new ArrayList<>(List.of(line)));
                }
            }

            if (duplicateRecords.isEmpty()) {
                System.out.println("No duplicate records found.");
            } else {
                System.out.println("Duplicate Records Found:");
                duplicateRecords.forEach(System.out::println);
            }

        } catch (IOException e) {
            System.out.println("Error reading CSV file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String filePath = "sample.csv";
        detectDuplicates(filePath);
    }
}

