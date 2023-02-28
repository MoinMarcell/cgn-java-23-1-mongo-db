package de.neuefische.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document("cats")
public record Cat(
        @Id
        String id,
        String name,
        String breed, // breed = Rasse
        boolean isHealthy,
        LocalDateTime birthdate
) {
}
