package com.ioprogramming.day02jasondatahandling.practiceproblems.validatejsonstructureusingjackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class ValidateJSONUsingJackson {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            Student student = objectMapper.readValue(new File("D:\\Capgemini\\Week05-IO-Programming\\src\\main\\java\\com\\ioprogramming\\day02jasondatahandling\\practiceproblems\\validatejsonstructureusingjackson\\DAta.json"), Student.class);

            System.out.println("Valid Aakrati : " + student);
        } catch (IOException e) {
            System.out.println("Invalid JSON structure : " + e.getMessage());
        }
    }
}


