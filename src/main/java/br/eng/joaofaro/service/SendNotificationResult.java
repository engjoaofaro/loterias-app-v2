package br.eng.joaofaro.service;

import br.eng.joaofaro.GameDto;
import com.amazonaws.auth.EnvironmentVariableCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class SendNotificationResult {

    public void send(GameDto dto) {
        GsonBuilder gsonBuilder = new GsonBuilder().setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        String lottery = gson.toJson(dto);
        AmazonSQS sqs = AmazonSQSClientBuilder.standard()
                .withCredentials(new EnvironmentVariableCredentialsProvider())
                .withRegion(Regions.SA_EAST_1)
                .build();
        SendMessageRequest request = new SendMessageRequest()
                .withQueueUrl(System.getenv("QUEUE_URL"))
                .withMessageBody(lottery)
                .withDelaySeconds(30);
        sqs.sendMessage(request);
        System.out.println("Aguarde resultado por e-mail. Obrigado");
        System.out.println();
    }
}
