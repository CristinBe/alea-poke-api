package com.pokeapi.demo.service.api;

import com.pokeapi.demo.web.rest.dto.PokemonResponseDTO;
import java.util.List;

public interface FilterPokemonWeightService {

    List<PokemonResponseDTO> filterPokemonByWeight();
}
