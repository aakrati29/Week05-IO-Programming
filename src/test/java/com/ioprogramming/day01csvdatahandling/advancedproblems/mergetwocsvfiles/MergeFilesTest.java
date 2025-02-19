package com.ioprogramming.day01csvdatahandling.advancedproblems.mergetwocsvfiles;

import org.junit.jupiter.api.Test;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class MergeFilesTest {

    @Test
    void testMergeCSVFiles() {
        // Define test files
        String file1 = "D:\\Capgemini\\Week05-IO-Programming\\src\\main\\java\\com\\ioprogramming\\day01csvdatahandling\\advancedproblems\\mergetwocsvfiles\\Student1.csv";
        String file2 = "D:\\Capgemini\\Week05-IO-Programming\\src\\main\\java\\com\\ioprogramming\\day01csvdatahandling\\advancedproblems\\mergetwocsvfiles\\Student2.csv";
        String outputFile = "D:\\Capgemini\\Week05-IO-Programming\\src\\main\\java\\com\\ioprogramming\\day01csvdatahandling\\advancedproblems\\mergetwocsvfiles\\output.csv";

        String expectedOutput = String.join(System.lineSeparator(),
                "ID,Name,Age,Marks,Grade",
                "101,Ram,20,85,A",
                "102,Aakrati,22,,",
                "103,Deepti,21,75,B"
        ) + System.lineSeparator();

        MergeFiles.mergeCSVFiles(file1, file2, outputFile);

        // Read the actual output
        StringBuilder actualOutput = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(outputFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                actualOutput.append(line).append(System.lineSeparator()); // Use platform-independent line breaks
            }
        } catch (IOException e) {
            fail("IOException occurred: " + e.getMessage());
        }

        assertEquals(expectedOutput, actualOutput.toString(), "Output CSV does not match expected.");
    }
}
