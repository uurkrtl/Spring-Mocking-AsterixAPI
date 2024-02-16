package net.ugurkartal.asterixapi.services;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IdServiceTest {
    private final IdService idService = new IdService();

    @Test
    void randomIdReturnsNonNullValue() {
        // WHEN
        String actual = idService.randomId();

        // THEN
        assertNotNull(actual);
    }

    @Test
    void randomIdReturnsUniqueValues() {
        // WHEN
        String actual1 = idService.randomId();
        String actual2 = idService.randomId();

        // THEN
        assertNotEquals(actual1, actual2);
    }

    @Test
    void randomIdReturnsValidUUID() {
        // WHEN
        String actual = idService.randomId();

        // THEN
        assertNotNull(java.util.UUID.fromString(actual));
    }
}