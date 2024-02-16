package net.ugurkartal.asterixapi.services;

import lombok.RequiredArgsConstructor;
import net.ugurkartal.asterixapi.models.Character;
import net.ugurkartal.asterixapi.models.dtos.CharacterDto;
import net.ugurkartal.asterixapi.repositories.AsterixRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AsterixService {
    private final AsterixRepository repository;
    private final IdService idService;

    public List<Character> getAll(){
        return repository.findAll();
    }

    public Character getByName (String name){
        return repository.findByName(name);
    }

    public Character getById (String id){
        return repository.findById(id).orElse(null);
    }

    public Character add (CharacterDto characterDto){
        String newId = idService.randomId();
        Character character = new Character(newId, characterDto.getName(), characterDto.getAge(), characterDto.getProfession());
        return repository.save(character);
    }

    public Character update (Character character){
        return repository.save(character);
    }

    public String deleteById (String id){
        repository.deleteById(id);
        return "Deleted: " + id;
    }

    public List<Character> getOldestCharacter (){
        int maxAge = getAll().stream().mapToInt(Character::age).max().orElse(0);
        return repository.findByAge(maxAge);
    }

    public double getAverageAge(){
        return getAll().stream().mapToDouble(Character::age).average().orElse(0);
    }
}