package br.eng.joaofaro;

import java.util.List;

public class GameDto {

    private int gameType;
    private String email;
    private List<Integer> games;
    private String voucher;

    public void setGameType(int gameType) {
        this.gameType = gameType;
    }

    public void setGames(List<Integer> games) {
        this.games = games;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setVoucher(String voucher) {
        this.voucher = voucher;
    }
}
