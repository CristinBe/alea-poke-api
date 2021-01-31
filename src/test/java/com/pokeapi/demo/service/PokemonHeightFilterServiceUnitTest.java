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
 * Test class for the {@link FilterPokemonHeightServiceImpl}  class.
 */
@RunWith(MockitoJUnitRunner.class)
public class PokemonHeightFilterServiceUnitTest {

    @Mock
    private PokemonRepository pokemonRepository;

    private FilterPokemonHeightServiceImpl heightService;

    @Before
    public void setUp() {
        when(pokemonRepository.findAll()).thenReturn(BasePokemonFilterUtil.getMockPokemons());

        heightService = new FilterPokemonHeightServiceImpl(pokemonRepository);
    }

    @Test
    public void testHeightFilter() {
        // given
        List<PokemonEntity> pokemonEntities = BasePokemonFilterUtil.getMockPokemons();
        pokemonEntities.sort(Comparator.comparing(PokemonEntity::getHeight).reversed());

        // when
        List<PokemonResponseDTO> pokemonResponseDTOS = heightService.filterPokemonByHeight();

        // then
        Assert.assertNotNull(pokemonResponseDTOS);
        Assert.assertEquals(5, pokemonResponseDTOS.size());
        assertThat(pokemonResponseDTOS.get(0).getHeight()).isEqualTo(pokemonEntities.get(0).getHeight());
        assertThat(pokemonResponseDTOS.get(1).getHeight()).isEqualTo(pokemonEntities.get(1).getHeight());
        assertThat(pokemonResponseDTOS.get(2).getHeight()).isEqualTo(pokemonEntities.get(2).getHeight());
        assertThat(pokemonResponseDTOS.get(3).getHeight()).isEqualTo(pokemonEntities.get(3).getHeight());
        assertThat(pokemonResponseDTOS.get(4).getHeight()).isEqualTo(pokemonEntities.get(4).getHeight());
    }
}
