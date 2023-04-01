package br.eng.joaofaro;

import java.util.ArrayList;
import java.util.List;

public class GameDto {

    protected int gameType;
    protected String email;
    protected List<ArrayList<Integer>> games;
    protected String voucher;

    protected Integer lotteryNumber;

    public void setLotteryNumber(Integer lotteryNumber) {
        this.lotteryNumber = lotteryNumber;
    }

    public void setGameType(int gameType) {
        this.gameType = gameType;
    }

    public void setGames(List<ArrayList<Integer>> games) {
        this.games = games;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setVoucher(String voucher) {
        this.voucher = voucher;
    }
}
