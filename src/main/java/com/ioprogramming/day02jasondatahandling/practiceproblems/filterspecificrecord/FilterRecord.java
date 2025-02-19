package com.ioprogramming.day02jasondatahandling.practiceproblems.filterspecificrecord;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FilterRecord {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            JsonNode rootNode = objectMapper.readTree(new File("D:\\Capgemini\\Week05-IO-Programming\\src\\main\\java\\com\\ioprogramming\\day02jasondatahandling\\practiceproblems\\filterspecificrecord\\Data.json"));

            List<JsonNode> filteredRecords = new ArrayList<>();

            for (JsonNode node : rootNode) {
                if (node.has("age") && node.get("age").asInt() > 25) {
                    filteredRecords.add(node);
                }
            }

            String filteredJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(filteredRecords);
            System.out.println(filteredJson);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

