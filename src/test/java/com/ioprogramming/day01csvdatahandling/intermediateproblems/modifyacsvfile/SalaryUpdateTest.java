package com.ioprogramming.day01csvdatahandling.intermediateproblems.modifyacsvfile;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.file.*;

class SalaryUpdateTest {

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
    void testUpdateSalaryInCSV() throws IOException {
        SalaryUpdate.updateSalaryInCSV(TEST_INPUT_FILE, TEST_OUTPUT_FILE);

        BufferedReader reader = new BufferedReader(new FileReader(TEST_OUTPUT_FILE));
        reader.readLine();

        String line;
        boolean itSalaryUpdated = false;

        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");
            String department = data[2].trim();
            double salary = Double.parseDouble(data[3].trim());

            if ("IT".equalsIgnoreCase(department)) {
                itSalaryUpdated = true;
                if (data[0].equals("101")) {
                    assertEquals(77000.00, salary, 0.01); // 70000 * 1.10
                }
                if (data[0].equals("103")) {
                    assertEquals(82500.00, salary, 0.01); // 75000 * 1.10
                }
            }
        }

        reader.close();

        assertTrue(itSalaryUpdated, "IT department salary should be updated.");
    }

    @AfterEach
    void tearDown() throws IOException {
        Files.deleteIfExists(Paths.get(TEST_INPUT_FILE));
        Files.deleteIfExists(Paths.get(TEST_OUTPUT_FILE));
    }
}

