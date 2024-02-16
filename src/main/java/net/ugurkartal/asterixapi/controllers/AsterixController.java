package net.ugurkartal.asterixapi.controllers;

import lombok.RequiredArgsConstructor;

import net.ugurkartal.asterixapi.models.dtos.CharacterDto;
import net.ugurkartal.asterixapi.models.dtos.CharacterUpdateRequest;
import net.ugurkartal.asterixapi.repositories.AsterixRepository;
import net.ugurkartal.asterixapi.models.Character;
import net.ugurkartal.asterixapi.services.AsterixService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("asterix/characters")
@RequiredArgsConstructor
public class AsterixController {

    private final AsterixService asterixService;

    @GetMapping
    public List<Character> getAllCharacters() {
        return this.asterixService.getAll();
    }

    @GetMapping("/{name}")
    public Character getCharacterByName(@PathVariable String name){
        return this.asterixService.getByName(name);
    }

    @GetMapping("/getById/{id}")
    public Character getCharacterById(@PathVariable String id){
        return this.asterixService.getById(id);
    }

    @GetMapping("/getAverageAge")
    public double getAverageAge(){
        return this.asterixService.getAverageAge();
    }

    @PostMapping("/add")
    public Character addCharacter(@RequestBody CharacterDto characterDto) {
        return this.asterixService.add(characterDto);
    }

    @PutMapping("/update")
    public Character updateCharacter(@RequestParam String id, @RequestBody CharacterUpdateRequest characterUpdateRequest){
        return this.asterixService.update(id, characterUpdateRequest);
    }

    @DeleteMapping("/delete")
    public String deleteById(@RequestParam String id){
        this.asterixService.deleteById(id);
        return "Deleted: " + id;
    }

    @GetMapping("/getOldestCharacter")
    public List<Character> getOldestCharacter(){
        return this.asterixService.getOldestCharacter();
    }
}