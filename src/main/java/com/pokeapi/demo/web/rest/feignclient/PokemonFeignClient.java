package com.pokeapi.demo.web.rest.feignclient;

import com.pokeapi.demo.web.rest.dto.PokeApiDTO;
import com.pokeapi.demo.web.rest.dto.PokemonDetailsDTO;
import feign.Headers;
import java.net.URI;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "pokemon", url = "https://pokeapi.co/api/v2/pokemon")
public interface PokemonFeignClient {

    // limit = 151 for retrieving only the pokemons from the red version
    @Headers("Content-Type: application/json")
    @GetMapping(consumes = "application/json", path = "/?limit=151")
    PokeApiDTO getPokemon();

    @Headers("Content-Type: application/json")
    @GetMapping(consumes = "application/json")
    PokemonDetailsDTO getPokemonDetails(URI baseUrl);

}
