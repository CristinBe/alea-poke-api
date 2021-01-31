package com.pokeapi.demo.web.rest.controller;

import com.pokeapi.demo.service.api.FilterPokemonBaseXpService;
import com.pokeapi.demo.web.rest.dto.PokemonResponseDTO;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/base-xp", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class PokemonBaseXpRestController {

    private final FilterPokemonBaseXpService filterPokemonBaseXpService;

    /**
    * Get endpoint accessible to all requesters which returns top 5 pokemons by Base Xp
    *
    * @return List<PokemonResponseDTO>
    */

    @GetMapping
    public ResponseEntity<List<PokemonResponseDTO>> getPokemonTopBaseXp() {
        return ResponseEntity.ok(filterPokemonBaseXpService.filterPokemonByBaseXp());
    }


}
