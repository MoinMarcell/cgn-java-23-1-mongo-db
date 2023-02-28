package de.neuefische.backend.service;

import de.neuefische.backend.model.Cat;
import de.neuefische.backend.repository.CatRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CatService {

    private final CatRepository repository;
    private final IdService idService;

    public CatService(CatRepository repository, IdService idService) {
        this.repository = repository;
        this.idService = idService;
    }

    public List<Cat> getAllCats(){
        return repository.findAll();
    }

    public Cat addCat(Cat cat){
        Cat catToAdd = new Cat(
                idService.generateId(),
                cat.name(),
                cat.breed(),
                cat.isHealthy(),
                cat.birthdate()
        );
        return repository.save(catToAdd);
    }

    public Cat getCatById(String id){
        return repository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public Cat getCatByName(String name){
        return repository.findCatByName(name).orElseThrow(NoSuchElementException::new);
    }

    public void deleteCatById(String id){
        repository.deleteById(id);
    }
}
