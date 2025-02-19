package com.ioprogramming.day02jasondatahandling.handsonpracticeproblems.convertcsvtojson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CsvToJsonConvertor {
    public static void main(String[] args) {
        String csvFilePath = "D:/Capgemini/Week05-IO-Programming/src/main/java/com/ioprogramming/day02jasondatahandling/handsonpracticeproblems/convertcsvtojson/Data.csv";  // CSV file path
        String jsonFilePath = "D:/Capgemini/Week05-IO-Programming/src/main/java/com/ioprogramming/day02jasondatahandling/handsonpracticeproblems/convertcsvtojson/data.json";

        try (CSVReader csvReader = new CSVReader(new FileReader(csvFilePath))) {
            ObjectMapper objectMapper = new ObjectMapper();
            ArrayNode jsonArray = objectMapper.createArrayNode();

            // Read CSV header
            String[] headers = csvReader.readNext();
            if (headers == null) {
                System.out.println("Empty CSV file.");
                return;
            }

            // Read CSV rows and convert to JSON
            String[] row;
            while ((row = csvReader.readNext()) != null) {
                ObjectNode jsonObject = objectMapper.createObjectNode();
                for (int i = 0; i < headers.length; i++) {
                    jsonObject.put(headers[i], row[i]);
                }
                jsonArray.add(jsonObject);
            }

            // Write JSON to a file
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(jsonFilePath), jsonArray);

            System.out.println("CSV successfully converted to JSON: " + jsonFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }
}

