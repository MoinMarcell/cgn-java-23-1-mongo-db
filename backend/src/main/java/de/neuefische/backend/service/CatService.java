package de.neuefische.backend.service;

import de.neuefische.backend.model.Cat;
import de.neuefische.backend.repository.CatRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatService {

    private final CatRepository repository;
    private final IdService idService;

    public CatService(CatRepository repository, IdService idService) {
        this.repository = repository;
        this.idService = idService;
    }

    public List<Cat> getAllCats(){
        return repository.getCats().values().stream().toList();
    }

    public Cat addCat(Cat cat){
        Cat catToAdd = new Cat(
                idService.generateId(),
                cat.name(),
                cat.breed(),
                cat.isHealthy(),
                cat.birthdate()
        );
        return repository.addCat(catToAdd);
    }

    public void deleteCatById(String id){
        repository.deleteCatById(id);
    }
}
