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
    public List<Character> getCharacters() {
        return this.asterixRepository.findAll();
    }

    @PostMapping("/add")
    public Character addCharacter(@RequestBody Character character) {
        return this.asterixRepository.save(character);
    }
}