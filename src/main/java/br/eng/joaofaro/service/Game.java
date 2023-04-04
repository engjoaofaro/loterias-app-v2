package br.eng.joaofaro.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public abstract class Game {

    @SuppressWarnings("OptionalGetWithoutIsPresent")
    public List<ArrayList<Integer>> gameGenerator(int quantity, int typeOfGame, int numbersOfGame) {
        System.out.println("Gerando "+quantity+" jogos...");
        System.out.println();
        List<ArrayList<Integer>> gamesReturn = new ArrayList<>();

        for (int i = 0; i < quantity; i++) {
            ArrayList<Integer> games = new ArrayList<>();
            Random randomGames = new Random();

            for (int j = 0; j < numbersOfGame; j++) {
                int number = randomGames.ints(1, (typeOfGame + 1)).findFirst().getAsInt();
                if (!games.contains(number)) {
                    games.add(number);
                } else {
                    //Retorna 1 no loop para poder gerar número não repetido
                    j = j -1;
                }
            }

            int gameIndex = i + 1;
            Collections.sort(games);
            System.out.println("Jogo "+ gameIndex+ ": "+ games);
            gamesReturn.add(games);
        }
        return gamesReturn;
    }

    protected abstract List<ArrayList<Integer>> generator(int quantity, int numbersOfGame);
    protected abstract Boolean canPlayGame(int minNumberOfGame);
}
