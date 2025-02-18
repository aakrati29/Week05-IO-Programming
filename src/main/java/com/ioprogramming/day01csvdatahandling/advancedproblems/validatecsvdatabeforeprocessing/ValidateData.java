package com.ioprogramming.day01csvdatahandling.advancedproblems.validatecsvdatabeforeprocessing;

import java.io.*;
import java.util.regex.*;

public class ValidateData {

    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@(.+)$";

    private static final String PHONE_REGEX = "^[0-9]{10}$";

    public static void validateCSVData(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isFirstRow = true;

            while ((line = br.readLine()) != null) {
                if (isFirstRow) {
                    isFirstRow = false;
                    continue;
                }

                String[] data = line.split(",");
                if (data.length < 4) {
                    continue;
                }

                String email = data[2].trim();
                String phoneNumber = data[3].trim();

                boolean isValidEmail = isValidEmail(email);
                boolean isValidPhone = isValidPhoneNumber(phoneNumber);

                if (!isValidEmail) {
                    System.out.println("Invalid Email : " + email + " in row : " + line);
                }

                if (!isValidPhone) {
                    System.out.println("Invalid Phone Number : " + phoneNumber + " in row : " + line);
                }

                if (isValidEmail && isValidPhone) {
                    System.out.println("Valid row : " + line);
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading the CSV file : " + e.getMessage());
        }
    }

    private static boolean isValidEmail(String email) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private static boolean isValidPhoneNumber(String phoneNumber) {
        Pattern pattern = Pattern.compile(PHONE_REGEX);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }

    public static void main(String[] args) {
        String filePath = "D:\\Capgemini\\Week05-IO-Programming\\src\\main\\java\\com\\ioprogramming\\day01csvdatahandling\\advancedproblems\\validatecsvdatabeforeprocessing\\validateFile.csv";
        validateCSVData(filePath);
    }
}

