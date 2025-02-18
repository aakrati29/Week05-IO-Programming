package com.ioprogramming.day01csvdatahandling.advancedproblems.readlargecsvfileefficiently;

import java.io.*;

public class LargeFileReader {

    private static final int CHUNK_SIZE = 100;

    public static void readLargeCSVInChunks(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader("D:\\Capgemini\\Week05-IO-Programming\\src\\main\\java\\com\\ioprogramming\\day01csvdatahandling\\advancedproblems\\readlargecsvfileefficiently\\LargeFile.csv"))) {
            String line;
            boolean isFirstRow = true;
            int recordCount = 0;
            int batchCount = 0;

            while ((line = br.readLine()) != null) {
                if (isFirstRow) {
                    isFirstRow = false;
                    continue;
                }

                recordCount++;

                if (recordCount % CHUNK_SIZE == 0) {
                    batchCount++;
                    System.out.println("Processed " + recordCount + " records so far...");
                }
            }

            if (recordCount % CHUNK_SIZE != 0) {
                batchCount++;
                System.out.println("Processed " + recordCount + " records in total.");
            }

        } catch (IOException e) {
            System.out.println("Error reading CSV file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String filePath = "large_file.csv";
        readLargeCSVInChunks(filePath);
    }
}

