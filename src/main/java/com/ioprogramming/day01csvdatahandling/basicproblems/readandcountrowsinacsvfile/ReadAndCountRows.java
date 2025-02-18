package com.ioprogramming.day01csvdatahandling.basicproblems.readandcountrowsinacsvfile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadAndCountRows {
    public static int countCSVRows(String filePath) {
        int rowCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isFirstRow = true;

            while ((line = br.readLine()) != null) {
                if (isFirstRow) {
                    isFirstRow = false;
                    continue;
                }
                rowCount++;
            }

        } catch (IOException e) {
            System.out.println("Error reading the CSV file: " + e.getMessage());
        }

        return rowCount;
    }

    public static void main(String[] args) {
        String filePath = "D:\\Capgemini\\Week05-IO-Programming\\src\\main\\java\\com\\ioprogramming\\day01csvdatahandling\\basicproblems\\readandcountrowsinacsvfile\\Data.csv";

        int totalRecords = countCSVRows(filePath);
        System.out.println("Total number of records (excluding header): " + totalRecords);
    }
}

