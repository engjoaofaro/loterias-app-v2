package br.eng.joaofaro.service;

import java.util.ArrayList;
import java.util.List;

public class GameCalculator {

    public List<ArrayList<Integer>> calculate(int quantity, int numbersOfGame, Game game) {
        List<ArrayList<Integer>> games = null;
        try {
            games = game.generator(quantity, numbersOfGame);
            System.out.println();
            System.out.println("Jogo(s) gerado(s) com sucesso!");
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao tentar gerar os jogos: "+ e);
        }
        return games;
    }
}
