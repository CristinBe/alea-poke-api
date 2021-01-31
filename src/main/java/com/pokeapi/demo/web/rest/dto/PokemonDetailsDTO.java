package com.pokeapi.demo.web.rest.dto;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO that is used when retrieving from PokeApi endpoint the details for a specific pokemon
 */
@Getter
@Setter
@NoArgsConstructor
public class PokemonDetailsDTO {
    private List<Form> forms = new ArrayList<>();
    private Integer base_experience;
    private Integer weight;
    private Integer height;

    @Getter
    @Setter
    @NoArgsConstructor
    public static class Form {
        String name;
        String url;
    }
}
