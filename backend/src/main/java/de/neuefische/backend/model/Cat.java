package de.neuefische.backend.model;

import java.time.LocalDateTime;

public record Cat(
        String id,
        String name,
        String breed, // breed = Rasse
        boolean isHealthy,
        LocalDateTime birthdate
) {
}
