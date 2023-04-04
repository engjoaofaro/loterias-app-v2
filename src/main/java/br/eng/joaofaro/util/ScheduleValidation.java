package br.eng.joaofaro.util;

import java.time.LocalDateTime;

public class ScheduleValidation {

    public static void validate() {
        LocalDateTime now = LocalDateTime.now();
        int hour = now.getHour();
        if (hour > 18) {
            throw new RuntimeException("O horário da aposta deve ser inferior às 18h. Tente novamente mais tarde");
        }
    }
}
