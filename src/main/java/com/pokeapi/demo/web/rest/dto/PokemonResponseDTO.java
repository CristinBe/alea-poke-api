package com.pokeapi.demo.web.rest.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO response for the Pokemon filtering controllers.
 */

// TODO : investigate why @JsonInclude(Include.NON_NULL) is not working as JsonSerialize is deprecated

@Getter
@Setter
@NoArgsConstructor
@JsonSerialize(include = Inclusion.NON_NULL)
public class PokemonResponseDTO {

    private String name;
    private Integer height;
    private Integer baseXp;
    private Integer weight;

}
