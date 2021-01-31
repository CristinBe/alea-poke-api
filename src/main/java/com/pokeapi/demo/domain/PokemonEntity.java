package com.pokeapi.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entity that stores data for a pokemon.
 */
@Entity
@Table(name = "pokemon")
@Getter
@Setter
@NoArgsConstructor
public class PokemonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "pokemon_id")
    private Long id;

    @NotNull
    @Column(nullable = false)
    private Integer weight;

    @NotNull
    @Column(nullable = false)
    private Integer height;

    @NotNull
    @Column(nullable = false)
    private Integer baseXp;

    @NotNull
    @Column(nullable = false)
    private String name;

    public PokemonEntity(Integer weight, Integer height, Integer baseXp, String name) {
        this.weight = weight;
        this.height = height;
        this.baseXp = baseXp;
        this.name = name;
    }
}
