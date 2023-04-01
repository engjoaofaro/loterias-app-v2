package br.eng.joaofaro.service;

import java.util.List;

public class GameCalculator {

    public List<Integer> calculate(int quantity, int numbersOfGame, Game game) {
        List<Integer> games = null;
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
