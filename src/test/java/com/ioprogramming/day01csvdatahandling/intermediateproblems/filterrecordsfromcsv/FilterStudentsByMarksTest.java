package com.ioprogramming.day01csvdatahandling.intermediateproblems.filterrecordsfromcsv;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FilterStudentsByMarksTest {
    private final String testFilePath = "src/main/java/com/ioprogramming/day01csvdatahandling/intermediateproblems/filterrecordsfromcsv/TestStudentData.csv";
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));

        try (FileWriter writer = new FileWriter(testFilePath)) {
            writer.write("ID,Name,Marks\n"); // Header
            writer.write("101,John,75\n");
            writer.write("102,Alice,85\n");
            writer.write("103,Michael,90\n");
            writer.write("104,Sophia,78\n");
            writer.write("105,David,82\n");
        } catch (IOException e) {
            System.out.println("Error setting up test file: " + e.getMessage());
        }
    }

    @Test
    void testFilterStudents() {
        FilterStudentsByMarks.filterStudents(testFilePath);

        String expectedOutput = "102,Alice,85\n103,Michael,90\n105,David,82";

        String actualOutput = outputStreamCaptor.toString().trim().replace("\r", "");

        assertEquals(expectedOutput, actualOutput);
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);

         File file = new File(testFilePath);
        if (file.exists()) {
            file.delete();
        }
    }
}
