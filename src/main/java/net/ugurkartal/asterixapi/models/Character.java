package net.ugurkartal.asterixapi.models;

import lombok.Builder;

@Builder
public record Character(String id, String name, int age, String profession) {
}
