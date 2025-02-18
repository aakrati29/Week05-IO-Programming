package com.ioprogramming.day01csvdatahandling.advancedproblems.validatecsvdatabeforeprocessing;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class ValidateDataTest {

    @Test
    public void testValidateCSVDataValidRows() throws IOException {
        String csvData = "ID,Name,Email,PhoneNumber\n" +
                "101,Ram,ram.doe@example.com,9876543210\n" +
                "104,Aakrati,aakrati@example.com,9876543210\n";
        Path tempFile = Files.createTempFile("testFile", ".csv");
        Files.write(tempFile, csvData.getBytes());

        ValidateData.validateCSVData(tempFile.toString());

        Files.delete(tempFile);
    }


    @Test
    public void testValidateCSVDataInvalidPhoneNumber() throws IOException {
        String csvData = "ID,Name,Email,PhoneNumber\n" +
                "102,Ankit,ankit@example.com,12345\n" +
                "103,Deepti,deepti@domain.com,98765432101\n";
        Path tempFile = Files.createTempFile("testFile", ".csv");
        Files.write(tempFile, csvData.getBytes());

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        ValidateData.validateCSVData(tempFile.toString());

        String output = outputStream.toString();
        assertTrue(output.contains("Invalid Phone Number : 12345 in row : 102,Ankit,ankit@example.com,12345"));
        assertTrue(output.contains("Invalid Phone Number : 98765432101 in row : 103,Deepti,deepti@domain.com,98765432101"));

        Files.delete(tempFile);
    }
}
