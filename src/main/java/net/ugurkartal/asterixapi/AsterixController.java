package net.ugurkartal.asterixapi;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("asterix/characters")
@RequiredArgsConstructor
public class AsterixController {

    private final AsterixRepository asterixRepository;

    @GetMapping
    public List<Character> getAllCharacters() {
        return this.asterixRepository.findAll();
    }

    @GetMapping("/{name}")
    public List<Character> getCharacterByName(@PathVariable String name){
        return this.asterixRepository.findByName(name);
    }

    @PostMapping("/add")
    public Character addCharacter(@RequestBody Character character) {
        return this.asterixRepository.save(character);
    }

    @PutMapping("/update")
    public Character updateCharacter(@RequestBody Character character){
        return this.asterixRepository.save(character);
    }

    @DeleteMapping("/delete")
    public String deleteById(@RequestParam String id){
        this.asterixRepository.deleteById(id);
        return "Deleted: " + id;
    }
}