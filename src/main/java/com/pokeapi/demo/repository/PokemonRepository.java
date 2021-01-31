package com.pokeapi.demo.repository;

import com.pokeapi.demo.domain.PokemonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the {@link PokemonEntity} entity.
 */
@Repository
public interface PokemonRepository extends JpaRepository<PokemonEntity, Long> {}
