package de.neuefische.backend.repository;

import de.neuefische.backend.model.Cat;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CatRepository extends MongoRepository<Cat, String> {
    Optional<Cat> findCatByName(String name);
}
