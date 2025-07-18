package com.velvetfusion.velvetfusion_api;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public class DataLoader {
    public static Map<String, Persona> loadPersonaData(String filename) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        InputStream inputStream = DataLoader.class.getClassLoader().getResourceAsStream(filename);

        if (inputStream == null) {
            throw new IOException("Resource not found: " + filename);
        }

        return mapper.readValue(inputStream, new TypeReference<Map<String, Persona>>() {});
    }

    public static Map<String, Map<String, String>> loadFusionChart(String filename) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        InputStream inputStream = DataLoader.class.getClassLoader().getResourceAsStream(filename);

        if (inputStream == null) {
            throw new IOException("Resource not found: " + filename);
        }

        return mapper.readValue(inputStream, new TypeReference<Map<String, Map<String, String>>>() {});
    }
}
