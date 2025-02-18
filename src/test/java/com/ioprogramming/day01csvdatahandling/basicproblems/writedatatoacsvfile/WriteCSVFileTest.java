package com.ioprogramming.day01csvdatahandling.basicproblems.writedatatoacsvfile;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class WriteCSVFileTest {
    private final String filePath = "src/main/java/com/ioprogramming/day01csvdatahandling/basicproblems/writedatatoacsvfile/EmployeesData.csv";

    @BeforeEach
    void setUp() {
        File file = new File(filePath);
        if (file.exists()) {
            file.delete();
        }
    }

    @Test
    void testWriteCSVFile() {
        EmployeeDetails.writeCSVFile();

        File file = new File(filePath);
        assertTrue(file.exists(), "CSV file should be created.");

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String header = reader.readLine();
            assertEquals("ID,Name,Department,Salary", header, "Header should match expected format.");

            String firstRecord = reader.readLine();
            assertEquals("101,Ram,IT,70000", firstRecord, "First record should match expected data.");

        } catch (IOException e) {
            fail("Failed to read the CSV file: " + e.getMessage());
        }
    }

    @AfterEach
    void tearDown() {
        // Clean up: Delete the test file after execution
        File file = new File(filePath);
        if (file.exists()) {
            file.delete();
        }
    }
}

