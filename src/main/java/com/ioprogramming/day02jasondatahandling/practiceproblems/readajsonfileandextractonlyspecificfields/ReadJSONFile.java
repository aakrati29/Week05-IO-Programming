package com.ioprogramming.day02jasondatahandling.practiceproblems.readajsonfileandextractonlyspecificfields;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class ReadJSONFile {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            JsonNode rootNode = objectMapper.readTree(new File("D:\\Capgemini\\Week05-IO-Programming\\src\\main\\java\\com\\ioprogramming\\day02jasondatahandling\\practiceproblems\\readajsonfileandextractonlyspecificfields\\Data.json"));

            String name = rootNode.get("name").asText();
            String email = rootNode.get("email").asText();

            System.out.println("Name: " + name);
            System.out.println("Email: " + email);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
