package br.eng.joaofaro.service;

import br.eng.joaofaro.GameDto;

public class SendNotificationResult {

    public void send(GameDto dto) {
        System.out.println("Aguarde resultado por e-mail. Obrigado");
        System.out.println();
    }
}
