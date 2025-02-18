package com.ioprogramming.day01csvdatahandling.advancedproblems.generateacsvreportfromdatabase;

import java.io.*;
import java.util.*;


class ReportGenerator {
    public static void writeToCSV(String filePath) {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Ankit", "IT", 60000),
                new Employee(2, "Aniket", "HR", 50000),
                new Employee(3, "Ram", "Finance", 70000),
                new Employee(4, "Aakrati", "IT", 65000),
                new Employee(5, "Aditi", "Marketing", 55000)
        );

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("Employee ID,Name,Department,Salary"); // Writing header
            writer.newLine();

            for (Employee emp : employees) {
                writer.write(emp.toCSVString());
                writer.newLine();
            }

            System.out.println("CSV file created successfully: " + filePath);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String filePath = "D:\\Capgemini\\Week05-IO-Programming\\src\\main\\java\\com\\ioprogramming\\day01csvdatahandling\\advancedproblems\\generateacsvreportfromdatabase\\EmployeeData\\Employee.csv";
        writeToCSV(filePath);
    }
}

