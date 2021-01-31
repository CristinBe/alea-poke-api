package com.pokeapi.demo.service;

import com.pokeapi.demo.domain.PokemonEntity;
import com.pokeapi.demo.repository.PokemonRepository;
import com.pokeapi.demo.web.rest.dto.PokeApiDTO.PokemonDTO;
import com.pokeapi.demo.web.rest.dto.PokemonDetailsDTO;
import com.pokeapi.demo.web.rest.feignclient.PokemonFeignClient;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PopulatePokemonService {

    private final PokemonFeignClient pokemonFeignClient;
    private final PokemonRepository pokemonRepository;

    private final List<PokemonEntity> pokemonEntities = new ArrayList<>();

    @PostConstruct
    public void initPokemon() {
        List<PokemonDTO> pokemonList = pokemonFeignClient.getPokemon().getResults();

        pokemonList.stream().map(pokemonDTO -> {
            PokemonEntity pokemonEntity = new PokemonEntity();
            URI pokemonURL = URI.create(pokemonDTO.getUrl());
            pokemonEntity.setName(pokemonDTO.getName());

            PokemonDetailsDTO pokemonDetailsDTO = pokemonFeignClient.getPokemonDetails(pokemonURL);

            pokemonEntity.setHeight(pokemonDetailsDTO.getHeight());
            pokemonEntity.setWeight(pokemonDetailsDTO.getWeight());
            pokemonEntity.setBaseXp(pokemonDetailsDTO.getBase_experience());

            return pokemonEntity;
        }).forEach(pokemonEntities::add);


    }

    //TODO find a better way of initializing the DB
    @EventListener(ApplicationReadyEvent.class)
    @Transactional
    public void doSomethingAfterStartup() {
        // empty the pokemon table since we are going to repopulate the table
        pokemonRepository.deleteAll();

        pokemonRepository.saveAll(pokemonEntities);
    }
}
