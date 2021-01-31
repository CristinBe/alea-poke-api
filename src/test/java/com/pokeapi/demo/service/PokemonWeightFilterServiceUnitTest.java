package com.pokeapi.demo.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import com.pokeapi.demo.domain.PokemonEntity;
import com.pokeapi.demo.repository.PokemonRepository;
import com.pokeapi.demo.service.util.BasePokemonFilterUtil;
import com.pokeapi.demo.web.rest.dto.PokemonResponseDTO;
import java.util.Comparator;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * Test class for the {@link FilterPokemonWeightServiceImpl}  class.
 */
@RunWith(MockitoJUnitRunner.class)
public class PokemonWeightFilterServiceUnitTest {

    @Mock
    private PokemonRepository pokemonRepository;

    private FilterPokemonWeightServiceImpl weightService;

    @Before
    public void setUp() {
        when(pokemonRepository.findAll()).thenReturn(BasePokemonFilterUtil.getMockPokemons());

        weightService = new FilterPokemonWeightServiceImpl(pokemonRepository);
    }

    @Test
    public void testWeightFilter() {
        // given
        List<PokemonEntity> pokemonEntities = BasePokemonFilterUtil.getMockPokemons();
        pokemonEntities.sort(Comparator.comparing(PokemonEntity::getWeight).reversed());

        // when
        List<PokemonResponseDTO> pokemonResponseDTOS = weightService.filterPokemonByWeight();

        // then
        Assert.assertNotNull(pokemonResponseDTOS);
        Assert.assertEquals(5, pokemonResponseDTOS.size());
        assertThat(pokemonResponseDTOS.get(0).getWeight()).isEqualTo(pokemonEntities.get(0).getWeight());
        assertThat(pokemonResponseDTOS.get(1).getWeight()).isEqualTo(pokemonEntities.get(1).getWeight());
        assertThat(pokemonResponseDTOS.get(2).getWeight()).isEqualTo(pokemonEntities.get(2).getWeight());
        assertThat(pokemonResponseDTOS.get(3).getWeight()).isEqualTo(pokemonEntities.get(3).getWeight());
        assertThat(pokemonResponseDTOS.get(4).getWeight()).isEqualTo(pokemonEntities.get(4).getWeight());
    }
}
