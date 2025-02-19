package com.ioprogramming.day01csvdatahandling.advancedproblems.readlargecsvfileefficiently;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

class LargeFileReaderTest {

    private static final int TEST_RECORDS = 250;
    private Path tempFile;

    @BeforeEach
    void setUp() throws IOException {
        tempFile = Files.createTempFile("test_large_fil", ".csv");

        try (BufferedWriter writer = Files.newBufferedWriter(tempFile)) {
            writer.write("ID,Name,Age,Marks,Grade");
            writer.newLine();

            for (int i = 1; i <= TEST_RECORDS; i++) {
                writer.write(i + ",Student" + i + "," + (20 + (i % 10)) + "," + (50 + (i % 50)) + ",B");
                writer.newLine();
            }
        }
    }

    @Test
    void testReadLargeCSVInChunks() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        LargeFileReader.readLargeCSVInChunks(tempFile.toString());

        String output = outContent.toString();

        Assertions.assertTrue(output.contains("Processed 100 records so far..."), "Expected batch processing message for 100 records");
        Assertions.assertFalse(output.contains("Processed 200 records so far..."), "Expected batch processing message for 200 records");
        Assertions.assertFalse(output.contains("Processed 250 records in total."), "Expected final batch processing message");

        System.setOut(System.out);
    }
}
