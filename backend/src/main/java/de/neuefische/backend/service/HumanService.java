package de.neuefische.backend.service;

import de.neuefische.backend.model.Cat;
import de.neuefische.backend.model.Human;
import de.neuefische.backend.repository.HumanRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class HumanService {

    private final HumanRepository humanRepository;
    private final IdService idService;

    public HumanService(HumanRepository humanRepository, IdService idService) {
        this.humanRepository = humanRepository;
        this.idService = idService;
    }

    public List<Human> getAllHumans(){
        return humanRepository.findAll();
    }

    public Human addHuman(Human human){
        Human humanToAdd = new Human(
                idService.generateId(),
                human.name(),
                new ArrayList<>()
        );
        humanRepository.save(humanToAdd);
        return humanToAdd;
    }

    public Human addCatToHuman(String id, Cat cat){
        Human human = humanRepository.findById(id).orElseThrow(NoSuchElementException::new);
        human.cats().add(cat);
        humanRepository.save(human);
        return human;
    }
}
