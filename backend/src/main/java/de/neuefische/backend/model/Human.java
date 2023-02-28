package de.neuefische.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("human")
public record Human(
        @Id
        String id,
        String name,
        List<Cat> cats
) {

}
