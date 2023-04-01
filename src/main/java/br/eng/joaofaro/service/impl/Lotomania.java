package br.eng.joaofaro.service.impl;

import br.eng.joaofaro.service.Game;

import java.util.ArrayList;
import java.util.List;

public class Lotomania extends Game {

    private static final Integer MAX_LOTOMANIA = 100;
    private static final Integer MIN_NUMBER_GAME = 50;
    @Override
    protected List<ArrayList<Integer>> generator(int quantity, int numbersOfGame) {
        if (!canPlayGame(numbersOfGame)) {
            throw new IllegalArgumentException("O valor mínimo de números a serem gerados" +
                    " para LotoMania é :"+ MIN_NUMBER_GAME);
        }
        return super.gameGenerator(quantity, MAX_LOTOMANIA, numbersOfGame);
    }

    @Override
    protected Boolean canPlayGame(int minNumberOfGame) {
        return minNumberOfGame >= MIN_NUMBER_GAME;
    }
}
