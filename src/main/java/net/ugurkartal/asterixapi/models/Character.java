package net.ugurkartal.asterixapi.models;

import lombok.Builder;

import java.time.Instant;

@Builder
public record Character(String id, String name, int age, String profession, Instant createdAt) {
}
