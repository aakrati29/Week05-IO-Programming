package com.ioprogramming.day01csvdatahandling.basicproblems.readcsvfileandprintdata;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReadCSVFileTest {

    @Test
    public void testReadCSVFile() {
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        StudentsDetails.readCSVFile();

        String actualOutput = outputStreamCaptor.toString();

        assertTrue(!actualOutput.isEmpty(), "Output should not be empty. Ensure Data.csv exists and has data.");
    }
}
