package com.pokeapi.demo.service.util;

import com.pokeapi.demo.domain.PokemonEntity;
import com.pokeapi.demo.web.rest.dto.PokemonResponseDTO;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PokemonFilterUtil {

    private PokemonFilterUtil() {
    }

    public static List<PokemonResponseDTO> filterPokemon(List<PokemonEntity> pokemonEntities,
            Function<PokemonEntity, Integer> getMethod,
            BiConsumer<PokemonResponseDTO, PokemonEntity> setMethod) {

        return pokemonEntities.stream().sequential()
                .sorted(Comparator.comparing(getMethod).reversed())
                .limit(5)
                .map(pokemonEntity -> {
                    PokemonResponseDTO pokemonResponseDTO = new PokemonResponseDTO();

                    pokemonResponseDTO.setName(pokemonEntity.getName());
                    setMethod.accept(pokemonResponseDTO, pokemonEntity);

                    return pokemonResponseDTO;
                })
                .collect(Collectors.toList());
    }
}
