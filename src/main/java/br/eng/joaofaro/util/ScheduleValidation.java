package br.eng.joaofaro.util;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;

public class ScheduleValidation {

    public static void validate(Boolean isEnable) throws InterruptedException {
        if (isEnable) {
            LocalDateTime now = LocalDateTime.now();
            int hour = now.getHour();
            if (hour < 1) {
                JFrame frameValidator = new JFrame("Loterias V2");
                frameValidator.setSize(500,100);
                JPanel panelValidator = new JPanel();
                panelValidator.setSize(100, 100);
                panelValidator.setLayout(new GridBagLayout());

                JLabel labelScheduleValidation = new JLabel();
                labelScheduleValidation.setText("O horário da aposta deve ser inferior às 18h. Tente novamente mais" +
                        " tarde");
                panelValidator.add(labelScheduleValidation);
                frameValidator.add(panelValidator);
                frameValidator.setVisible(true);

                Thread.sleep(3000);

                frameValidator.setVisible(false);
                throw new RuntimeException("O horário da aposta deve ser inferior às 18h. Tente novamente mais tarde");
            }
        }
    }
}
