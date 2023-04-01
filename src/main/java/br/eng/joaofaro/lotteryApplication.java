package br.eng.joaofaro;

import br.eng.joaofaro.service.Game;
import br.eng.joaofaro.service.GameCalculator;
import br.eng.joaofaro.service.SendNotificationResult;
import br.eng.joaofaro.service.impl.LotoFacil;
import br.eng.joaofaro.service.impl.Lotomania;
import br.eng.joaofaro.service.impl.Megasena;
import br.eng.joaofaro.util.VoucherGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class lotteryApplication {

    private static final int MEGASENA = 1;
    private static final int LOTOFACIL = 2;
    private static final int LOTOMANIA = 3;

    public static void main(String[] args) {
        Game gameType;
        GameDto dto = new GameDto();
        System.out.println("#### ATUALMENTE SOMENTE JOGOS DA MEGASENA, LOTOFACIL E LOTOMANIA ESTÃO DISPONÍVEIS ####");
        System.out.println();
        Scanner input = new Scanner(System.in);
        System.out.println("Digite 1 para Megasena, 2 para Lotofácil ou 3 para LotoMania: ");
        int game = input.nextInt();
        dto.setGameType(game);

        switch (game) {
            case MEGASENA -> gameType = new Megasena();
            case LOTOFACIL -> gameType = new LotoFacil();
            case LOTOMANIA -> gameType = new Lotomania();
            default -> throw new IllegalArgumentException("Número inválido. Por favor digite 1 ou 2 para escolher o " +
                    "tipo do jogo");
        }
        System.out.println("Digite o número do concurso (Número de concurso incorreto poderá afetar o resultado): ");
        int lotteryNumber = input.nextInt();
        dto.setLotteryNumber(lotteryNumber);
        System.out.println("Digite a quantidade de números a serem gerados por jogo: ");
        int numbersOfGame = input.nextInt();
        System.out.println("Digite a quantidade de jogos a serem gerados: ");
        int quantity = input.nextInt();

        GameCalculator gameCalculator = new GameCalculator();
        List<ArrayList<Integer>> games = gameCalculator.calculate(quantity, numbersOfGame, gameType);
        dto.setGames(games);
        if (games != null) {
            String voucher = new VoucherGenerator().generator();
            System.out.println();
            System.out.println("ID da transação: "+ voucher);
            System.out.println();
            dto.setVoucher(voucher);
        }
        System.out.println("Deseja acompanhar o resultado? (1) Sim ou (2) Não");
        int resultado = input.nextInt();

        switch (resultado) {
            case 1 -> {
                System.out.println("Digite o e-mail que deseja receber o(s) resultado(s): ");
                String email = input.next();
                if (email != null) {
                    dto.setEmail(email);
                    new SendNotificationResult().send(dto);
                } else {
                    throw new IllegalArgumentException("Opção inválida. Jogo seguirá sem acompanhamento");
                }
            }
            case 2 -> System.out.println("Obrigado!");
            default -> throw new IllegalArgumentException("Opção inválida. Jogo seguirá sem acompanhamento");
        }

        System.out.println();
    }
}