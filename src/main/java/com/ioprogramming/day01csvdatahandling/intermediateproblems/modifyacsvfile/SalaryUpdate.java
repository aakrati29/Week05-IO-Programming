package com.ioprogramming.day01csvdatahandling.intermediateproblems.modifyacsvfile;

import java.io.*;

public class SalaryUpdate {
    public static void updateSalaryInCSV(String inputFilePath, String outputFilePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFilePath))) {

            String line;
            boolean isFirstRow = true;

            while ((line = br.readLine()) != null) {
                if (isFirstRow) {
                    bw.write(line);
                    bw.newLine();
                    isFirstRow = false;
                    continue;
                }

                String[] data = line.split(",");
                if (data.length < 4) continue;

                String department = data[2].trim();
                String salaryStr = data[3].trim();

                try {
                    double salary = Double.parseDouble(salaryStr);
                    if ("IT".equalsIgnoreCase(department)) {
                        salary *= 1.10;
                    }
                    data[3] = String.format("%.2f", salary);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid salary value: " + salaryStr);
                    continue;
                }

                bw.write(String.join(",", data));
                bw.newLine();
            }

            System.out.println("Updated CSV file saved at: " + outputFilePath);

        } catch (IOException e) {
            System.out.println("Error processing the CSV file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String inputFilePath = "D:\\Capgemini\\Week05-IO-Programming\\src\\main\\java\\com\\ioprogramming\\day01csvdatahandling\\intermediateproblems\\modifyacsvfile\\EmployeeData.csv";
        String outputFilePath = "UpdatedData.csv";

        updateSalaryInCSV(inputFilePath, outputFilePath);
    }
}

