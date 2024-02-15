package net.ugurkartal.asterixapi;

import lombok.RequiredArgsConstructor;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;

import org.springframework.data.mongodb.core.aggregation.Aggregation;
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

    @GetMapping("/getAverageAge")
    public double getAverageAge(){
        return this.asterixRepository.findAll().stream().mapToDouble(Character::age).average().orElse(0);
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