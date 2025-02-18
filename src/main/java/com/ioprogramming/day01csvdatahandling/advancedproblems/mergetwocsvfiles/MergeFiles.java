package com.ioprogramming.day01csvdatahandling.advancedproblems.mergetwocsvfiles;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

class MergeFiles {
    public static void mergeCSVFiles(String file1, String file2, String outputFile) {
        Map<Integer, String[]> studentDetails = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file1))) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0].trim());
                studentDetails.put(id, new String[]{data[1].trim(), data[2].trim(), "", ""});
            }
        } catch (IOException e) {
            System.out.println("Error reading " + file1 + ": " + e.getMessage());
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file2))) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0].trim());
                if (studentDetails.containsKey(id)) {
                    studentDetails.get(id)[2] = data[1].trim();
                    studentDetails.get(id)[3] = data[2].trim();
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading " + file2 + ": " + e.getMessage());
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            bw.write("ID,Name,Age,Marks,Grade\n");
            for (Map.Entry<Integer, String[]> entry : studentDetails.entrySet()) {
                bw.write(entry.getKey() + "," + String.join(",", entry.getValue()) + "\n");
            }
            System.out.println("Files merged successfully!");
        } catch (IOException e) {
            System.out.println("Error writing " + outputFile + ": " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String file1 = "D:\\Capgemini\\Week05-IO-Programming\\src\\main\\java\\com\\ioprogramming\\day01csvdatahandling\\advancedproblems\\mergetwocsvfiles\\Student1.csv";
        String file2 = "D:\\Capgemini\\Week05-IO-Programming\\src\\main\\java\\com\\ioprogramming\\day01csvdatahandling\\advancedproblems\\mergetwocsvfiles\\Student2.csv";
        String outputFile = "D:\\Capgemini\\Week05-IO-Programming\\src\\main\\java\\com\\ioprogramming\\day01csvdatahandling\\advancedproblems\\mergetwocsvfiles\\output.csv";

        mergeCSVFiles(file1, file2, outputFile);
    }
}