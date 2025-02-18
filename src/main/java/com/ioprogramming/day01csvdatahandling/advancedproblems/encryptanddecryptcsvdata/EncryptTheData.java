package com.ioprogramming.day01csvdatahandling.advancedproblems.encryptanddecryptcsvdata;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class EncryptTheData {

    private static final String SECRET_KEY = "1234567890123456";

    public static void writeToCSV(String filePath, List<Employee> employees) {
        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath))) {
            writer.writeNext(new String[]{"ID", "Name", "Email", "Salary"}); // Write headers

            for (Employee emp : employees) {
                String encryptedEmail = EncryptDecryptMethods.encrypt(emp.email, SECRET_KEY);
                String encryptedSalary = EncryptDecryptMethods.encrypt(emp.salary, SECRET_KEY);
                String[] row = {emp.id, emp.name, encryptedEmail, encryptedSalary};
                writer.writeNext(row);
            }

            System.out.println("Data written to CSV with encrypted fields.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void readFromCSV(String filePath) {
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] nextLine;
            reader.readNext();

            while ((nextLine = reader.readNext()) != null) {
                String decryptedEmail = EncryptDecryptMethods.decrypt(nextLine[2], SECRET_KEY);
                String decryptedSalary = EncryptDecryptMethods.decrypt(nextLine[3], SECRET_KEY);

                Employee emp = new Employee(nextLine[0], nextLine[1], decryptedEmail, decryptedSalary);
                System.out.println(emp);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("01", "Aakrati", "aakrati@example.com", "5000"));
        employees.add(new Employee("02", "Ankit", "ankit@example.com", "6000"));
        employees.add(new Employee("03", "Anand", "anand@example.com", "7000"));

        String filePath = "D:\\Capgemini\\Week05-IO-Programming\\src\\main\\java\\com\\ioprogramming\\day01csvdatahandling\\advancedproblems\\encryptanddecryptcsvdata\\Input.csv";

        writeToCSV(filePath, employees);

        System.out.println("\nReading decrypted data :");
        readFromCSV(filePath);
    }
}
