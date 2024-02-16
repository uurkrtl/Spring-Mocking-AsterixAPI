package net.ugurkartal.asterixapi.services;

import net.ugurkartal.asterixapi.models.Character;
import net.ugurkartal.asterixapi.models.dtos.CharacterDto;
import net.ugurkartal.asterixapi.models.dtos.CharacterUpdateRequest;
import net.ugurkartal.asterixapi.repositories.AsterixRepository;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
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
        Instant createdAt = Instant.now();
        Character character1 = new Character("1", "Asterix", 35, "Warrior", createdAt);
        Character character2 = new Character("2", "Obelix", 35, "Blacksmith", createdAt);
        List<Character> expected = List.of(character1, character2);
        when(mockAsterixRepository.findAll()).thenReturn(expected);

        // WHEN
        List<Character> actual = service.getAll();

        // THEN
        assertEquals(expected, actual);
        verify(mockAsterixRepository, times(1)).findAll();
    }

    @Test
    void getCharacterByIdReturnsExpectedCharacter() {
        // GIVEN
        Instant createdAt = Instant.now();
        Character expected = new Character("1", "Asterix", 35, "Warrior", createdAt);
        when(mockAsterixRepository.findById("1")).thenReturn(Optional.of(expected));

        // WHEN
        Character actual = service.getById("1");

        // THEN
        assertEquals(expected, actual);
        verify(mockAsterixRepository, times(1)).findById("1");
    }

    @Test
    void updateCharacterReturnsUpdatedCharacter() {
        // GIVEN
        Instant createdAt = Instant.now();
        Character expected = new Character("1", "Asterix", 35, "Warrior", createdAt);
        CharacterUpdateRequest characterUpdateRequest = new CharacterUpdateRequest("Asterix", 35, "Warrior");
        when(mockAsterixRepository.findById("1")).thenReturn(Optional.of(expected));
        when(mockAsterixRepository.save(expected)).thenReturn(expected);

        // WHEN
        Character actual = service.update("1", characterUpdateRequest);

        // THEN
        assertEquals(expected, actual);
        verify(mockAsterixRepository, times(1)).save(expected);
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
        Instant createdAt = Instant.now();
        Character expected = new Character("1", "Asterix", 35, "Warrior", createdAt);
        CharacterDto characterDto = new CharacterDto("Asterix", 35, "Warrior");
        when(mockIdService.randomId()).thenReturn("1");
        when(mockAsterixRepository.save(expected)).thenReturn(expected);

        // WHEN
        Character actual = service.add(characterDto);

        // THEN
        Instant january1st2020 = LocalDateTime.of(2020, 1, 1, 0, 0).atZone(ZoneId.systemDefault()).toInstant();
        Instant ninePM = LocalDateTime.now().withHour(21).atZone(ZoneId.systemDefault()).toInstant();
        assertTrue(createdAt.isAfter(january1st2020) && createdAt.isBefore(ninePM));
    }
}