import java.io.IOException;
import java.util.*;

public class FusionCalculator {
    private final PersonaSearch personaSearch;
    private final Map<String, Map<String, String>> fusionChart;
    private final List<String> arcanaOrder;

    public FusionCalculator() throws IOException {
        this.personaSearch = new PersonaSearch();
        this.fusionChart = DataLoader.loadFusionChart("src/main/resources/fusionChart.json");
        this.arcanaOrder = Arrays.asList(
            "Fool", "Magician", "Priestess", "Empress", "Emperor",
            "Hierophant", "Lovers", "Chariot", "Justice", "Hermit",
            "Fortune", "Strength", "Hanged Man", "Death", "Temperance",
            "Devil", "Tower", "Star", "Moon", "Sun", "Judgement", "World"
        );
    }

    public String fuse(String name1, String name2) throws PersonaNotFoundException {
        Persona persona1 = personaSearch.find(name1);
        Persona persona2 = personaSearch.find(name2);

        String arcana1 = persona1.getArcana();
        String arcana2 = persona2.getArcana();

        int level1 = persona1.getLevel();
        int level2 = persona2.getLevel();

        // Determine result arcana
        String resultArcana;
        try {
            if (arcanaOrder.indexOf(arcana1) < arcanaOrder.indexOf(arcana2)) {
                resultArcana = fusionChart.get(arcana1).get(arcana2);
            } else {
                resultArcana = fusionChart.get(arcana2).get(arcana1);
            }
        } catch (Exception e) {
            return "Invalid fusion";
        }

        // Calculate result level
        String bestMatch = getString(level1, level2, resultArcana);

        return bestMatch != null ? bestMatch : "No valid fusion result";
    }

    private String getString(int level1, int level2, String resultArcana) {
        int resultLevel = (level1 + level2) / 2 + 1;

        // Find the best matching persona
        String bestMatch = null;
        int lowestLevel = Integer.MAX_VALUE;

        for (Map.Entry<String, Persona> entry : personaSearch.getAllPersonas().entrySet()) {
            Persona persona = entry.getValue();
            if (persona.getArcana().equals(resultArcana) && persona.getLevel() >= resultLevel) {
                if (persona.getLevel() < lowestLevel) {
                    bestMatch = entry.getKey();
                    lowestLevel = persona.getLevel();
                }
            }
        }
        return bestMatch;
    }
}
