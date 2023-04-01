package br.eng.joaofaro;

import br.eng.joaofaro.service.Game;
import br.eng.joaofaro.service.GameCalculator;
import br.eng.joaofaro.service.impl.LotoFacil;
import br.eng.joaofaro.service.impl.Lotomania;
import br.eng.joaofaro.service.impl.Megasena;

import java.util.Scanner;

public class lotteryApplication {

    private static final int MEGASENA = 1;
    private static final int LOTOFACIL = 2;
    private static final int LOTOMANIA = 3;

    public static void main(String[] args) {
        Game gameType;
        System.out.println("#### ATUALMENTE SOMENTE JOGOS DA MEGASENA, LOTOFACIL E LOTOMANIA ESTÃO DISPONÍVEIS ####");
        System.out.println();
        Scanner input = new Scanner(System.in);
        System.out.println("Digite 1 para Megasena, 2 para Lotofácil ou 3 para LotoMania: ");
        int game = input.nextInt();

        switch (game) {
            case MEGASENA -> gameType = new Megasena();
            case LOTOFACIL -> gameType = new LotoFacil();
            case LOTOMANIA -> gameType = new Lotomania();
            default -> throw new IllegalArgumentException("Número inválido. Por favor digite 1 ou 2 para escolher o " +
                    "tipo do jogo");
        }
        System.out.println("Digite a quantidade de números a serem gerados por jogo: ");
        int numbersOfGame = input.nextInt();
        System.out.println("Digite a quantidade de jogos a serem gerados: ");
        int quantity = input.nextInt();

        GameCalculator gameCalculator = new GameCalculator();
        String voucher = gameCalculator.calculate(quantity, numbersOfGame, gameType);
        if (voucher != null) {
            System.out.println();
            System.out.println("ID da transação: "+ voucher);
            System.out.println();
        }
    }
}