package com.ioprogramming.day01csvdatahandling.intermediateproblems.searchforarecordincsv;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchEmployeeByNameTest {
    private final String testFilePath = "src/main/java/com/ioprogramming/day01csvdatahandling/intermediateproblems/searchforarecordincsv/TestEmployeeData.csv";
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));

        try (FileWriter writer = new FileWriter(testFilePath)) {
            writer.write("ID,Name,Department,Salary\n"); // Header
            writer.write("101,John,IT,75000\n");
            writer.write("102,Alice,HR,68000\n");
            writer.write("103,Michael,Finance,72000\n");
            writer.write("104,Sophia,Marketing,70000\n");
            writer.write("105,David,Sales,73000\n");
        } catch (IOException e) {
            System.out.println("Error setting up test file: " + e.getMessage());
        }
    }

    @Test
    void testSearchEmployeeFound() {
        SearchEmployeeByName.searchEmployeeByName(testFilePath, "Michael");

        String actualOutput = outputStreamCaptor.toString().trim().replace("\r\n", "\n").replace("\r", "\n");

        String expectedOutput = String.join("\n",
                "Employee Found :-",
                "Employee ID : 103",
                "Department : Finance",
                "Salary : 72000"
        );

        String[] expectedLines = expectedOutput.split("\n");
        String[] actualLines = actualOutput.split("\n");

        assertTrue(actualLines.length >= expectedLines.length, "Output contains fewer lines than expected.");

        for (String expectedLine : expectedLines) {
            assertTrue(actualOutput.contains(expectedLine), "Expected line missing: " + expectedLine);
        }
    }


    @Test
    void testSearchEmployeeNotFound() {
        SearchEmployeeByName.searchEmployeeByName(testFilePath, "Robert");

        String expectedOutput = "Employee 'Robert' not found.";

        String actualOutput = outputStreamCaptor.toString().trim().replace("\r", "");

        assertTrue(actualOutput.contains(expectedOutput));
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
