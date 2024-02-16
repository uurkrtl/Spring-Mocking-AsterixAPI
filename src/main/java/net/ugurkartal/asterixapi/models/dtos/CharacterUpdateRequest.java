package net.ugurkartal.asterixapi.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CharacterUpdateRequest {
    private String name;
    private int age;
    private String profession;
}
