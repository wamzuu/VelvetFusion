# VelvetFusion (CLI)

A Java-based command-line application for calculating Persona fusions, inspired by the Persona video game series. This tool allows users to search for personas and calculate fusion results between different personas.

## Table of Contents

- [Features](#features)
- [Project Structure](#project-structure)
- [Data Files](#data-files)
    - [personaData.json](#personadatajson)
    - [fusionChart.json](#fusionchartjson)
- [Getting Started](#getting-started)
    - [Prerequisites](#prerequisites)
    - [Dependencies](#dependencies)
    - [Running the Application](#running-the-application)
- [Usage](#usage)
    - [Menu Options](#menu-options)
    - [Example Usage](#example-usage)
- [How Fusion Works](#how-fusion-works)
- [Features in Detail](#features-in-detail)
    - [Fuzzy Search](#fuzzy-search)
    - [Error Handling](#error-handling)
- [Current Limitations](#current-limitations)
- [Roadmap](#roadmap)
- [Architecture Notes](#architecture-notes)
- [Contributing](#contributing)

## Features

- **Persona Search**: Fuzzy search functionality with case-insensitive matching and special character normalization
- **Fusion Calculator**: Calculate the result of fusing two personas based on arcana rules and level calculations
- **Interactive CLI**: User-friendly command-line interface with menu-driven navigation
- **Data-Driven**: JSON-based data files for easy maintenance and expansion

## Project Structure

```
src/
├── main/
│   ├── java/
│   │   ├── Main.java                     # CLI entry point
│   │   ├── Persona.java                  # Persona data model
│   │   ├── PersonaSearch.java            # Search functionality with fuzzy matching
│   │   ├── FusionCalculator.java         # Core fusion logic
│   │   ├── DataLoader.java               # JSON data loading utilities
│   │   ├── PersonaNotFoundException.java # Custom exception
│   │   └── PersonaViewer.java            # Future display component
│   └── resources/
│       ├── personaData.json              # Persona database
│       └── fusionChart.json              # Arcana fusion rules
```

## Data Files

### personaData.json
Contains persona information with arcana and level:
```json
{
  "Arsene": { "arcana": "Fool", "lvl": 1 },
  "Pixie": { "arcana": "Lovers", "lvl": 2 },
  "Jack Frost": { "arcana": "Magician", "lvl": 11 }
}
```

### fusionChart.json
Defines fusion rules between different arcana:
```json
{
  "Fool": {
    "Magician": "Death",
    "Priestess": "Moon"
  }
}
```

## Getting Started

### Prerequisites
- Java 11 or higher
- Jackson library for JSON processing

### Dependencies
Add to your `pom.xml`:
```xml
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.15.2</version>
</dependency>
```

### Running the Application
1. Clone the repository
2. Ensure JSON data files are in `src/main/resources/`
3. Compile and run:
```bash
javac -cp "path/to/jackson-jars/*" src/main/java/*.java
java -cp ".:path/to/jackson-jars/*" Main
```

## Usage

### Menu Options
1. **Find Persona**: Search for a specific persona by name
2. **Fuse Persona**: Calculate fusion result between two personas

### Example Usage

**Persona Search:**
```
Enter persona (or 'exit' to quit): jack frost
Jack Frost
arcana: Magician
level: 11
```

**Fusion Calculation:**
```
Enter first persona: arsene
Enter second persona: pixie
Fusion result: Mandrake
```

## How Fusion Works

1. **Arcana Lookup**: Determines result arcana based on the fusion chart
2. **Level Calculation**: `(level1 + level2) / 2 + 1`
3. **Persona Selection**: Finds the lowest-level persona of the result arcana that meets the minimum level requirement

## Features in Detail

### Fuzzy Search
The search function normalizes input by:
- Converting to lowercase
- Removing special characters and spaces
- Matching against all persona names

Examples that work:
- "jack frost" → "Jack Frost"
- "jacko lantern" → "Jack-o'-Lantern"
- "ARSENE" → "Arsene"

## Current Limitations
- Limited persona database (11 personas)
- Basic fusion rules (no special fusion cases)
- CLI-only interface
- No reverse fusion lookup
- No fusion chain calculations

## Roadmap
This CLI version serves as the foundation for a planned web application:
- **Phase 2**: Spring Boot REST API backend
- **Phase 3**: Next.js frontend interface
- **Phase 4**: Database migration with expanded persona data
- **Phase 5**: Advanced features (reverse fusion, fusion chains, etc.)

---

**Version**: 1.0 (CLI)  
**Status**: Complete baseline for web application migration