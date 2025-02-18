package com.ioprogramming.day01csvdatahandling.basicproblems.writedatatoacsvfile;

import java.io.FileWriter;
import java.io.IOException;

public class EmployeeDetails {
    public static void writeCSVFile() {
        String filePath = "src/main/java/com/ioprogramming/day01csvdatahandling/basicproblems/writedatatoacsvfile/EmployeesData.csv";

        String[] employees = {
                "101,Ram,IT,70000",
                "102,Aakrati,HR,65000",
                "103,Anand ,Finance,75000",
                "104,,Avinash, Marketing,68000",
                "105,Ankit,Sales,72000"
        };

        try (FileWriter writer = new FileWriter(filePath)) {
            writer.append("ID,Name,Department,Salary\n");

            for (String employee : employees) {
                writer.append(employee).append("\n");
            }

            System.out.println("CSV file created successfully at: " + filePath);
        } catch (IOException e) {
            System.out.println("Error writing CSV file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        writeCSVFile();
    }
}
