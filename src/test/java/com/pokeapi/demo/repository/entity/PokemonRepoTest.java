package com.pokeapi.demo.repository.entity;

import com.pokeapi.demo.PokeApiAleaDemoApp;
import com.pokeapi.demo.domain.PokemonEntity;
import com.pokeapi.demo.repository.PokemonRepository;
import javax.transaction.Transactional;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PokeApiAleaDemoApp.class)
public class PokemonRepoTest {

    @Autowired
    private PokemonRepository pokemonRepository;

    @Transactional
    @Test
    public void testSave() {
        PokemonEntity pokemonEntity = new PokemonEntity(122, 2, 306, "MewTwo");

        pokemonEntity = pokemonRepository.save(pokemonEntity);

        PokemonEntity pokemonResponseEntity = pokemonRepository.findById(pokemonEntity.getId())
                .orElse(null);

        Assert.assertNotNull(pokemonResponseEntity);

    }
}
