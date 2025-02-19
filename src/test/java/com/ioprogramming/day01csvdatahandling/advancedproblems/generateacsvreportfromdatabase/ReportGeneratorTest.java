package com.ioprogramming.day01csvdatahandling.advancedproblems.generateacsvreportfromdatabase;

import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import static org.junit.jupiter.api.Assertions.*;

class ReportGeneratorTest {

    private Path tempFile;

    @BeforeEach
    void setUp() throws IOException {
        tempFile = Files.createTempFile("EmployeeReport", ".csv");
    }

    @Test
    void testWriteToCSV() throws IOException {
        ReportGenerator.writeToCSV(tempFile.toString());

        String content = Files.readString(tempFile);

        String expectedHeader = "Employee ID,Name,Department,Salary";
        assertTrue(content.contains(expectedHeader), "CSV should contain header");

        assertTrue(content.contains("1,Ankit,IT,60000"), "CSV should contain employee Ankit's data");
        assertTrue(content.contains("2,Aniket,HR,50000"), "CSV should contain employee Aniket's data");
        assertTrue(content.contains("3,Ram,Finance,70000"), "CSV should contain employee Ram's data");
        assertTrue(content.contains("4,Aakrati,IT,65000"), "CSV should contain employee Aakrati's data");
        assertTrue(content.contains("5,Aditi,Marketing,55000"), "CSV should contain employee Aditi's data");

        long rowCount = content.lines().count();
        assertEquals(6, rowCount, "CSV should have exactly 6 lines (header + 5 employees)");
    }
}

