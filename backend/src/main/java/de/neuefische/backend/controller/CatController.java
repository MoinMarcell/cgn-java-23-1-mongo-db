package de.neuefische.backend.controller;

import de.neuefische.backend.model.Cat;
import de.neuefische.backend.service.CatService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cats")
public class CatController {

    private final CatService service;

    public CatController(CatService service) {
        this.service = service;
    }

    @GetMapping
    public List<Cat> allCats(){
        return service.getAllCats();
    }

    @GetMapping("/{id}")
    public Cat getCatById(@PathVariable String id){
        return service.getById(id);
    }

    @PostMapping
    public Cat addCat(@RequestBody Cat cat){
        return service.addCat(cat);
    }

    @DeleteMapping("/{id}")
    public void deleteCat(@PathVariable String id){
        service.deleteCatById(id);
    }
}
