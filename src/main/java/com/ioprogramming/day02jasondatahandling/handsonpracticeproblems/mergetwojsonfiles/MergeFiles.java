package com.ioprogramming.day02jasondatahandling.handsonpracticeproblems.mergetwojsonfiles;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;

public class MergeFiles {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            JsonNode json1 = objectMapper.readTree(new File("D:\\Capgemini\\Week05-IO-Programming\\src\\main\\java\\com\\ioprogramming\\day02jasondatahandling\\handsonpracticeproblems\\mergetwojsonfiles\\File1.json"));
            JsonNode json2 = objectMapper.readTree(new File("D:\\Capgemini\\Week05-IO-Programming\\src\\main\\java\\com\\ioprogramming\\day02jasondatahandling\\handsonpracticeproblems\\mergetwojsonfiles\\File2.json"));

            ObjectNode mergedJson = objectMapper.createObjectNode();
            mergedJson.setAll((ObjectNode) json1);
            mergedJson.setAll((ObjectNode) json2);

            System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(mergedJson));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

