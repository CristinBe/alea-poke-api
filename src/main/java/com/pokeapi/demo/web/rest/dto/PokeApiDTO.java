package com.pokeapi.demo.web.rest.dto;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO that is used to retrieve from PokeApi the list of all the pokemons and their URLs.
 */
@Getter
@Setter
@NoArgsConstructor
public class PokeApiDTO {
    List<PokemonDTO> results = new ArrayList<>();

    @Getter
    @Setter
    @NoArgsConstructor
    public static class PokemonDTO {
        String name;
        String url;
    }
}
