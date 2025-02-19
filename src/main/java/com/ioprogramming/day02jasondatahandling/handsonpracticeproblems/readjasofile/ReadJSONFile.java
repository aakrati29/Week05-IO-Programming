package com.ioprogramming.day02jasondatahandling.handsonpracticeproblems.readjasofile;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public class ReadJSONFile {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            JsonNode rootNode = objectMapper.readTree(new File("D:\\Capgemini\\Week05-IO-Programming\\src\\main\\java\\com\\ioprogramming\\day02jasondatahandling\\handsonpracticeproblems\\readjasofile\\Data.json"));

            printJsonKeysAndValues(rootNode, "");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printJsonKeysAndValues(JsonNode node, String parentKey) {
        if (node.isObject()) {
            Iterator<Map.Entry<String, JsonNode>> fields = node.fields();
            while (fields.hasNext()) {
                Map.Entry<String, JsonNode> entry = fields.next();
                printJsonKeysAndValues(entry.getValue(), parentKey + entry.getKey() + ".");
            }
        } else if (node.isArray()) {
            for (int i = 0; i < node.size(); i++) {
                printJsonKeysAndValues(node.get(i), parentKey + "[" + i + "].");
            }
        } else {
            System.out.println(parentKey.substring(0, parentKey.length() - 1) + " -> " + node.asText());
        }
    }
}
