package com.velvetfusion.velvetfusion_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(path = "api/v1/persona")
public class PersonaController {
    private final PersonaSearchService personaSearch;
    private final FusionCalculatorService fusionCalculator;

    @Autowired
    public PersonaController(PersonaSearchService personaSearch, FusionCalculatorService fusionCalculator) {
        this.personaSearch = personaSearch;
        this.fusionCalculator = fusionCalculator;
    }

    @GetMapping
    public Map<String, Persona> getAllPersonas() {
        return personaSearch.getAllPersonas();
    }

    @GetMapping("/{name}")
    public Persona getPersona(@PathVariable String name) throws PersonaNotFoundException {
        return personaSearch.find(name);
    }

    @PostMapping("/fuse")
    public String fuse( @RequestParam String name1, @RequestParam String name2) throws PersonaNotFoundException {
        return fusionCalculator.fuse(name1, name2);
    }
}
