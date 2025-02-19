package com.ioprogramming.day01csvdatahandling.advancedproblems.detectduplicatesinacsvfile;

import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import static org.junit.jupiter.api.Assertions.*;

class DuplicatesDetectorTest {

    private Path tempFile;

    @BeforeEach
    void setUp() throws IOException {
        tempFile = Files.createTempFile("Input", ".csv");

        try (BufferedWriter writer = Files.newBufferedWriter(tempFile)) {
            writer.write("ID,Name,Age,Marks,Grade");
            writer.newLine();
            writer.write("1,John,22,85,A");
            writer.newLine();
            writer.write("2,Alice,23,78,B");
            writer.newLine();
            writer.write("3,Bob,24,90,A");
            writer.newLine();
            writer.write("2,Alice,23,78,B");
            writer.newLine();
            writer.write("4,David,25,88,B");
            writer.newLine();
            writer.write("1,John,22,85,A");
            writer.newLine();
        }
    }

    @Test
    void testDetectDuplicates() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        DuplicatesDetector.detectDuplicates(tempFile.toString());

        String output = outContent.toString();

        assertTrue(output.contains("Duplicate Records Found"), "Should detect duplicates.");
        assertFalse(output.contains("2,Alice,23,78,B"), "Should detect duplicate for ID 2.");
        assertFalse(output.contains("1,John,22,85,A"), "Should detect duplicate for ID 1.");

        System.setOut(System.out);
    }
}
