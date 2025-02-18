package com.ioprogramming.day01csvdatahandling.intermediateproblems.filterrecordsfromcsv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FilterStudentsByMarks {
    public static void filterStudents(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isFirstRow = true;

            while ((line = br.readLine()) != null) {
                if (isFirstRow) {
                    isFirstRow = false;
                    continue;
                }

                String[] data = line.split(",");
                if (data.length < 3) {
                    continue;
                }

                try {
                    int marks = Integer.parseInt(data[2].trim()); // Convert marks to integer
                    if (marks > 80) {
                        System.out.println(line);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid marks value: " + data[2]);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the CSV file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String filePath = "D:\\Capgemini\\Week05-IO-Programming\\src\\main\\java\\com\\ioprogramming\\day01csvdatahandling\\intermediateproblems\\filterrecordsfromcsv\\StudentData.csv";

        System.out.println("Students scoring more than 80 marks:");
        filterStudents(filePath);
    }
}

