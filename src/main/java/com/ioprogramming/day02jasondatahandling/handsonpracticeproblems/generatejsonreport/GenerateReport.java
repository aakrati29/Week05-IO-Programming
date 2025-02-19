package com.ioprogramming.day02jasondatahandling.handsonpracticeproblems.generatejsonreport;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.util.ArrayList;
import java.util.List;

public class GenerateReport {

    public static String generateJsonReport(List<Student> students) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            ObjectWriter writer = objectMapper.writerWithDefaultPrettyPrinter();
            return writer.writeValueAsString(students);
        } catch (Exception e) {
            System.out.println("Error generating JSON report: " + e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Aakrati", 24, "ankit@example.com"));
        students.add(new Student("Ram", 22, "aakrati@example.com"));
        students.add(new Student("Ankit", 26, "anand@example.com"));
        students.add(new Student("Avinash", 23, "avinash@example.com"));
        students.add(new Student("Aniket", 25, "yaman@example.com"));

        String jsonReport = generateJsonReport(students);
        System.out.println("Generated JSON Report:\n" + jsonReport);
    }
}