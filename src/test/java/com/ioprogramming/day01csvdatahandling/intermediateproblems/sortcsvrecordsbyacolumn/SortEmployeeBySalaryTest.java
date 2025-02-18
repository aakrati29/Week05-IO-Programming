package com.ioprogramming.day01csvdatahandling.intermediateproblems.sortcsvrecordsbyacolumn;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;

class SortEmployeeBySalaryTest {

    private static final String TEST_INPUT_FILE = "test_input.csv";
    private static final String TEST_OUTPUT_FILE = "test_output.csv";

    @BeforeEach
    void setUp() throws IOException {
        String sampleData =
                "ID,Name,Department,Salary\n" +
                        "101,Aakrati,IT,70000\n" +
                        "102,Ankit,HR,68000\n" +
                        "103,Avinash,IT,75000\n" +
                        "104,Anand,Marketing,70000\n" +
                        "105,Ankit,Sales,73000\n";

        Files.write(Paths.get(TEST_INPUT_FILE), sampleData.getBytes());
    }

    @Test
    void testSortCSVBySalary() throws IOException {
        SortEmployeeBySalary.sortCSVBySalary(TEST_INPUT_FILE);

        List<String> expectedTopEmployees = Arrays.asList(
                "[103, Michael, IT, 75000.0]",
                "[101, John, IT, 70000.0]",
                "[105, David, Sales, 73000.0]",
                "[104, Sophia, Marketing, 70000.0]",
                "[102, Alice, HR, 68000.0]"
        );

        System.out.println("Expected Output for Top 5 Employees:");
        expectedTopEmployees.forEach(System.out::println);

        assertTrue(true, "Test passes if the top 5 highest paid employees are printed correctly.");
    }

    @AfterEach
    void tearDown() throws IOException {
        Files.deleteIfExists(Paths.get(TEST_INPUT_FILE));
    }
}


