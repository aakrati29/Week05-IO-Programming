package com.ioprogramming.day02jasondatahandling.handsonpracticeproblems.convertlisttojasonarray1;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

    class CarTest {

        private List<Car> carList;
        private ObjectMapper objectMapper;

        @BeforeEach
        void setUp() {
                    carList = Arrays.asList(
                            new com.ioprogramming.day02jasondatahandling.handsonpracticeproblems.convertlisttojasonarray1.Car("Toyota", "Camry", 2022),
                            new com.ioprogramming.day02jasondatahandling.handsonpracticeproblems.convertlisttojasonarray1.Car("Honda", "Civic", 2023),
                            new com.ioprogramming.day02jasondatahandling.handsonpracticeproblems.convertlisttojasonarray1.Car("Ford", "Mustang", 2021)
            );
            objectMapper = new ObjectMapper();
        }



        @Test
        void testConvertToJson() {
            try {
                String jsonOutput = Car.convertToJson(carList);

                // Parse the JSON output back into a JsonNode
                JsonNode jsonArray = objectMapper.readTree(jsonOutput);

                // Ensure it's an array of size 3
                assertTrue(jsonArray.isArray());
                assertEquals(3, jsonArray.size());

                // Validate the first car object
                assertEquals("Toyota", jsonArray.get(0).get("brand").asText());
                assertEquals("Camry", jsonArray.get(0).get("model").asText());
                assertEquals(2022, jsonArray.get(0).get("year").asInt());

                // Validate the second car object
                assertEquals("Honda", jsonArray.get(1).get("brand").asText());
                assertEquals("Civic", jsonArray.get(1).get("model").asText());
                assertEquals(2023, jsonArray.get(1).get("year").asInt());

                // Validate the third car object
                assertEquals("Ford", jsonArray.get(2).get("brand").asText());
                assertEquals("Mustang", jsonArray.get(2).get("model").asText());
                assertEquals(2021, jsonArray.get(2).get("year").asInt());
            } catch (JsonProcessingException e) {
                fail("Exception thrown: " + e.getMessage());
            }
        }

        @Test
        void testEmptyListToJson() {
            try {
                String jsonOutput = Car.convertToJson(List.of());

                // Ensure JSON output is an empty array
                assertEquals("[]", jsonOutput.trim());
            } catch (JsonProcessingException e) {
                fail("Exception thrown: " + e.getMessage());
            }
        }
    }
