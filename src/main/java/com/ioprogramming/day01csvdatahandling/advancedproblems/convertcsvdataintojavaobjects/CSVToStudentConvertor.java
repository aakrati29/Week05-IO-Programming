package com.ioprogramming.day01csvdatahandling.advancedproblems.convertcsvdataintojavaobjects;

import java.io.*;
import java.util.*;
public class CSVToStudentConvertor {

    public static List<Student> convertCSVToStudents(String filePath) {
        List<Student> students = new ArrayList<>();

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
                    System.out.println("Skipping invalid row: " + line);
                    continue;
                }

                int id = Integer.parseInt(data[0].trim());
                String name = data[1].trim();
                String email = data[2].trim();
                String phoneNumber = data[3].trim();

                Student student = new Student(id, name, email, phoneNumber);

                students.add(student);
            }

        } catch (IOException e) {
            System.out.println("Error reading the CSV file: " + e.getMessage());
        }

        return students;
    }

    public static void main(String[] args) {
        String filePath = "D:\\Capgemini\\Week05-IO-Programming\\src\\main\\java\\com\\ioprogramming\\day01csvdatahandling\\advancedproblems\\convertcsvdataintojavaobjects\\Student.csv";

        List<Student> students = convertCSVToStudents(filePath);

        for (Student student : students) {
            System.out.println(student);
        }
    }
}

