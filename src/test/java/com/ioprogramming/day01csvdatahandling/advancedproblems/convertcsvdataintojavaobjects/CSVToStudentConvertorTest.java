package com.ioprogramming.day01csvdatahandling.advancedproblems.convertcsvdataintojavaobjects;

import org.junit.jupiter.api.Test;
import java.io.*;
import java.nio.file.*;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class CSVToStudentConvertorTest {

    @Test
    public void testConvertCSVToStudents_ValidData() throws IOException {
        String csvData = "ID,Name,Email,PhoneNumber\n" +
                "101,Ram,ram.doe@example.com,9876543210\n" +
                "102,Aakrati,aakrati@example.com,9876543210\n";

        Path tempFile = Files.createTempFile("students", ".csv");
        Files.write(tempFile, csvData.getBytes());

        List<Student> students = CSVToStudentConvertor.convertCSVToStudents(tempFile.toString());

        assertNotNull(students);
        assertEquals(2, students.size());
        Student student1 = students.get(0);
        assertEquals(101, student1.getId());
        assertEquals("Ram", student1.getName());
        assertEquals("ram.doe@example.com", student1.getEmail());
        assertEquals("9876543210", student1.getPhoneNumber());

        Student student2 = students.get(1);
        assertEquals(102, student2.getId());
        assertEquals("Aakrati", student2.getName());
        assertEquals("aakrati@example.com", student2.getEmail());
        assertEquals("9876543210", student2.getPhoneNumber());

        Files.delete(tempFile);
    }

    @Test
    public void testConvertCSVToStudents_EmptyFile() throws IOException {
        Path tempFile = Files.createTempFile("empty_students", ".csv");

        List<Student> students = CSVToStudentConvertor.convertCSVToStudents(tempFile.toString());

        assertNotNull(students);
        assertEquals(0, students.size());

        Files.delete(tempFile);
    }

    @Test
    public void testConvertCSVToStudents_FileNotFound() {
        List<Student> students = CSVToStudentConvertor.convertCSVToStudents("non_existent_file.csv");

        assertNotNull(students);
        assertEquals(0, students.size());
    }
}

