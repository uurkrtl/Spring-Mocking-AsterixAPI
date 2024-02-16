package net.ugurkartal.asterixapi.services;

import net.ugurkartal.asterixapi.models.Character;
import net.ugurkartal.asterixapi.models.dtos.CharacterDto;
import net.ugurkartal.asterixapi.models.dtos.CharacterUpdateRequest;
import net.ugurkartal.asterixapi.repositories.AsterixRepository;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AsterixServiceTest {
    private final AsterixRepository mockAsterixRepository = mock(AsterixRepository.class);
    private final IdService mockIdService = mock(IdService.class);
    AsterixService service = new AsterixService(mockAsterixRepository, mockIdService);

    @Test
    void getAllCharactersReturnsExpectedList() {
        // GIVEN
        Character character1 = new Character("1", "Asterix", 35, "Warrior");
        Character character2 = new Character("2", "Obelix", 35, "Blacksmith");
        List<Character> expected = List.of(character1, character2);
        when(mockAsterixRepository.findAll()).thenReturn(expected);

        // WHEN
        List<Character> actual = service.getAll();

        // THEN
        assertEquals(expected, actual);
    }

    @Test
    void getCharacterByIdReturnsExpectedCharacter() {
        // GIVEN
        Character expected = new Character("1", "Asterix", 35, "Warrior");
        when(mockAsterixRepository.findById("1")).thenReturn(Optional.of(expected));

        // WHEN
        Character actual = service.getById("1");

        // THEN
        assertEquals(expected, actual);
    }

    @Test
    void updateCharacterReturnsUpdatedCharacter() {
        // GIVEN
        Character expected = new Character("1", "Asterix", 35, "Warrior");
        CharacterUpdateRequest characterUpdateRequest = new CharacterUpdateRequest("Asterix", 35, "Warrior");
        when(mockAsterixRepository.save(expected)).thenReturn(expected);

        // WHEN
        Character actual = service.update("1", characterUpdateRequest);

        // THEN
        assertEquals(expected, actual);
    }

    @Test
    void deleteCharacterByIdReturnsDeletedId() {
        // GIVEN
        String expected = "Deleted: 1";
        //when(mockAsterixRepository.deleteById("1")).thenReturn(null);

        // WHEN
        String actual = service.deleteById("1");

        // THEN
        assertEquals(expected, actual);
        verify(mockAsterixRepository, times(1)).deleteById("1");
    }

    @Test
    void addCharacterReturnsNewCharacter() {
        // GIVEN
        Character expected = new Character("1", "Asterix", 35, "Warrior");
        CharacterDto characterDto = new CharacterDto("Asterix", 35, "Warrior");
        when(mockIdService.randomId()).thenReturn("1");
        when(mockAsterixRepository.save(expected)).thenReturn(expected);

        // WHEN
        Character actual = service.add(characterDto);

        // THEN
        assertEquals(expected, actual);
    }
}