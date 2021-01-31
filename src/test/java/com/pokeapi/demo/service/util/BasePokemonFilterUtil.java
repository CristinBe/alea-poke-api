package com.pokeapi.demo.service.util;

import com.pokeapi.demo.domain.PokemonEntity;
import java.util.Arrays;
import java.util.List;

public class BasePokemonFilterUtil {

    private BasePokemonFilterUtil() {
    }

    // TODO: refactor this to read the list from a file
    public static List<PokemonEntity> getMockPokemons() {
        PokemonEntity mewTwo = new PokemonEntity(122, 2, 306, "MewTwo");
        PokemonEntity mew = new PokemonEntity(4, 4, 270, "Mew");
        PokemonEntity charizard = new PokemonEntity(90, 17, 240, "Charizard");
        PokemonEntity bulbasaur = new PokemonEntity(7, 7, 64, "Bulbasaur");
        PokemonEntity jigglypuff = new PokemonEntity(5, 5, 95, "Jigglypuff");
        PokemonEntity pikachu = new PokemonEntity(6, 4, 112, "Pikachu");
        PokemonEntity nidoran = new PokemonEntity(9, 5, 55, "Nidoran");
        PokemonEntity ninetales = new PokemonEntity(19, 1, 177, "Ninetales");
        PokemonEntity zubat = new PokemonEntity(8, 7, 49, "Zubat");
        PokemonEntity oddish = new PokemonEntity(5, 5, 64, "Oddish");

        return Arrays.asList(mewTwo, mew, charizard, bulbasaur, jigglypuff, pikachu, nidoran, ninetales, zubat, oddish);
    }

}
