package de.neuefische.backend.repository;

import de.neuefische.backend.model.Cat;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class CatRepository {

    private final Map<String, Cat> cats;

    public CatRepository(Map<String, Cat> cats) {
        this.cats = cats;
    }

    public Map<String, Cat> getCats() {
        return cats;
    }

    public Cat addCat(Cat cat){
        cats.put(cat.id(), cat);
        return cats.get(cat.id());
    }

    public void deleteCatById(String id){
        cats.remove(id);
    }
}
