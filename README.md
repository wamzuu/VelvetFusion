# VelvetFusion (Spring Boot API)

A Java-based REST API for calculating Persona fusions, inspired by the Persona video game series. This Spring Boot application provides HTTP endpoints for searching personas and calculating fusion results between different personas.

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
- [API Endpoints](#api-endpoints)
    - [Get All Personas](#get-all-personas)
    - [Get Specific Persona](#get-specific-persona)
    - [Fuse Personas](#fuse-personas)
- [Usage Examples](#usage-examples)
- [How Fusion Works](#how-fusion-works)
- [Features in Detail](#features-in-detail)
    - [Fuzzy Search](#fuzzy-search)
    - [Spring Boot Architecture](#spring-boot-architecture)
- [Current Limitations](#current-limitations)
- [Roadmap](#roadmap)

## Features

- **REST API**: HTTP endpoints for persona operations
- **Persona Search**: Fuzzy search functionality with case-insensitive matching and special character normalization
- **Fusion Calculator**: Calculate the result of fusing two personas based on arcana rules and level calculations
- **Spring Boot Integration**: Dependency injection, auto-configuration, and embedded web server
- **JSON Responses**: All endpoints return JSON data
- **Data-Driven**: JSON-based data files for easy maintenance and expansion

## Project Structure

```
src/
├── main/
│   ├── java/com/velvetfusion/velvetfusion_api/
│   │   ├── VelvetfusionApiApplication.java   # Spring Boot main class
│   │   ├── PersonaController.java            # REST API endpoints
│   │   ├── PersonaSearchService.java         # Search service with fuzzy matching
│   │   ├── FusionCalculatorService.java      # Core fusion logic service
│   │   ├── Persona.java                      # Persona data model
│   │   ├── DataLoader.java                   # JSON data loading utilities
│   │   └── PersonaNotFoundException.java     # Custom exception
│   └── resources/
│       ├── application.properties            # Spring Boot configuration
│       ├── personaData.json                  # Persona database
│       └── fusionChart.json                  # Arcana fusion rules
└── pom.xml                                   # Maven dependencies
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

## Development Status

**🚧 Work in Progress**: This is the Spring Boot API version currently under development.

### Current State
- ✅ REST API endpoints functional
- ✅ Persona search and fusion logic working
- ✅ Spring Boot architecture implemented
- 🔄 Database integration pending (Phase 3)
- 🔄 Frontend interface pending (Phase 4)

### Tech Stack
- Spring Boot
- Java
- Maven
- Jackson for JSON processing
- Currently using JSON files for data storage

## Planned API Design

### Get All Personas
```
GET /api/v1/persona
```
Returns all personas in the database.

### Get Specific Persona
```
GET /api/v1/persona/{name}
```
Returns details for a specific persona. Uses fuzzy search for name matching.

### Fuse Personas
```
POST /api/v1/persona/fuse?name1={persona1}&name2={persona2}
```
Calculates the fusion result between two personas.

## Architecture Overview

The application follows a clean 3-layer architecture:
- **Controller Layer**: `PersonaController` handles HTTP requests/responses
- **Service Layer**: `PersonaSearchService` and `FusionCalculatorService` contain business logic
- **Data Layer**: `DataLoader` handles JSON file reading (temporary, will be replaced with database)

Spring Boot manages all component lifecycles through dependency injection.

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
- JSON file storage (no database yet)
- No reverse fusion lookup
- No fusion chain calculations

## Roadmap
✅ **Phase 1 (v0.1)**: CLI Version (Complete)  
✅ **Phase 2 (v0.2)**: Spring Boot REST API (Current - WIP)  
🚧 **Phase 3 (v0.3)**: Database Integration (PostgreSQL)  
🔜 **Phase 4 (v0.4)**: Frontend Interface (React/Next.js)  
🔜 **Phase 5 (v1.0)**: Production Release (Advanced features, polish)

---

**Version**: v0.2 (Spring Boot API)  
**Status**: Core API functionality implemented, database integration pending