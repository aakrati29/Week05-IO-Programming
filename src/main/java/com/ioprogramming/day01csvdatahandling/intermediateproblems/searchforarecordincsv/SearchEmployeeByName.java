package com.ioprogramming.day01csvdatahandling.intermediateproblems.searchforarecordincsv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SearchEmployeeByName {
    public static void searchEmployeeByName(String filePath, String employeeName) {
        boolean found = false;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isFirstRow = true;

            while ((line = br.readLine()) != null) {
                if (isFirstRow) {
                    isFirstRow = false;
                    continue;
                }

                String[] data = line.split(",");
                if (data.length < 4) {
                    continue;
                }

                String name = data[1].trim();

                if (name.equalsIgnoreCase(employeeName)) {
                    System.out.println("Employee Found :- ");
                    System.out.println("Employee ID : " + data[0].trim());
                    System.out.println("Department : " + data[2].trim());
                    System.out.println("Salary : " + data[3].trim());
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Employee '" + employeeName + "' not found.");
            }
        } catch (IOException e) {
            System.out.println("Error reading the CSV file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String filePath = "D:\\Capgemini\\Week05-IO-Programming\\src\\main\\java\\com\\ioprogramming\\day01csvdatahandling\\intermediateproblems\\searchforarecordincsv\\EmployeeData.csv";

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter employee name to search: ");
        String employeeName = scanner.nextLine();

        searchEmployeeByName(filePath, employeeName);
    }
}

