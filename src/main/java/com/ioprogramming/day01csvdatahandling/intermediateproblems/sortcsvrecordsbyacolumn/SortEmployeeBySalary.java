package com.ioprogramming.day01csvdatahandling.intermediateproblems.sortcsvrecordsbyacolumn;

import java.io.*;
import java.util.*;

public class SortEmployeeBySalary {
    public static void sortCSVBySalary(String filePath) {
        List<String[]> employeeData = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isFirstRow = true;

            while ((line = br.readLine()) != null) {
                if (isFirstRow) {
                    System.out.println("Top 5 highest-paid employees:");
                    isFirstRow = false;
                    continue;
                }
                String[] data = line.split(",");
                if (data.length < 4) continue;

                employeeData.add(data);
            }

            employeeData.sort((a, b) -> Double.compare(Double.parseDouble(b[3].trim()), Double.parseDouble(a[3].trim())));

            for (int i = 0; i < Math.min(5, employeeData.size()); i++) {
                System.out.println(Arrays.toString(employeeData.get(i)));
            }

        } catch (IOException e) {
            System.out.println("Error reading the CSV file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String filePath = "D:\\Capgemini\\Week05-IO-Programming\\src\\main\\java\\com\\ioprogramming\\day01csvdatahandling\\intermediateproblems\\sortcsvrecordsbyacolumn\\EmployeeData.csv";
        sortCSVBySalary(filePath);
    }
}

