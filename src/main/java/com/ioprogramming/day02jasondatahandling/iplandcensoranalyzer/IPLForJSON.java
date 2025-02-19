package com.ioprogramming.day02jasondatahandling.iplandcensoranalyzer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.File;
import java.util.List;

public class IPLForJSON {

    public static List<IPLMatch> readJson(String filePath) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(new File(filePath), new TypeReference<List<IPLMatch>>() {});
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void writeJson(String filePath, List<IPLMatch> matches) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(filePath), matches);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

