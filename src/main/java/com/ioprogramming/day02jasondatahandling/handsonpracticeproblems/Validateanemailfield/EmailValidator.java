package com.ioprogramming.day02jasondatahandling.handsonpracticeproblems.Validateanemailfield;

import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class EmailValidator {
    public static void main(String[] args) {
        String jsonFilePath = "D:/Capgemini/Week05-IO-Programming/src/main/java/com/ioprogramming/day02jasondatahandling/handsonpracticeproblems/Validateanemailfield/EmailValidator.java"; 
        String schemaFilePath = "D:/Capgemini/Week05-IO-Programming/src/main/java/com/ioprogramming/day02jasondatahandling/handsonpracticeproblems/Validateanemailfield/email-schema.json";

        try (InputStream schemaStream = new FileInputStream(new File(schemaFilePath));
             InputStream jsonStream = new FileInputStream(new File(jsonFilePath))) {

            // Load JSON Schema
            JSONObject jsonSchema = new JSONObject(new JSONTokener(schemaStream));
            Schema schema = SchemaLoader.load(jsonSchema);

            // Load JSON Data
            JSONObject jsonData = new JSONObject(new JSONTokener(jsonStream));

            // Validate JSON
            schema.validate(jsonData);
            System.out.println("JSON is valid!");

        } catch (Exception e) {
            System.out.println("JSON Validation Failed: " + e.getMessage());
        }
    }
}

