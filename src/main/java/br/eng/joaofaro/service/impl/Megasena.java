package br.eng.joaofaro.service.impl;

import br.eng.joaofaro.service.Game;

public class Megasena extends Game {

    private static final Integer MAX_MEGASENA = 60;
    private static final Integer MIN_NUMBER_GAME = 6;
    @Override
    protected String generator(int quantity, int numbersOfGame) {
        if (!canPlayGame(numbersOfGame)) {
            throw new IllegalArgumentException("O valor mínimo de números a serem gerados" +
                    " para Megasena é :"+ MIN_NUMBER_GAME);
        }
        return super.gameGenerator(quantity, MAX_MEGASENA, numbersOfGame);
    }

    @Override
    protected Boolean canPlayGame(int minNumberOfGame) {
        return minNumberOfGame >= MIN_NUMBER_GAME;
    }
}
