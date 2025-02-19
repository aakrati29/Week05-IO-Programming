package com.ioprogramming.day01csvdatahandling.advancedproblems.encryptanddecryptcsvdata;

import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class EncryptDecryptTest {

    private static final String SECRET_KEY = "1234567890123456";
    private Path csvTempFile;
    private List<Employee> employees;

    @BeforeEach
    void setUp() throws Exception {
        csvTempFile = Files.createTempFile("test_employees", ".csv");

        employees = Arrays.asList(
                new Employee("01", "Aakrati", "aakrati@example.com", "5000"),
                new Employee("02", "Ankit", "ankit@example.com", "6000"),
                new Employee("03", "Anand", "anand@example.com", "7000")
        );
    }

    @Test
    void testEncryptionAndDecryption() throws Exception {
        String originalData = "test@example.com";
        String encryptedData = EncryptDecryptMethods.encrypt(originalData, SECRET_KEY);
        String decryptedData = EncryptDecryptMethods.decrypt(encryptedData, SECRET_KEY);

        assertNotNull(encryptedData, "Encrypted data should not be null");
        assertNotEquals(originalData, encryptedData, "Encrypted data should be different from original");
        assertEquals(originalData, decryptedData, "Decrypted data should match original");
    }

    @Test
    void testWriteToCSV() throws IOException {
        EncryptTheData.writeToCSV(csvTempFile.toString(), employees);

        List<String> csvLines = Files.readAllLines(csvTempFile);

        assertEquals(4, csvLines.size(), "CSV should contain header + 3 data rows");
        assertFalse(csvLines.get(0).contains("ID,Name,Email,Salary"), "CSV header should be correct");
    }

    @Test
    void testReadFromCSV() throws Exception {
        EncryptTheData.writeToCSV(csvTempFile.toString(), employees);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        EncryptTheData.readFromCSV(csvTempFile.toString());

        String output = outputStream.toString();
        assertTrue(output.contains("Employee{id='01', name='Aakrati', email='aakrati@example.com', salary='5000'}"), "Decrypted data should match original");
        assertTrue(output.contains("Employee{id='02', name='Ankit', email='ankit@example.com', salary='6000'}"), "Decrypted data should match original");
        assertTrue(output.contains("Employee{id='03', name='Anand', email='anand@example.com', salary='7000'}"), "Decrypted data should match original");
    }
}

