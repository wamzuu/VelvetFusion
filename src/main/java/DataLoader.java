
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class DataLoader {
    public static Map<String, Persona> loadPersonaData(String filepath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(filepath), new TypeReference<>() {});
    }

    public static Map<String, Map<String, String>> loadFusionChart(String filepath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(filepath), new TypeReference<>() {});
    }
}
