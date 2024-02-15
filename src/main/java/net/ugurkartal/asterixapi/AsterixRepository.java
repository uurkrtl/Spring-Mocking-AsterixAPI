package net.ugurkartal.asterixapi;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AsterixRepository extends MongoRepository<Character, String>{
    List<Character> findByName(String name);
}
