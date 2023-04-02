package br.eng.joaofaro.service;

import java.util.ArrayList;
import java.util.List;

public class GameCalculator {

    public List<ArrayList<Integer>> calculate(int quantity, int numbersOfGame, Game game) {
        List<ArrayList<Integer>> games = game.generator(quantity, numbersOfGame);
        System.out.println();
        System.out.println("Jogo(s) gerado(s) com sucesso!");
        return games;
    }
}
