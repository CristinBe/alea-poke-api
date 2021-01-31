package com.pokeapi.demo.service;

import com.pokeapi.demo.domain.PokemonEntity;
import com.pokeapi.demo.repository.PokemonRepository;
import com.pokeapi.demo.service.api.FilterPokemonHeightService;
import com.pokeapi.demo.service.util.PokemonFilterUtil;
import com.pokeapi.demo.web.rest.dto.PokemonResponseDTO;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class FilterPokemonHeightServiceImpl implements FilterPokemonHeightService {

    private final PokemonRepository pokemonRepository;

    public List<PokemonResponseDTO> filterPokemonByHeight() {
        List<PokemonEntity> pokemonEntities = pokemonRepository.findAll();

        Function<PokemonEntity, Integer> getMethod = pokemonEntity -> pokemonEntity.getHeight();
        BiConsumer<PokemonResponseDTO, PokemonEntity> setMethod = (pokemonResponseDTO, pokemonEntity) -> pokemonResponseDTO
                .setHeight(pokemonEntity.getHeight());

        return PokemonFilterUtil.filterPokemon(pokemonEntities, getMethod, setMethod);
    }
}
