package com.ioprogramming.day01csvdatahandling.basicproblems.readandcountrowsinacsvfile;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReadAndCountRowsTest {
    private final String testFilePath = "src/main/java/com/ioprogramming/day01csvdatahandling/basicproblems/readandcountrowsinacsvfile/TestData.csv";

    @BeforeEach
    void setUp() {
        try (FileWriter writer = new FileWriter(testFilePath)) {
            writer.write("ID,Name,Department,Salary\n"); // Header
            writer.write("101,Ram,IT,70000\n");
            writer.write("102,Aakrati,HR,65000\n");
            writer.write("103,Anand,Finance,75000\n");
            writer.write("104,Avinash,Marketing,68000\n");
            writer.write("105,Ankit,Sales,72000\n");
        } catch (IOException e) {
            System.out.println("Error setting up test file: " + e.getMessage());
        }
    }

    @Test
    void testCountCSVRows() {
        int rowCount = ReadAndCountRows.countCSVRows(testFilePath);

        assertEquals(5, rowCount, "The number of records should be 5.");
    }

    @AfterEach
    void tearDown() {
        // Delete the test file after execution
        File file = new File(testFilePath);
        if (file.exists()) {
            file.delete();
        }
    }
}

