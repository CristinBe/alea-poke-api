package com.pokeapi.demo.service;

import com.pokeapi.demo.domain.PokemonEntity;
import com.pokeapi.demo.repository.PokemonRepository;
import com.pokeapi.demo.service.api.FilterPokemonWeightService;
import com.pokeapi.demo.service.util.PokemonFilterUtil;
import com.pokeapi.demo.web.rest.dto.PokemonResponseDTO;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class FilterPokemonWeightServiceImpl implements FilterPokemonWeightService {

    private final PokemonRepository pokemonRepository;

    public List<PokemonResponseDTO> filterPokemonByWeight() {
        List<PokemonEntity> pokemonEntities = pokemonRepository.findAll();

        Function<PokemonEntity, Integer> getMethod = pokemonEntity -> pokemonEntity.getWeight();
        BiConsumer<PokemonResponseDTO, PokemonEntity> setMethod = (pokemonResponseDTO, pokemonEntity) -> pokemonResponseDTO
                .setWeight(pokemonEntity.getWeight());

        return PokemonFilterUtil.filterPokemon(pokemonEntities, getMethod, setMethod);
    }
}
