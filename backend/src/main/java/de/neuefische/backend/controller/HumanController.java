package de.neuefische.backend.controller;

import de.neuefische.backend.model.Cat;
import de.neuefische.backend.model.Human;
import de.neuefische.backend.service.HumanService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/humans")
public class HumanController {

    private final HumanService humanService;

    public HumanController(HumanService humanService) {
        this.humanService = humanService;
    }

    @GetMapping
    public List<Human> allHumans(){
        return humanService.getAllHumans();
    }

    @PostMapping
    public Human addHuman(@RequestBody Human human){
        return humanService.addHuman(human);
    }

    @PostMapping("/{id}")
    public Human addCatToHuman(@PathVariable String id, @RequestBody Cat cat){
        return humanService.addCatToHuman(id, cat);
    }
}
