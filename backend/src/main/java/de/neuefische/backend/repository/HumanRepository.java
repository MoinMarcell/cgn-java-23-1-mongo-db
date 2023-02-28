package de.neuefische.backend.repository;

import de.neuefische.backend.model.Human;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HumanRepository extends MongoRepository<Human, String> {
}
