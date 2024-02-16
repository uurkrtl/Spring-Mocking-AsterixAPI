package net.ugurkartal.asterixapi.repositories;

import net.ugurkartal.asterixapi.models.Character;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AsterixRepository extends MongoRepository<Character, String>{
    Character findByName(String name);

    List<Character> findByAge(int maxAge);
}
