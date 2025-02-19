package com.ioprogramming.day01csvdatahandling.advancedproblems.convertjsontocsvandviceversa;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class JsonToCsvConvertorTest {

    private Path jsonTempFile;
    private Path csvTempFile;
    private Path outputJsonFile;

    @BeforeEach
    void setUp() throws IOException {
        jsonTempFile = Files.createTempFile("test_students", ".json");
        csvTempFile = Files.createTempFile("test_students", ".csv");
        outputJsonFile = Files.createTempFile("output_students", ".json");

        String jsonContent = "["
                + "{\"ID\": \"1\", \"Name\": \"Alice\", \"Age\": \"22\"},"
                + "{\"ID\": \"2\", \"Name\": \"Bob\", \"Age\": \"23\"},"
                + "{\"ID\": \"3\", \"Name\": \"Charlie\", \"Age\": \"21\"}"
                + "]";

        Files.writeString(jsonTempFile, jsonContent);
    }

    @Test
    void testCsvToJson() throws IOException {
        JsonToCsvConvertor.jsonToCsv(jsonTempFile.toString(), csvTempFile.toString());
        JsonToCsvConvertor.csvToJson(csvTempFile.toString(), outputJsonFile.toString());

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonArray = objectMapper.readTree(outputJsonFile.toFile());

        assertEquals(3, jsonArray.size(), "JSON should contain 3 objects");

        assertEquals("1", jsonArray.get(0).get("ID").asText(), "First JSON object ID should be 1");
        assertEquals("Alice", jsonArray.get(0).get("Name").asText(), "First JSON object Name should be Alice");
        assertEquals("22", jsonArray.get(0).get("Age").asText(), "First JSON object Age should be 22");
    }
}

