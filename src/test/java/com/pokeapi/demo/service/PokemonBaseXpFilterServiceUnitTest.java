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
 * Test class for the {@link FilterPokemonBaseXpServiceImpl}  class.
 */
@RunWith(MockitoJUnitRunner.class)
public class PokemonBaseXpFilterServiceUnitTest {

    @Mock
    private PokemonRepository pokemonRepository;

    private FilterPokemonBaseXpServiceImpl baseXpService;

    @Before
    public void setUp() {
        when(pokemonRepository.findAll()).thenReturn(BasePokemonFilterUtil.getMockPokemons());

        baseXpService = new FilterPokemonBaseXpServiceImpl(pokemonRepository);
    }

    @Test
    public void testBaseXPFilter() {
        // given
        List<PokemonEntity> pokemonEntities = BasePokemonFilterUtil.getMockPokemons();
        pokemonEntities.sort(Comparator.comparing(PokemonEntity::getBaseXp).reversed());

        // when
        List<PokemonResponseDTO> pokemonResponseDTOS = baseXpService.filterPokemonByBaseXp();

        // then
        Assert.assertNotNull(pokemonResponseDTOS);
        Assert.assertEquals(5, pokemonResponseDTOS.size());
        assertThat(pokemonResponseDTOS.get(0).getBaseXp()).isEqualTo(pokemonEntities.get(0).getBaseXp());
        assertThat(pokemonResponseDTOS.get(1).getBaseXp()).isEqualTo(pokemonEntities.get(1).getBaseXp());
        assertThat(pokemonResponseDTOS.get(2).getBaseXp()).isEqualTo(pokemonEntities.get(2).getBaseXp());
        assertThat(pokemonResponseDTOS.get(3).getBaseXp()).isEqualTo(pokemonEntities.get(3).getBaseXp());
        assertThat(pokemonResponseDTOS.get(4).getBaseXp()).isEqualTo(pokemonEntities.get(4).getBaseXp());
    }
}
